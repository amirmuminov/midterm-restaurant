package kz.muminov.midtermrestaraunt.mapper;

import kz.muminov.midtermrestaraunt.entity.Staff;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StaffSalaryMapper implements RowMapper<Staff> {
    @Override
    public Staff mapRow(ResultSet resultSet, int i) throws SQLException {
        Staff staff = new Staff();
        staff.setId(resultSet.getLong(1));
        staff.setFirstName(resultSet.getString(2));
        staff.setLastName(resultSet.getString(3));
        staff.setBaseSalary(resultSet.getFloat(4));
        return staff;
    }
}
