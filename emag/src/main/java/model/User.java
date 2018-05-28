package model;




import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

@Entity
@Table(name="user")
public class User implements Serializable, Observer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = false)
    private int id;

    @Column(name="username", unique = true, nullable = false)
    private String username;

    @Column(name = "password", unique = true, nullable = false)
    private String password;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "phone", unique = true, nullable = false)
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "card_nr", unique = true, nullable = false)
    private String cardNr;

    /*@Column(name = "balance")
    private double balance;*/

    @Column(name = "loyal")
    private boolean loyal;

    @Column(name = "logged")
    private boolean logged;

    /*@OneToMany(mappedBy="user", cascade = CascadeType.ALL)
    private List<OrderP> orders;*/

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String email, String phone, String address, String cardNr) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.cardNr = cardNr;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCardNr() {
        return cardNr;
    }

    public void setCardNr(String cardNr) {
        this.cardNr = cardNr;
    }

    public boolean isLoyal() {
        return loyal;
    }

    public void setLoyal(boolean loyal) {
        this.loyal = loyal;
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", cardNr='" + cardNr + '\'' +
                ", loyal=" + loyal +
                ", logged=" + logged +
                '}';
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println((String)arg);
    }
}
