package kz.muminov.midtermrestaraunt.service;

import kz.muminov.midtermrestaraunt.entity.Meal;
import kz.muminov.midtermrestaraunt.repository.MealRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MealService {

    private final MealRepository mealRepository;

    public MealService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    public List<Meal> getMeals(){
        return mealRepository.findAll();
    }

    public Meal getMealById(Long id){
        Optional<Meal> meal = mealRepository.findById(id);
        return meal.orElse(null);
    }

    public Meal saveMeal(Meal meal){
        return mealRepository.save(meal);
    }

}
