<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Scriplet demo</title>
</head>
<body>
	<h1>Scriplet expression generated message</h1>
	<br />
	<%=getHello()%>
	<br />
	<%
		out.println("<h1>Scriplet generated date</h1> <br/> Current date is: ");
		out.println(getDate());
	%>
	<br />

	<h1>Scriplet generated table</h1>
	<table border=2>
		<th>Row number</th>
		<th>Odd/Even</th>

		<%
			int i;
			boolean odd = false;
			for (i = 0; i < 5; i++) {
				odd = (i % 2) == 0;
		%>
		<tr>
			<td><%=i + 1%></td>
			<%
				if (odd) {
			%>
			<td>Odd</td>
			<%
				} else {
			%>
			<td>Even</td>
			<%
				}
			%>
		</tr>
		<%
			}
		%>
	</table>
	<br />

	<h1>System informations</h1>
	<%
		// Prints some system informations.
			String[] propertyKeys = new String[] { "java.version", "java.home",
			"os.name", "user.name", "user.home", "user.dir" };
			for (String propertyKey : propertyKeys) {
		out.println(propertyKey);
		out.println(":");
		out.println(System.getProperties().getProperty(propertyKey));
		// Prints a line break before ending the loop.
	%>
	<br />
	<%
		}
	%>
	<br />
	<%!
	// Scriplet declaration of methods and variables used. The position on the page doesn't matter.
	// The tag used to open the declaration is <%!. 

	Date date;

	Date getDate() {
		date = new Date();
		return date;
	}

	String getHello() {
		return "Hello World!";
	}%>
</body>
</html>