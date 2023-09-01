<%@include file="../../init.jsp"%>
<%

	String className = (String)request.getParameter("tag-classname");
	String value = (String)request.getParameter("tag-value");

%>
<span class="label label-lg label-secondary iot-catalogue-element-label m-0 <%= className!=null?className:"" %>" >
	<%=value %>
</span>

