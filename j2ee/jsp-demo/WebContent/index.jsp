<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page errorPage="GuestBookErrorPage.jsp"%>

<jsp:useBean id='guest' scope='page'
	class='co.aurasphere.courseware.j2ee.demo.jsp.model.GuestBean' />

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP Demo - Guest Form</title>
</head>
<h1>Guest form</h1>
<body>
	<jsp:setProperty name='guest' property='*' />
	<%
		if ((guest.getFirstName() == null) || (guest.getLastName() == null)
				|| (guest.getEmail() == null)) {	
	%>
	<form method="post" action="index.jsp">
		First Name <input type="text" name="firstName" /> <br /> 
		Last Name <input type="text" name="lastName" /> <br /> 
		Email <input type="text" name="email" /> <br /> 
		<input type="submit" value="Send" />
	</form>
	<%
		} else {
	%>
	<jsp:forward page="ViewGuestBook.jsp">
		<jsp:param name="firstName" value="<%=guest.getFirstName()%>" />
		<jsp:param name="lastName" value="<%=guest.getLastName()%>" />
		<jsp:param name="email" value="<%=guest.getEmail()%>" />
	</jsp:forward>

	<%
		}
	%>
</body>
</html>