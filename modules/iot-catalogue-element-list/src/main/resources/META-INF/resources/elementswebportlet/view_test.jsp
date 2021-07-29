<%@ include file="../init.jsp" %>


<%
String str = (String) request.getAttribute("test");
%>
<h1>View test</h1>


Hello <b><%= str%></b>!