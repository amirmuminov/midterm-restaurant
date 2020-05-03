package kz.muminov.midtermrestaraunt.exception.types;

public class MealNotFoundException extends NullPointerException {

    public MealNotFoundException(){
        super("Meal with this ID is not found");
    }

    public MealNotFoundException(Long id){
        super("Meal with ID " + id + " is not found");
    }

}
