package hotel.repositories;

import hotel.entities.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Bogush Aleksandr
 * @version 1.0
 * @since 15-11-2020
 */

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

    Category getCategoryByCategoryName(String name);

    List<Category> findAll();
}
