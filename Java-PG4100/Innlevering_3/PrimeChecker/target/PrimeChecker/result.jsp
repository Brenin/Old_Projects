<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Prime Checker</title>
	<style type="text/css">
		<%@include file="/Styling.css" %>
	</style>
</head>

<body>
	<div class="center">
		<div id="header">
			<h2>Welcome to my awesome Prime Checker</h2>
		</div>
	
	<p class="centering"><% String number = (String) request.getAttribute("nr"); %>
	<%= number%></p>
	
	<h3 class="centering">New number you want to check:</h3>
	<p></p>
	<form action="primeServlet" method="post" class="centering">
		<input type="text" name="nrToCheck">
		<input type="submit">
	</form>
	<p></p>
	<div id="footer">
		Copyright © Eirikur Lundin
	</div>
	
	</div>
</body>

</html>