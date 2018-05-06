<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
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
<%@ include file="/header.jspx" %>
<hr>
<p>Edit Employee ${id}:</p>
<hr>
<form action ="/addemployee" method="POST">
    <label> Name :
        <input type ="text" name ="name"/>
    </label><br>
    <label> Surname :
        <input type ="text" name ="surname"/>
    </label><br>
    <label>  Address :
        <input type ="text" name ="address"/>
    </label><br>
    <label>  Phone number :
        <input type ="number" name ="number"/>
    </label><br>
    <label>  Note :
        <input type ="text" name ="note"/>
    </label><br>
    <label>  Salary / H :
        <input type ="number" step="any" name ="salary"/>
    </label><br>
    <input type ="submit" value="Save"/>
</form>
<hr>
<%@ include file="/footer.jspx" %>
</body>
</html>
