package hotel.repositories;

import hotel.entities.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

    Category getCategoryByCategoryName(String name);

    List<Category> findAll();
}
