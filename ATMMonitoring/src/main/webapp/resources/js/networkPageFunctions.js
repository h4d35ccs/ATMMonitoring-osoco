var editInputCommonName = "routerTableInput";
var editInputCont = 0;
var commonNameAndId = "'" + editInputCommonName + "[$cont]'";
var commonUrl = "serverchain/";
var getNetworkMapUrl = commonUrl + "networkmap";
var forceNetworkMapUrl = commonUrl + "forceMapping";
//var reloadLocallyOkMessage = "Network Map Locally reloaded";
//var reloadLocallyErrorMessage = "An Error occurs while Reloading Locally the Network Map";
//
//var requestRemoteOkMessage = "The Remote Request was succesfuly Sent";
//var requestRemoteErrorMessage = "An Error occurs while Requesting the Remote Request";
//
//var editRouterTableOkMessage = "The Update was succesfuly Sent";
//var editRouterTableErrorMessage = "An Error occurs while Sending the Update Request";
var messageBoxDelay = 20000;

function setupReloadButton() {
	try {
		$("#reloadNetwork").click(function() {
			reloadTree();
			hideActionDiv("#routerTableEdit");
			hideActionDiv("#routerTable");
			showOkMessage(reloadLocallyOkMessage);
		});
		
	} catch (error) {
		console.log(error);
		showAlertMessage(reloadLocallyErrorMessage);
	}
}

function startNetworkTree() {

	NetworkTree.setupHtmlElements("#jstree", "#searchInput",
			"resources/images/icons/server.png",
			"resources/images/icons/serversIdle.png",
			"resources/images/icons/serverRoot.png");
	NetworkTree.nodeIddleSeconds = 40;
	NetworkTree.startJStreeRemote(getMenuItems, getNetworkMapUrl);
	// NetworkTree.startJStreeLocal(networkJson(),getMenuItems);
	NetworkTree.extraMenuHandler = notLeafMenuHandler;
}

function notLeafMenuHandler(node, menuItems) {
	if (node.children.length > 0) {
		delete menuItems.editRouterTableItem;
	}
}

function getMenuItems(node) {

	return {

		showRouterTableItem : {
			label : "Show Router Table",
			action : function() {
				showRouterTableAction($(node)[0].id, $(node)[0].data);
			}
		},
		editRouterTableItem : {
			label : "Edit Router Table",
			action : function() {
				showEditRouterTableAction($(node)[0].id, $(node)[0].data);
			}
		}

	};
}

function showRouterTableAction(nodeId, routerTable) {

	var liElements = generateLIElements(routerTable,
			getLiElementFromRouterTable);
	populateUlElement(liElements, "#routerTableContentUl");
	var title = "Router Table From: " + nodeId;
	showActionDiv("#routerTable", "#routerTableContentTitle", title,
			"#routerTableEdit");
	hideActionDiv("#routerTableEdit");

}

function showEditRouterTableAction(nodeId, routerTable) {

	var liElements = generateLIElements(routerTable,
			getLiInputElementFromRouterTable);
	populateUlElement(liElements, "#routerTableEditContentUl");
	var title = "Edit Router Table For : " + nodeId;
	showActionDiv("#routerTableEdit", "#routerTableEditContentTitle", title);
	hideActionDiv("#routerTable");
	$("#addresseeNode").val(nodeId);

}

function showActionDiv(divId, titleId, title) {
	var divElement = $(divId);
	var titleElement = $(titleId);
	var divElementisHidden = divElement.is(':hidden');

	titleElement.empty();
	titleElement.append(title);

	if (divElementisHidden) {
		divElement.show();
	}
}

function hideActionDiv(divId) {

	var divElement = $(divId);
	divElement.hide();
}

function populateUlElement(liElements, ulId) {
	var ulElement = $(ulId);
	ulElement.empty();
	ulElement.append(liElements);
}

function generateLIElements(routerTable, liElementsFunction) {

	routerTable = returnPlainRouterTable(routerTable);
	var routerTableElements = routerTable.split(",");
	var liElements = "";

	for (var i = 0; i < routerTableElements.length; i++) {

		var routerTableElement = routerTableElements[i];

		if ((routerTableElement != "") && (routerTableElement.length > 1)) {
			routerTableElement = routerTableElement.trim();
			liElements += liElementsFunction(routerTableElement);
		}

	}

	return liElements;
}

function returnPlainRouterTable(routerTable) {

	var openBraketPosition = routerTable.indexOf("[");
	var closeBraketPosition = routerTable.indexOf("]");

	routerTable = routerTable.substring((openBraketPosition + 1),
			routerTable.length);
	routerTable = routerTable.substring(0, closeBraketPosition - 1);
	return routerTable;
}

function getLiElementFromRouterTable(routerTableElement) {
	var openLIElement = "<li><strong>";
	var closeLIElement = "</strong></li>";

	return openLIElement + routerTableElement + closeLIElement;
}

function getLiInputElementFromRouterTable(routerTableElement) {
	var matricula = getMatriculaOnlyFromValue(routerTableElement);
	var openInputIdAndName = "<input id=" + generateInputName() + " name="
			+ generateInputName();
	var inputClassType = " class='form-tf-grey\' type='text' ";
	var valueAndClose = " value='" + matricula + "'/>";
	increaseInputCounter();
	return "<li>" + openInputIdAndName + inputClassType + valueAndClose
			+ "</li>";
}

function getMatriculaOnlyFromValue(routerTableElement) {
	var matriculaAndIpPort = routerTableElement.split("=");
	var matricula = matriculaAndIpPort[0];
	return matricula;
}

function deleteAllEmptyInputs(formId) {

	$($(formId + " input[type=text]")).each(function() {
		var input = $(this);
		var liElement = input.closest("li");
		var inputValue = input.val();
		if (inputValue.length < 1) {
			input.remove();
			liElement.remove();
			decreaseInputCounter();
		}

	});
}

function addEditValue(ulId) {

	var newInput = addNewLiInputElementToEdit();
	$(ulId).append(newInput);
}

function addNewLiInputElementToEdit() {
	console.log(editInputCont);
	var openInputIdAndName = "<input id=" + generateInputName() + "  name="
			+ generateInputName();
	var inputClassType = " class='form-tf-grey\' type='text' ";
	var valueAndClose = "/>";
	increaseInputCounter();
	return "<li>" + openInputIdAndName + inputClassType + valueAndClose
			+ "</li>";
}

function generateInputName() {

	return commonNameAndId.replace("\$cont", editInputCont);
}

function increaseInputCounter() {
	editInputCont = (editInputCont + 1);
}

function decreaseInputCounter() {
	if (editInputCont > 0) {
		editInputCont = (editInputCont - 1);
	}
}


function submitEditValuesForm(formId) {
	deleteAllEmptyInputs(formId);
	var formData = $(formId).serialize();

	$.post("serverchain/editroutertable", formData,function() {
		showOkMessage(editRouterTableOkMessage);
		hideActionDiv("#routerTableEdit");
	}).fail(function() {
		showAlertMessage(editRouterTableErrorMessage);
	 });

}

function forceNetworkMapping() {

	$.get(forceNetworkMapUrl, function() {
		showOkMessage(requestRemoteOkMessage);
	}).fail(function() {
		showAlertMessage(requestRemoteErrorMessage);
	});
}

function showAlertMessage(alertMessage) {
	showMessageBox(alertMessage, "alert");
}
function showOkMessage(okMessage) {
	showMessageBox(okMessage, "notification");
}

function showMessageBox(message, cssClass) {

	$("#messageBox").empty();
	$("#messageBox").attr("class", "");
	$("#messageBox").attr("class", cssClass);
	$("#messageBox").append("<p>" + message + "</p>");
	$("#messageBox").show();
	$("#messageBox").focus();
	$("#messageBox").delay(messageBoxDelay).fadeOut("slow"); 

}

function reloadTree(){
	NetworkTree.reload();
}
