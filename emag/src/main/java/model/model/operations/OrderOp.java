package model.model.operations;

import model.Cart;
import model.OrderP;
import model.Product;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class OrderOp {

    public OrderOp() {

    }




    public OrderP createOrder( ){
        UserOp userOp=new UserOp();
        CartOp cartOp=new CartOp();
        ProductOp productOp=new ProductOp();
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();


        Session session = sessionFactory.openSession();

        session.beginTransaction();

        //User user=session.find(User.class,userId);
        User user=userOp.getLogged();
        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);

        double totalPrice=0.0;
        double part,part2=0.0;
        boolean loyal=user.isLoyal();
        List<Cart> mycarts=cartOp.readMyCarts();
        System.out.println(mycarts.toString());
        for(Cart c:mycarts){
            System.out.println(c.toString());
            Product product=session.find(Product.class,c.getIdProduct().getId());
            //double price=productOp.getPrice(c.getIdProduct());
            double price=product.getPrice();
            part=price*(double)c.getQuantity();
            if(loyal){
                part2+=part;
                totalPrice=part2-(0.05*part2);

            }else{
                totalPrice+=part;
            }

        }
        OrderP order=new OrderP(user,date,totalPrice);

        session.save(order);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return order;
    }

    public int getMaxId(){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();


        Session session = sessionFactory.openSession();

        session.beginTransaction();
        OrderP order = (OrderP) session.createQuery("FROM OrderP ORDER BY id DESC").setMaxResults(1).uniqueResult();
        //NativeQuery id=session.createSQLQuery("select max(id) from orderp");
        //int idd=session.createQuery("SELECT max(o.id) FROM OrderP o");

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return order.getId();
    }

    public OrderP getLastOrder(){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();


        Session session = sessionFactory.openSession();

        session.beginTransaction();
        OrderP order = (OrderP) session.createQuery("FROM OrderP ORDER BY id DESC").setMaxResults(1).uniqueResult();
        //NativeQuery id=session.createSQLQuery("select max(id) from orderp");
        //int idd=session.createQuery("SELECT max(o.id) FROM OrderP o");

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return order;
    }



    public List<OrderP> readMyOrders() {
        OrderOp orderOp=new OrderOp();
        UserOp userOp=new UserOp();
        List<OrderP> list;

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();


        Session session = sessionFactory.openSession();

        session.beginTransaction();

        int id=orderOp.getMaxId();
        User user=userOp.getLogged();
        OrderP order=session.find(OrderP.class,id);
        String hql="from OrderP order where order.user.id='"+user.getId()+"'";
        Query query = session.createQuery(hql);
        //query.setParameter("id",id);
        list = query.list();
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

        return list;
    }
}
