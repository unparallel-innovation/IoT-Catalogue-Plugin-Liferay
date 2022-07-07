<%@include file="/init.jsp"%>
<%

String subscriptionId = (String) request.getParameter("subscriptionId");

%>
<portlet:renderURL var="viewURL">

	<portlet:param name="mvcPath"
		value="/elementslistadminportlet/view.jsp"></portlet:param>

</portlet:renderURL>
<portlet:actionURL name="addFilesToQueue" var="addFilesToQueueURL">
	<portlet:param name="getEntries" value="true"/>
	<portlet:param name="subscriptionId" value="<%= subscriptionId %>"/>
	<portlet:param name="mvcPath"
		value="/elementslistadminportlet/pdf_generation/pdf_generation_queue.jsp" />

</portlet:actionURL>

<div class="closed sidenav-container sidenav-right"
	id="<%=liferayPortletResponse.getNamespace() + "infoPanelId"%>">
	<clay:container-fluid cssClass="container-view">
		<div class="sheet sheet-lg" id="sheet-portlet">
			<h1>Select element type to exports</h1>
			<br/>
			<aui:form  action="<%=addFilesToQueueURL%>"
					name="<portlet:namespace />fm">
					<liferay-frontend:fieldset>
						<aui:input type="hidden" name="subscriptionId"   value="<%= subscriptionId %>" />
						<aui:input    name="includeComponents"  label="includeComponents" type="checkbox"/>
						<aui:input name="includeValidations" label="includeValidations" type="checkbox" />
					</liferay-frontend:fieldset>
					<aui:button-row>

						<aui:button type="submit" name="Export"></aui:button>
						<aui:button type="cancel" onClick="<%=viewURL.toString()%>"></aui:button>

					</aui:button-row>
			</aui:form>
		</div>
		
		
	</clay:container-fluid>
</div>