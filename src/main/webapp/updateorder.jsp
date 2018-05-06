<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Order</title>
</head>
<body>
<nav>
    <%@include file="header.jspx"%>
</nav>
<hr>
<div>
    <h2>Update Order ${id}:</h2>
    <form action ="/updateorder" method="POST">
        <label> Actual start date :
            <input type ="date" name ="actual_repair_date"/>
        </label><br>
        <label>  Repair description :
            <input type ="text" name ="repair_description"/>
        </label><br>
        <label>  Parts price :
            <input type ="number" step="any" name ="parts_price"/>
        </label><br>
        <label>  Repair Hours :
            <input type ="number"  name ="repair_hours"/>
        </label><br>
        <input type ="submit" value="Save"/>
    </form>
</div>
<hr>
<footer>
    <%@include file="footer.jspx"%>
</footer>

</body>
</html>
