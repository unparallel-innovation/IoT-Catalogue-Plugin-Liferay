<%@include file="../../init.jsp"%>
<%
IoTComponent iotComponent = (IoTComponent) request.getAttribute("iot_component");
AssetEntry assetEntry = (AssetEntry) request.getAttribute("asset_entry");
Object notFound =  request.getAttribute("not_found");
Object notAuthorized =  request.getAttribute("not_authorized");
if (iotComponent != null) {
	iotComponent = iotComponent.toEscapedModel();
}
%>




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
<div class="asset-tags mb-3 d-flex justify-content-center">
	<liferay-asset:asset-tags-summary
		className="<%= assetEntry.getClassName() %>"
		classPK="<%= assetEntry.getClassPK() %>"
		portletURL="<%= null %>"

	/>
</div>

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

