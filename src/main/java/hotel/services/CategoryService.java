package hotel.services;

import hotel.entities.Category;
import hotel.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public String findAllCategory() {
        String resultCategory = " ";
        for (Category category : categoryRepository.findAll()) {
            resultCategory += category.toString() + "</br>";
        }
        return resultCategory;
    }
}
