<%@ include file="../init.jsp" %>

<% 

long elementId = ParamUtil.getLong(renderRequest, "elementId");

Element element = null;
if (elementId > 0) {
	element = ElementLocalServiceUtil.getElement(elementId);
}

long categoryId = ParamUtil.getLong(renderRequest, "categoryId");

%>
<portlet:renderURL var="viewURL">

<portlet:param name="mvcPath" value="/elementswebportlet/view.jsp"></portlet:param>

</portlet:renderURL>


<portlet:actionURL name="addElement" var="addElementURL"></portlet:actionURL>

<aui:form action="<%= addElementURL %>" name="<portlet:namespace />fm">

<aui:model-context bean="<%= element %>" model="<%= Element.class %>" />

    <aui:fieldset>

        <aui:input name="name" />
        <aui:input name="description" />
        <aui:input name="iotCatalogueId" />
        <aui:input name="collectionName" />
        <aui:input name="elementId" type="hidden" />
        <aui:input name="categoryId" type="hidden" value='<%= element == null ? categoryId : element.getCategoryId() %>'/>

    </aui:fieldset>

    <aui:button-row>

        <aui:button type="submit"></aui:button>
        <aui:button type="cancel" onClick="<%= viewURL.toString() %>"></aui:button>

    </aui:button-row>
</aui:form>