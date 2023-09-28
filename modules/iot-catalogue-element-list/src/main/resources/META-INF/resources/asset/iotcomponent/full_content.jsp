
<%@include file="../../init.jsp"%>

<%
IoTComponent iotComponent = (IoTComponent) request.getAttribute("iot_component");
AssetEntry assetEntry = (AssetEntry) request.getAttribute("asset_entry");

List<ElementEntity> manufacturers = (List<ElementEntity>) request.getAttribute("manufacturers");
List<ElementEntity> developers = (List<ElementEntity>) request.getAttribute("developers");
List<ElementStandard> standards = (List<ElementStandard>) request.getAttribute("standards");
HashMap<String, List<HashMap<String,String>>> vocabulariesCategories = (HashMap<String, List<HashMap<String,String>>>)request.getAttribute("vocabularies_categories");
String vocabulariesCategoriesJSON = (String)request.getAttribute("vocabulariesCategoriesJSON");
Object notFound =  request.getAttribute("not_found");
Object notAuthorized =  request.getAttribute("not_authorized");

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



if (iotComponent != null) {
	iotComponent = iotComponent.toEscapedModel();
}
List<String> categories = new ArrayList<String>();

List<String> standardNames = new ArrayList<String>();
if(standards != null){
	
	for(ElementStandard standard:standards){
		standardNames.add(standard.getName());
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


















<section class="d-flex w-100 justify-content-center flex-wrap">

<%if(url!=null && urlHost!=null){ 

%>
	<span class="font-weight-normal rounded-pill text-white bg-primary h5 pl-3 pr-3 pt-0 pb-0 d-inline-flex ml-2 mr-2" >
		<p class="mb-1 mt-1">Website</p>
		<div class="ml-2 mr-2 iot-catalogue-separator"></div> 
		<p class="mb-1 mt-1"><a class="text-white" target="_blank" href="<%=url%>"><%=urlHost%></a></p>
	</span>
	


<%} %>
<%if(manufacturers != null && manufacturers.size() >0){ %>

	<span class="font-weight-normal rounded-pill text-white bg-primary h5 pl-3 pr-3 pt-0 pb-0 d-inline-flex mr-2" >
	<p class="mb-1 mt-1">Manufacturers</p>
	<div class="ml-2 mr-2 iot-catalogue-separator"></div> 
	<%
	int inc = 0;
	for(ElementEntity manufacturer:manufacturers){ 
	
	%>
		<p class="mb-1 mt-1"><a class="text-white" target="_blank" href="<%=manufacturer.getWebsite()%>"><%=manufacturer.getName() %></a></p>
		<%if(inc < manufacturers.size()-1){ %>
		<div class="ml-2 mr-2 iot-catalogue-separator bg-secondary"></div> 
		<%} %>
	<%
	inc ++;
	} 
	%>
</span>
<%} %>
<%if(developers != null && developers.size() >0){ %>

	<span class="font-weight-normal rounded-pill text-white bg-primary h5 pl-3 pr-3 pt-0 pb-0 d-inline-flex mr-2" >
	<p class="mb-1 mt-1">Developers</p>
	<div class="ml-2 mr-2 iot-catalogue-separator"></div> 
	<%
	int inc = 0;
	for(ElementEntity developer:developers){ 
	
	%>
		<p class="mb-1 mt-1"><a class="text-white" target="_blank" href="<%=developer.getWebsite()%>"><%=developer.getName() %></a></p>
		<%if(inc < (developers.size()-1)){ %>
		<div class="ml-2 mr-2 iot-catalogue-separator bg-secondary"></div> 
		<%} %>
	<%
	inc ++;
	} 
	%>
</span>
<%} %>
</section>



<p class="text-justify d-flex justify-content-center"><%=StringEscapeUtils.unescapeHtml4(iotComponent.getDescription()) %></p>

<liferay-util:include page="/asset/visualelements/element_intro.jsp"  servletContext="<%= application %>">
	<liferay-util:param name="vocabulariesCategoriesJSON" value="<%= vocabulariesCategoriesJSON %>"/>
	<liferay-util:param name="trl" value="<%= iotComponent.getTrl() %>"/>
	<liferay-util:param name="license" value="<%= iotComponent.getLicense() %>"/>
	<% for(String standardName:standardNames){ %>
		<liferay-util:param name="standard" value="<%= standardName %>"/>
	<% } %>
	
</liferay-util:include>



<iframe id="iotCatalogueIframe" frameborder="0"
	style="height: 0px;width: 100%; max-width: 100% !important"
	src="<%=iotComponent.getEmbeddedUrl()%>"></iframe>


<%
} else {
%>

<h1 class="text-center">
	<liferay-ui:message key="componentFullContentPlaceholder" />
</h1>
<%
}
%>
