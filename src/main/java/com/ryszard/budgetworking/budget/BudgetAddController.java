package com.ryszard.budgetworking.budget;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/add")
public class BudgetAddController extends HttpServlet {
    private BudgetService budgetService = new BudgetService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, javax.servlet.ServletException {
        request.getRequestDispatcher("/WEB-INF/addform.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String description = request.getParameter("description");
        BigDecimal value = new BigDecimal(request.getParameter("value"));
        BudgetItemType type = BudgetItemType.valueOf(request.getParameter("type"));
        BudgetItemDto budgetItem = new BudgetItemDto(description, value);
        if (type == BudgetItemType.EXPENSE)
            budgetService.addExpense(budgetItem);
        else if (type == BudgetItemType.INCOME)
            budgetService.addIncome(budgetItem);
        response.sendRedirect(request.getContextPath() + "/");
    }
}