package pl.coderslab.controllers;

import pl.coderslab.dao.VehicleDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/addvehicle")
public class addvehicle extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int customer_id = Integer.parseInt(request.getParameter("id"));
        String model =request.getParameter("model");
        String brand=request.getParameter("brand");
        int year = Integer.parseInt(request.getParameter("id"));
        String registration = request.getParameter("registration");
        LocalDate nextcheck = LocalDate.parse(request.getParameter("next_check"));
        VehicleDao.create(model,brand,customer_id,year,registration,nextcheck);
        response.sendRedirect("/customervehicles?id="+customer_id);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/addvehicle.jsp").forward(request,response);

    }
}
