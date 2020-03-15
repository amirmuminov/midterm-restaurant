package kz.muminov.midtermrestaraunt.dao;

import kz.muminov.midtermrestaraunt.connection.DatabaseConnection;
import kz.muminov.midtermrestaraunt.entity.Staff;
import kz.muminov.midtermrestaraunt.mapper.StaffMapper;
import kz.muminov.midtermrestaraunt.mapper.StaffSalaryMapper;
import kz.muminov.midtermrestaraunt.notification.event.StaffDeleteEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class StaffDAO implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher eventPublisher;
    private JdbcTemplate jdbcTemplate;

    private final String GET_ALL_STAFF = "SELECT s.id, first_name, last_name, age, hire_date, p.id, name FROM staff s\n" +
                                         "JOIN position p ON p.id = s.position_id";
    private final String DELETE_STAFF_MEMBER = "DELETE FROM staff WHERE id = ?";
    private final String INSERT_NEW_STAFF_MEMBER = "INSERT INTO staff(first_name, last_name, age, position_id, hire_date, base_salary)" +
                                                    "VALUES (?, ?, ?, ?, ?, ?)";
    //Query for calculating staff member's salary depending on his position and day
    private final String CALCULATE_SALARY_FOR_EMPLOYEE =    "SELECT\n" +
                                                            "       s.id,\n" +
                                                            "       first_name,\n" +
                                                            "       last_name,\n" +
                                                            "       CASE WHEN name = 'Waiter' THEN base_salary + (income.income * 0.1)\n" +
                                                            "       ELSE base_salary\n" +
                                                            "       END salary\n" +
                                                            "FROM\n" +
                                                            "     staff s\n" +
                                                            "JOIN\n" +
                                                            "     position p on s.position_id = p.id\n" +
                                                            "CROSS JOIN\n" +
                                                            "         income\n" +
                                                            "WHERE income.day = ? AND s.id = ?";

    public StaffDAO(DatabaseConnection databaseConnection){
        this.jdbcTemplate = new JdbcTemplate(databaseConnection.getDriverManagerDataSource());
    }

    public List<Staff> getAllStaff(){
        return jdbcTemplate.query(GET_ALL_STAFF, new StaffMapper());
    }

    public int deleteStaffMember(Long id) {
        //Publish event when staff member was deleted
        eventPublisher.publishEvent(new StaffDeleteEvent(this, id));
        return jdbcTemplate.update(DELETE_STAFF_MEMBER, id);
    }

    public int createStaffMember(Staff staff){
        return jdbcTemplate.update(INSERT_NEW_STAFF_MEMBER, staff.getFirstName(), staff.getLastName(), staff.getAge(), staff.getPosition().getId(), staff.getHireDate(), staff.getBaseSalary());
    }

    public List<Staff> calculateSalary(Long id, Date date){
        return jdbcTemplate.query(CALCULATE_SALARY_FOR_EMPLOYEE, new StaffSalaryMapper(), date, id);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }

}
