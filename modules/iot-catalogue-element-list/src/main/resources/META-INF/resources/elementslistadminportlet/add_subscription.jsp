<%@include file="../init.jsp"%>


<%
List<User> users = (List<User>) renderRequest.getAttribute("users");
ArrayList<Group> sites = (ArrayList<Group>) renderRequest.getAttribute("sites");


List<Map<String, Object>> options = new ArrayList<>();

boolean hideInputs = true;

String host = "www.iot-catalogue.com";
String port = "443";
boolean useSSL = true;
%>


<portlet:renderURL var="viewURL">

	<portlet:param name="mvcPath"
		value="/elementslistadminportlet/view.jsp"></portlet:param>

</portlet:renderURL>


<portlet:actionURL name="addSubscription" var="addSubscriptionURL"></portlet:actionURL>


<div class="closed sidenav-container sidenav-right"
	id="<%=liferayPortletResponse.getNamespace() + "infoPanelId"%>">




	<div class="sidenav-content">
		<clay:container-fluid cssClass="container-view">
			<div class="sheet sheet-lg" id="sheet-portlet">
				<h1>Set subscription</h1>
				<aui:form action="<%=addSubscriptionURL%>"
					name="<portlet:namespace />fm">

					<liferay-frontend:fieldset>
						<aui:model-context model="<%=Subscription.class%>" />
						<aui:input helpMessage="tokenHelpMessage"  name="token" />
						<aui:input type="<%=hideInputs?"hidden":"text" %>"  name="host"   value="<%= host %>" />
						<aui:input    name="port" type="<%=hideInputs?"hidden":"text" %>" value="<%= port %>" />
						<aui:input title="Component page path" name="componentPagePath" helpMessage="componentPagePathHelp" />
						<aui:input title="Validation page path" name="validationPagePath"  helpMessage="validationPagePathHelp"  />
						<aui:select name="User" helpMessage="userHelp">
							<%
							for (User usr: users) {
							%>

							<aui:option value="<%= usr.getUserId() %>"><%=usr.getScreenName() %></aui:option>
							<%}%>
						</aui:select>
						<aui:select name="Site" helpMessage="siteHelp">
							<%
							for (Group site: sites) {
							%>

							<aui:option value="<%= site.getGroupId() %>"><%=site.getGroupKey() %></aui:option>
							<%}%>
						</aui:select>
						<aui:input   name="useSSL" type="<%=hideInputs?"hidden":"checkbox" %>" value="<%= useSSL %>"/>
					</liferay-frontend:fieldset>
					<aui:button-row>

						<aui:button type="submit"></aui:button>
						<aui:button type="cancel" onClick="<%=viewURL.toString()%>"></aui:button>

					</aui:button-row>
				</aui:form>

			</div>
		</clay:container-fluid>
	</div>

</div>
