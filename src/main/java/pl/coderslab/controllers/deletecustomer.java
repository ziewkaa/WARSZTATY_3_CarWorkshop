package pl.coderslab.controllers;

import pl.coderslab.dao.CustomerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deletecustomer")
public class deletecustomer extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int delete_customer = Integer.parseInt(request.getParameter("id"));
        CustomerDao.delete(delete_customer);
        response.sendRedirect("/allcustomers");

    }
}
