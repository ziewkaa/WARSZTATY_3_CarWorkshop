package pl.coderslab.controllers;

import pl.coderslab.dao.OrderDao;
import pl.coderslab.models.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/orderdetails")
public class orderdetails extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int order_id = Integer.parseInt(request.getParameter("id"));
        Order order = OrderDao.read(order_id);
        request.setAttribute("order", order);
        getServletContext().getRequestDispatcher("/orderdetails.jsp").forward(request,response);

    }
}
