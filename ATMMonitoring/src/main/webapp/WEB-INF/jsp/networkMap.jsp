<%@taglib tagdir="/WEB-INF/tags/terminal/" prefix="terminal"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="t"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>

<t:osoco-wrapper titleCode="label.networkmap" userMsg="${userMsg}"
	section="networkMap">

	<jsp:attribute name="header">
	<link rel="stylesheet" href="resources/css/jstree.style.min.css" />
	<script type="text/javascript" src="resources/js/jstree.min.js"></script>
	<script type="text/javascript" src="resources/js/networkTree.js"></script>
	<script>
		var reloadLocallyOkMessage ="<spring:message code="success.reloadLocallyNetworkMap"/>";
		var reloadLocallyErrorMessage ="<spring:message code="error.reloadLocallyNetworkMap"/>";
		var requestRemoteOkMessage ="<spring:message code="success.requestRemoteNetworkMap"/>";
		var requestRemoteErrorMessage ="<spring:message code="error.requestRemoteNetworkMap"/>";
		var editRouterTableOkMessage = "<spring:message code="success.editRouterTable"/>";
		var editRouterTableErrorMessage = "<spring:message code="error.editRouterTable"/>";
	</script>	
	<script type="text/javascript"
			src="resources/js/networkPageFunctions.js"></script>
	</jsp:attribute>
	<jsp:body>
		   <div class="content">
			   	<h1>Network Map</h1>
			   	<div id="messageBox" class="hidden">
   				 </div>
				<div class="action_box">
					<h2>Node Search:</h2>
					<div class="row">
					 <a class="btn right update" id="reloadNetwork"> Reload Network Locally </a>
						<form>
							<label>Search: </label> <input id="searchInput" class="input"
					type="text" value="" />
							<input class="btn" type="reset" value="Clear Search" />
						</form>
					</div>
				</div>
				<div class="content_tab">
					<div class="action_box">
						<div id="jstree"></div>
						<div class="botonera">
										<input class="btn update" type="button" value="Request Remote Network Mapping"onclick="forceNetworkMapping()">
										<input class="btn" type="button" value="Close All"onclick="NetworkTree.closeAll()">
										<input class="btn" type="button" value="Open All" onclick="NetworkTree.openAll()">	
						</div>
					</div>
					<div id="routerTable" class="action_box data hidden">
						<h2 id="routerTableContentTitle"></h2>
							<div class="ul_data ">
								<ul id="routerTableContentUl"></ul>
							</div>
					</div>
					<div id="routerTableEdit" class="action_box data hidden">
							<h2 id="routerTableEditContentTitle"></h2>
							<form id="editRouterTable" onSubmit="submitEditValuesForm('#'+this.id);return false;">
								<input type="hidden" id="addresseeNode" name="addresseeNode"/>
								<div class="ul_data">
										<ul id="routerTableEditContentUl"></ul>
										<div class="botonera">
											<input class="btn" type="submit" value="Save changes"/>
											<input class="btn add" type="button" value="Add Values" onclick="addEditValue('#routerTableEditContentUl')"/>
											<input id="cancelEdit" class="cancel right" type=reset value="Cancel" onClick="deleteAllEmptyInputs('#editRouterTable')"/>
										</div>
								</div>
							</form>
						</div> 
					</div> 
			</div>
	<script type="text/javascript">
		$(document).ready(function() {
			startNetworkTree();
			setupReloadButton();
		});
	</script>
</jsp:body>
</t:osoco-wrapper>