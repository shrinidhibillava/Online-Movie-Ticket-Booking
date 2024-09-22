<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="insertBank">
Enter Name:<input type="text" name="name"><br>
Enter AccoutNumber:<input type ="text" name="acc"><br>
SetPin:<input type ="text" name="pin"><br>
Minimum Amount :<input type="text" name="bal"><br>
<input type="submit">
</form>
<form action="diposite">
Diposit Amount to Your Account <br>
Enter AccoutNumber:<input type ="text" name="acc"><br>
 Enter Amount :<input type="text" name="bal"><br>
Enter Pin:<input type ="text" name="pin"><br>

<input type="submit">
</form>
</body>
</html>
