package kz.muminov.midtermrestaraunt.contoller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import kz.muminov.midtermrestaraunt.entity.MealCategory;
import kz.muminov.midtermrestaraunt.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@Api(value = "Category Management System")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("")
    @ApiOperation(value = "Get all categories", response = List.class)
    public List<MealCategory> getCategories(){
        return categoryService.getCategories();
    }

    @PostMapping("")
    @ApiOperation(value = "Save category into the database", response = MealCategory.class)
    public MealCategory saveCategory(@ApiParam(value = "Object to be saved into the database") @RequestBody MealCategory mealCategory){
        return categoryService.saveCategory(mealCategory);
    }

}
