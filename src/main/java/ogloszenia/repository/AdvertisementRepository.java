package ogloszenia.repository;

import ogloszenia.model.Advertisement;
import ogloszenia.model.CATEGORY;
import ogloszenia.model.User;
import ogloszeniar.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


/**
 * Created by RENT on 2017-07-28.
 */
public class AdvertisementRepository {

    public static Optional<Advertisement> findById(Integer id) {
        Session session = null;
        try {
            session = HibernateUtil.openSession().getSession();
            String hql = "SELECT e FROM Advertisement e WHERE e.id = :id";
            Query<Advertisement> query = session.createQuery(hql, Advertisement.class);
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

    public static List<Advertisement> findByCategory(CATEGORY category) {
        Session session = null;
        try {
            session = HibernateUtil.openSession().getSession();
            String hql = "SELECT e FROM Advertisement e WHERE e.category = :category";
            Query query = session.createQuery(hql);
            query.setParameter("category", category);
            return query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
            return Collections.emptyList();
        } finally {
            session.close();
        }

    }

    //dodanie ogloszenia
    public static Integer persist(Advertisement advertisement) {
        Session session = null;
        try {
            session = HibernateUtil.openSession().getSession();
            session.getTransaction().begin();
            session.persist(advertisement);
            session.getTransaction().commit();
            return advertisement.getId();
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
            return 0;
        } finally {
            session.close();
        }
    }

    //update ogloszenia - moja wersja definiowania sesji i transakcji
    public static boolean merge(Advertisement advertisement) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.openSession();
            transaction = session.beginTransaction();
            session.merge(advertisement);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
            return false;
        } finally {
            session.close();
        }
    }

    //usuwanie ogloszena, czyli przeniesienie do archiwum
    public static boolean delete(Integer id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.openSession();

            Optional<Advertisement> advertisement = findById(id);
            //sprawdzam, czy optional nie jest nullem
            if (advertisement.isPresent()) {
                transaction = session.beginTransaction();
                Advertisement advertisement1 = advertisement.get();
                advertisement1.setIsActive(false); //ustawiam ogloszenie jako nieaktywne
                session.merge(advertisement1);
                transaction.commit();
                return true;
            }
            return false;
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
            return false;
        } finally {
            session.close();
        }
    }

}
