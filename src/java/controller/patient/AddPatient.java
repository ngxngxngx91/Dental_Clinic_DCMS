package controller.patient;

import dao.AuthenticationDAO;
import model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
//import java.sql.SQLException;

/**
 *
 * @author ntawo
 */
@WebServlet("/patient")
public class AddPatient extends HttpServlet {

    private AuthenticationDAO dao;

    @Override
    public void init() throws ServletException {
        dao = new AuthenticationDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        String action = request.getParameter("action");
        String username = request.getParameter("username");
        String displayName = request.getParameter("displayName");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String mobile = request.getParameter("mobile");
        String password = request.getParameter("password");
        String others = request.getParameter("others");
        String image = request.getParameter("image");
        String dob = request.getParameter("dob");

        User user = new User();
        user.setUsername(username);
        user.setDisplayName(displayName);
        user.setEmail(email);
        user.setAddress(address);
        user.setMobile(mobile);
        user.setPassword(password);
        user.setOthers(others);
        user.setImage(image);
        user.setDob(dob);

        try {
            if ("add".equals(action)) {
                if (!dao.existedUser(username) && !dao.existedEmail(email)) {
                    dao.register(user);
                    response.sendRedirect("viewpatient?msg=added");
                } else {
                    response.sendRedirect("viewpatient?msg=error");
                }
            }
        } catch (IOException e) {
            out.print("error:An error occurred: " + e.getMessage());
        }
    }
}
