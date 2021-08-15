
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSTL Example</title>
</head>
<body>
	<h1>Sample JSTL Bank Account</h1>

	<form action="display_email_entry.jsp" method="post">
		<table cellspacing="5" border="0">
			<tr>
				<td align="right"><c:out value='First&apos; &quot; &lt; &gt; Name' default="First Name"/></td>
				<td><input type="text" name="firstName">
				</td>
			</tr>
			<tr>
				<td align="right"><c:out value="Last Name &lt; &gt;" default="Last Name"/></td>
				<td><input type="text" name="lastName">
				</td>
			</tr>
			<tr>
				<td align="right"><c:out value="left bracket character (<) with &lt;, the ampersand (&) itself with
&amp;, and the right bracket character (>) with &gt;."/></td>
				<td><input type="text" name="emailAddress">
				</td>
			</tr>
			<tr>
				<td align="right">Balance:</td>
				<td><input type="text" name="balance">
				</td>
			</tr>
			<tr>
				<td></td>
				<td><br>
				<input type="submit" value="Submit">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>