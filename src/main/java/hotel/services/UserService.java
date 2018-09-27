package hotel.services;

import hotel.entities.User;
import hotel.repositories.BookingJournalRepository;
import hotel.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final JournalService journalService;
    private final BookingJournalRepository bookingJournalRepository;

    @Autowired
    public UserService(UserRepository userRepository,
                       JournalService journalService, BookingJournalRepository bookingJournalRepository) {
        this.userRepository = userRepository;
        this.journalService = journalService;
        this.bookingJournalRepository = bookingJournalRepository;
    }

    public String findedallUser() {
        StringBuilder resultUsers = new StringBuilder(" ");
        for (User user : userRepository.findAll()) {
            resultUsers.append(user.toString()).append("</br>");
        }
        return resultUsers.toString();
    }

}
