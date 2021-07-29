<%@include file="../init.jsp"%>

<%
ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Subscription subscription = (Subscription) row.getObject();
String deleteConfirm = "javascript:confirmDel()";
%>
<portlet:actionURL name="test" var="testVar"></portlet:actionURL>
<link type="text/css" href="/css/main.scss" rel="stylesheet" />


<portlet:actionURL name="deleteSubscriptionAction"
	var="deleteSubscriptionUrl">
	<portlet:param name="subscriptionId"
		value="<%=String.valueOf(subscription.getSubscriptionId())%>" />
</portlet:actionURL>
<portlet:actionURL name="deleteSubscriptionAndDataAction"
	var="deleteSubscriptionAndDataUrl">
	<portlet:param name="subscriptionId"
		value="<%=String.valueOf(subscription.getSubscriptionId())%>" />
</portlet:actionURL>
<portlet:actionURL name="disconnectAction" var="disconnectActionUrl">
	<portlet:param name="subscriptionId"
		value="<%=String.valueOf(subscription.getSubscriptionId())%>" />
</portlet:actionURL>

<portlet:actionURL name="connectAction" var="connectActionUrl">
	<portlet:param name="subscriptionId"
		value="<%=String.valueOf(subscription.getSubscriptionId())%>" />
</portlet:actionURL>


<portlet:renderURL var="modalURL"
	windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="subscriptionId" value="<%=String.valueOf(subscription.getSubscriptionId())%>"/>
	<portlet:param name="mvcPath"
	
		value="/elementslistadminportlet/delete_subscription.jsp" />
</portlet:renderURL>

<!-- AUI Script For IFrame POPUP -->
<aui:script position="inline" use="aui-base">
/*
var popupButton =  A.one('#<portlet:namespace />popupButton');

popupButton.on('click',
	function() {
		Liferay.Util.openWindow(
			{
				dialog: {
					//cssClass: 'aui-popup-example',
					destroyOnHide: true,
				
					width: 700,
					height: 220
				},
				dialogIframe: {
					//bodyCssClass: 'custom-css-class'
				},
				id: '<portlet:namespace/>dialog',
				title: 'Delete Subscription',
				uri: '<%=modalURL.toString()%>'
			}
		);
	}
);

Liferay.provide(
	window,
	'<portlet:namespace/>closePopup',
	function(data, dialogId) {
		var A = AUI();
		
		// Here you can use "data" parameter
		
		// Closing the dialog
		var dialog = Liferay.Util.Window.getById(dialogId);
		dialog.destroy();
	},
	['liferay-util-window']
);*/
</aui:script>
<script>
	var css = '.cursor-pointer{cursor: pointer;}', head = document.head
			|| document.getElementsByTagName('head')[0], style = document
			.createElement('style');

	head.appendChild(style);

	style.type = 'text/css';
	if (style.styleSheet) {
		// This is required for IE8 and below.
		style.styleSheet.cssText = css;
	} else {
		style.appendChild(document.createTextNode(css));
	}
	
	function confirmDel() {
		msg = "The data associated with the subscription will be deleted.";
		if(confirm(msg)) {
		window.location.href = '<%=deleteSubscriptionAndDataUrl.toString()%>';
		} else {
		return false;
		}
		}
</script>
<div>
	<%

	%>
</div>


<span data-str="<portlet:namespace />"	class="d-flex justify-content-around"  >
	<!-- <span id='<portlet:namespace/>popupButton'>
		 <liferay-ui:icon
	 
				 ariaRole="button" 
					image="delete" cssClass="icon-monospaced cursor-pointer"    markupView="lexicon"
					message="Delete subscription"  />
					
					
					
					
	</span>
	-->
	 <liferay-ui:icon
	
		 ariaRole="button" 
			image="delete" cssClass="icon-monospaced cursor-pointer"    markupView="lexicon" url="<%=deleteConfirm%>"
			message="Delete subscription"  />
					

		
		 <%
 if (subscription.getConnectionState().equals("Connected")) {
 %> 
 
 <liferay-ui:icon image="unsubscribe" linkCssClass="icon-monospaced"
		markupView="lexicon" message="Disconnect"
		url="<%=disconnectActionUrl%>" /> 
		
		<%
 } else {
 %> 
 
 <liferay-ui:icon image="subscribe" linkCssClass="icon-monospaced"
		markupView="lexicon" message="Connect" url="<%=connectActionUrl%>" />
		
		
	<%
	}
	%>

</span>
