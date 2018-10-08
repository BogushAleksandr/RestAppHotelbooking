package hotel.repositories;

import hotel.entities.BookingJournal;
import hotel.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingJournalRepository extends CrudRepository<BookingJournal, Long> {

    List<BookingJournal> findByUser(User user);

    List<BookingJournal> findAll();
}
