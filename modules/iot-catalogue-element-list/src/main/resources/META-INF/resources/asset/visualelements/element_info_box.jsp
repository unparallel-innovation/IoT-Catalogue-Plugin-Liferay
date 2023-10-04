<%@include file="../../init.jsp"%>

<% 
	String title = (String)request.getParameter("title");
	String className = (String)request.getParameter("box-classname");
	String[] values = request.getParameterValues("value");

%>


<span class="label label-lg label-secondary pt-2 pb-0 iot-catalogue-element-label align-items-center d-flex m-0 flex-wrap <%= className!=null?className:"" %>" >
	<span class="text-primary mr-2"><%= title %></span>
	<%
	int inc = 0;  
	for(String value:values){ 
		String _className = "mb-2";
		if(inc < (values.length - 1)){
			_className = "mb-2 mr-2";
		}
		inc++;
	
	%>
	<liferay-util:include page="/asset/visualelements/element_info_tag.jsp"  servletContext="<%= application %>">
		<liferay-util:param name="tag-classname" value="<%= _className %>"/>
		<liferay-util:param name="tag-value" value="<%=value %>"/>
		
	</liferay-util:include>
	<%} %>


</span>

