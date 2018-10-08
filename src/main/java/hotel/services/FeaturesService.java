package hotel.services;

import hotel.entities.Feature;
import hotel.repositories.FeaturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
