package com.ryszard.budgetworking.user;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UsersController extends HttpServlet {
    private UserDao userDao = new UserDao();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, javax.servlet.ServletException {
        List<User> allUsers = userDao.findAllUsers();
        request.setAttribute("users", allUsers);

        request.getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
    }
}