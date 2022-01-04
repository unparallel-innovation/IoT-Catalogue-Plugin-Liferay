<%@include file="../../init.jsp"%>
<%
IoTValidation iotValidation = (IoTValidation) request.getAttribute("iot_validation");
AssetEntry assetEntry = (AssetEntry) request.getAttribute("asset_entry");
Object notFound = request.getAttribute("not_found");
Object notAuthorized =  request.getAttribute("not_authorized");
if (iotValidation != null) {
	iotValidation = iotValidation.toEscapedModel();
	assetEntry = AssetEntryLocalServiceUtil.getEntry(IoTValidation.class.getName(), iotValidation.getIotValidationId());
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
<portlet:renderURL var="testURL">
    <portlet:param name="mvcPath" value="/asset/iotcomponent/full_content.jsp"></portlet:param>
</portlet:renderURL>
<%
if (notFound != null) {
%>
<h1 class="text-center">
	<liferay-ui:message key="validationFullContentNotFound" />
</h1>


<%
} else if (notAuthorized != null) {
%>

<h1 class="text-center">
	<liferay-ui:message key="validationFullContentNotAuthorized" />
</h1>
<%
} else if (iotValidation != null) {
%>
<div class="d-flex justify-content-center mb-4">

	<img style="max-width: 500px; max-height: 300px"
		src="<%=iotValidation.getImageUrl()%>" />
</div>
<h2 class="text-center">
	<b><%=iotValidation.getName()%></b>
</h2>


<p class="text-justify d-flex justify-content-center"><%=iotValidation.getDescription()%></p>
<div class="asset-tags mb-3 d-flex justify-content-center">
	<liferay-asset:asset-tags-summary
		className="<%= assetEntry.getClassName() %>"
		classPK="<%= assetEntry.getClassPK() %>"
		portletURL="<%= null %>"
	/>
</div>

<iframe id="iotCatalogueIframe" frameborder="0"
	style="height: 0px; width: 100%; max-width: 100% !important"
	src="<%=iotValidation.getEmbeddedUrl()%>">


	<%
} else {
%>

	<h1 class="text-center">
		<liferay-ui:message key="validationFullContentPlaceholder" />
	</h1>
	<%
	}
	%>
