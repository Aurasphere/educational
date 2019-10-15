<html>
<body>
	<%
		
		if (request.getParameter("clear") != null) {
			out.println("Session cleared");
			session.removeAttribute("user");
		} else if (session.getAttribute("user") == null) {
			String user = request.getParameter("user");
			session.setAttribute("user", user);
		}
%>
<h2>
		Hello
		<%=session.getAttribute("user")%>
		<form>
			<input type="hidden" name="clear" value="true"/>
			<input type="submit" value="Clear session" name="submit">
		</form>
	</h2>
</body>
</html>