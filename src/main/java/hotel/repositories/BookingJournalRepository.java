package hotel.repositories;

import hotel.entities.BookingJournal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingJournalRepository extends CrudRepository<BookingJournal, Long> {
}
