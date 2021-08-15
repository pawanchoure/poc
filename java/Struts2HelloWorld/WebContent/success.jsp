
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success Page</title>
   <script type="text/javascript">
$(document).ready( function() {
    $.subscribe('handleJsonResult', function(event,data) {
        $('#result').html("<ul id='languagesList'></ul>");
        var list = $('#languagesList');
                $.each(event.originalEvent.data, function(index, value) { 
                        list.append('<li>'+value+'</li>\n');
                });
    });
});    
    </script> 
</head>
<body>
	<h1>
		<s:property value="message" />
	</h1>
	




 <div id="result">Click on the link bellow.</div>
        <s:url var="jsonurl" action="jsonsample"/> 
        
        <sj:a id="ajaxjsonlink" 
                href="jsonsample1" 
                dataType="json"
                onSuccessTopics="handleJsonResult"
                button="true" 
                buttonIcon="ui-icon-gear"
                label="AJAX"
                >
                Run AJAX Action
                </sj:a>


</body>
</html>