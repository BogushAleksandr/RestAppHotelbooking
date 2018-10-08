package hotel.repositories;

import hotel.entities.Feature;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeaturesRepository extends CrudRepository<Feature, Long> {
    List<Feature> findAll();
}
