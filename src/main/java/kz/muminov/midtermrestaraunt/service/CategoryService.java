package kz.muminov.midtermrestaraunt.service;

import kz.muminov.midtermrestaraunt.dao.CategoryDAO;
import kz.muminov.midtermrestaraunt.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryService {

    private CategoryDAO categoryDAO;

    @Autowired
    public CategoryService(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    public void createCategory(Category category){
        int affectedRows = categoryDAO.createCategory(category);
        System.out.println("Affected rows: " + affectedRows);
    }

    public void deleteCategory(Long id){
        int affectedRows = categoryDAO.deleteCategory(id);
        System.out.println("Affected rows: " + affectedRows);
    }

    public void getAllCategories(){
        for (Category category: categoryDAO.getAllCategories()){
            System.out.println(category.getId() + ". " + category.getName());
        }
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - -");
    }

}
