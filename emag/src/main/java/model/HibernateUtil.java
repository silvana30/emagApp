package model;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    private static SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
