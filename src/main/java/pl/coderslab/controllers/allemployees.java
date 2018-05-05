package pl.coderslab.controllers;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.models.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/allemployees")
public class allemployees extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Employee[] employees = EmployeeDao.findAllEmployees();
        request.setAttribute("employees", employees);
        getServletContext().getRequestDispatcher("/allemployees.jsp").forward(request,response);

    }
}
