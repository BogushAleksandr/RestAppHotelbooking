package hotel.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author Bogush Aleksandr
 * @version 1.0
 * @since 15-11-2020
 */

@Entity
@Table(name = "bookingjournal")
public class BookingJournal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToOne
    @JoinColumn(name = "ROOM_ID")
    private Room room_id;

    @Column(name = "date_from")
    private LocalDate date_from;

    @Column(name = "date_to")
    private LocalDate date_to;

    @Column(name = "total_price")
    private double total_price;

    public BookingJournal() {

    }

    public BookingJournal(User user, Room room_id, LocalDate date_from, LocalDate date_to, double total_price) {
        this.user = user;
        this.room_id = room_id;
        this.date_from = date_from;
        this.date_to = date_to;
        this.total_price = total_price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Room getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Room room_id) {
        this.room_id = room_id;
    }

    public LocalDate getDate_from() {
        return date_from;
    }

    public void setDate_from(LocalDate date_from) {
        this.date_from = date_from;
    }

    public LocalDate getDate_to() {
        return date_to;
    }

    public void setDate_to(LocalDate date_to) {
        this.date_to = date_to;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    @Override
    public String toString() {
        return String.format("BookingJournal [id = '%d', user = '%d', room_id = '%d', date_from = '%s', date_to = '%s', total_price = '%8.2f']",
                id, user.getId(), room_id.getId(), date_from, date_to, total_price);
    }
}
