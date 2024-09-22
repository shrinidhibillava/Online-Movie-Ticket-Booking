<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<form action="feedback">
<body style="background-image: url('https://as2.ftcdn.net/v2/jpg/06/18/13/25/1000_F_618132549_AgNtMESAgKbLpyk9ixUXwx38tH967YKP.jpg');" >


<h1> <marquee> <header Style="font-style: oblique;color: red">  <%
	
	out.println(request.getAttribute("con"));
	%>
	</header></marquee></h1>
	</form>
	<h1><header Style="font-style: oblique;color: red"><br>
	<form action="feedback">
	     please Rating:<input type="text" name="r"><br>
	Give Your Feedback:<input type="text" name="f"><br>
	
	<input type="submit">
	</form>
	</header></h1>
</body>
</html>