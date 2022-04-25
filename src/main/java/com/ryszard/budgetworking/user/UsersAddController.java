package com.ryszard.budgetworking.user;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add_users")
public class UsersAddController extends HttpServlet {

    private UserDao userDao = new UserDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, javax.servlet.ServletException {
        request.getRequestDispatcher("/WEB-INF/add_user.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String area = request.getParameter("area");
        String phoneNumber = request.getParameter("phoneNumber");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String birthDate = request.getParameter("birthDate");
        String password = request.getParameter("password");
        System.out.println("TEST2     "+firstName+area+phoneNumber);
        userDao.save(area, phoneNumber, firstName, lastName, birthDate, password);

        response.sendRedirect(request.getContextPath() + "/");
    }
}