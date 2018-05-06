
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
<h2>VEHICLE REPAIRS AND CHECKS:</h2>
<table>
    <tr><th>Registered</th><th>Employee</th><th>Parts Price</th><th>Repair Price</th><th>Repair Hours</th></tr>
    <tr>
        <td>${order.registered}</td>
        <td>${order.employee_id}</td>
        <td>${order.parts_price}</td>
        <td>${order.repair_price}</td>
        <td>${order.repair_hours}</td>
    </tr>
</table>
<hr>
<footer>
    <%@include file="footer.jspx"%>
</footer>
</body>
</html>
