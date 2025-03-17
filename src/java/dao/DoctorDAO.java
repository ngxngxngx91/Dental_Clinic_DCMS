package dao;

import dal.DBContext;
import java.sql.Date;
import model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.User;

public class DoctorDAO extends DBContext {

    public List<User> getDoctor() {
        List<User> employees = new ArrayList<>();
        String sql = "SELECT * FROM [user] \n"
                + "WHERE tbl_role = 'doctor' and tbl_isActive= 'active'";
        try {

            PreparedStatement pt = connection.prepareStatement(sql);
            ResultSet resultSet = pt.executeQuery();

            while (resultSet.next()) {
                User user = new User();
                user.setUserID(Integer.parseInt(resultSet.getString("tbl_userID")));
                user.setUsername(resultSet.getString("tbl_username"));
                user.setDisplayName(resultSet.getString("tbl_displayname"));
                user.setEmail(resultSet.getString("tbl_email"));
                user.setAddress(resultSet.getString("tbl_address"));
                user.setMobile(resultSet.getString("tbl_mobile"));
                user.setRole(resultSet.getString("tbl_role"));
                user.setOthers(resultSet.getString("tbl_others"));
                user.setImage(resultSet.getString("tbl_image"));

                employees.add(user);
            }
        } catch (SQLException e) {
        }
        return employees;
    }
}
