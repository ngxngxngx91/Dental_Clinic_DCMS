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
import model.Service;
import model.Appointment;

public class ServiceDAO extends DBContext {

    public List<Service> getService() {
        List<Service> services = new ArrayList<>();
        String sql = "SELECT * FROM [Service] ";
        try {

            PreparedStatement pt = connection.prepareStatement(sql);
            ResultSet resultSet = pt.executeQuery();

            while (resultSet.next()) {
                Service service = new Service();
                service.setServiceID(resultSet.getInt("tbl_serviceID"));
                service.setServiceName(resultSet.getString("tbl_serviceName"));
                service.setDescription(resultSet.getString("tbl_description"));
                service.setTime(Integer.parseInt(resultSet.getString("tbl_time")));
                service.setPrice(resultSet.getInt("tbl_price"));
                service.setImage(resultSet.getString("tbl_image"));
                services.add(service);
            }
        } catch (SQLException e) {
        }
        return services;
    }

    public Service getServiceByName(String serviceName) {
        String sql = "SELECT * FROM [service] "
                + "WHERE tbl_serviceName = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, serviceName);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Service service = new Service();
                service.setServiceName(rs.getString("tbl_serviceName"));
                service.setDescription(rs.getString("tbl_description"));
                service.setPrice(rs.getFloat("tbl_price"));
                service.setTime(rs.getInt("tbl_time"));
                return service;
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e);
        }
        return null;
    }

    public int getserviceID(int appointmentID) {
        List<Appointment> Appointments = new ArrayList<>();
        String sql = "select a.tbl_serviceID from Appointment a\n"
                + "where a.tbl_appointmentID=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, appointmentID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Service a = new Service();
                a.setServiceID(rs.getInt("tbl_serviceID"));
                return a.getServiceID();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Service getServiceByID(int serviceID) {
        String sql = "SELECT * FROM [service] " + "WHERE tbl_serviceID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, serviceID);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Service service = new Service();
                service.setServiceID(rs.getInt("tbl_serviceID"));
                service.setServiceName(rs.getString("tbl_serviceName"));
                service.setDescription(rs.getString("tbl_description"));
                service.setPrice(rs.getFloat("tbl_price"));
                service.setTime(rs.getInt("tbl_time"));
                service.setImage(rs.getString("tbl_image"));
                return service;
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e);
        }
        return null;
    }
}
