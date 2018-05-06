<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Welcome</title>
    <style>
        * {
            margin: 20px;
        }
        div {
            width: 80%;
            height: 400px;
            padding: 10px;
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
            <h1>WELCOME ON EVE'S CAR-WORKSHOP SITE</h1>
            <p>UNDERGOING REPAIRS :</p>
            <table>
                <tr><th>Registered </th><th>Vehicle</th><th>Employee </th><th>Details </th></tr>
                <c:forEach items="${orders}" var="order">
                    <tr>
                        <td>${order.registered}</td>
                        <td>${order.vahicle_id}</td>
                        <td>${order.employee_id}</td>
                        <td><a href="/orderdetails?id=${order.id}">Click</a></td>
                    </tr>
                </c:forEach>
            </table>
        <hr>
        <footer>
        <%@include file="footer.jspx"%>
        </footer>
    </body>
</html>
