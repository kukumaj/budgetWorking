package com.ryszard.budgetworking.user;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit")
public class UsersUpdateController extends HttpServlet {

    private UserDao userDao = new UserDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, javax.servlet.ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userDao.findUser(id);
        System.out.println("SHOW !!!!!  " +user.areaCode);
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
        System.out.println("Update action !!!   " + id +"   "+ area);
        userDao.update(id, area);
        response.sendRedirect(request.getContextPath() + "/");
    }
}
