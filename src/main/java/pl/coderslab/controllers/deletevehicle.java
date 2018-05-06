package pl.coderslab.controllers;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.dao.VehicleDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deletevehicle")
public class deletevehicle extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int delete_vehicle = Integer.parseInt(request.getParameter("id"));
        VehicleDao.delete(delete_vehicle);
        response.sendRedirect("/customervehicles");

    }
}
