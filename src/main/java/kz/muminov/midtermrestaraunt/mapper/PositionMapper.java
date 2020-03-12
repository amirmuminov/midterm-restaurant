package kz.muminov.midtermrestaraunt.mapper;

import kz.muminov.midtermrestaraunt.entity.Position;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PositionMapper implements RowMapper<Position> {

    @Override
    public Position mapRow(ResultSet resultSet, int i) throws SQLException {
        Position position = new Position(
                resultSet.getLong(1),
                resultSet.getString(2)
        );
        return position;
    }
}
