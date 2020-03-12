package kz.muminov.midtermrestaraunt.controller;

import kz.muminov.midtermrestaraunt.entity.Position;
import kz.muminov.midtermrestaraunt.entity.Staff;
import kz.muminov.midtermrestaraunt.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

@Component
public class StaffController {

    private Scanner in = new Scanner(System.in);
    private StaffService staffService;
    private PositionController positionController;

    @Autowired
    public StaffController(StaffService staffService, PositionController positionController){
        this.staffService = staffService;
        this.positionController = positionController;
    }

    public void showMenu(){
        System.out.println("1. Insert staff member");
        System.out.println("2. Delete staff member");
        System.out.println("3. List all staff members");
        System.out.println("4. Calculate staff member salary");
    }

    public void choice(int choice){
        switch (choice){
            case 1:
                createStaffMember();
                break;
            case 2:
                deleteStaffMember();
                break;
            case 3:
                getAllStaffMembers();
                break;
            case 4:
                calculateStaffMemberSalary();
                break;
            default:
                System.out.println("There is no such option");
        }
    }

    public void createStaffMember(){
        System.out.println("First name: ");
        String firstName = in.next();
        System.out.println("Last name: ");
        String lastName = in.next();
        System.out.println("Age: ");
        int age = in.nextInt();
        positionController.getAllPosition();
        System.out.println("Position id: ");
        Long positionId = in.nextLong();
        System.out.println("Hire date (format: 'yyyy-mm-dd'): ");
        String date = in.next();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date hireDate = null;
        try {
            hireDate = format.parse(date);
            System.out.println(format.format(hireDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Position position = new Position();
        position.setId(positionId);
        System.out.println("Base salary: ");
        float baseSalary = in.nextFloat();
        Staff staff = new Staff(firstName, lastName, age, position, hireDate, baseSalary);
        staffService.createStaffMember(staff);
    }

    public void calculateStaffMemberSalary(){
        System.out.println("Date (format: 'yyyy-mm-dd'): ");
        String date = in.next();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date incomeDate = null;
        try {
            incomeDate = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Id: ");
        Long id = in.nextLong();
        staffService.calculateStaffMemberSalary(incomeDate, id);
    }

    public void deleteStaffMember(){
        System.out.println("Enter the staff member's id: ");
        Long id = in.nextLong();
        staffService.deleteStaffMember(id);
    }

    public void getAllStaffMembers(){
        staffService.getAllStaffMembers();
    }

}
