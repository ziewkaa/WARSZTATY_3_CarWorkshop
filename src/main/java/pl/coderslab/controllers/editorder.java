package pl.coderslab.controllers;

import pl.coderslab.dao.OrderDao;
import pl.coderslab.models.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/editorder")
public class editorder extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        int order_id = (int) session.getAttribute("order_id");
        Order update_order = OrderDao.read(order_id);
        update_order.setActual_repair_date(LocalDate.parse(request.getParameter("actual_repair_date")));
        update_order.setRepair_description(request.getParameter("repair_description"));
        update_order.setParts_price(Double.parseDouble(request.getParameter("parts_price")));
        update_order.setRepair_hours(Integer.parseInt(request.getParameter("repair_hours")));
        response.sendRedirect("/allorders");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        int order_id = Integer.parseInt(request.getParameter("id"));
        session.setAttribute("order_id", order_id);
        getServletContext().getRequestDispatcher("/orders/editorder.jsp").forward(request,response);
    }
}
