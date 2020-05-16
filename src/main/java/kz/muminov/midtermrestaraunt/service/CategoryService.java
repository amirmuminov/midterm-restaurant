package kz.muminov.midtermrestaraunt.service;

import kz.muminov.midtermrestaraunt.entity.MealCategory;
import kz.muminov.midtermrestaraunt.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<MealCategory> getCategories(){
        return categoryRepository.findAll();
    }

    public MealCategory saveCategory(MealCategory mealCategory) {
        return categoryRepository.save(mealCategory);
    }
}
