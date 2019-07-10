<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<h2>A AJAX based Double Select Box</h2>

<p class="text">
	Two select boxes with remote json content. The second select box content is dependent from the first one.
</p>
<strong>Reload example with two select boxes.</strong>
${languageList} ${languageObjList}
<s:url var="remoteurl" action="JsonSample"/>
<sj:select
        href="%{remoteurl}"
        id="echo3"
        name="echo"
        list="languageObjList"
        listKey="myKey"
        listValue="myValue"
        emptyOption="true"
        headerKey="-1"
        headerValue="Please Select a Language"/>
<s:select list="languageObjList" listKey="myKey" listValue="myValue" headerValue="Please Select a Language" onchange="JsonSample"></s:select>