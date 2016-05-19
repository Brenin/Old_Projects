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

	<h3 class="centering">Number you want to check:</h3>
	<p></p>
	<form action="primeServlet" method="post" class="centering">
		<input type="text" name="nrToCheck">
		<input type="submit"><br>
	</form>

	<div id="footer">
		Copyright © Eirikur Lundin
	</div>

	</div>
</body>
</html>
