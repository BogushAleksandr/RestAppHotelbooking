package hotel.controller;


import hotel.entities.Feature;
import hotel.repositories.FeaturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class FeaturesController {
    @Autowired
    FeaturesRepository featuresRepository;
    @ResponseBody
    @RequestMapping("/saveFeatures")
    public String addFeatures() {
        featuresRepository.save(new Feature("Ужин1", 151.59));
        featuresRepository.save(new Feature("Ужин2", 1.59));
        featuresRepository.save(new Feature("Ужин3", 1353.59));
        featuresRepository.save(new Feature("Ужин4", 19.59));
        featuresRepository.save(new Feature("Ужин5", 19.19));
        featuresRepository.save(new Feature("Обед6", 3.9));
        return "Done!";
    }
    @ResponseBody
    @RequestMapping("/findallFeatures")
    public String findedAllFeatures() {
        StringBuilder result = new StringBuilder(" ");
        for (Feature feature : featuresRepository.findAll()) {
            result.append(feature.toString()).append("</br>");
        }
        return result.toString();
    }
}

