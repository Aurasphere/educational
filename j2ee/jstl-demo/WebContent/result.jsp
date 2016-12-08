<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page
	import="java.util.List,co.aurasphere.educational.j2ee.demo.jstl.model.Person"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSTL Demo - Thank you</title>
</head>
<body>
	<h1>Thank you!</h1>
	<p>Thank you for your submission. Last entries:</p>
	<table>
		<c:forEach items="${people}" var="p">
			<tr>
				<td><c:out value="${p.getFirstName()}" /></td>
				<td><c:out value="${p.getLastName()}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>