<%@include file="../../init.jsp"%>
<%
IoTValidation iotValidation = (IoTValidation) request.getAttribute("iot_validation");
AssetEntry assetEntry = (AssetEntry) request.getAttribute("asset_entry");

HashMap<String, List<HashMap<String,String>>> vocabulariesCategories = (HashMap<String, List<HashMap<String,String>>>)request.getAttribute("vocabularies_categories");


Object notFound = request.getAttribute("not_found");
Object notAuthorized =  request.getAttribute("not_authorized");
if (iotValidation != null) {
	iotValidation = iotValidation.toEscapedModel();
	assetEntry = AssetEntryLocalServiceUtil.getEntry(IoTValidation.class.getName(), iotValidation.getIotValidationId());
}


String url = null;
String urlHost = null;
if(assetEntry != null){
	url = assetEntry.getUrl();

	if(url!=null && !url.equals("")){
		try{
		URL urlObj = new URL(url);
		urlHost = urlObj.getHost();
		}catch(Exception ex){
			
		}
	}
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

<%
if(vocabulariesCategories!= null){
	for(Map.Entry<String, List<HashMap<String,String>>> entry:vocabulariesCategories.entrySet()) {
	
%>
		<div class="mb-2">
		<liferay-util:include page="/asset/visualelements/vocabulary_tags.jsp" servletContext="<%= application %>">
	 			<liferay-util:param name="vocabularyTitle" value="<%= entry.getKey() %>"/>
	 			<%
					for(HashMap<String,String> category: entry.getValue()){
				%>
						<liferay-util:param name="category" value="<%=category.toString() %>"/>
				<%
					}
				%>
		 </liferay-util:include>
		</div>
<%

	}
}
%>

<% if(url!=null && urlHost!=null){ %>

	<div class="mb-2">
		<div class="bg-light rounded p-2 h-100 d-flex align-items-center">
			<h5 class="mb-0 mr-2">Website</h5>
			<a href="<%= url%>" target="_blank"><%= urlHost %></a>
		</div>
	</div>
<%} %>
	 
<iframe id="iotCatalogueIframe" frameborder="0"
	style="height: 0px; width: 100%; max-width: 100% !important"
	src="<%=iotValidation.getEmbeddedUrl()%>"></iframe>


	<%
} else {
%>

	<h1 class="text-center">
		<liferay-ui:message key="validationFullContentPlaceholder" />
	</h1>
	<%
	}
	%>
