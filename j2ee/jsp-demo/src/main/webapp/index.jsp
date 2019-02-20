<!--
MIT License
Copyright (c) 2016 Donato Rimenti
Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page errorPage="GuestBookErrorPage.jsp"%>

<jsp:useBean id='guest' scope='page'
	class='co.aurasphere.courseware.j2ee.jsp.GuestBean' />

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