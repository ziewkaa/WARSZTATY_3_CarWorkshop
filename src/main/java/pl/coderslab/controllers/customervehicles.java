package pl.coderslab.controllers;

import pl.coderslab.dao.VehicleDao;
import pl.coderslab.models.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/customervehicles")
public class customervehicles extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int customer_id = Integer.parseInt(request.getParameter("id"));
        List<Vehicle> vehicles = VehicleDao.findAllVehicles();
        List<Vehicle> customer_vehicles = new ArrayList<>();

        for (Vehicle v : vehicles) {
            if(v.getCustomer_id() == customer_id){
                customer_vehicles.add(v);
            }
        }
        request.setAttribute("customer_vehicles", customer_vehicles);
        getServletContext().getRequestDispatcher("/customervehicles.jsp").forward(request,response);

    }
}
