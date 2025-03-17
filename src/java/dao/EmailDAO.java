/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

/**
 *
 * @author ntawo
 */
public class EmailDAO extends DBContext {

    public String getdoctorEmailByAppointmentID(int AppointmentID) {
        String sql = "SELECT \n"
                + "    \n"
                + "    tbl_email\n"
                + "   \n"
                + "FROM \n"
                + "    [User] u\n"
                + "WHERE \n"
                + "    u.tbl_userID = (select a.tbl_controllerID from Appointment a where a.tbl_appointmentID = ?) ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, AppointmentID);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                User u = new User();
                u.setEmail(rs.getString("tbl_email"));
                return u.getEmail();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    // public boolean checkMail(String mail) {
    //     String sql = "select * from [User] "
    //             + "where tbl_email = ?";
    //     try {
    //         PreparedStatement ab = connection.prepareStatement(sql);
    //         ab.setString(1, mail);
    //         ResultSet rs = ab.executeQuery();
    //         if (rs.next()) {
    //             return true;
    //         }
    //     } catch (SQLException e) {
    //         System.out.println(e);
    //     }
    //     return false;
    // }
    // public boolean checkUsernameAndPsw(String username, String psw) {
    //     String sql = "SELECT * FROM [User] "
    //             + "WHERE tbl_username = ? "
    //             + "AND tbl_password = ?";
    //     try {
    //         PreparedStatement st = connection.prepareStatement(sql);
    //         st.setString(1, username);
    //         st.setString(2, psw);
    //         ResultSet rs = st.executeQuery();
    //         if (rs.next()) {
    //             return true;
    //         }
    //     } catch (SQLException e) {
    //         System.out.println(e);
    //     } catch (NullPointerException e) {
    //         System.out.println("");
    //     }
    //     return false;
    // }
    public String getEmailByAppointmentID(int appointmentID) {
        String email = null;
        String sql = "select u.tbl_email from [User] u\n"
                + "where u.tbl_userID=(select a.tbl_patientID from Appointment a\n"
                + "where a.tbl_appointmentID=?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, appointmentID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                email = rs.getString("tbl_email");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return email;
    }

}
