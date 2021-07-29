<%@include file="../../init.jsp"%>

<%
boolean showingAsset = (boolean) request.getAttribute("showing_asset");
String title = "Validations";
String description = "List of all validations available for your user, selecting one will allow you to see more information including, the places, solutions, problems and components related with this validation.";

%>




<%
if (!showingAsset) {
%>


<div class="container-fluid pt-5 pb-5" style="background: linear-gradient(to right, #ffffff , #D3EAED);">
	<div class="container">
		<h1 class="text-primary ml-2 mr-2"><%=title %></h1>
		<h3 class="m-0 ml-2 mr-2" style="color: #495057"><%=description %></h3>
	</div>
</div>
<%
}
%>
