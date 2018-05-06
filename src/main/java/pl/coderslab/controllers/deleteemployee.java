package pl.coderslab.controllers;

import pl.coderslab.dao.EmployeeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteemployee")
public class deleteemployee extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int delete_employee = Integer.parseInt(request.getParameter("id"));
        EmployeeDao.delete(delete_employee);
        response.sendRedirect("/allemployees");


    }
}
