package pl.coderslab.controllers;

import pl.coderslab.dao.OrderDao;
import pl.coderslab.models.Order;
import pl.coderslab.utils.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class homepage extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            List<Order> orders = OrderDao.findAllOrders();
            request.setAttribute("orders", orders);
            getServletContext().getRequestDispatcher("/homepage.jsp").forward(request,response);

        } catch (Exception e){
            e.getStackTrace();
        }

    }
}
