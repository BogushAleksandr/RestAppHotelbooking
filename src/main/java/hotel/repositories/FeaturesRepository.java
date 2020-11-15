package hotel.repositories;

import hotel.entities.Feature;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Bogush Aleksandr
 * @version 1.0
 * @since 15-11-2020
 */

@Repository
public interface FeaturesRepository extends CrudRepository<Feature, Long> {
    List<Feature> findAll();
}
