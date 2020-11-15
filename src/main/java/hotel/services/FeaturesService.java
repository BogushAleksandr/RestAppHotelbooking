package hotel.services;

import hotel.entities.Feature;
import hotel.repositories.FeaturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Bogush Aleksandr
 * @version 1.0
 * @since 15-11-2020
 */

@Service
public class FeaturesService {
    private final FeaturesRepository featuresRepository;
    @Autowired
    public FeaturesService(FeaturesRepository featuresRepository) {
        this.featuresRepository = featuresRepository;
    }

    public List<Feature> findedAllFeatures() {
        return featuresRepository.findAll();
    }
}
