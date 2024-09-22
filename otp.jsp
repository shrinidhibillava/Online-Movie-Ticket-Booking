<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-image: url('https://as2.ftcdn.net/v2/jpg/06/18/13/25/1000_F_618132549_AgNtMESAgKbLpyk9ixUXwx38tH967YKP.jpg');">
<header Style="font-style: oblique;color: red">
<%
	
	Object list=request.getAttribute("otp");
	
		out.print("<h1 align=center color=read > Your OTP is "+list+"</h1>");	
	
	%>
	</header>

	<form action="otp"> 
	 <h1 align="right" Style="font-style: oblique;color: red"> 
    Enter otp :<input type="text" name ="k"> <br>
	<input type="submit">
	</h1>
	</form>
</body>
</html>