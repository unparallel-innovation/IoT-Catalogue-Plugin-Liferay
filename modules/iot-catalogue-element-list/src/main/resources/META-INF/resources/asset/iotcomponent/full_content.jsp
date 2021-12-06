<%@include file="../../init.jsp"%>
<%
IoTComponent iotComponent = (IoTComponent) request.getAttribute("iot_component");
Object notFound =  request.getAttribute("not_found");
Object notAuthorized =  request.getAttribute("not_authorized");
if (iotComponent != null) {
	iotComponent = iotComponent.toEscapedModel();
}
%>



<div style="border: 1px solid red">
	<div>Tags</div>
	<liferay-asset:asset-categories-error />
	<liferay-asset:asset-tags-error />
	<liferay-asset:asset-categories-selector
		className="<%= IoTComponent.class.getName() %>"
		classPK="<%= iotComponent.getIotComponentId() %>"
		
	/>
	
	<liferay-asset:asset-tags-selector
		className="<%= IoTComponent.class.getName() %>"
		classPK="<%= iotComponent.getIotComponentId() %>"
	/>

</div>
<script>
	function receiveMessage(event) {
		const data = event.data
		if (data.action == "resize") {

			const iframe = document.getElementById("iotCatalogueIframe");
			console.log(iframe)
			console.log("Set height " + data.height)
			iframe.style.height = data.height + 'px';
		}
	}

	window.addEventListener("message", receiveMessage, false)
</script>

<%
if (notFound!=null) {
%>
<h1 class="text-center">
	<liferay-ui:message key="componentFullContentNotFound" />
</h1>
<%
} else if (notAuthorized != null) {
%>
<h1 class="text-center">
	<liferay-ui:message key="componentFullContentNotAuthorized" />
</h1>

<%
} else if (iotComponent != null) {
%>
<div class="d-flex justify-content-center mb-4">

	<img style="max-width: 500px; max-height: 300px"
		src="<%=iotComponent.getImageUrl()%>" />
</div>
<h2 class="text-center">
	<b><%=iotComponent.getName()%></b>
</h2>
<p class="text-justify d-flex justify-content-center"><%=iotComponent.getDescription()%></p>
<iframe id="iotCatalogueIframe" frameborder="0"
	style="height: 0px;width: 100%; max-width: 100% !important"
	src="<%=iotComponent.getEmbeddedUrl()%>"> </iframe>


<%
} else {
%>

<h1 class="text-center">
	<liferay-ui:message key="componentFullContentPlaceholder" />
</h1>
<%
}
%>

