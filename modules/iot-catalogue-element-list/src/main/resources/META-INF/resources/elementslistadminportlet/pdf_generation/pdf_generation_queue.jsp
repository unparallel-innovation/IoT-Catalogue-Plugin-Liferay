<%@include file="/init.jsp"%>

<portlet:renderURL var="viewURL">

	<portlet:param name="mvcPath"
		value="/elementslistadminportlet/view.jsp"></portlet:param>

</portlet:renderURL>
<%

	String subscriptionId = (String) request.getParameter("subscriptionId");
	String getEntries = (String) request.getParameter("getEntries");
	String test = (String) request.getParameter("test");

	List<Map<String,Object>> entries = (List<Map<String,Object>>) renderRequest.getAttribute("entries");

	if(entries!=null){
		
%>

<portlet:renderURL var="refreshURL">
	<portlet:param name="getEntries" value="true"/>
	<portlet:param name="subscriptionId" value="<%= subscriptionId %>"/>
	<portlet:param name="mvcPath"
		value="/elementslistadminportlet/pdf_generation/pdf_generation_queue.jsp" />

</portlet:renderURL>



<div class="closed sidenav-container sidenav-right" id="<%=liferayPortletResponse.getNamespace() + "infoPanelId"%>">
	<div class="sidenav-content">
		<clay:container-fluid cssClass="container-view">
			<div class="sheet pb-4" id="sheet-portlet">
				<% if(entries.size() == 0){ %>
				
					<h1>Documents not available</h1>
				<%} else{%>
				<h1>Exported Documents</h1>

				<table class="table table-bordered table-hover table-striped">
					<thead>
						<tr>
							<th>Request Id</th>
							<th>Date</th>
							<th>Status</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<% for(Map<String,Object> entry: entries){ 
							String status = (String)entry.get("status");
						%>
						<tr>
							<td><%= entry.get("_id") %></td>
							<td><%= entry.get("requestDateStr") %></td>
							<td><%= status %></td>
							<td>
							
							<%if(status.equals("Finished") ||status.equals("Failed")  ){ %>
							<portlet:resourceURL var="download">
									<portlet:param name="requestId"
										value="<%= (String)entry.get("_id") %>" />
								</portlet:resourceURL>
								<portlet:actionURL name="deleteExportedDocuments" var="deleteExportedDocumentsURL">
									<portlet:param name="getEntries" value="true"/>
									<portlet:param name="subscriptionId" value="<%= subscriptionId %>"/>
									<portlet:param name="requestId" value="<%= (String)entry.get("_id") %>"/>
									<portlet:param name="mvcPath"
										value="/elementslistadminportlet/pdf_generation/pdf_generation_queue.jsp" />
									
								</portlet:actionURL>
								<span data-str="<portlet:namespace />"	class="d-flex justify-content-around"  >
										<%if(status.equals("Finished")){%>
									<liferay-ui:icon
										
											 ariaRole="button" 
												image="download" cssClass="icon-monospaced cursor-pointer"    markupView="lexicon" url="<%= download.toString() %>"
												message="Download PDFs"  />
													<%} %>
									<liferay-ui:icon
									
										 ariaRole="button" 
											image="delete" cssClass="icon-monospaced cursor-pointer"    markupView="lexicon" url="<%= deleteExportedDocumentsURL.toString() %>"
											message="Delete exported documents"  />
									</span>
									
								
									<%} %>
							</td>
						</tr>
						<%} %>
					</tbody>
				</table>
				<%} %>
					<aui:button-row cssClass="subscription-buttons">

					<aui:button  onClick="<%=viewURL.toString()%>"
						value="Back"></aui:button>
					<aui:button  onClick="<%=refreshURL.toString()%>"
						value="Refresh"></aui:button>
			

				</aui:button-row> 
			</div>
		</clay:container-fluid>
	</div>
</div>

<%


	}
		
		
%>

