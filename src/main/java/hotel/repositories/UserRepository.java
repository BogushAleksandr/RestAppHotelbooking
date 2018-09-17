package hotel.repositories;

import hotel.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User getUserById(Long id);
}
