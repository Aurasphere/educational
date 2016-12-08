<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSTL Demo - Form</title>
</head>
<body>
	<h1>Input form</h1>
	<p>Please insert your data:</p>
	<form action="ResultServlet" method="POST">
		First Name <input type="text" name="firstName" /><br /> 
		Last Name <input type="text" name="lastName" /><br /> 
		<input type="submit" value="Send" />
	</form>
</body>
</html>