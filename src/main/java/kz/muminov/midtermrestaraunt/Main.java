package kz.muminov.midtermrestaraunt;

import kz.muminov.midtermrestaraunt.config.SpringConfig;
import kz.muminov.midtermrestaraunt.controller.CategoryController;
import kz.muminov.midtermrestaraunt.controller.MealController;
import kz.muminov.midtermrestaraunt.controller.PositionController;
import kz.muminov.midtermrestaraunt.controller.StaffController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        //Getting controllers from the context
        PositionController positionController = context.getBean("positionController", PositionController.class);
        StaffController staffController = context.getBean("staffController", StaffController.class);
        CategoryController categoryController = context.getBean("categoryController", CategoryController.class);
        MealController mealController = context.getBean("mealController", MealController.class);
        //Call method which shows entity on which you want to perform some actions
        showMenu();
        //Choose the entity
        int choice = in.nextInt();

        while(choice != 0){
            switch (choice){
                case 1:
                    //Call method which shows controller's menu
                    positionController.showMenu();
                    //User inputs number depending on operation he would like to perform
                    int controllerMenuChoice = in.nextInt();
                    //Passing user's choice to the controller's method which is responsible for handling user's choice
                    positionController.choice(controllerMenuChoice);
                    break;
                case 2:
                    staffController.showMenu();
                    controllerMenuChoice = in.nextInt();
                    staffController.choice(controllerMenuChoice);
                    break;
                case 3:
                    categoryController.showMenu();
                    controllerMenuChoice = in.nextInt();
                    categoryController.choice(controllerMenuChoice);
                    break;
                case 4:
                    mealController.showMenu();
                    controllerMenuChoice = in.nextInt();
                    mealController.choice(controllerMenuChoice);
                    break;
                default:
                    System.out.println("There is no such option");
            }
            showMenu();
            choice = in.nextInt();
        }
    }

    private static void showMenu(){
        System.out.println("0. Exit");
        System.out.println("1. Position");
        System.out.println("2. Staff");
        System.out.println("3. Category");
        System.out.println("4. Meal");
    }
}
