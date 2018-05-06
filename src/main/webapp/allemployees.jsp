<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Employees</title>
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
<p>New Employee:<a href="/addemployee"><button>Click</button></a></p>
<hr>
<p>EMPLOYEES:</p>
<table>
    <tr><th>Name </th><th>Surname</th><th>Details</th><th>Orders</th><th>Action</th></tr>
    <c:forEach items="${employees}" var="employee">
        <tr>
            <td>${employee.name}</td>
            <td>${employee.surname}</td>
            <td><a href="/employeedetails?id=${employee.id}">Click</a></td>
            <td><a href="/employeeorders?id=${employee.id}">Click</a></td>
            <td><a href="/editemployee?id=${employee.id}">Edit</a> / <a href="/deleteemployee?id=${employee.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<hr>
<%@ include file="footer.jspx" %>

</body>
</html>
