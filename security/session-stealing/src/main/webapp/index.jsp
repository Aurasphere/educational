<html>
<body>
	<% if(request.getSession().getAttribute("user") != null) response.sendRedirect("session.jsp"); %>
	<h2>Enter your name</h2>
	<form action="session.jsp">
		<input type="text" name="user"> <input type="submit"><br />
	</form>
</body>
</html>