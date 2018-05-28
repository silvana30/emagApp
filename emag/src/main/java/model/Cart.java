package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cart")
public class Cart implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = false)
    private int id;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idOrder")
    private OrderP idOrder;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idProduct")
    private Product idProduct;

    public Cart(int cantity, OrderP idOrder, Product idProduct) {
        this.quantity = cantity;
        this.idOrder = idOrder;
        this.idProduct = idProduct;
    }

    public Cart() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OrderP getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(OrderP idOrder) {
        this.idOrder = idOrder;
    }


    public Product getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Product idProduct) {
        this.idProduct = idProduct;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", idOrder=" + idOrder +
                ", idProduct=" + idProduct +
                '}';
    }
}
