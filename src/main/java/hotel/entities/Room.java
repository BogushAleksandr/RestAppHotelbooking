package hotel.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "room")
public class Room implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    @Column(name = "number")
    private String number;

    @Column(name = "price")
    private double price;

    @Column(name = "available")
    private int available;

    public Room() {

    }

    public Room(Category category, String number, double price, int available) {
        this.category = category;
        this.number = number;
        this.price = price;
        this.available = available;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return String.format("Room [id = '%d', category = '%s', number = '%s', price = '%8.2f', avaible = '%d']",
                id, category.toString(), number, price, available);
    }
}
