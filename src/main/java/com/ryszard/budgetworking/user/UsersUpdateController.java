package com.ryszard.budgetworking.user;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Enumeration;

@WebServlet("/edit")
public class UsersUpdateController extends HttpServlet {

    private UserDao userDao = new UserDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, javax.servlet.ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userDao.findUser(id);
        System.out.println("SHOW !!!!!  " + user.areaCode);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/add_user.jsp");
        System.out.println("User!!!");
        System.out.println(user);
        request.setAttribute("user", user);
        dispatcher.forward(request, response);
        //request.getRequestDispatcher("/WEB-INF/add_user.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String area = request.getParameter("area");
        String phoneNumber = request.getParameter("phoneNumber");
        Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements()) {
            System.out.println(names.nextElement());
        }
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("last name");
        String password = request.getParameter("password");
        User user = new User(area, phoneNumber, firstName, lastName, password);
        userDao.update(id, user);
        response.sendRedirect(request.getContextPath() + "/");
    }
}
