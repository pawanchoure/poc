<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>TimeSheet Application - Login </title>
<link href="./css/login.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id=Login><label>Login</label></div>

<s:form action="login" method="post">
    <s:textfield name="username" key="label.username" size="20" class="field required" title="Please provide your username" />
    <s:password name="password" key="label.password" size="20" class="field required" title="Password is required"/>
    <s:submit method="execute" key="label.login" align="center"></s:submit>
    <s:actionerror />
</s:form>
<div id=Login><p class="forgot"><a href="#">Forgot your password?</a></p></div>
</body>
</html>