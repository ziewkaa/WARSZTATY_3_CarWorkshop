package pl.coderslab.controllers;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.models.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/employeedetails")
public class employeedetails extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int employee_id = Integer.parseInt(request.getParameter("id"));
        Employee employee = EmployeeDao.read(employee_id);
        request.setAttribute("employee", employee);
        getServletContext().getRequestDispatcher("/employeedetails.jsp").forward(request,response);

    }
}
