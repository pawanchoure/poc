<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>EMP</title>
</head>
<body>
<p>Employee's Portal</p>
<p>Welcome</p>
<p>In order to find information for other employee's, please insert the employee ID.</p>
<form id="empinfo" name="empinfo" method="post" action="">
  <table width="400" border="1">
    <tr>
      <td colspan="3">EMPLOYEE INFORMATION</td>
    </tr>
    <tr>
      <td width="56">EMP ID</td>
      <td width="170"><input type="text" name="empinfo2" id="emp_lookup" /></td>
      <td width="152"><input type="submit" name="info" id="emp_info" value="INFO" />
        </div></td>
    </tr>
  </table>
</form>
</body>
</html>