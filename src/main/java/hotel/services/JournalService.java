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

    //TODO make this return boolean
    public void bookRoom(User user, Room room, LocalDate dateFrom, LocalDate dateTo, List<Feature> features) {
        double price = priceCalculator.getPrice(room, features);
        BookingJournal journalEntry = new BookingJournal(user, room, dateFrom, dateTo, price);
        bookingJournalRepository.save(journalEntry);
    }

    public String findallBooking(){

        String resultFindallBooking = " ";
        for (BookingJournal bookingJournalResult : bookingJournalRepository.findAll()) {
            resultFindallBooking += bookingJournalResult.toString() + "</br>";
        }
        return resultFindallBooking;
    }
}
