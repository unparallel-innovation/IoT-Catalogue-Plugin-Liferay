<%@include file="../init.jsp"%>

<%
int subscriptionCount = SubscriptionLocalServiceUtil.getSubscriptionCount();

try {

} catch (Exception ex) {

}
%>
<portlet:actionURL name="deleteAll" var="deleteAllVar"></portlet:actionURL>
<portlet:actionURL name="deleteAllSubscriptions"
	var="deleteAllSubscriptionsVar"></portlet:actionURL>
<portlet:actionURL name="test" var="testVar"></portlet:actionURL>


<portlet:renderURL var="addSubscriptionUrl">
	<portlet:param name="mvcPath"
		value="/elementslistadminportlet/add_subscription.jsp" />

</portlet:renderURL>


<div class="closed sidenav-container sidenav-right"
	id="<%=liferayPortletResponse.getNamespace() + "infoPanelId"%>">

	<div class="sidenav-content">

		<clay:container-fluid cssClass="container-view">
			<div class="sheet" id="sheet-portlet">
				<%
				if (subscriptionCount > 0) {
				%>

				<h1>Active subscriptions</h1>
				<liferay-ui:search-container
					total="<%=SubscriptionLocalServiceUtil.getSubscriptionsCount()%>">
					<liferay-ui:search-container-results
						results="<%=SubscriptionLocalServiceUtil.getSubscriptions(searchContainer.getStart(),
                    searchContainer.getEnd())%>" />
					<liferay-ui:search-container-row
						className="com.iot_catalogue.model.Subscription"
						modelVar="subscriptionModel">

						<liferay-ui:search-container-column-text property="connectionId" />
						<liferay-ui:search-container-column-text
							property="componentPagePath" />
						<liferay-ui:search-container-column-text
							property="validationPagePath" />
						<liferay-ui:search-container-column-text
							property="connectionState" />

						<liferay-ui:search-container-column-text property="userId" />
						<liferay-ui:search-container-column-text property="groupId" />
						<liferay-ui:search-container-column-jsp name="actions"
							path="/elementslistadminportlet/row_actions.jsp"></liferay-ui:search-container-column-jsp>

					</liferay-ui:search-container-row>
					<liferay-ui:search-iterator />
				</liferay-ui:search-container>

				<%
				}
				%>
				<aui:button-row cssClass="subscription-buttons">

					<aui:button  onClick="<%=addSubscriptionUrl.toString()%>"
						value="Add subscription"></aui:button>

			<aui:button onClick="<%=testVar.toString()%>"
									value="Test"></aui:button>
				</aui:button-row>
			</div>
		</clay:container-fluid>
	</div>

</div>





