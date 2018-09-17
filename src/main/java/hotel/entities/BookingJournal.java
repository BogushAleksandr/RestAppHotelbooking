package hotel.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "bookingjournal")
public class BookingJournal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User user_id;

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

    public BookingJournal(User user_id, Room room_id, LocalDate date_from, LocalDate date_to, double total_price) {
        this.user_id = user_id;
        this.room_id = room_id;
        this.date_from = date_from;
        this.date_to = date_to;
        this.total_price = total_price;
    }
}
