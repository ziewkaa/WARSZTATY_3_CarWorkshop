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
<%@ include file="header.jspx" %>
<hr>
<p>Add Vehicle:<a href="/addvehicle"><button>Click</button></a></p>
<hr>
<p>VEHICLES:</p>
<table>
    <tr><th>Model </th><th>Brand</th><th>Year</th><th>Next check</th><th>Actions</th></tr>
    <c:forEach items="${customer_vehicles}" var="vehicle">
        <tr>
            <td>${vehicle.model}</td>
            <td>${vehicle.brand}</td>
            <td>${vehicle.year}</td>
            <td>${vehicle.next_check}</td>
            <td><a href="/editvehicle?id=${vehicle.id}">Edit</a> / <a href="/deletevehicle?id=${vehicle.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<hr>
<%@ include file="footer.jspx" %>
</body>
</html>
