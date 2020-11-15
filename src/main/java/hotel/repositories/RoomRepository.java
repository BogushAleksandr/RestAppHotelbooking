package hotel.repositories;

import hotel.entities.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Bogush Aleksandr
 * @version 1.0
 * @since 15-11-2020
 */

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {

    List<Room> findAll();
}
