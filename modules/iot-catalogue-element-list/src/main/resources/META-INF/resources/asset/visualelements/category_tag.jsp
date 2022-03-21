<%@include file="../../init.jsp"%>
<%
	String categoryName = (String)request.getParameter("categoryName");
	String parentCategoryName = (String)request.getParameter("parentCategoryName");
	String label = null;
	
	if(categoryName!=null){
		if(parentCategoryName!=null){
			label = "<div><span class='border-secondary border-right pr-1'>" + parentCategoryName + "</span><span class='pl-1'>" + categoryName + "</span></div>";
		}else{
			label = categoryName;
		}
	}
	
	
%>


<%
if (label!=null) {
%>
	
	<clay:label		
		cssClass="bg-transparent"			
		label="<%= label %>"
		large="<%= true %>"
	/>
					
<%
}
%>