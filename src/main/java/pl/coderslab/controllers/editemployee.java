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

@WebServlet("/editemployee")
public class editemployee extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        int employee_id = (int) session.getAttribute("employee_id");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String address = request.getParameter("address");
        String number = request.getParameter("number");
        String note = request.getParameter("note");
        double salary = Double.parseDouble(request.getParameter("salary"));

        Employee employee = new Employee(employee_id,name,surname,address,number,note,salary);
        EmployeeDao.update(employee);
        response.sendRedirect("/allemployees");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        int employee_id = Integer.parseInt(request.getParameter("id"));
        session.setAttribute("employee_id", employee_id);
        getServletContext().getRequestDispatcher("/editemployee.jsp").forward(request,response);

    }
}
