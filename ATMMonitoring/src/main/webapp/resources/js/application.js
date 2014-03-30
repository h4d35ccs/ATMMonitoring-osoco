function defaultInitTabs() {
	$('#tabs .content_tab').hide(); // cierro todas las capas
	$('#tabs .content_tab:first').show(); // muestro la primera
	$('.sub_nav li').removeClass('current');
	$('.sub_nav li:first').addClass('current'); // activo el primer tab
	$('.sub_nav li').click(function(event) {
		$('.sub_nav li').removeClass('current'); // borro estilo current de
		// todos los li
		$(this).addClass('current');
		var tab_click = $('.sub_nav li').index(this);
		$('#tabs .content_tab').hide();
		$('#tabs').find(".content_tab").eq(tab_click).show();

		event.preventDefault();

		var eventOnShowData = $(this).data('onShow');
		if (eventOnShowData) {
			eval(eventOnShowData);
		}
	});
}

function countOccurences(mainStr, strToCount) {
	return mainStr.split(strToCount).length;
}
/**
 * Fades a notification after some time
 * 
 * @param msgDivId
 * @param notificationClass
 */
function fadeNotification(msgDivId, notificationClass) {

	$(msgDivId).focus();
	$(msgDivId).delay(10000).fadeOut("slow", function() {
		$(msgDivId).empty();
		$(msgDivId).removeClass(notificationClass);
	});
}

/**
 * Load an URL inside an element
 * 
 * @param elementID
 *            where the content is going to be shown
 * @param url
 *            the remote url to show
 */
function loadInnerSection(elementID, url) {
	$(elementID).empty();
	$(elementID).load(url, function(data) {
		if (!checkForError(data)) {
			try {

				initPageJS();
			} catch (err) {
				// alert(err);
				// in case that the initPage is not defined on the page
			}
		}

	});
}

/**
 * Load an URL inside an element
 * 
 * @param link
 *            where the click is made
 * @param elementID
 *            where the content is going to be shown
 * @param url
 *            the remote url to show
 */
function loadInnerSectionMenu(link, elementID, url, segmentId) {

	loadInnerSection(elementID, url);
	changeURLmenu($(link).id);

}
/**
 * Gets the result of submitting a form and put it on a HTML element
 * 
 * @param formId
 *            id of the form
 * @param elementID
 *            parent element where the result of the query will be put
 * @param otherElementID
 *            result to be put inside the parent
 */
function loadInnerSectionFromForm(formId, elementID) {
	// Get some values from elements on the page:
	var $form = $(formId), term = $form.serializeArray(), url = $form
			.attr("action");
	$(elementID).load(url, term, function(data) {

		if (!checkForError(data)) {
			try {

				initPageJS();
			} catch (err) {
				// alert(err);
				// in case that the initPage is not defined on the page
			}
		}

	});
	
}
/**
 * Calls a controller and do not expect an answer
 * 
 * @param url
 */
function loadPostRequestNoResponse(url) {
	$.post(url);
}
/**
 * Calls a controller and expects an response
 * 
 * @param url
 * @param elementID
 * @param otherElementID
 */
function loadPostRequestResponse(url, elementID, otherElementID) {

	$.post(url, function(data) {
		if (!checkForError(data)) {
			// Put the results in a div
			var content = $(data).filter(otherElementID);

			$(elementID).empty();
			$(elementID).append(content);
		}
	});
}
function getDate(today) {

	var dd = today.getDate();
	var mm = today.getMonth() + 1; // January is 0!
	var yyyy = today.getFullYear();

	if (dd < 10) {
		dd = '0' + dd;
	}
	if (mm < 10) {
		mm = '0' + mm;
	}
	today = dd + '/' + mm + '/' + yyyy;
	return today;
}
/**
 * clock and dateto show on the app base code taken from :
 * http://www.w3schools.com/js/tryit.asp?filename=tryjs_timing_clock
 */
function clock() {
	var today = new Date();
	var h = today.getHours();
	var m = today.getMinutes();
	var s = today.getSeconds();
	// add a zero in front of numbers<10
	m = checkTime(m);
	s = checkTime(s);
	$("#welcomeDate").empty().append(
			getDate(today) + " " + h + ":" + m + ":" + s);
	t = setTimeout(function() {
		clock();
	}, 500);
}
/**
 * Shows elapsed time since the user login
 * @param loggedTimeMilisec
 */
 function loggedTimeUser(loggedTimeMilisec){
	var loggedTime = null;
	
	if(loggedTimeMilisec != 0){
		
		loggedTime = new Date(loggedTimeMilisec);
		console.log(loggedTime);
	}else{
		
		loggedTime = new Date();
	}
	 var now = new Date();
	 var diff = now.getTime() - loggedTime.getTime(); 
	 console.log(diff);
	 if(diff > 0){
		diff = (diff/1000);
	 }
	 $("#welcomeDate").empty().append(splitTime(diff));
	 t = setTimeout(function() {
		 loggedTimeUser((loggedTime.getTime()));
		}, 500);
 }
 
/**
 * Transforms a milisec into hours minutes and seconds
 * @param a
 * @returns {String}
 */
 function splitTime(a) {
	var hours = Math.floor(a / 3600);
	var minutes = Math.floor(a / 60) - (hours * 60);
	var seconds = Math.round( a - (hours * 3600) - (minutes * 60));

	var hs = ':';
	var ms = ':';
	
	if(hours < 10){
		hours = "0"+hours
	}
	
	if(minutes < 10){
		minutes = "0"+minutes;
	}
	
	if(seconds < 10){
		seconds = "0"+seconds;
	}
	
	
	return hours + hs + minutes + ms  + seconds; 
}  

function checkTime(i) {
	if (i < 10) {
		i = "0" + i;
	}
	return i;
}
/**
 * Calls an controller to init a task such an update
 * 
 * @param url
 * @param data
 * @param methodType
 *            POST or GET
 * @param msgElementId
 * @param msgClass
 * @param msgClassError
 * @param msg
 * @param errorMsg
 */
function callTask(url, data, methodType, msgElementId, msgClass, msgClassError,
		msg, errorMsg) {
	$.ajax({
		url : url, // JQuery loads serverside.php
		data : data, // Send value of the clicked button
		type : methodType,// we post or get the value
		dataType : 'json', // Choosing a JSON datatype
		success : function(data) { // Variable data contains the data we get
			// from servers
			$(msgElementId).empty();
			// because of fade animation can have style display none
			var attr = $(msgElementId).attr("style");
			if (typeof attr !== 'undefined' && attr !== false) {

				$(msgElementId).removeAttr("style");
			}

			
			var msgClassToAdd = "";
			var msgContent = "";

			if (data.response == "success") {

				msgClassToAdd = msgClass;
				msgContent = msg;

			} else if (data.response == "error") {

				msgClassToAdd = msgClassError;
				msgContent = errorMsg;
			}
			// shows the notification
			$(msgElementId).append("<p>" + msgContent + "<p>");
			$(msgElementId).addClass(msgClassToAdd);
			
			fadeNotification(msgElementId, msgClassToAdd);
		
		},
		error : function(xhr, ajaxOptions, thrownError) {
			$(msgElementId).append(errorMsg + " " + xhr.status);
			$(msgElementId).addClass("<p>" + msgClassError + "<p>");
			fadeNotification(msgElementId, msgClassError);
		}

	});
}

/**
 * Returns the value of a URL query param
 * 
 * @param name
 * @returns
 */
function getParameterByName(name) {

	return decodeURIComponent((new RegExp('[?|&]' + name + '='
			+ '([^&;]+?)(&|#|;|$)').exec(location.search) || [ , "" ])[1]
			.replace(/\+/g, '%20'))
			|| null;

}

function changeURLmenu(sectionName) {
	// var params = { "section": sectionName};
	// var str = $.param(params);
	// alert(str);
}

function showLoad(loadClass) {
	$("." + loadClass).fadeOut("slow");
}
/**
 * Verify if the execution is an error page
 * 
 * @param data
 * @returns {Boolean}
 */
function checkForError(data) {

	var errorContent = $(data).find("#error_box");
	var hasError = false;
	if (errorContent.length > 0) {
		hasError = true;
	
		showError(errorContent);
	}
	return hasError;
}
/**
 * puts the error on the page
 * 
 * @param errorData
 */
function showError(errorData) {
	$("#primary").empty();
	$("#primary").append(errorData);
}
/**
 * gets the lang from the url
 * 
 * @returns {String}
 */
function getLangFromUrl() {
	var lang = getParameterByName('lang');

	if (lang == null || lang == "") {
		lang = "en";
	}
	return lang;
}
/********************widget *************/

function postNewWidgetRequestResponse(formId,closeButtonId) {
	var url = $(formId).attr("action");
	var formValues =  $(formId).serializeArray();
	$.post(url,formValues);
	$(closeButtonId).click();
	$("#dashboardMenu").click();
}

/**
 * ****************terminals functions **********************************
 */
function onLoadModelCB() {
	var value = $('#ManufacturerCombo').val();
	var $cb = $('#ModelsCombo');
	if (value == '') {
		$cb.empty();
		$cb.append($('<option selected="selected"></option>'));
	} else {
		var values = valuesTree[value];
		$('#ModelsCombo > option').each(function() {
			if (!(($(this).val() in values) || ($(this).val() == ''))) {
				$(this).remove();
			}
		});
	}
	if (!$cb.val()) {
		// var photoUrl = valuesTree[value]['photoUrl'];
		// $('.photo a').attr("href", photoUrl);
		// $('.photo img').attr("src", photoUrl);
	}
};

function ChangeManufacturer() {
	var $cb1 = $('#ModelsCombo');
	var $cb2 = $('#ManufacturerCombo');
	$cb1.empty();
	$cb1.append($('<option selected="selected"></option>'));
	if ($cb2.val() != '') {
		var values = valuesTree[$cb2.val()];
		var keys = $.map(values, function(v, i) {
			return i;
		});
		keys.sort(function(a, b) {
			var compA = values[a].label;
			var compB = values[b].label;
			return (compA < compB) ? -1 : (compA > compB) ? 1 : 0;
		});
		$.each(keys, function(index, key) {
			if (key != 'photoUrl') {
				$cb1.append($('<option/>').attr("value", key).text(
						values[key]['product_class']));
			}
		});
		$cb1.prop('disabled', false);
	} else {
		$cb1.prop('disabled', true);
	}
	;
	$('#field_model').text('');
	$('#field_product_class').text('');
	$('#field_manufacturer').text('');
	$('#field_nickname').text('');
	$('#field_width').text('');
	$('#field_height').text('');
	$('#field_depth').text('');
	$('#field_min_weight').text('');
	$('#field_max_weight').text('');
	// var photoUrl;
	// if ($cb2.val()) {
	// // photoUrl = valuesTree[$cb2.val()]['photoUrl'];
	// } else {
	// // photoUrl = '<ncr:terminalModelPhotoUrl />'
	// }
	// // $('.photo a').attr("href", photoUrl);
	// // $('.photo img').attr("src", photoUrl);
};

function ChangeModel(imgElementId, methodType, manFPicPath, noFotoPath,
		imgLoaderId, zoomClick) {
	var $cb1 = $('#ModelsCombo');
	var $cb2 = $('#ManufacturerCombo');
	if (($cb1.val() != '') && ($cb2.val() != '')) {
		var values = valuesTree[$cb2.val()][$cb1.val()];
		$('#field_model').text(values.model);
		$('#field_product_class').text(values.product_class);
		$('#field_manufacturer').text(values.manufacturer);
		$('#field_nickname').text(values.nickname);
		$('#field_width').text(values.width);
		$('#field_height').text(values.height);
		$('#field_depth').text(values.depth);
		$('#field_min_weight').text(values.min_weight);
		$('#field_max_weight').text(values.max_weight);

	}
	// if (!$cb1.val()) {
	// // var photoUrl = valuesTree[$cb2.val()]['photoUrl'];
	// // $('.photo a').attr("href", photoUrl);
	// // $('.photo img').attr("src", photoUrl);
	// }
	getAtmModelPic("terminals/model/photo/" + $cb1.val(), imgElementId,
			methodType, manFPicPath, noFotoPath, imgLoaderId, zoomClick);
};

function requestSnmpUpdate() {
	window.location.assignWithBase("terminals/request/${terminal.id}");
}
/** **********terminal details/new***************** */

/**
 * Gets the image to show in the atm details
 * 
 * @param url
 * @param imgElementId
 * @param methodType
 * @param manFPicPath
 * @param noFotoPath
 * @param imgLoaderId
 */
function getAtmPic(url, imgElementId, methodType, manFPicPath, noFotoPath,
		imgLoaderId, zoomClick) {
	var noPhoto = "no_photo.png";

	$(imgLoaderId).show();
	$.ajax({
		url : url, // JQuery loads serverside.php
		type : methodType,// we post or get the value
		dataType : 'json', // Choosing a JSON datatype
		success : function(data) {
			// i make sure that the element has no picture
			$(imgElementId).attr("src", "");
			$(zoomClick).attr("href", "");

			if (data.imagetype == "atm") {

				$(imgElementId).attr("src",
						"data:image/png;base64," + data.imagebinary);
				$(zoomClick).attr("href",
						"data:image/png;base64," + data.imagebinary);

			} else if (data.imagetype == "manufacturer") {
				
				$(imgElementId).attr("src", manFPicPath + data.imagename);
				$(zoomClick).attr("href",manFPicPath + data.imagename);

			} else if (data.imagetype == "nophoto") {

				$(imgElementId).attr("src", noFotoPath + noPhoto);
			}

			$(imgLoaderId).hide();
		},
		error : function(xhr, ajaxOptions, thrownError) {
			$(imgElementId).attr("src", noFotoPath + noPhoto);
			$(imgLoaderId).hide();
		}

	});
}

function getAtmModelPic(url, imgElementId, methodType, manFPicPath, noFotoPath,
		imgLoaderId, zoomClick) {
	var noPhoto = "no_photo.png";
	$(imgLoaderId).show();
	$.ajax({
		url : url, // JQuery loads serverside.php
		type : methodType,// we post or get the value
		dataType : 'json', // Choosing a JSON datatype
		success : function(data) {
			// i make sure that the element has no picture
			$(imgElementId).attr("src", "");
			$(zoomClick).attr("href", "");

			if (data.imagetype == "model") {

				$(imgElementId).attr("src",
						"data:image/png;base64," + data.imagebinary);
				$(zoomClick).attr("href",
						"data:image/png;base64," + data.imagebinary);

			} else if (data.imagetype == "nophoto") {

				$(imgElementId).attr("src", noFotoPath + noPhoto);
			}

			$(imgLoaderId).hide();
		},
		error : function(xhr, ajaxOptions, thrownError) {
			$(imgElementId).attr("src", noFotoPath + noPhoto);
			$(imgLoaderId).hide();
		}

	});
}
/**
 * Gets the manufacturer image
 * @param imgElementId
 * @param manFPicPath
 * @param manufacturerName
 */
function getManufacturerPic(imgElementId, comboManufacturerId ,imgLoaderId,zoomClick,manFPicPath,noPhotoPath){

	var manufacturerName = $(comboManufacturerId).val().toLowerCase();
	var photo = "";
	if(manufacturerName != ""){
		photo =manFPicPath+manufacturerName+".png";
	}else{
		photo = noPhotoPath+"no_photo.png";
	}
	
	$(imgLoaderId).show();
	$(imgElementId).attr("src", "");
	$(zoomClick).attr("href", "");
	$(imgElementId).attr("src",photo);
	$(zoomClick).attr("href",photo);
	$(imgLoaderId).hide();
}
/**
 * ******** queries functions **************************
 */
/**
 * Switches the value of the combobox
 */
function checkboxChangeValue(checkBoxId){
	
	
	if($(checkBoxId).attr("value") =="false"){
		$(checkBoxId).attr("value","true");
		
	}else{
		
		$(checkBoxId).attr("value","false");
		
	}
}

function displayOnLoad(name, maxValue) {
	for (i = maxValue; i > 1; i--) {
		if ($('#' + name + 'Combo' + i + '1').val() != '') {
			for (j = 1; j < i; j++) {
				showHiddenRow(name, j);
			}
			break;
		}
	}
};
function onLoadValueCB2(entity, maxNumber) {
	for (var number = 1; number <= maxNumber; number++) {
		var value = $('#' + entity + 'Combo' + number + '1').val();
		var $cb = $('#' + entity + 'Combo' + number + '2');
		if (value == '') {
			$cb.empty();
			$cb.append($('<option selected="selected"></option>'));
		} else {
			$cb.prop('disabled', false);
			var values = valuesTree[entity][value].values;
			$('#' + entity + 'Combo' + number + '2 > option').each(function() {
				if (!(($(this).val() in values) || ($(this).val() == ''))) {
					$(this).remove();
				}
			});
			if ($cb.val() != '') {
				$('#' + entity + 'Field' + number).prop('disabled', false);
			}
		}
	}
};
function onLoadValueCB3(entity, maxNumber) {
	for (var number = 1; number <= maxNumber; number++) {
		var value1 = $('#' + entity + 'Combo' + number + '1').val();
		var $cb2 = $('#' + entity + 'Combo' + number + '2');
		var $cb3 = $('#' + entity + 'Combo' + number + '3');
		if (value1 == '') {
			$cb2.empty();
			$cb2.append($('<option selected="selected"></option>'));
			$cb3.empty();
			$cb3.append($('<option selected="selected"></option>'));
		} else {
			$cb2.prop('disabled', false);
			var values = valuesTree[entity][value1].values;
			$('#' + entity + 'Combo' + number + '2 > option').each(function() {
				if (!(($(this).val() in values) || ($(this).val() == ''))) {
					$(this).remove();
				}
			});
			var value2 = $cb2.val();
			if (value2 == '') {
				$cb3.empty();
				$cb3.append($('<option selected="selected"></option>'));
			} else {
				$cb3.prop('disabled', false);
				values = values[value2].values;
				$('#' + entity + 'Combo' + number + '3 > option')
						.each(
								function() {
									if (!(($(this).val() in values) || ($(this)
											.val() == ''))) {
										$(this).remove();
									}
								});
			}
			if ($cb3.val() != '') {
				$('#' + entity + 'Field' + number).prop('disabled', false);
			}
		}
	}
};
function ChangeValue2CB1(entity, number) {
	var $cb = $('#' + entity + 'Combo' + number + '2');
	$cb.empty();
	$cb.append($('<option selected="selected"></option>'));
	if ($('#' + entity + 'Combo' + number + '1').val() != '') {
		var values = valuesTree[entity][$('#' + entity + 'Combo' + number + '1')
				.val()].values;
		var keys = $.map(values, function(v, i) {
			return i;
		});
		keys.sort(function(a, b) {
			var compA = values[a].label;
			var compB = values[b].label;
			return (compA < compB) ? -1 : (compA > compB) ? 1 : 0;
		});
		$.each(keys, function(index, key) {
			$cb.append($('<option/>').attr("value", key)
					.text(values[key].label));
		});
		$('#' + entity + 'CB' + number).prop('disabled', false);
		$cb.prop('disabled', false);
	} else {
		$('#' + entity + 'CB' + number).prop('disabled', true);
		$cb.prop('disabled', true);
	}
	;
	$('#' + entity + 'Field' + number).prop('disabled', true);
};
function ChangeValue2CB2(entity, number) {
	if ($('#' + entity + 'Combo' + number + '2').val() != '') {
		if (valuesTree[entity][$('#' + entity + 'Combo' + number + '1').val()].values[$(
				'#' + entity + 'Combo' + number + '2').val()].values) {
			$('#' + entity + 'Field' + number).prop('disabled', false);
		} else {
			$('#' + entity + 'Field' + number).prop('disabled', true);
		}
	} else {
		$('#' + entity + 'Field' + number).prop('disabled', true);
	}
	;
};
function ChangeValue3CB1(entity, number) {
	var $cb = $('#' + entity + 'Combo' + number + '2');
	$cb.empty();
	$cb.append($('<option selected="selected"></option>'));
	if ($('#' + entity + 'Combo' + number + '1').val() != '') {
		var values = valuesTree[entity][$('#' + entity + 'Combo' + number + '1')
				.val()].values;
		var keys = $.map(values, function(v, i) {
			return i;
		});
		keys.sort(function(a, b) {
			var compA = values[a].label;
			var compB = values[b].label;
			return (compA < compB) ? -1 : (compA > compB) ? 1 : 0;
		});
		$.each(keys, function(index, key) {
			$cb.append($('<option/>').attr("value", key)
					.text(values[key].label));
		});
		$('#' + entity + 'CB' + number).prop('disabled', false);
		$cb.prop('disabled', false);
	} else {
		$cb.prop('disabled', true);
	}
	;
	$('#' + entity + 'Combo' + number + '3').prop('disabled', true);
	$('#' + entity + 'CB' + number).prop('disabled', true);
	$('#' + entity + 'Field' + number).prop('disabled', true);
};
function ChangeValue3CB2(entity, number) {
	var $cb = $('#' + entity + 'Combo' + number + '3');
	$cb.empty();
	$cb.append($('<option selected="selected"></option>'));
	if ($('#' + entity + 'Combo' + number + '2').val() != '') {
		var values = valuesTree[entity][$('#' + entity + 'Combo' + number + '1')
				.val()].values[$('#' + entity + 'Combo' + number + '2').val()].values
		var keys = $.map(values, function(v, i) {
			return i;
		});
		keys.sort(function(a, b) {
			var compA = values[a].label;
			var compB = values[b].label;
			return (compA < compB) ? -1 : (compA > compB) ? 1 : 0;
		});
		$.each(keys, function(index, key) {
			$cb.append($('<option/>').attr("value", key)
					.text(values[key].label));
		});
		$('#' + entity + 'CB' + number).prop('disabled', false);
		$cb.prop('disabled', false);
	} else {
		$('#' + entity + 'CB' + number).prop('disabled', true);
		$cb.prop('disabled', true);
	}
	;
	$('#' + entity + 'Field' + number).prop('disabled', true);
};
function ChangeValue3CB3(entity, number) {
	if ($('#' + entity + 'Combo' + number + '3').val() != '') {
		if (valuesTree[entity][$('#' + entity + 'Combo' + number + '1').val()].values[$(
				'#' + entity + 'Combo' + number + '2').val()].values[$(
				'#' + entity + 'Combo' + number + '3').val()].values) {
			$('#' + entity + 'Field' + number).prop('disabled', false);
		} else {
			$('#' + entity + 'Field' + number).prop('disabled', true);
		}
	} else {
		$('#' + entity + 'Field' + number).prop('disabled', true);
	}
	;
};
function checkSaveExecute() {
	if ($('#queryName').val().length > 0) {
		if ($("#save_execute").button("option", "disabled")) {
			$("#save_execute").button("option", "disabled", false);
		}
	} else {
		if (!$("#save_execute").button("option", "disabled")) {
			$("#save_execute").button("option", "disabled", true);
		}
	}
}
function showHiddenRow(name, rowNumber) {
	$('#' + name + 'Row' + (rowNumber + 1)).removeClass('hidden');
	$('#' + name + 'ShowButton' + rowNumber).addClass('hidden');
}
function userQuerySelected() {
	document.userQueriesForm.submit();
}

function removeDuplicatedValueFromCombobox(comboBox){
	var usedValues = {};
	$(comboBox).children().each(function() {
		
		if(usedValues[this.value]) {
			  $(this).remove();
		}else{
			usedValues[this.value] = this.value;
		}
	    
	});
}

/**
 * Fill the first combobox field from the query page
 * 
 * @param optionType
 * @param fieldCombo
 */
function loadQueryOptions(optionType, fieldCombo) {

	if ($(fieldCombo).find('option').length <= 2) {
		var lang = getLangFromUrl();
		$(fieldCombo).empty();
		$(fieldCombo).append("<option></option>");
		$.ajax({
			url : "queries/combos/" + optionType + "/" + lang, // JQuery loads
			// serverside.php
			type : "GET",// we post or get the value
			dataType : 'json', // Choosing a JSON datatype
			success : function(data) {
				savedOptions = data.selectoptions;

				jQuery.each(savedOptions, function(key, data) {
					var comboOption = "<option value=" + key + ">" + data
							+ "</option>";
					$(fieldCombo).append(comboOption);

				});

			},
			error : function(xhr, ajaxOptions, thrownError) {

			}

		});
	}
	
	removeDuplicatedValueFromCombobox(fieldCombo);
	
}
/**
 * Loads the content of the comparision textbox based on the value get from the
 * field combo
 * 
 * @param optionType
 * @param fieldCombo
 * @param comparisonCombo
 * @param checkbox
 */
function loadQueryComparisonOptions(optionType, fieldCombo, comparisonCombo,
		checkbox,textValue) {

	var lang = getLangFromUrl();
	$(comparisonCombo).empty();
	$(comparisonCombo).append("<option></option>");
	$(checkbox).prop('checked', false);
	$(textValue).attr("value","");
	
	var fieldName = $(fieldCombo).val();
	if (fieldName != "") {

		$(comparisonCombo).prop('disabled', false);
		$(checkbox).prop('disabled', false);

		$.ajax({
			url : "queries/combos/comparison/" + optionType + "/" + fieldName
					+ "/" + lang, // JQuery loads
			// serverside.php
			type : "GET",// we post or get the value
			dataType : 'json', // Choosing a JSON datatype
			success : function(data) {
				savedOptions = data.selectoptions;

				jQuery.each(savedOptions, function(key, data) {
					var comboOption = "<option value=" + key + ">" + data
							+ "</option>";
					$(comparisonCombo).append(comboOption);

				});

			},
			error : function(xhr, ajaxOptions, thrownError) {

			}

		});
	} else {

		$(comparisonCombo).empty();
		$(comparisonCombo).append("<option></option>");
		$(textValue).attr("value","");
		$(comparisonCombo).prop('disabled', true);
		$(checkbox).prop('checked', false);
		$(checkbox).prop('disabled', true);
		$(textValue).prop('disabled', true);
		
	}

}
/**
 * Loads the options for the combobox of hardware device types
 */
function loadQueryHardwareFieldsOptions(deviceCombo, fieldCombo,checkbox,comparisionCombo,valueTextbox) {

	var lang = getLangFromUrl();

	var deviceType = $(deviceCombo).val();

	if (deviceType != "") {
		$(fieldCombo).empty();
		$(fieldCombo).append("<option></option>");
		$(fieldCombo).prop('disabled', false);
		$(checkbox).prop('checked', false);
		$(valueTextbox).attr("value","");

		$.ajax({
			url : "queries/combos/comparison/" + deviceType + "/" + lang, // JQuery
			// loads
			// serverside.php
			type : "GET",// we post or get the value
			dataType : 'json', // Choosing a JSON datatype
			success : function(data) {
				savedOptions = data.selectoptions;

				jQuery.each(savedOptions, function(key, data) {
					var comboOption = "<option value=" + key + ">" + data
							+ "</option>";
					$(fieldCombo).append(comboOption);

				});

			},
			error : function(xhr, ajaxOptions, thrownError) {

			}

		});
	} else {
		var emptyOption = "<option></option>";
		
		$(fieldCombo).empty();
		$(comparisionCombo).empty();
		$(fieldCombo).append(emptyOption);
		$(comparisionCombo).append(emptyOption);
		$(checkbox).prop('checked', false);
		$(checkbox).prop('disabled', true);
		$(valueTextbox).prop('disabled', true);
		$(valueTextbox).attr("value","");
	}
	removeDuplicatedValueFromCombobox(deviceCombo);
}
/**
 * Sets the query values in the page
 * @param jsonValues
 */
function loadQueryValues(jsonValues) {
	var comboFieldRegex = "Combo\\d1$";

	jQuery
			.each(
					jsonValues,
					function(key, data) {

						var comboFieldPattern = new RegExp(comboFieldRegex);
						//verify if the first combo has some values
						if (comboFieldPattern.test(key) && data != "") {
							var comboBaseName = jsonValues[key+"Group"];
						
							var comboNameBaseAndPosition = key.split("Combo");
							var comboposition = comboNameBaseAndPosition[1];

							var comboLabel = jsonValues[key + "Label"];
							var comboRowPosition = comboposition.substring(0,1);
//							
							$("#" + key).click();
							$("#" + key).append(
									"<option value='" + data + "'selected>"
											+ comboLabel + "</option>");
							$("#" + key).prop('disabled', false);
							$("#" + key).change();
							
							// combobox for negation
							var checkboxName = comboBaseName + "CB"
									+ comboRowPosition;
							var checkboxValue = jsonValues[checkboxName];
							var checkboxNot = $("#" + checkboxName);
							checkboxNot.prop('disabled', false);
							checkboxNot.attr("value", checkboxValue);
							
							if (checkboxValue == "true") {
								checkboxNot.attr('checked', true);
							}

							// Combobox comparison
							var comboboxComparisonName = comboBaseName
									+ "Combo" + comboRowPosition + "2";
							var comboboxComparisonValue = jsonValues[comboboxComparisonName];
							var comboboxComparisonLable = jsonValues[comboboxComparisonName
									+ "Label"];
							$("#" + comboboxComparisonName).append(
									"<option value='" + comboboxComparisonValue
											+ "'selected>"
											+ comboboxComparisonLable
											+ "</option>");
							$("#" + comboboxComparisonName).prop('disabled',
									false);

							// Value textfield

							var textfieldName = comboBaseName + "Field"
									+ comboRowPosition;
							var textfieldValue = jsonValues[textfieldName];
							$("#" + textfieldName)
									.attr("value", textfieldValue);
							//only remove the disable if the previous value is not equal to is_null
							if(comboboxComparisonValue !="is_null"){
								$("#" + textfieldName).prop('disabled', false);
							}
							// check for hardware values to handdle the 3rd
							// combo
							
							if (new RegExp("hardware").test(comboBaseName)) {
								
								$("#" + comboboxComparisonName).change();
								var comboboxComparisonHardwareName = comboBaseName
										+ "Combo" + comboRowPosition + "3";
								var comboboxComparisonHardwareValue = jsonValues[comboboxComparisonHardwareName];
								var comboboxComparisonHardwareLable = jsonValues[comboboxComparisonHardwareName
										+ "Label"];
								
								$("#" + comboboxComparisonHardwareName)
										.append(
												"<option value='"
														+ comboboxComparisonHardwareValue
														+ "'selected>"
														+ comboboxComparisonHardwareLable
														+ "</option>");
								$("#" + comboboxComparisonHardwareName).prop(
										'disabled', false);
							}

							// show the row
							$("#"+comboBaseName+"ShowButton"+comboRowPosition).click();
					
						}
					});
	

}

/**
 * Enable or disable the value textbox after selecting some comparision
 * 
 * @param comparisonCombo
 * @param textField
 */
function onChangeComparisonEnableDisableText(comparisonCombo, textField) {
	var comparisonValue = $(comparisonCombo).val();
	if (comparisonValue != "" && comparisonValue != 'is_null') {
		$(textField).prop('disabled', false);
	} else {
		$(textField).prop('disabled', true);
		$(textField).attr('value', "");
	}
}

/** *************************Scheduled update******************************* */

function deleteConfirmation(url, msg, elementID, msgDivId, notificationClass) {
	var confirm = window.confirm(msg);
	if (confirm == true) {
		loadInnerSection(elementID, url);

	} else {
		$(msgDivId).empty();
		$(msgDivId).removeClass(notificationClass);
	}
};

/** *************************help******************* */
/**
 * Loads the inner content for the help section
 */
function loadHelpContent(linkId, linkClass, section, elementID) {
	var baseHelpUrl = "resources/help/";
	var lang = getLangFromUrl();

	baseHelpUrl += lang + "/";
	$(linkId).closest('ul').find('.' + linkClass).removeClass(linkClass);
	$(linkId).addClass(linkClass);
	$(elementID).load(baseHelpUrl + section + ".html");

}

/** ********************* my queries ************************** */
/**
 * Submit the query form and adds a param to execute an especific action such as
 * execute or delete
 */
function changeRequestParam(formId, elementID, otherElementID, action) {
	var url = $(formId).attr("action");
	url = url.split('?')[0];
	url = url + "?" + $.param({
		'action' : action
	});
	$(formId).attr('action', url);
	loadInnerSectionFromForm(formId, elementID, otherElementID);
}
/**
 * Deletes a query from the details page
 * 
 * @param formId
 * @param elementID
 * @param otherElementID
 * @param action
 * @param deleteMsg
 */
function deleteQuery(formId, elementID, otherElementID, action, deleteMsg) {
	if (confirm(deleteMsg)) {
		changeRequestParam(formId, elementID, otherElementID, action);
	}
}

function deleteQueryIcon(elementID, url, deleteMsg) {
	if (confirm(deleteMsg)) {
		loadInnerSection(elementID, url);
	}
}
/** ******************* Users ***************************** */
/**
 * Adds a new role calling the remote controler, if succeed it will load the new
 * page
 */
function addNewRole(formId, methodType, errorDivIdElement, errorClass,
		errorMsg, toFillElemnent) {

	var $form = $(formId), term = $form.serializeArray(), url = $form
			.attr("action");

	$.ajax({
		url : url, // JQuery loads serverside.php
		data : term, // Send value of the clicked button
		type : methodType,// we post or get the value
		dataType : 'json', // Choosing a JSON datatype
		success : function(data) { // Variable data contains the data
			if (!checkForError(data)) {
				if (data.response == "success") {
					var redirect = data.redirect;
					loadInnerSection(toFillElemnent, redirect);
				} else if (data.response == "error"
						&& data.duplicatedname == "true") {
					$(errorDivIdElement).empty();
					$(errorDivIdElement).append(
							"<div class=" + errorClass + ">" + errorMsg
									+ "</div>");
				}
			}
		},
		error : function(xhr, ajaxOptions, thrownError) {
			$(toFillElemnent).empty();
			$(toFillElemnent).append(xhr.responseText);

		}

	});
}