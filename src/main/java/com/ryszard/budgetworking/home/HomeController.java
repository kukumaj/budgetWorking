package com.ryszard.budgetworking.home;

import com.ryszard.budgetworking.budget.BudgetItemDto;
import com.ryszard.budgetworking.budget.BudgetService;
import com.ryszard.budgetworking.budget.BudgetSummaryDto;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("")
public class HomeController extends HttpServlet {
    private BudgetService budgetService = new BudgetService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BudgetItemDto> incomes = budgetService.findAllIncomes();
        List<BudgetItemDto> expenses = budgetService.findAllExpenses();
        BudgetSummaryDto summary = budgetService.getSummary();
        request.setAttribute("incomes", incomes);
        request.setAttribute("expenses", expenses);
        request.setAttribute("summary", summary);
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }
}
