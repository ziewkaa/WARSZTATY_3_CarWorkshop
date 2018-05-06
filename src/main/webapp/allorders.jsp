<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Orders</title>
    <style>
        * {
            margin: 20px;
        }
        div {
            width: 80%;
            height: 400px;
            padding: 10px;
            margin: 0 auto;
        }

        th, td {
            margin: 10px;
            padding: 5px;
            border: 1px solid gray;
        }
    </style>
</head>
<body>
<%@ include file="header.jspx" %>
<hr>
<p>New Order:<a href="/addorder"><button>Click</button></a></p>
<hr>
<p>ALL ORDERS:</p>
<table>
    <tr><th>Registered </th><th>Employee</th><th>Vehicle</th><th>Status</th><th>Details</th><th>Action</th></tr>
    <c:forEach items="${orders}" var="order">
        <tr>
            <td>${order.registered}</td>
            <td>${order.employee_id}</td>
            <td>${order.vehicle_id}</td>
            <td>${order.status}</td>
            <td><a href="/orderdetails?id=${employee.id}">Click</a></td>
            <td><a href="/updateorder?id=${customer.id}">Update</a> / <a href="/deleteorder?id=${order.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<hr>
<%@ include file="footer.jspx" %>
</body>
</html>
