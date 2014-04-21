<%@include file="includes/JspImports.jsp"%>
<%@taglib uri="http://www.ncr.com/tags" prefix="ncr"%>
<div id="header_g">
	<%-- <nav id="breadcrumb">
		<ul>
			<li><a href="dashboard"><spring:message
						code="breadcrumb.home" /></a></li>
			<li><a href="terminals"><spring:message
						code="breadcrumb.terminals" /></a></li>
			<li><spring:message code="label.terminal" /> ${terminal.mac}</li>
		</ul>
	</nav> --%>
	<c:set var="navigationBackMain" scope="request" >home,terminals</c:set>
	<c:set var="navigationActual" value="label.terminal" scope="request" />
	<c:set var="navigationActualExtra" value="${terminal.mac}" scope="request" />
	
	<jsp:include page="includes/navigation.jsp" />
</div>
<div class="content">
	<h1>
		<spring:message code="label.terminal" />
		${terminal.mac}
	</h1>
	<c:if test="${date != null}">
		<h4>
			<a href="terminals/details/${terminal.id}"><spring:message
					code="label.terminal.returnToNow" /></a>
		</h4>
	</c:if>
	<c:if test="${success != null}">
		<div id="terminalModifNotification" class="notification">
			<p>
				<spring:message code="${success}" />
			</p>
		</div>
		<script type="text/javascript">
			fadeNotification("terminalModifNotification", "notification");
		</script>
	</c:if>

	<c:if test="${errors != null}">
		<div id="terminalModifError" class="alert">
			<p>
				<spring:message code="label.error.form" />
			</p>
		</div>
		<script type="text/javascript">
			fadeNotification("terminalModifNotification", "alert");
		</script>
	</c:if>

	<c:if test="${timeout != null}">
		<div class="message">
			<p>${timeout}</p>
		</div>
	</c:if>
	<div id="ajaxMsg"></div>
	<div class="action_box data desplegable">
		<h2 class="txt last">
			<spring:message code="label.terminalDetails" />
			<c:if test="${date != null}">
				<spring:message code="label.terminal.forDate" />
				<fmt:formatDate value="${date}" pattern="dd/MM/yyyy HH:mm:ss" />
			</c:if>
		</h2>
		<div class="collapsible last">
			<div class="model">
				<div class="photo">
					     <a id="clickeablePhoto" href="" class="colorbox"> 
							<img id="atmPicture" src="resources/images/ejemplo/no_photo.png" width="300">
							<img id="imgLoader" src="resources/images/icons/icon_loader.gif" style="display:none"  />
							<div class="zoom"></div>
						</a>
				</div>
				<div class="desplegable">
					<div class="txt content_hide">
						<span><spring:message code="label.moreInfo" /></span>
					</div>
					<dl class="collapsible hide">
						<dt>
							<spring:message code="label.terminalModel.model" />
							:
						</dt>
						<dd id="field_model">${terminal.terminalModel.model}</dd>
						<dt>
							<spring:message code="label.terminalModel.productClass" />
							:
						</dt>
						<dd id="field_product_class">${terminal.terminalModel.productClass}</dd>
						<dt>
							<spring:message code="label.terminalModel.manufacturer" />
							:
						</dt>
						<dd id="field_manufacturer">${terminal.terminalModel.manufacturer}</dd>
						<dt>
							<spring:message code="label.terminalModel.nickname" />
							:
						</dt>
						<dd id="field_nickname">${terminal.terminalModel.nickname}</dd>
						<dt>
							<spring:message code="label.terminalModel.height" />
							:
						</dt>
						<dd id="field_height">${terminal.terminalModel.height}</dd>
						<dt>
							<spring:message code="label.terminalModel.width" />
							:
						</dt>
						<dd id="field_width">${terminal.terminalModel.width}</dd>
						<dt>
							<spring:message code="label.terminalModel.depth" />
							:
						</dt>
						<dd id="field_depth">${terminal.terminalModel.depth}</dd>
						<dt>
							<spring:message code="label.terminalModel.minWeight" />
							:
						</dt>
						<dd id="field_min_weight">${terminal.terminalModel.minWeight}</dd>
						<dt>
							<spring:message code="label.terminalModel.maxWeight" />
							:
						</dt>
						<dd id="field_max_weight">${terminal.terminalModel.maxWeight}</dd>
					</dl>
				</div>
			</div>
			<sec:authorize
				access="hasAnyRole(${terminalsManagementAllowedRoles})">
				<div id="editForm" class="${errors != null ? '': 'hide'}">
					<form:form method="post" action="terminals/update"
						commandName="terminal">
						<form:hidden path="id" />
						<div class="ul_data editable">
							<ul>
								<li><strong><form:label path="mac">
											<spring:message code="label.terminal.mac" />
															*
														</form:label></strong> <form:input class='form-tf-grey' path="mac"
										maxlength="17" /> <form:errors path="mac" element="div"
										cssClass="error top" /> <c:if test="${duplicatedMac == true}">
										<div class="error top">
											<spring:message code="label.terminal.duplicatedMac" />
										</div>
									</c:if></li>
								<li><strong><form:label path="ip">
											<spring:message code="label.terminal.ip" />
															*
														</form:label></strong> <form:input class='form-tf-grey' path="ip" maxlength="23" />

									<form:errors path="ip" element="div" cssClass="error top" /> <c:if
										test="${duplicatedIp == true}">
										<div class="error top">
											<spring:message code="label.terminal.duplicatedIp" />
										</div>
									</c:if></li>
								<li><strong> <form:label path="terminalVendor">

											<spring:message code="label.terminal.terminalVendor" />

										</form:label>
								</strong> <form:select id="ManufacturerCombo" path="terminalVendor"
										onchange="ChangeManufacturer()">
										<option value=""><spring:message
												code="label.select.default" /></option>
										<c:forEach items="${values.keySet()}" var="key"
											varStatus="status1">
											<c:if test="${key != 'allManufacturers'}">
												<option value="${key}"
													<c:if test="${key.equals(terminal.terminalVendor)}">
															  		selected="true"
															  	</c:if>>${key}</option>
											</c:if>
										</c:forEach>
									</form:select></li>
								<li><strong> <form:label
											path="terminalModel.productClass">

											<spring:message code="label.terminalModel.productClass" />

										</form:label>
								</strong> <form:select id="ModelsCombo" path="terminalModel.id"
										onchange="ChangeModel('#atmPicture',
																		'GET','resources/images/logo/','resources/images/ejemplo/',
																		'#imgLoader','#clickeablePhoto')">
										<option value=""></option>
										<c:forEach items="${values.get('allManufacturers')}"
											var="model">
											<option value="${model.id}"
												<c:if test="${model.productClass.equals(terminal.terminalModel.productClass)}">
															  		selected="true"
															  	</c:if>>${model.productClass}</option>
										</c:forEach>
									</form:select></li>
								<li><strong> <form:label
											path="productClassDescription">

											<spring:message code="label.terminal.productClassDescription" />

										</form:label>
								</strong> <form:input class='form-tf-grey' path="productClassDescription"
										maxlength="120" /></li>
								<li><strong> <form:label path="serialNumber">

											<spring:message code="label.terminal.serialNumber" />

										</form:label>
								</strong> <form:input class='form-tf-grey' path="serialNumber"
										maxlength="50" /> <form:errors path="serialNumber"
										element="div" cssClass="error top" /> <c:if
										test="${duplicatedSerialNumber == true}">
										<div class="error top">
											<spring:message code="label.terminal.duplicatedSerialNumber" />
										</div>
									</c:if></li>
								<li><strong> <form:label path="terminalType">

											<spring:message code="label.terminal.terminalType" />

										</form:label>
								</strong> <form:input class='form-tf-grey' path="terminalType"
										maxlength="50" /> <form:errors path="terminalType"
										elnement="div" cssClass="error top" /></li>
								<li><strong> <form:label path="frontReplenish">

											<spring:message code="label.terminal.frontReplenish" />

										</form:label>
								</strong> <form:checkbox path="frontReplenish" /></li>
								<li><strong> <form:label path="bank">

											<spring:message code="label.terminal.bank" />

										</form:label>
								</strong> <form:input class='form-tf-grey' path="bank" maxlength="50" />
									<form:errors path="bank" element="div" cssClass="error top" />
								</li>
								<li><strong> <form:label path="branch">

											<spring:message code="label.terminal.branch" />

										</form:label>
								</strong> <form:input class='form-tf-grey' path="branch" maxlength="50" />
									<form:errors path="branch" element="div" cssClass="error top" />
								</li>
								<li><strong> <form:label path="manufacturingSite">

											<spring:message code="label.terminal.manufacturingSite" />

										</form:label>
								</strong> <form:input class='form-tf-grey' path="manufacturingSite"
										maxlength="20" /></li>
								<li><strong> <form:label path="tracerNumber">

											<spring:message code="label.terminal.tracerNumber" />

										</form:label>
								</strong> <form:input class='form-tf-grey' path="tracerNumber"
										maxlength="20" /></li>
							</ul>
							<div class="botonera">

								<button  class="btn" onclick="loadInnerSectionFromForm('#terminal', '#primary'); return false;" >
									<spring:message code="label.terminal.updateTerminal"/> </button>
								<c:if test="${!agentPushState}">
									<button class="btn update" onclick="callTask('terminals/request/${terminal.id}',{},'POST', '#ajaxMsg','notification','alert', terminalsUpdate,terminalsUpdateError)"><spring:message
										code="label.terminal.requestSingleSnmpUpdate" /></button>
								</c:if>
								<input id="cancelEdit" type="reset" class="cancel right"
									value="<spring:message code="label.cancel"/>" />
							</div>

						</div>
					</form:form>
				</div>
			</sec:authorize>
			<div id="showTerminal"
				class="ul_data ${errors  != null ? 'hide': ''}">
				<terminal:terminalSummary />

				<div class="botonera">
					<sec:authorize
						access="hasAnyRole(${terminalsManagementAllowedRoles})">
						<button id="editTerminalButton" class="btn"><spring:message code="label.terminal.editTerminal"/></button>
					</sec:authorize>
					<sec:authorize
						access="hasAnyRole(${terminalsUpdateRequestAllowedRoles})">
						<c:if test="${!agentPushState}">
							<button class="btn update" onclick="callTask('terminals/request/${terminal.id}',{},'POST', '#ajaxMsg','notification','alert', terminalsUpdate,terminalsUpdateError)"><spring:message
								code="label.terminal.requestSingleSnmpUpdate"/></button>
						</c:if>
					</sec:authorize>
				</div>

			</div>
			<!-- //ul-data -->


		<!-- //ul-data -->

						</div>
						<!-- // collapsible -->
					</div>
		<!-- // /action_box -->
    	<div>
		<iframe src="terminals/details/historical/${terminal.id}" width="100%" height="100%" id="historicalDetails" marginheight="0" frameborder="0" scrolling="no" onLoad="autoResize(this.id,555,jQuery.browser.mobile)"></iframe>
		</div> 
		<!-- historical ends --> 																			
<script type="text/javascript">

		function initTabs() {
		   defaultInitTabs();
		    
	       $('a[href*=#]').click(function(event) {
	           event.preventDefault();
	           if (location.pathname.replace(/^\//,'') == this.pathname.replace(/^\//,'')
	               && location.hostname == this.hostname) {
	
	               var $target = $(this.hash);
	               $target = $target.length && $target || $('[name=' + this.hash.slice(1) +']');
	               if ($target.length) {
	                   var targetOffset = $target.offset().top - 220;
	                   $('html,body').animate({scrollTop: targetOffset}, 1000);
	               }
	           }
	       }); 
	       <c:if test="${preselectedTab != null}" >
		  		$('li > a[href*=#].${preselectedTab}').click()	
		   </c:if>
		}
		var valuesTree = {
		    	<c:forEach items="${values.keySet()}" var="key" varStatus="status1">
		    		<c:set var="value" value="${values.get(key)}"/>
		   	 '${key}': {
					<c:forEach items="${value}" var="model" varStatus="status2">
						'${model.id}': {
							'model' : '${model.model}',
							'product_class' : '${model.productClass}',
							'manufacturer' : '${model.manufacturer}',
							'nickname' : '${model.nickname}',
							'height' : '${model.height}',
							'width' : '${model.width}',
							'depth' : '${model.depth}',
							'min_weight' : '${model.minWeight}',
							'max_weight' : '${model.maxWeight}'
						},
					</c:forEach>
		                'photoUrl': '<ncr:terminalModelPhotoUrl manufacturer="${key}"/>'
		   	 			}${not status1.last ? ',' : ''}
		   		</c:forEach>
		};
		
		
	 	 function callInit(){
	 		 $("#editTerminalButton").click(function(event) {
	                $("#showTerminal").hide();
	                $("#editForm").show();
		       });
	            $("#cancelEdit").click(function(event) {
	                $("#showTerminal").show();
	                $("#editForm").hide();
		        });
		        
		 	initTabs();
	        onLoadModelCB(); 
	       
		}

	    function initPageJS() {
			callInit();
			getAtmPic("terminals/details/photo/${terminal.id}",
					"#atmPicture","GET",
					"resources/images/logo/",
					"resources/images/ejemplo/",
					"#imgLoader","#clickeablePhoto");
			 
	 	 }

	    function autoResize(id,newheight,isMobile){
			if(!isMobile){
			    var newheight;
		       	document.getElementById(id).height=newheight + "px";
		    }
	    }
	    </script>