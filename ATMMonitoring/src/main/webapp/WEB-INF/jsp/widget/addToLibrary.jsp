<%@include file="../includes/JspImports.jsp"%>
<%@taglib tagdir="/WEB-INF/tags/widget/" prefix="widget" %>
<widget:libraryCategories 
	widgetId="${widgetId}" 
	formAction="dashboard/addToLibrary" 
	messageKey="add.to" 
	selectCategory="${true}"/>
