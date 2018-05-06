<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Employee Details</title>
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
<nav>
    <%@include file="header.jspx"%>
</nav>
<hr>
    <h2>EMPLOYEE DETAILS:</h2>
    <table>
        <tr><th>Name</th><th>Surname </th><th>Address</th><th>Number</th><th>Salary/H</th><th>Orders</th></tr>
        <tr>
            <td>${employee.name}</td>
            <td>${employee.surname}</td>
            <td>${employee.address}</td>
            <td>${employee.number}</td>
            <td>${employee.hour_salary}</td>
            <td><a href="/employeeorders?${employee.id}">Click</a></td>
        </tr>
    </table>
<hr>
<footer>
    <%@include file="footer.jspx"%>
</footer>
</body>
</html>
