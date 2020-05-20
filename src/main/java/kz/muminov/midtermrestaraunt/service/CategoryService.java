package kz.muminov.midtermrestaraunt.service;

import kz.muminov.midtermrestaraunt.entity.Category;
import kz.muminov.midtermrestaraunt.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }

    public Category saveCategory(Category mealCategory) {
        return categoryRepository.save(mealCategory);
    }
}
