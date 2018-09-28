package hotel.services;

import hotel.entities.*;
import hotel.repositories.BookingJournalRepository;
import hotel.util.PriceCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class JournalService {

    private BookingJournalRepository bookingJournalRepository;
    private final PriceCalculator priceCalculator;

    @Autowired
    public JournalService(BookingJournalRepository bookingJournalRepository, PriceCalculator priceCalculator) {
        this.bookingJournalRepository = bookingJournalRepository;
        this.priceCalculator = priceCalculator;
    }

    public Room bookRoom(User user, Room room, LocalDate dateFrom, LocalDate dateTo, List<Feature> features) {
        double price = priceCalculator.getPrice(room, features);
        BookingJournal journalEntry = new BookingJournal(user, room, dateFrom, dateTo, price);
        return bookingJournalRepository.save(journalEntry).getRoom_id();
    }

    public String findallBooking(){

        String resultFindallBooking = " ";
        for (BookingJournal bookingJournalResult : bookingJournalRepository.findAll()) {
            resultFindallBooking += bookingJournalResult.toString() + "</br>";
        }
        return resultFindallBooking;
    }

    public List<BookingJournal> findBookingUser(User user){
        return bookingJournalRepository.findByUser(user);
    }
}
