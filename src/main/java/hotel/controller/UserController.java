package hotel.controller;

import hotel.entities.User;
import hotel.repositories.BookingJournalRepository;
import hotel.repositories.UserRepository;
import hotel.services.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    UserRepository userRepository;
    JournalService journalService;
    BookingJournalRepository bookingJournalRepository;

    @Autowired
    public UserController(UserRepository userRepository,
                          JournalService journalService,
                          BookingJournalRepository bookingJournalRepository) {
        this.userRepository = userRepository;
        this.journalService = journalService;
        this.bookingJournalRepository = bookingJournalRepository;
    }

    @RequestMapping("/saveUser")
    public String addUser() {
        userRepository.save(new User("firstnameUser0", "secondnameUser0", "+380969604510", "user1kasd0@ukr.net"));
        userRepository.save(new User("firstnameUser1", "secondnameUser1", "+380969604511", "user1kasd1@ukr.net"));
        userRepository.save(new User("firstnameUser2", "secondnameUser2", "+380969604512", "user1kasd2@ukr.net"));
        userRepository.save(new User("firstnameUser3", "secondnameUser3", "+380969604513", "user1kasd3@ukr.net"));
        userRepository.save(new User("firstnameUser4", "secondnameUser4", "+380969604514", "user1kasd4@ukr.net"));
        userRepository.save(new User("firstnameUser5", "secondnameUser5", "+380969604515", "user1kasd5@ukr.net"));
        userRepository.save(new User("firstnameUser6", "secondnameUser6", "+380969604516", "user1kasd6@ukr.net"));
        userRepository.save(new User("firstnameUser7", "secondnameUser7", "+380969604517", "user1kasd7@ukr.net"));
        userRepository.save(new User("firstnameUser8", "secondnameUser8", "+380969604518", "user1kasd8@ukr.net"));
        userRepository.save(new User("firstnameUser9", "secondnameUser9", "+380969604519", "user1kasd9@ukr.net"));
        return "User is added!";
    }
    @RequestMapping("/findallUser")
    public String findedallUser() {
        StringBuilder resultUsers = new StringBuilder(" ");
        for (User user : userRepository.findAll()) {
            resultUsers.append(user.toString()).append("</br>");
        }
        return resultUsers.toString();
    }
    @RequestMapping("/user/can/view/his/booking/{userId}")
    public String userCanViewHisBooking(@PathVariable Long userId){
        User user = userRepository.getUserById(userId);

        return "200";
    }

    /*
       @ResponseBody
    @RequestMapping("/findallCategory")
    public String findAllCategory() {
        String resultCategory = " ";
        for (Category category : categoryRepository.findAll()) {
            resultCategory += category.toString() + "</br>";
        }
        return resultCategory;
    }
     */

   /* @ResponseBody
    @RequestMapping("room/book/{roomId}")
    public boolean bookRoom(@PathVariable Long roomId) {

        User user = userRepository.getUserById(1L);
        Room room = roomRepository.getById(roomId);
        LocalDate dateFrom = LocalDate.now();
        LocalDate dateTo = LocalDate.of(2018, 8, 14);
        List<Feature> features = new ArrayList<>();

        features.add(featuresRepository.getById(1L));

        journalService.bookRoom(user, room, dateFrom, dateTo, features);

        //TODO test
        return true;
    }*/
}