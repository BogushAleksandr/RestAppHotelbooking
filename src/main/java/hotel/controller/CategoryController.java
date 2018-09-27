package hotel.controller;


import hotel.entities.Category;
import hotel.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping("/findallCategory")
    public String findAllCategory() {
        String resultCategory = " ";
        for (Category category : categoryRepository.findAll()) {
            resultCategory += category.toString() + "</br>";
        }
        return resultCategory;
    }


}
