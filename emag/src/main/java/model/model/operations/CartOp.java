package model.model.operations;

import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class CartOp {
    public CartOp() {
    }
    //private OrderOp orderOp=new OrderOp();

    public Cart createCart(int quantity,  int idProduct){
        //SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();
        OrderOp orderOp=new OrderOp();
        OrderP order=new OrderP();
        /////////////////////fara +1
        int id=orderOp.getMaxId();
        OrderP orderP=session.find(OrderP.class,id);
        Product product=session.find(Product.class,idProduct);
        Cart cart=new Cart(quantity,orderP,product);
        session.save(cart);
        session.getTransaction().commit();
        session.close();
       // sessionFactory.close();
        return cart;
    }


    public List<Cart> readCarts() {

        List<Cart> list;

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();


        Session session = sessionFactory.openSession();

        session.beginTransaction();


        list = session.createSQLQuery("SELECT * FROM cart").addEntity(Cart.class).list();
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

        return list;
    }

    public List<Cart> readMyCarts() {
        OrderOp orderOp=new OrderOp();
        List<Cart> list;

        //SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();


        Session session = sessionFactory.openSession();

        session.beginTransaction();

        int id=orderOp.getMaxId();
        OrderP order=session.find(OrderP.class,id);
        String hql="from Cart cart where cart.idOrder.id='"+id+"'";
        Query query = session.createQuery(hql);
        //query.setParameter("id",id);
        list = query.list();
        session.getTransaction().commit();
        session.close();
        //sessionFactory.close();

        return list;
    }

    public void removeCart(int i) {
       // SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();


        Session session = sessionFactory.openSession();

        session.beginTransaction();

        /*String hql="from Cart cart where cart.idProduct.id='"+i+"'";
        Cart query = (Cart) session.createQuery(hql).getSingleResult();*/
        Cart cart=session.find(Cart.class,i);
        session.delete(cart);

        session.getTransaction().commit();
        session.close();
        //sessionFactory.close();

    }
}
