package hotel.services;

import hotel.entities.Feature;
import hotel.repositories.FeaturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeaturesService {
    private final FeaturesRepository featuresRepository;
    @Autowired
    public FeaturesService(FeaturesRepository featuresRepository) {
        this.featuresRepository = featuresRepository;
    }

    public String findedAllFeatures() {
        StringBuilder result = new StringBuilder(" ");
        for (Feature feature : featuresRepository.findAll()) {
            result.append(feature.toString()).append("</br>");
        }
        return result.toString();
    }
}
