package hotel.repositories;

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
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAll();

}
