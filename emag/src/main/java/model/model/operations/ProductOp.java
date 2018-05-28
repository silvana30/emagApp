package model.model.operations;

import model.OrderP;
import model.Product;
import model.Specification;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ProductOp {
    public ProductOp() {
    }

    public List<Product> readProducts() {

        List<Product> list;

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();


        Session session = sessionFactory.openSession();

        session.beginTransaction();


        list = session.createSQLQuery("SELECT * FROM product").addEntity(Product.class).list();
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

        return list;
    }

    public Product createProduct(String name, double price, String category, boolean resealed){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Product product =new Product(name,price,category,resealed);
        session.save(product);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return product;
    }

    public void deleteProduct(int id){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();


        Session session = sessionFactory.openSession();

        session.beginTransaction();
        Product product=session.find(Product.class,id);
        session.delete(product);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    public void updateProduct(int id, double price){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();


        Session session = sessionFactory.openSession();

        session.beginTransaction();
        Product product=session.find(Product.class,id);
        product.setPrice(price);
        session.update(product);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

    }

    public void makeResealed(int id){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();


        Session session = sessionFactory.openSession();

        session.beginTransaction();
        Product product=session.find(Product.class,id);
        product.setResealed(true);
        session.update(product);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    public int getMaxIdProd(){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();


        Session session = sessionFactory.openSession();

        session.beginTransaction();
        Product product = (Product) session.createQuery("FROM Product ORDER BY id DESC").setMaxResults(1).uniqueResult();
        //NativeQuery id=session.createSQLQuery("select max(id) from orderp");
        //int idd=session.createQuery("SELECT max(o.id) FROM OrderP o");

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return product.getId();
    }
    public double getPrice(int id){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();


        Session session = sessionFactory.openSession();

        session.beginTransaction();
        Product product = session.find(Product.class,id);

        //NativeQuery id=session.createSQLQuery("select max(id) from orderp");
        //int idd=session.createQuery("SELECT max(o.id) FROM OrderP o");

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return product.getPrice();
    }

    public Specification createSpecification(int id, String processor, String screenSize, String ram, String hdd, String videoCard, String color, String camera){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Specification specification=new Specification(id,processor,screenSize,ram,hdd,videoCard,color,camera);
        session.save(specification);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return specification;
    }

    public Specification getSpecification(int id){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();
        Specification specification=session.find(Specification.class,id);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return specification;
    }

    public Product findById(int id){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Product product =session.find(Product.class,id);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return product;
    }
}
