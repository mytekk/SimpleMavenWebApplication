package ogloszenia.repository;

import ogloszenia.model.Conversation;
import ogloszenia.model.ConversationMessage;
import ogloszenia.model.User;
import ogloszeniar.hibernate.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.Collections;
import java.util.List;

/**
 * Created by RENT on 2017-08-01.
 */
public class ConversationMessageRepository {

    final static Logger logger = Logger.getLogger(ConversationMessageRepository.class);

    public static Integer addNewConversationMessage(ConversationMessage conversationMessage, int userId) {
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            session.getTransaction().begin();

            conversationMessage.setAuthor(UserRepository.findById(userId).get());

            session.persist(conversationMessage);
            session.getTransaction().commit();
            logger.info("ddddddddd");
            return conversationMessage.getId();
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error(ex);
            session.getTransaction().rollback();
            return 0;
        } finally {
            session.close();
        }

    }

    //dodanie pojedynczej wiadomosci do bazy
    public static Integer persist(ConversationMessage conversationMessage) {
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            session.getTransaction().begin();

            if(! session.contains(conversationMessage.getConversation()) && conversationMessage.getConversation().getId()!= null ) {

                conversationMessage.setConversation((Conversation) session.merge(conversationMessage.getConversation()));
            }
            if(! session.contains(conversationMessage.getAuthor()) && conversationMessage.getAuthor().getId()!= null) {
                conversationMessage.setAuthor((User) session.merge(conversationMessage.getAuthor()));
            }

            session.persist(conversationMessage);
            session.getTransaction().commit();
            logger.info("ddddddddd");
            return conversationMessage.getId();
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error(ex);
            session.getTransaction().rollback();
            return 0;
        } finally {
            session.close();
        }

    }

    public static List<ConversationMessage> findByConversationId(Integer id) {
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            String hql = "SELECT  e FROM ConversationMessage e WHERE e.conversation.id=:id";
            Query query = session.createQuery(hql);
            query.setParameter("id",id);
            return  query.getResultList();
        } catch (Exception ex) {
            logger.error(ex);
            session.getTransaction().rollback();
            return Collections.emptyList();
        } finally {
            session.close();
        }
    }

}


