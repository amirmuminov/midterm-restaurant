package kz.muminov.midtermrestaraunt.contoller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import kz.muminov.midtermrestaraunt.entity.Meal;
import kz.muminov.midtermrestaraunt.service.MealService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meal")
@CrossOrigin(origins = "http://localhost:3000")
@Api(value = "Meal management system")
public class MealController {

    private final MealService mealService;

    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping("")
    @ApiOperation(value = "Get all meals", response = List.class)
    public List<Meal> getMeals(){
        return mealService.getMeals();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get meal by id", response = Meal.class)
    public Meal getMealById(@ApiParam(value = "ID to find the meal") @PathVariable Long id){
        return mealService.getMealById(id);
    }

    @PostMapping("")
    @ApiOperation(value = "Save meal", response = Meal.class)
    public Meal saveMeal(@ApiParam(value = "Meal body to save it into database") @RequestBody Meal meal){
        return mealService.saveMeal(meal);
    }

}
