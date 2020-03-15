package kz.muminov.midtermrestaraunt.mapper;

import kz.muminov.midtermrestaraunt.entity.Category;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

//Class for mapping rows in result set to entity
@Component
public class CategoryMapper implements RowMapper<Category> {
    @Override
    public Category mapRow(ResultSet resultSet, int i) throws SQLException {
        Category category = new Category(
                            resultSet.getLong(1),
                            resultSet.getString(2)
        );
        return category;
    }
}
