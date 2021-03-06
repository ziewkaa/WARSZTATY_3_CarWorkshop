package pl.coderslab.controllers;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.models.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/allcustomers")
public class allcustomers extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Customer> customers = CustomerDao.findAllCustomers();
        request.setAttribute("customers", customers);
        getServletContext().getRequestDispatcher("/allcustomers.jsp").forward(request,response);

    }
}
