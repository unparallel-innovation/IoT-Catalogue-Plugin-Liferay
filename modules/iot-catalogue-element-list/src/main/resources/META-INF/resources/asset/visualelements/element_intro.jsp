<%@include file="../../init.jsp"%>

<% 


	String vocabulariesCategoriesJSON = (String)request.getParameter("vocabulariesCategoriesJSON");
	String trl = (String)request.getParameter("trl");
	String license = (String)request.getParameter("license");
	String[] standards = request.getParameterValues("standard");


	ObjectMapper mapper = new ObjectMapper();
	List<String> fieldNames = new ArrayList<String>();
	JsonNode jsonNode = null;
	try {

		jsonNode = mapper.readTree(vocabulariesCategoriesJSON);
		Iterator<String> _fieldNames = jsonNode.fieldNames();
		while(_fieldNames.hasNext()) {
			fieldNames.add(_fieldNames.next());
		}
		
		
	}catch(Exception e) {
		System.out.println(e);
	}


%>

<section class="iot-catalogue-element-page-intro-container bg-light mb-2 pt-3">

	<div class="iot-catalogue-element-page-intro d-flex flex-wrap">
		<% 
		
		int inc = 0;
		for(String fieldName:fieldNames){ 
			String boxClassName = "mb-3";
			if(inc < (fieldNames.size() -1)){
				boxClassName = "mb-3 mr-3";
			}
			if(trl!=null|| license != null || (standards != null &&  standards.length > 0) ){
				boxClassName = "mb-3 mr-3";
			}
			inc++;
			String json = jsonNode.get(fieldName).asText();
			List<HashMap<String,String>> categories = mapper.readValue(jsonNode.get(fieldName).toString(), new TypeReference<List<HashMap<String,String>>>(){});

			List<String> values = new ArrayList<String>();
			for(HashMap<String,String> category:categories){
				String parentCategoryName = category.get("parentCategoryName");
				String categoryName = category.get("categoryName");
				String value = categoryName;
				if(parentCategoryName!=null){
					value = parentCategoryName + " | " + categoryName;
				}
				values.add(value);
			}

		
		%>
			<liferay-util:include page="/asset/visualelements/element_info_box.jsp"  servletContext="<%= application %>">
				<liferay-util:param name="title" value="<%=fieldName %>"/>
				<liferay-util:param name="box-classname" value="<%=boxClassName %>"/>
				
				<% 
	
				for(String value:values){ 
				
				%>
						<liferay-util:param name="value" value="<%=value %>"/>
				<% } %>
			</liferay-util:include>
		<%} %>
					
		<%
		if(trl!=null){
			String boxClassName = "mb-3";
			if( license != null || (standards != null &&  standards.length > 0)){
				boxClassName =  "mb-3 mr-3";
			}
			%>
			<liferay-util:include page="/asset/visualelements/element_info_box.jsp"  servletContext="<%= application %>">
				<liferay-util:param name="box-classname" value="<%=boxClassName %>"/>
				<liferay-util:param name="title" value="TRL"/>
				<liferay-util:param name="value" value="<%=trl %>"/>
			</liferay-util:include>
		<% } %>
		<%if(license!=null){
			String boxClassName = "mb-3";
			if( standards != null &&  standards.length > 0){
				boxClassName = "mb-3 mr-3";
			}
			
			%>
			<liferay-util:include page="/asset/visualelements/element_info_box.jsp"  servletContext="<%= application %>">
				<liferay-util:param name="box-classname" value="<%=boxClassName %>"/>
				<liferay-util:param name="title" value="License"/>
				<liferay-util:param name="value" value="<%=license %>"/>
			</liferay-util:include>
		<% } %>
		<% if(standards != null &&  standards.length > 0){ %>
			<liferay-util:include page="/asset/visualelements/element_info_box.jsp"  servletContext="<%= application %>">
			<liferay-util:param name="box-classname" value="mb-3"/>
				<liferay-util:param name="title" value="Standards"/>
				<%for(String standard:standards){ %>
					<liferay-util:param name="value" value="<%=standard %>"/>
				<%} %>
			</liferay-util:include>
		<%} %>
	</div>
</section>
