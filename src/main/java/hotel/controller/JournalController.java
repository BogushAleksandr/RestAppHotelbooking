package hotel.controller;

import hotel.entities.BookingJournal;
import hotel.entities.User;
import hotel.services.JournalService;
import hotel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JournalController {

    private final UserService userService;
    private final JournalService journalService;

    @Autowired
    public JournalController(
            UserService userService,
            JournalService journalService
    ) {
        this.userService = userService;
        this.journalService = journalService;
    }

    @RequestMapping("/findallBooking")
    private String findallBooking() {
        return journalService.findallBooking();
    }

    @RequestMapping(value = "/findBookingUser/{userID}", method = RequestMethod.GET)
    private List<BookingJournal> findBookingUser(@PathVariable("userID") Long userid) {
        User user = userService.getUserById(userid);
        return journalService.findBookingUser(user);
    }
}
