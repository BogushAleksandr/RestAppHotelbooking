package hotel.controller;

import hotel.services.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JournalController {
    private final JournalService journalService;
    @Autowired
    public JournalController(JournalService journalService) {
        this.journalService = journalService;
    }

    @RequestMapping("/findallBooking")
    public String findallBooking(){
        return journalService.findallBooking();
    }



}
