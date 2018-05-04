<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Welcome</title>
    <style>
        li {
            display: inline-block;
            text-decoration: none;
            margin: 10px;
        }
    </style>
</head>
<body>
<%@include file="header.jspx"%>
<h1>Welcome on the CarWorkshop Site</h1>

<p>Add customer: <a href="/addcustomer">Link</a> </p>
<p>Add employee: <a href="/addemployee">Link</a> </p>

<%@include file="footer.jspx"%>
</body>
</html>
