<%@include file="../init.jsp"%>


<%

String subscriptionId = (String) request.getParameter("subscriptionId");

%>
<portlet:actionURL name="deleteSubscriptionAndDataAction"
	var="deleteSubscriptionAndDataUrl">
	<portlet:param name="subscriptionId"
		value="<%=subscriptionId%>" />
</portlet:actionURL>
<aui:script use="aui-base">
console.log("subscriptionId",<%=subscriptionId %>)
A.one('#<portlet:namespace/>closeDialog').on('click', function(event) {
	// Let's suppose that "data" contains the processing results
	var data = undefined
	Liferay.Util.getOpener().<portlet:namespace/>closePopup(data, '<portlet:namespace/>dialog');
});
</aui:script>
<div class="p-4 d-flex flex-column justify-content-between h-100">

	<p><%=subscriptionId %><liferay-ui:message key="deleteSubscriptionBody"/></p>
	

	<div class="d-flex justify-content-between">
		<aui:button onClick="" id="closeDialog" value="Cancel"></aui:button>
		<div class="d-flex">
			<aui:button onClick="" primary="<%=true%>"
				value="Delete subscription"></aui:button>

			<aui:button cssClass="ml-3"  onClick="<%=deleteSubscriptionAndDataUrl.toString()%>" primary="<%=true%>"
				value="Delete subscription and data"></aui:button>

		</div>


	</div>
</div>

