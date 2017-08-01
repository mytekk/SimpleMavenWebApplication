package ogloszenia.repository;

import ogloszenia.model.User;
import ogloszeniar.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Optional;


/**
 * Created by RENT on 2017-07-28.
 */
public class UserRepository {

    public static Optional<User> findByMail(String email) {
        Session session = null;
        try {
            session = HibernateUtil.openSession().getSession();
            String hql = "SELECT e FROM User e WHERE e.email = :email";
            Query query = session.createQuery(hql);
            query.setParameter("email", email);
            return Optional.ofNullable((User) query.getSingleResult());
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
            return Optional.empty();
        } finally {
            session.close();
        }
    }

    public static void persist(User user) {
        Session session = null;
        try {
            session = HibernateUtil.openSession().getSession();
            session.getTransaction().begin();
            session.persist(user);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

}