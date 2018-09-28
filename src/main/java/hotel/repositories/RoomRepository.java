package hotel.repositories;

import hotel.entities.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {

    Room getById(Long id);

    List<Room> findAll();
}
