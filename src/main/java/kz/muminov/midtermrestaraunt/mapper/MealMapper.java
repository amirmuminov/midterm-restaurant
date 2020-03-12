package kz.muminov.midtermrestaraunt.mapper;

import kz.muminov.midtermrestaraunt.entity.Category;
import kz.muminov.midtermrestaraunt.entity.Meal;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MealMapper implements RowMapper<Meal> {

    @Override
    public Meal mapRow(ResultSet resultSet, int i) throws SQLException {
        Meal meal = new Meal(
                resultSet.getLong(1),
                resultSet.getString(2),
                resultSet.getFloat(3),
                new Category(resultSet.getLong(5), resultSet.getString(6))
        );
        return meal;
    }

}
