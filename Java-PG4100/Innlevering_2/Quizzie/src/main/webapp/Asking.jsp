<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Quizzie"></title>
	<style type="text/css">
		<%@include file="/Styling.css" %>
	</style>
</head>

<body>
	<div class="center">
		<div id="header">
			<h2>Welcome to my awesome Quizzie</h2>
		</div>

	<p></p>
	<form action="questionServlet" method="post" class="centering">
		<input type="text" name="answer">
		<input type="submit"><br>
	</form>
	
	<div id="footer">
		Copyright © Eirikur Lundin
	</div>

	</div>
</body>
</html>
