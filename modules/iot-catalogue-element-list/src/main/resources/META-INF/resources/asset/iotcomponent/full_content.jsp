
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
System.out.println("standardNames");


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

<liferay-util:include page="/asset/visualelements/element_intro.jsp"  servletContext="<%= application %>">
	<liferay-util:param name="vocabulariesCategoriesJSON" value="<%= vocabulariesCategoriesJSON %>"/>
	<liferay-util:param name="trl" value="<%= iotComponent.getTrl() %>"/>
	<liferay-util:param name="license" value="<%= iotComponent.getLicense() %>"/>
	<% for(String standardName:standardNames){ %>
		<liferay-util:param name="standard" value="<%= standardName %>"/>
	<% } %>
	
</liferay-util:include>


<% 
if(vocabulariesCategories!= null){
	System.out.println("**********************  vocabulariesCategories");
	System.out.println(vocabulariesCategoriesJSON);
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


<% 
if(manufacturers!= null && manufacturers.size()>0 ){

	
%>
		<div class="mb-2">
		<div class="bg-light rounded p-2 h-100 d-flex align-items-center">
			<h5 class="mb-0 mr-2">Manufacturer</h5>
			<div>
			<% for(ElementEntity manufacturer:manufacturers){ %>
				<span class="label label-secondary label-lg bg-transparent"><span class="label-item label-item-expand"><a href="<%= manufacturer.getWebsite() %>" target="_blank"><%= manufacturer.getName() %></a></span></span>
			<%} %>
			</div>
		</div>
	</div>
<%


}
%>

<% 
if(developers!= null && developers.size()>0){

	
%>
		<div class="mb-2">
		<div class="bg-light rounded p-2 h-100 d-flex align-items-center">
			<h5 class="mb-0 mr-2">Developer</h5>
			<div>
			<% for(ElementEntity developer:developers){ %>
				<span class="label label-secondary label-lg bg-transparent"><span class="label-item label-item-expand"><a href="<%= developer.getWebsite() %>" target="_blank"><%= developer.getName() %></a></span></span>
			<%} %>
			</div>
		</div>
	</div>
<%


}
%>
<% 
if(standards!= null && standards.size()>0 ){

	
%>
		<div class="mb-2">
		<div class="bg-light rounded p-2 h-100 d-flex align-items-center">
			<h5 class="mb-0 mr-2">Standards</h5>
			<div>
			<% for(ElementStandard standard:standards){ %>
				<span class="label label-secondary label-lg bg-transparent"><span class="label-item label-item-expand"><%= standard.getName() %></span></span>
			<%} %>
			</div>
		</div>
	</div>
<%


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


<% if(iotComponent.getLicense()!=null && iotComponent.getLicense()!= ""){ %>

	<div class="mb-2">
		<div class="bg-light rounded p-2 h-100 d-flex align-items-center">
			<h5 class="mb-0 mr-2">License</h5>
			<div>
				<span class="label label-secondary label-lg bg-transparent"><span class="label-item label-item-expand"><%= iotComponent.getLicense() %></span></span>
			</div>
		</div>
	</div>

<%} %>
	 	 
<% if(iotComponent.getTrl()!=null && iotComponent.getTrl()!= ""){ %>

	<div class="mb-2">
		<div class="bg-light rounded p-2 h-100 d-flex align-items-center">
			<h5 class="mb-0 mr-2">TRL</h5>
			<div>
				<span class="label label-secondary label-lg bg-transparent"><span class="label-item label-item-expand"><%= iotComponent.getTrl() %></span></span>
			</div>
		</div>
	</div>
<%} %>
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
