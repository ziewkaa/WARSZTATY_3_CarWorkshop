<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<p>Edit Vehicle ${param.id}:</p>
<form action ="/editvehicle" method="POST">
    <label> Model :
        <input type ="text" name ="model"/>
    </label><br>
    <label> Brand :
        <input type ="text" name ="brand"/>
    </label><br>
    <label>  Year :
        <input type ="number" name ="year"/>
    </label><br>
    <label>  Registration :
        <input type ="text" name ="registration"/>
    </label><br>
    <label>  Next check :
        <input type ="datet" name ="next_check"/>
    </label><br>
    <input type ="submit" value="Save"/>
</form>
<hr>
<%@ include file="/footer.jspx" %>
</body>
</html>
