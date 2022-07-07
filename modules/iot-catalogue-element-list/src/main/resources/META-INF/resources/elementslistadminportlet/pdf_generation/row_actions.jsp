<%@include file="/init.jsp"%>

<%
String subscriptionId = (String) request.getParameter("subscriptionId");
String requestId = (String) request.getParameter("requestId");
%>


<div>subscriptionId: <%=subscriptionId %></div>
<div>requestId: <%=requestId %></div>
<span data-str="<portlet:namespace />"	class="d-flex justify-content-around"  >

<liferay-ui:icon
	
		 ariaRole="button" 
			image="delete" cssClass="icon-monospaced cursor-pointer"    markupView="lexicon" url=""
			message="Delete subscription"  />
</span>