package kz.muminov.midtermrestaraunt.controller;

import kz.muminov.midtermrestaraunt.entity.Category;
import kz.muminov.midtermrestaraunt.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CategoryController {

    private Scanner in = new Scanner(System.in);
    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public void showMenu(){
        System.out.println("1. Insert category");
        System.out.println("2. Delete category");
        System.out.println("3. List all categories");
    }

    public void choice(int choice){
        switch (choice){
            case 1:
                createCategory();
                break;
            case 2:
                deleteCategory();
                break;
            case 3:
                getAllCategories();
                break;
            default:
                System.out.println("There is no such option");
        }
    }

    public void createCategory(){
        System.out.println("Category name: ");
        String name = in.next();
        categoryService.createCategory(new Category(name));
    }

    public void deleteCategory(){
        System.out.println("Category id");
        Long id = in.nextLong();
        categoryService.deleteCategory(id);
    }

    public void getAllCategories(){
        categoryService.getAllCategories();
    }
}
