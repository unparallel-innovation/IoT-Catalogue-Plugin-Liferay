<%@ include file="../init.jsp" %>


<%



long groupId = scopeGroupId.longValue();


%>

<portlet:renderURL var="testURL">
    <portlet:param name="mvcPath" value="/asset/iotcomponent/full_content.jsp"></portlet:param>
</portlet:renderURL>
<portlet:actionURL name="test" var="testVar"></portlet:actionURL>
<aui:button-row>
    <aui:button onClick="<%= testVar.toString() %>" value="go to test view"></aui:button>
</aui:button-row>



<portlet:actionURL name="connect" var="connectVar"></portlet:actionURL>
<portlet:actionURL name="deleteAllElements" var="deleteAllElementsVar"></portlet:actionURL>
<portlet:actionURL name="test" var="testVar"></portlet:actionURL>
<div>Portlet view</div>


<aui:button-row cssClass="category-buttons">

    <portlet:renderURL var="addElementUrl">
        <portlet:param name="mvcPath" value="/elementswebportlet/edit_element.jsp" />

    </portlet:renderURL>

	  
	 
</aui:button-row>
<h1></h1>
