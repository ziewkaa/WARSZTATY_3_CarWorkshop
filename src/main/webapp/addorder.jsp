<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>New Order</title>
    <style>
        * {
            margin: 20px;
        }
        nav {
            display: inline-block;
        }
        form {
            width: 200px;
        }
        input {
            margin: 10px;
            padding: 10px;
        }
    </style>
</head>
<body>
<%@ include file="header.jspx" %>
<hr>
<form action ="/addorder" method="POST">
    <label> Planned start date :
        <input type ="datet" name ="planned_repair_date"/>
    </label><br>
    <label> Employee :
        <input type ="number" name ="employee_id"/>
    </label><br>
    <label>  Problem :
        <input type ="text" name ="problem_description"/>
    </label><br>
    <label>  Status :
        <input type ="number" name ="status"/>
    </label><br>
    <label>  Vehicle :
        <input type ="number" name ="vehicle_id"/>
    </label><br>
    <label>  Estimated Price :
        <input type ="number" step="any" name ="repair_price"/>
    </label><br>
    <label>  Estimated Working Hours :
        <input type ="number" name ="repair_hours"/>
    </label><br>
    <input type ="submit" value="Save"/>
</form>
<hr>
<%@ include file="footer.jspx" %>

</body>
</html>
