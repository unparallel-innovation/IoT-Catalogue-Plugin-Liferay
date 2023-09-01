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
String vocabulariesCategoriesJSON = (String)request.getAttribute("vocabulariesCategoriesJSON");

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

<section class="d-flex w-100 justify-content-center flex-wrap">

<%if(url!=null && urlHost!=null){ 

%>
	<span class="font-weight-normal rounded-pill text-white bg-primary h5 pl-3 pr-3 pt-0 pb-0 d-inline-flex ml-2 mr-2" >
		<p class="mb-1 mt-1">Website</p>
		<div class="ml-2 mr-2 iot-catalogue-separator"></div> 
		<p class="mb-1 mt-1"><a class="text-white" target="_blank" href="<%=url%>"><%=urlHost%></a></p>
	</span>
	


<%} %>
</section>
<p class="text-justify d-flex justify-content-center"><%=iotValidation.getDescription()%></p>

<liferay-util:include page="/asset/visualelements/element_intro.jsp"  servletContext="<%= application %>">
	<liferay-util:param name="vocabulariesCategoriesJSON" value="<%= vocabulariesCategoriesJSON %>"/>
	
</liferay-util:include>

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
