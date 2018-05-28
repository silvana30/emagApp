package model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "orderP")
public class OrderP implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    /*@OneToMany(fetch = FetchType.LAZY,mappedBy = "order")
    private List<Cart> carts= new ArrayList<Cart>();*/

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "placementDate")
    private Date placementDate;

    @Column(name = "totalPrice")
    private double totalPrice;

    public OrderP(){}


    public OrderP(User user, Date placementDate, double totalPrice) {
        this.user = user;
        this.placementDate = placementDate;
        this.totalPrice = totalPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getPlacementDate() {
        return placementDate;
    }

    public void setPlacementDate(Date placementDate) {
        this.placementDate = placementDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "OrderP{" +
                "id=" + id +
                ", user=" + user +
                ", placementDate=" + placementDate +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
