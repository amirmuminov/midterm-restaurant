package kz.muminov.midtermrestaraunt.mapper;

import kz.muminov.midtermrestaraunt.entity.Position;
import kz.muminov.midtermrestaraunt.entity.Staff;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StaffMapper implements RowMapper<Staff> {

    @Override
    public Staff mapRow(ResultSet resultSet, int i) throws SQLException {
        Staff staff = new Staff(
                        resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        new Position(resultSet.getLong(6), resultSet.getString(7)),
                        resultSet.getDate(5),
                        resultSet.getFloat(6)
                    );
        return staff;
    }

}
