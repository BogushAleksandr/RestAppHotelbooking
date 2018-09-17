package hotel.repositories;

import hotel.entities.Feature;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeaturesRepository extends CrudRepository<Feature, Long> {

    Feature getById(Long id);

}
