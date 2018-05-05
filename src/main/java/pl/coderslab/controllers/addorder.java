package pl.coderslab.controllers;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.dao.OrderDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/addorder")
public class addorder extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        LocalDate registered = LocalDate.now();
        LocalDate planned_repair_date = LocalDate.parse(request.getParameter("planned_repair_date"));
        int employee_id = Integer.parseInt(request.getParameter("employee_id"));
        String problem_description = request.getParameter("problem_description");
        int status = Integer.parseInt(request.getParameter("status"));
        int vehicle_id = Integer.parseInt(request.getParameter("vehicle_id"));
        double repair_price = Double.parseDouble(request.getParameter("repair_price"));
        double employee_work_price = EmployeeDao.read(employee_id).getHour_salary();
        int repair_hours = Integer.parseInt(request.getParameter("repair_hours"));

        OrderDao.create(registered, planned_repair_date, employee_id, problem_description, status, vehicle_id, repair_price, employee_work_price, repair_hours);
        response.sendRedirect("/allorders");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/addorder.jsp").forward(request,response);

    }
}
