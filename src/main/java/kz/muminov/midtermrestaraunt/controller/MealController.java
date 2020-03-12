package kz.muminov.midtermrestaraunt.controller;

import kz.muminov.midtermrestaraunt.entity.Category;
import kz.muminov.midtermrestaraunt.entity.Meal;
import kz.muminov.midtermrestaraunt.service.CategoryService;
import kz.muminov.midtermrestaraunt.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MealController {
    private Scanner in = new Scanner(System.in);
    private MealService mealService;
    private CategoryController categoryController;

    @Autowired
    public MealController(MealService mealService, CategoryController categoryController) {
        this.mealService = mealService;
        this.categoryController = categoryController;
    }

    public void showMenu(){
        System.out.println("1. Insert meal");
        System.out.println("2. Delete meal");
        System.out.println("3. List all meals");
    }

    public void choice(int choice){
        switch (choice){
            case 1:
                createMeal();
                break;
            case 2:
                deleteMeal();
                break;
            case 3:
                getAllMeals();
                break;
            default:
                System.out.println("There is no such option");
        }
    }

    public void createMeal(){
        System.out.println("Meal name: ");
        String name = in.next();
        System.out.println("Meal price: ");
        float price = in.nextFloat();
        categoryController.getAllCategories();
        System.out.println("Meal category: ");
        Long categoryChoice = in.nextLong();
        Category category = new Category();
        category.setId(categoryChoice);
        Meal meal = new Meal(name, price, category);
        mealService.createMeal(meal);
    }

    public void deleteMeal(){
        System.out.println("Id: ");
        Long id = in.nextLong();
        mealService.deleteMeal(id);
    }

    public void getAllMeals(){
        mealService.getAllMeals();
    }

}
