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

public class AuthenticationDAO extends DBContext {

    public User check(String username, String password) {
        String sql = "SELECT [tbl_userID],\n"
                + "       [tbl_username],\n"
                + "       [tbl_password],\n"
                + "       [tbl_displayName],\n"
                + "       [tbl_email],\n"
                + "       [tbl_address],\n"
                + "       [tbl_mobile],\n"
                + "       [tbl_role],\n"
                + "       [tbl_others],\n"
                + "       [tbl_isActive],\n"
                + "       [tbl_image],\n"
                + "       [tbl_dob],\n"
                + "       YEAR(GETDATE()) - YEAR([tbl_dob]) AS [age]\n"
                + "  FROM [dbo].[User]\n"
                + " WHERE tbl_username = ? AND tbl_password = ? AND tbl_isActive = 'active'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                User u = new User();
                u.setUsername(username);
                u.setPassword(password);
                u.setUserID(rs.getInt("tbl_userID"));
                u.setRole(rs.getString("tbl_role"));
                u.setDisplayName(rs.getString("tbl_displayname"));
                u.setEmail(rs.getString("tbl_email"));
                u.setAddress(rs.getString("tbl_address"));
                u.setMobile(rs.getString("tbl_mobile"));
                u.setOthers(rs.getString("tbl_others"));
                u.setIsActive(rs.getString("tbl_isActive"));
                u.setImage(rs.getString("tbl_image"));
                u.setDob(rs.getString("tbl_dob"));
                u.setAge(rs.getInt("age"));
                return u;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public boolean existedUser(String username) {
        String sql = "SELECT [tbl_userID],\n"
                + "       [tbl_username],\n"
                + "       [tbl_password],\n"
                + "       [tbl_displayName],\n"
                + "       [tbl_email],\n"
                + "       [tbl_address],\n"
                + "       [tbl_mobile],\n"
                + "       [tbl_role],\n"
                + "       [tbl_others],\n"
                + "       [tbl_isActive],\n"
                + "       [tbl_image],\n"
                + "       YEAR(GETDATE()) - YEAR([tbl_dob]) AS [age]\n"
                + "  FROM [dbo].[User]\n"
                + " WHERE tbl_username = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean existedEmail(String email) {
        String sql = "SELECT [tbl_userID],\n"
                + "       [tbl_username],\n"
                + "       [tbl_password],\n"
                + "       [tbl_displayName],\n"
                + "       [tbl_email],\n"
                + "       [tbl_address],\n"
                + "       [tbl_mobile],\n"
                + "       [tbl_role],\n"
                + "       [tbl_others],\n"
                + "       [tbl_isActive],\n"
                + "       [tbl_image],\n"
                + "       YEAR(GETDATE()) - YEAR([tbl_dob]) AS [age]\n"
                + "  FROM [dbo].[User]\n"
                + " WHERE tbl_email=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public void register(User u) {
        String sql = "INSERT INTO [dbo].[User] "
                + "(tbl_username, "
                + "tbl_displayName, "
                + "tbl_email, "
                + "tbl_dob, "
                + "[tbl_password]) "
                + "VALUES "
                + "(?, "
                + "?, "
                + "?, "
                + "?, "
                + "?)";
        try {
            System.out.println("Registering user: " + u.getUsername() + ", " + u.getDisplayName() + ", " + u.getPassword() + ", " + u.getEmail() + ", " + u.getDob());
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, u.getUsername());
            st.setString(2, u.getDisplayName());
            st.setString(3, u.getEmail());
            st.setString(4, u.getDob());
            st.setString(5, u.getPassword());
            int rowsInserted = st.executeUpdate();
            System.out.println("Rows inserted: " + rowsInserted);
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e);
        }
    }

}
