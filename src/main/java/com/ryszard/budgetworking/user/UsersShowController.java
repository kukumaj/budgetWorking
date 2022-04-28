package com.ryszard.budgetworking.user;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/show")
public class UsersShowController extends HttpServlet {

    private UserDao userDao = new UserDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userDao.findUser(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/show_user.jsp");
        request.setAttribute("user", user);
        dispatcher.forward(request, response);
    }
}
