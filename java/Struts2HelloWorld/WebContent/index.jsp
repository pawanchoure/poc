<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<html>

<head>

<title>Hello World</title>

</head>

<body>
	<s:a href="annotatedHelloWorld">annotatedHelloWorld Demo</s:a>
	<s:a href="jsonsample2">JSON Demo</s:a>
	<s:a href="jsonsample" >JSON Demo2</s:a>
	<s:url var="urlformselect" action="jsonsample"/>
	<sj:div id="content" href="%{urlformselect}">
	</sj:div>
	<sj:menuItem id="remoteformselectlink" href="%{urlformselect}" targets="content" title="AJAX Select" />
<%--  	<s:form action="helloWorld">

		<s:textfield name="userName" label="User Name" />

		<s:submit />

	</s:form>  --%>
	 	<s:form action="helloAjax">

		<s:textfield name="userName" label="User Name" />

		<s:submit />

	</s:form> 
	
</body>

</html>