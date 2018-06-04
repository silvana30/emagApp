package model.model.operations;

import model.Admin;
import model.HibernateUtil;
import model.Product;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;

public class AdminOp {
    public AdminOp() {
    }

    public boolean logAdmin(String username, String password) {
        boolean rez = false;
       // SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();


        Query query = session.createQuery("SELECT admin FROM Admin admin");
        List<Admin> list = query.getResultList();
        for (Admin a : list) {
            if (a.getUsername().equals(username) && a.getPassword().equals(password)) {
                rez = true;
                break;
            } else {
                rez = false;
            }
        }


        session.getTransaction().commit();
        session.close();
       // sessionFactory.close();
        return rez;


    }

}
