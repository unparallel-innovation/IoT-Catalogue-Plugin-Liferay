<%@include file="../../init.jsp"%>

<% 
	String title = (String)request.getParameter("title");
	String className = (String)request.getParameter("box-classname");
	String[] values = request.getParameterValues("value");
	System.out.println("valuex");
	System.out.println(values.toString());
	for(String value:values){
		System.out.println(value);
	}

%>


<span class="label label-lg label-secondary iot-catalogue-element-label align-items-center d-flex m-0 <%= className!=null?className:"" %>" >
	<span class="text-primary mr-2"><%= title %></span>
	<%
	int inc = 0;  
	for(String value:values){ 
		String _className = "";
		if(inc < (values.length - 1)){
			_className = "mr-2";
		}
		inc++;
	
	%>
	<liferay-util:include page="/asset/visualelements/element_info_tag.jsp"  servletContext="<%= application %>">
		<liferay-util:param name="tag-classname" value="<%= _className %>"/>
		<liferay-util:param name="tag-value" value="<%=value %>"/>
		
	</liferay-util:include>
	<%} %>


</span>

