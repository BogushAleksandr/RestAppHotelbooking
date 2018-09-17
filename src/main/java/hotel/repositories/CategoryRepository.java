package hotel.repositories;

import hotel.entities.Category;
import org.springframework.data.repository.CrudRepository;


public interface CategoryRepository extends CrudRepository<Category, Long> {

    Category getCategoryByCategoryName(String name);
}
