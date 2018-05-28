package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class Product implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" , unique = true, nullable = false)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "category")
    private String category;

    @Column(name = "resealed")
    private boolean resealed;

   /* @Column(name="rating")
    private int rating;

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }/*

/*@Column(name = "specification",length=300)
    private String specification;
*/
    /*@Column
    private String specification;*/
    /*@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<Cart> carts = new ArrayList<Cart>();*/

   /* @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;*/

    public Product() {
    }

    public Product(String name, double price, String category, boolean resealed) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.resealed = resealed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isResealed() {
        return resealed;
    }

    public void setResealed(boolean resealed) {
        this.resealed = resealed;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", resealed=" + resealed +
                '}';
    }
}
