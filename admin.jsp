<%@page import="javax.swing.text.AttributeSet.ColorAttribute"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ page import="java.util.List" %>
<html>
<title>Admin</title>
<form action="admin"></form>
<body bgcolor="pink" style="background-image: url('https://as2.ftcdn.net/v2/jpg/06/18/13/25/1000_F_618132549_AgNtMESAgKbLpyk9ixUXwx38tH967YKP.jpg');">
<form action="insert">
<header Style="font-style: oblique;color: red">
     Adding Section<br>
Enter Movie Id:<input type="text" name="id"><br>
Enter Movie Name:<input type="text" name="name"><br>
Enter Movie Price:<input type="text" name="price"><br>
</header>
<input type="submit">
</form>
<form action="ritriw">
<marquee>
<output type="id"></output>
</marquee>

</form>
<form  action="delete">
	 
	 <header Style="font-style: oblique;color: red" >
        Deleting Section<br>
        Enter choice        :<input  type="text" name ="a"><br>
	
	</header>
	<input type="submit">

	</form>
	<form action="">
	<h1 align="center"  Style=font-style: oblique;color: red>
	<header Style="font-style: oblique;color: red"> 
	<%
	       out.println("Avaleble Movies");
	List list=(List)request.getAttribute("list1");
	for (Object ele : list) {
		out.print("<h3 align=center color:red>"+ele+"</h3>");	
		
	}
	%>
	</header>
	
	</h1 >
	</form>
	
</body>
</html>
