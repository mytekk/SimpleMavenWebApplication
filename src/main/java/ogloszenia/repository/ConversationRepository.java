package ogloszenia.repository;

import ogloszenia.model.Advertisement;
import ogloszenia.model.CATEGORY;
import ogloszenia.model.Conversation;
import ogloszeniar.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Created by RENT on 2017-08-01.
 */
public class ConversationRepository {

    public static Optional<Conversation> findById(Integer id) {
        Session session = null;
        try {
            session = HibernateUtil.openSession().getSession();
            String hql = "SELECT e FROM Conversation e WHERE e.id = :id";
            Query<Conversation> query = session.createQuery(hql, Conversation.class);
            query.setParameter("id", id);
            return Optional.ofNullable(query.getSingleResult());
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
            return Optional.empty();
        } finally {
            session.close();
        }
    }

    public static List<Conversation> findByUserId(Integer id) {
        Session session = null;
        try {
            session = HibernateUtil.openSession().getSession();
            String hql = "SELECT e FROM Conversation e WHERE e.conversationSender.id = :id or e.conversationReceiver.id = :id";
            Query<Conversation> query = session.createQuery(hql, Conversation.class);
            query.setParameter("id", id);
            return Optional.ofNullable(query.list());
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
            return Collections.emptyList();
        } finally {
            session.close();
        }
    }

    //dodanie konwesacji
    public static Integer persist(Conversation conversation) {
        Session session = null;
        try {
            session = HibernateUtil.openSession().getSession();
            session.getTransaction().begin();
            session.persist(conversation);
            session.getTransaction().commit();
            return conversation.getId();
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
            return 0;
        } finally {
            session.close();
        }
    }


}
