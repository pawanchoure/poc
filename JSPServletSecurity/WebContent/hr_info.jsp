<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>Human Resource</title>
</head>

<body>
<p>HumanResource Portal</p>
<p>Welcome </p>
<p>Your have read access to all tables but edit only employee and dependent table. </p>
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
        <input type="text" name="project_info2" id="project_lookup" /></td>
      <td><input type="submit" name="proj_lookup2" id="proj_info" value="INFO" /></td>
    </tr>
    <tr>
      <td>DEPENDENT</td>
      <td><label for="dependent_lookup"></label>
      <input type="text" name="dependent_lookup" id="dependent_lookup"></td>
      <td><input type="submit" name="dependent_info" id="dependent_info" value="INFO"></td>
    </tr>
  </table>
</form>
</body>
</html>