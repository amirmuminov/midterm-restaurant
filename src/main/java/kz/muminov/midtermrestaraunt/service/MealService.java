package kz.muminov.midtermrestaraunt.service;

import kz.muminov.midtermrestaraunt.dao.MealDAO;
import kz.muminov.midtermrestaraunt.entity.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MealService {

    private MealDAO mealDAO;

    @Autowired
    public MealService(MealDAO mealDAO){
        this.mealDAO = mealDAO;
    }

    public void deleteMeal(Long id){
        int affectedRows = mealDAO.deleteMeal(id);
        System.out.println("Affected rows: " + affectedRows);
    }

    public void createMeal(Meal meal){
        int affectedRows = mealDAO.createMeal(meal);
        System.out.println("Affected rows: " + affectedRows);
    }

    public void getAllMeals(){
        for(Meal meal: mealDAO.getAllMeals()){
            System.out.println("Id: " + meal.getId());
            System.out.println("Name: " + meal.getName());
            System.out.println("Price: " + meal.getPrice());
            System.out.println("Category: " + meal.getCategory().getName());
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - -");
        }
    }

}
