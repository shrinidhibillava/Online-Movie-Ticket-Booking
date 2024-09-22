<%@page import="javax.swing.text.AttributeSet.ColorAttribute"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ page import="java.util.List" %>
<title>Loading please wait</title>
</head>
<body bgcolor="Skyblue" style="background-image: url('https://as2.ftcdn.net/v2/jpg/06/18/13/25/1000_F_618132549_AgNtMESAgKbLpyk9ixUXwx38tH967YKP.jpg');">
	<h3 align="center"  Style=font-style: oblique;color: red>
	<header Style="font-style: oblique;color: red"> 
	<%
	
	List list=(List)request.getAttribute("list1");
	for (Object ele : list) {
		out.print("<h3 align=center color:red>"+ele+"</h3>");	
		
	}
	%>
	</header>
	</h3 >
	<h1 Style="font-style: oblique;color: red">
	<form action="insert1"> 
	                    User Section<br>
    Enter choice              :<input type="text" name ="a"><br>
	Enter Number of tickets   :<input type="text" name ="b"><br>
    Enter Your Screen         :<input type="text" name ="rc"><br>
    
   
	<input type="submit">
	</form>
	</h1>
</body>
</html>