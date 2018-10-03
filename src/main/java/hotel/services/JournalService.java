package hotel.services;

import hotel.entities.BookingJournal;
import hotel.entities.Feature;
import hotel.entities.Room;
import hotel.entities.User;
import hotel.repositories.BookingJournalRepository;
import hotel.util.PriceCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class JournalService {

    private BookingJournalRepository bookingJournalRepository;

    @Autowired
    public JournalService(BookingJournalRepository bookingJournalRepository) {
        this.bookingJournalRepository = bookingJournalRepository;
    }

    public Room bookRoom(Room room, User user, Feature[] features, int year, int month, int dayOfMonth) {
        LocalDate dateFrom = LocalDate.now();
        LocalDate dateTo = LocalDate.of(year, month, dayOfMonth);

        List<Feature> featuresList = Arrays.asList(features);

        return bookRoom(user, room, dateFrom, dateTo, featuresList);
    }

    private Room bookRoom(User user, Room room, LocalDate dateFrom, LocalDate dateTo, List<Feature> features) {
        double price = PriceCalculator.getPrice(room, features);
        BookingJournal journalEntry = new BookingJournal(user, room, dateFrom, dateTo, price);
        return bookingJournalRepository.save(journalEntry).getRoom_id();
    }

    public String findallBooking(){

        StringBuilder resultFindallBooking = new StringBuilder(" ");
        for (BookingJournal bookingJournalResult : bookingJournalRepository.findAll()) {
            resultFindallBooking.append(bookingJournalResult.toString()).append("</br>");
        }
        return resultFindallBooking.toString();
    }

    public List<BookingJournal> findBookingUser(User user){
        return bookingJournalRepository.findByUser(user);
    }
}
