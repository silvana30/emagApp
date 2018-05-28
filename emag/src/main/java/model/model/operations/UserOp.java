package model.model.operations;

import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;

public class UserOp {
    public UserOp() {
    }

    public List<User> readUsers(){
        List<User> users;
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();


        Session session = sessionFactory.openSession();

        session.beginTransaction();


        users = session.createSQLQuery("SELECT * FROM user").addEntity(User.class).list();
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

        return users;
    }

    public User createUser(String username, String password, String email, String phone, String address, String cardN) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        User user = new User(username, password, email, phone, address, cardN);
        session.save(user);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return user;

    }


    public boolean logUser(String username, String password) {
        boolean rez = false;
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Query query = session.createQuery("SELECT user FROM User user");
        List<User> list = query.getResultList();
        for (User a : list) {

            if (a.getUsername().equals(username) && a.getPassword().equals(password)) {
                rez = true;
                a.setLogged(true);
                break;
            } else {
                rez = false;
            }
        }

        System.out.println(list.toString());


        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return rez;


    }

    public User getLogged(){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        User user= (User) session.createQuery("FROM User WHERE logged=true").getSingleResult();




        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return user;


    }

    public User getLoyal(){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        User user= (User) session.createQuery("FROM User WHERE loyal=true").getSingleResult();




        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return user;


    }
    public void logout(){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        User user= (User) session.createQuery("FROM User WHERE logged=true").getSingleResult();
        user.setLogged(false);
        session.update(user);




        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
    public void makeLoyal(int id){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        User user =session.find(User.class,id);
        user.setLoyal(true);
        session.update(user);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
