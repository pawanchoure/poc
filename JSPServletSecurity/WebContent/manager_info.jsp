<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>MANAGER'S INFO</title>
</head>

<body>
<p>Manager's Portal</p>
<p>Welcome </p>
<p> Your access is limited to read and edit the employee, department and project table but not the dependent table. </p>
<form id="maninfo" name="maninfo" method="post" action="">
  <table width="439" border="1">
    <tr>
      <td colspan="3">INFORMATION LOOKUP</td>
    </tr>
    <tr>
      <td width="147">EMP </td>
      <td width="28"><label for="emp_info"></label>
        <input type="text" name="emp_info" id="emp_lookup" /></td>
      <td width="166"><input type="submit" name="emp_lookup" id="emp_info" value="INFO" /></td>
    </tr>
    <tr>
      <td>DEPARTMENT</td>
      <td><label for="deptinfo"></label>
        <input type="text" name="dept_info" id="dept_lookup" /></td>
      <td><input type="submit" name="dept_lookup" id="dept_info" value="INFO" /></td>
    </tr>
    <tr>
      <td>PROJECT</td>
      <td><label for="project_info"></label>
        <input type="text" name="project_info" id="project_lookup" /></td>
      <td><input type="submit" name="proj_lookup" id="project_info" value="INFO" /></td>
    </tr>
  </table>
</form>
</body>
</html>