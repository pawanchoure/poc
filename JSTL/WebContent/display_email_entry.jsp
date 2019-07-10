<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Mailing List</title>
</head>
<body>
	<%
		// get parameters from the request
		//String firstName = request.getParameter("firstName");
		//String lastName = request.getParameter("lastName");
		//String emailAddress = request.getParameter("emailAddress");
	%>

	<h1>Thanks for joining JSTL Mailing List</h1>

	<p>Here is the information that you entered:</p>

	<table cellspacing="5" cellpadding="5" border="1">
		<tr>
			<td align="right">First name:</td>
			<td>
			<c:choose>
			<c:when test="${not empty param.firstName }">
				<c:out value="${param.firstName}"></c:out>
			</c:when>
			<c:otherwise>
			<c:out value="First Name not Entered"></c:out>
			</c:otherwise>
			</c:choose>
			</td>
		</tr>
		<tr>
			<td align="right">Last name:</td>
			<td>
			<c:choose>
			<c:when test="${not empty param.lastName }">
				<c:out value="${param.lastName}"></c:out>
			</c:when>
			<c:otherwise>
			<c:out value=" Last Name not Entered"></c:out>
			</c:otherwise>
			</c:choose>
			</td>
		</tr>
		<tr>
			<td align="right">Email address:</td>
			<td>
			<c:choose>
			<c:when test="${not empty param.emailAddress }">
				<c:out value="${param.emailAddress}"></c:out>
			</c:when>
			<c:otherwise>
			<c:out value=" Email Address not Entered"></c:out>
			</c:otherwise>
			</c:choose>
			</td>
		</tr>
			<tr>
			<td align="right">Balance:</td>
			<td>
			<c:choose>
			<c:when test="${not empty param.balance }">
			<fmt:formatNumber value="${param.balance}" type="currency"> </fmt:formatNumber>
				<c:out value=""></c:out>
			</c:when>
			<c:otherwise>
			<c:out value=" Balanca not Entered"></c:out>
			</c:otherwise>
			</c:choose>
			</td>
		</tr>
	</table>

	<c:if test="${empty param.firstName or empty param.emailAddress or empty param.lastName }">
	<jsp:forward page="Index.jsp"></jsp:forward>
	</c:if>
	<p>
		To enter another email address, click on the Back <br> button in
		your browser or the Return button shown <br> below.
	</p>

	<form action="Index.jsp" method="post">
		<input type="submit" value="Return">
	</form>

	<p>This email address was added to our list</p>

</body>
</html>