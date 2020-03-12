package kz.muminov.midtermrestaraunt.service;

import kz.muminov.midtermrestaraunt.dao.StaffDAO;
import kz.muminov.midtermrestaraunt.entity.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class StaffService {

    private StaffDAO staffDAO;

    @Autowired
    public StaffService(StaffDAO staffDAO){
        this.staffDAO = staffDAO;
    }

    public void getAllStaffMembers(){
        for (Staff staff: staffDAO.getAllStaff()) {
            System.out.println("Id: " + staff.getId());
            System.out.println("First name: " + staff.getFirstName());
            System.out.println("Last name: " + staff.getLastName());
            System.out.println("Age: " + staff.getAge());
            System.out.println("Hire date: " + staff.getHireDate());
            System.out.println("Position: " + staff.getPosition().getName());
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - -");
        }
    }

    public void deleteStaffMember(Long id) {
        int affectedRows = staffDAO.deleteStaffMember(id);
        System.out.println("Affected rows: " + affectedRows);
    }

    public void createStaffMember(Staff staff) {
        int affectedRows = staffDAO.createStaffMember(staff);
        System.out.println("Affected rows: " + affectedRows);
    }

    public void calculateStaffMemberSalary(Date date, Long id){
        for (Staff staff: staffDAO.calculateSalary(id, date)) {
            System.out.println("Id: " + staff.getId());
            System.out.println("First name: " + staff.getFirstName());
            System.out.println("Last name: " + staff.getLastName());
            System.out.println("Salary: " + staff.getBaseSalary());
        }
    }
}
