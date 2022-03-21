<%@include file="../../init.jsp"%>


<%

	String vocabularyTitle = (String)request.getParameter("vocabularyTitle");
	String[] categories = request.getParameterValues("category");
	List<HashMap<String,String>> categoryHashMaps = null;
	if(categories != null){
		categoryHashMaps = new ArrayList<HashMap<String,String>>();
		for(String category: categories){
			categoryHashMaps.add(DataUtils.strToHashMap(category));
		}
	}


%> 

<% if(vocabularyTitle != null && categoryHashMaps != null){ %>

<div class="bg-light bg-light rounded p-2 h-100 d-flex align-items-center">
	<h5 class="mb-0 mr-2"><%=vocabularyTitle %></h5>
	<div>
	
		<%for(HashMap<String,String> category: categoryHashMaps){ %>
			<liferay-util:include page="/asset/visualelements/category_tag.jsp" servletContext="<%= application %>">
				<liferay-util:param name="categoryName" value="<%=category.get("categoryName") %>"/>
				<liferay-util:param name="parentCategoryName" value="<%=category.get("parentCategoryName") %>"/>
			</liferay-util:include>


		<%} %>

	</div>
</div>

<%
}
%>