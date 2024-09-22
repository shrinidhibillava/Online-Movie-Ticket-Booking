<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-image: url('https://as2.ftcdn.net/v2/jpg/06/18/13/25/1000_F_618132549_AgNtMESAgKbLpyk9ixUXwx38tH967YKP.jpg');">
<form action="feedback">



<header  Style="font-style: oblique;color: red"><h1> <marquee>   <%

	     out.println("<h1  >Thank you for visiting HaleshkhaddiOnlinetickete Booking</h1><br>");
	     if(request.getAttribute("con")!=null)
	     {
	out.println("<h1 style=background-image: url(https://www.jiocinema.com/movies/kirik-party/3490905/watch)>"+request.getAttribute("con")+"</h1>");
	     }
	     else
	    	 out.println("<h1>Your not Booked any Tickets Go backe and Book Now</h1><br>");
	%>
	</marquee></h1>
	<h1 align="right" >
	
	      please Rate:<input type="text"  placeholder="5*" name="u"><br>
Give Your Feedback   :<input type="text"                   name="m"><br>
	
	<input type="submit">
	</h1>
	</header> 
	
</body>
</html>