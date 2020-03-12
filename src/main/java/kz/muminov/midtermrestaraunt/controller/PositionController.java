package kz.muminov.midtermrestaraunt.controller;

import kz.muminov.midtermrestaraunt.entity.Position;
import kz.muminov.midtermrestaraunt.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class PositionController {

    private Scanner in = new Scanner(System.in);
    private PositionService positionService;

    @Autowired
    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    public void showMenu(){
        System.out.println("1. Insert position");
        System.out.println("2. Delete position");
        System.out.println("3. List all positions");
    }

    public void choice(int choice){
        switch (choice){
            case 1:
                createPosition();
                break;
            case 2:
                deletePosition();
                break;
            case 3:
                getAllPosition();
                break;
            default:
                System.out.println("There is no such option");
        }
    }

    public void createPosition(){
        System.out.println("Position name: ");
        String name = in.next();
        positionService.createPosition(new Position(name));
    }

    public void deletePosition(){
        System.out.println("Position id");
        Long id = in.nextLong();
        positionService.deletePosition(id);
    }

    public void getAllPosition(){
        positionService.getAllPositions();
    }
}
