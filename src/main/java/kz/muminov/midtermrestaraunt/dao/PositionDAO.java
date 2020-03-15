package kz.muminov.midtermrestaraunt.dao;

import kz.muminov.midtermrestaraunt.connection.DatabaseConnection;
import kz.muminov.midtermrestaraunt.entity.Position;
import kz.muminov.midtermrestaraunt.mapper.PositionMapper;
import kz.muminov.midtermrestaraunt.notification.event.PositionDeleteEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PositionDAO implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher eventPublisher;
    private JdbcTemplate jdbcTemplate;

    //Insert new category
    private final String INSERT_INTO_POSITION = "INSERT INTO position(name) VALUES (?)";
    //Delete category
    private final String DELETE_POSITION = "DELETE FROM position WHERE id = ?";
    //Get all categories
    private final String GET_ALL_POSITIONS = "SELECT id, name FROM position";

    @Autowired
    public PositionDAO(DatabaseConnection databaseConnection){
        this.jdbcTemplate = new JdbcTemplate(databaseConnection.getDriverManagerDataSource());
    }

    public int createPosition(Position position){
        return jdbcTemplate.update(INSERT_INTO_POSITION, position.getName());
    }

    public int deletePosition(Long id){
        eventPublisher.publishEvent(new PositionDeleteEvent(this, id));
        return jdbcTemplate.update(DELETE_POSITION, id);
    }

    public List<Position> getAllPositions(){
        return jdbcTemplate.query(GET_ALL_POSITIONS, new PositionMapper());
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }
}
