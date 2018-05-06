package pl.coderslab.controllers;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.models.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/editcustomer")
public class editcustomer extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        int customer_id = (int) session.getAttribute("customer_id");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        LocalDate birthdate = LocalDate.parse(request.getParameter("birthdate"));

        Customer customer = new Customer(customer_id,name,surname,birthdate);
        CustomerDao.update(customer);
        response.sendRedirect("/allcustomers");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        int customer_id = Integer.parseInt(request.getParameter("id"));
        session.setAttribute("customer_id", customer_id);
        getServletContext().getRequestDispatcher("/editcustomer.jsp").forward(request,response);
    }
}
