package hotel.controller;


import hotel.entities.Feature;
import hotel.repositories.FeaturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeaturesController {
    @Autowired
    FeaturesRepository featuresRepository;

    @RequestMapping("/findallFeatures")
    public String findedAllFeatures() {
        StringBuilder result = new StringBuilder(" ");
        for (Feature feature : featuresRepository.findAll()) {
            result.append(feature.toString()).append("</br>");
        }
        return result.toString();
    }
}

