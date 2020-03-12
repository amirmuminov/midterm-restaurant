package kz.muminov.midtermrestaraunt.dao;

import kz.muminov.midtermrestaraunt.connection.DatabaseConnection;
import kz.muminov.midtermrestaraunt.entity.Meal;
import kz.muminov.midtermrestaraunt.mapper.MealMapper;
import kz.muminov.midtermrestaraunt.notification.event.MealDeleteEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MealDAO implements ApplicationEventPublisherAware {

    private JdbcTemplate jdbcTemplate;
    private ApplicationEventPublisher eventPublisher;

    private final String GET_ALL_MEALS = "SELECT * FROM meal JOIN category c on meal.category_id = c.id ORDER BY c.name";
    private final String DELETE_MEAL = "DELETE FROM meal WHERE id = ?";
    private final String INSERT_NEW_MEAL = "INSERT INTO meal(name, price, category_id) VALUES(?, ?, ?)";

    @Autowired
    public MealDAO(DatabaseConnection databaseConnection){
        this.jdbcTemplate = new JdbcTemplate(databaseConnection.getDriverManagerDataSource());
    }

    public List<Meal> getAllMeals(){
        return jdbcTemplate.query(GET_ALL_MEALS, new MealMapper());
    }

    public int deleteMeal(Long id){
        eventPublisher.publishEvent(new MealDeleteEvent(this, id));
        return jdbcTemplate.update(DELETE_MEAL, id);
    }

    public int createMeal(Meal meal){
        return jdbcTemplate.update(INSERT_NEW_MEAL, meal.getName(), meal.getPrice(), meal.getCategory().getId());
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }
}
