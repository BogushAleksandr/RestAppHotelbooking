package hotel.controller;

import hotel.entities.Feature;
import hotel.services.FeaturesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Bogush Aleksandr
 * @version 1.0
 * @since 15-11-2020
 */

@RestController
public class FeaturesController {
    private final FeaturesService featuresService;

    @Autowired
    public FeaturesController(FeaturesService featuresService) {
        this.featuresService = featuresService;
    }

    @RequestMapping("/findallFeatures")
    private List<Feature> findedAllFeatures() {
        return featuresService.findedAllFeatures();
    }
}

