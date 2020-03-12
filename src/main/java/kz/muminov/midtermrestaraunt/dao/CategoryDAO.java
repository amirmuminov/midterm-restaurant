package kz.muminov.midtermrestaraunt.dao;

import kz.muminov.midtermrestaraunt.connection.DatabaseConnection;
import kz.muminov.midtermrestaraunt.entity.Category;
import kz.muminov.midtermrestaraunt.mapper.CategoryMapper;
import kz.muminov.midtermrestaraunt.notification.event.CategoryDeleteEvent;
import kz.muminov.midtermrestaraunt.notification.event.PositionDeleteEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryDAO implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher eventPublisher;
    private JdbcTemplate jdbcTemplate;

    private final String INSERT_INTO_CATEGORY = "INSERT INTO category(name) VALUES (?)";
    private final String DELETE_CATEGORY = "DELETE FROM category WHERE id = ?";
    private final String GET_ALL_CATEGORIES = "SELECT id, name FROM category";

    @Autowired
    public CategoryDAO(DatabaseConnection databaseConnection){
        this.jdbcTemplate = new JdbcTemplate(databaseConnection.getDriverManagerDataSource());
    }

    public int createCategory(Category category){
        return jdbcTemplate.update(INSERT_INTO_CATEGORY, category.getName());
    }

    public int deleteCategory(Long id){
        eventPublisher.publishEvent(new CategoryDeleteEvent(this, id));
        return jdbcTemplate.update(DELETE_CATEGORY, id);
    }

    public List<Category> getAllCategories(){
        return jdbcTemplate.query(GET_ALL_CATEGORIES, new CategoryMapper());
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }
}
