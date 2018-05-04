<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Add Customer</title>
    <style>

        nav {
            display: inline-block;
        }

    </style>
</head>
    <body>
    <%@ include file="header.jspx" %>
        <form action ="/addcustomer" method="POST">
            <label> Name :
                <input type ="text" name ="name"/>
            </label><br>
            <label> Surname :
                <input type ="text" name ="surname"/>
            </label><br>
            <label> Birth date :
                <input type ="date" name ="birthdate"/>
            </label><br>
            <input type ="submit" value="Save"/>
        </form>
    <%@ include file="footer.jspx" %>
    </body>
</html>
