<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags/widget/" prefix="widget" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:osoco-wrapperWoMenu titleCode="label.terminalsManager" section="iframe">

<widget:libraryCategories 
	formAction="dashboard/addFromLibrary" 
	messageKey="create.from" 
	selectCategory="${false}"/>

</t:osoco-wrapperWoMenu>