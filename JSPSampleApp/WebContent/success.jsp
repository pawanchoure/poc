<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success</title>
</head>
<body>
Inside Success..Before
<%= request.getParameter("id") %>
<jsp:include page="process.jsp" flush="true">
	<jsp:param value="adarsh" name="id"/>
</jsp:include>
Inside Success..After
</body>
</html>