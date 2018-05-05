<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Customers</title>
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
<p>New Customer:<a href="/addcustomer"><button>Click</button></a></p>
<hr>
<p>CUSTOMERS:</p>
    <table>
        <tr><th>Name </th><th>Surname</th><th>Birth Date</th><th>Vehicles</th><th>Orders</th><th>Action</th></tr>
        <c:forEach items="${customers}" var="customer">
            <tr>
                <td>${customer.name}</td>
                <td>${customer.surname}</td>
                <td>${customer.birth_date}</td>
                <td><a href="/customervehicles?id=${customer.id}">Click</a></td>
                <td><a href="/customerorders?id=${customer.id}">Click</a></td>
                <td><a href="/editcustomer?id=${customer.id}">Edit</a> / <a href="/deletecustomer?id=${customer.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
<hr>
<%@ include file="footer.jspx" %>
</body>
</html>
