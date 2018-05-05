<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Order</title>
</head>
<body>
<nav>
    <%@include file="header.jspx"%>
</nav>
<hr>
    <div>
        <h2>Order details:</h2>
        <table>
        <tr><th>Vehicle</th><th>Employee </th><th>Problem</th><th>Status</th><th>Hours under repair</th></tr>
            <tr>
                <td>${order.vahicle_id}</td>
                <td>${order.employee_id}</td>
                <td>${order.problem_description}</td>
                <td>${order.status}</td>
                <td>${order.repair_hours}</td>
            </tr>
        </table>
    </div>
<footer>
    <%@include file="footer.jspx"%>
</footer>
</body>
</html>
