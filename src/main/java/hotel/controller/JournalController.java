package hotel.controller;

import hotel.entities.BookingJournal;
import hotel.entities.User;
import hotel.services.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Bogush Aleksandr
 * @version 1.0
 * @since 15-11-2020
 */

@RestController
public class JournalController {

    private final JournalService journalService;

    @Autowired
    public JournalController(JournalService journalService) {
        this.journalService = journalService;
    }

    @RequestMapping(value = "/booking", method = RequestMethod.GET)
    private List<BookingJournal> findallBooking() {
        return journalService.findallBooking();
    }

    @RequestMapping(value = "/findBookingUser/{userID}", method = RequestMethod.GET)
    private List<BookingJournal> findBookingUser(@PathVariable("userID") User user) {
        return journalService.findBookingUser(user);
    }
}
