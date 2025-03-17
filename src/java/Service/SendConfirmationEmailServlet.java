/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Service;

import dao.EmailDAO;
import dao.AppointmentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//import java.util.List;
import model.Appointment;

/**
 *
 * @author ADMIN
 */
public class SendConfirmationEmailServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SendConfirmationEmailServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SendConfirmationEmailServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int appointmentID = Integer.parseInt(request.getParameter("appointmentID"));

        // Lấy thông tin lịch hẹn từ cơ sở dữ liệu
        AppointmentDAO dao = new AppointmentDAO();
        Appointment appointment = dao.getAppointmentsByID(appointmentID);
        dao.updateAppointmentStatus(request.getParameter("appointmentID"), "waiting confirm");

        // Tạo nội dung email
        String subject = "Xác nhận lịch hẹn";
        String message = String.format(
                "Dear Dr. %s,\\n\\nYou have a new appointment that needs confirmation:\\n Patient: %s\\n Date and Time: %s\\n Reason: %s\\n Please log in to proceed: http://localhost:9999/Dental_Clinic_DCMS/login.jsp\\n Best regards,\\n Dental Clinic",
                appointment.getController(),
                appointment.getPatient(),
                appointment.getDate(),
                appointment.getNote()
        );

        // Gửi email
        EmailDAO email_dao = new EmailDAO();
        Email.sendEmail(email_dao.getdoctorEmailByAppointmentID(appointmentID), subject, message);

        // Chuyển hướng về trang quản lý lịch hẹn
        response.sendRedirect("doctor.jsp");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
