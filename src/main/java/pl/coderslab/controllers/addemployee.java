package pl.coderslab.controllers;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.EmployeeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/addemployee")
public class addemployee extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String address = request.getParameter("address");
        String number = request.getParameter("number");
        String note = request.getParameter("note");
        double salary = Double.parseDouble(request.getParameter("salary"));

        EmployeeDao.create(name,surname, address,number,note,salary);
        response.sendRedirect("/allemployees");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/addemployee.jsp").forward(request,response);


    }
}
