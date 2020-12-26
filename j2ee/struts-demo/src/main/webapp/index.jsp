<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<html:errors />
<html:form action="Login">
Username:<html:text name="LoginForm" property="username"/>
Password:<html:password name="LoginForm" property="password"/>
<html:submit value="Login"/>
</html:form>
</body>
</html>