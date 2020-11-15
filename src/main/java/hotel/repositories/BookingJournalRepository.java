package hotel.repositories;

import hotel.entities.BookingJournal;
import hotel.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Bogush Aleksandr
 * @version 1.0
 * @since 15-11-2020
 */

@Repository
public interface BookingJournalRepository extends CrudRepository<BookingJournal, Long> {

    List<BookingJournal> findByUser(User user);

    List<BookingJournal> findAll();
}
