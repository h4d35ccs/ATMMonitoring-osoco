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
	<c:set var="navigationBackMain" scope="request" >home,ups</c:set>
	<c:set var="navigationActual" value="label.terminal" scope="request" />
	<c:set var="navigationActualExtra" value="${ups.seriesNumber}" scope="request" />
	
	<jsp:include page="includes/navigation.jsp" />
</div>
<div class="content">
	<h1>
		<spring:message code="label.ups" />
		${terminal.seriesNumber}
	</h1>
	<c:if test="${success != null}">
		<div id="upsModifNotification" class="notification">
			<p>
				<spring:message code="${success}" />
			</p>
		</div>
		<script type="text/javascript">
			fadeNotification("upsModifNotification", "notification");
		</script>
	</c:if>

	<c:if test="${errors != null}">
		<div id="upsModifError" class="alert">
			<p>
				<spring:message code="label.error.form" />
			</p>
		</div>
		<script type="text/javascript">
			fadeNotification("upsModifNotification", "alert");
		</script>
	</c:if>
	<div id="ajaxMsg"></div>
	<div class="action_box data desplegable">
		<h2 class="txt last">
			<spring:message code="label.upsDetails" />
		</h2>
		<div class="collapsible last">
			<sec:authorize
				access="hasAnyRole(${upsManagementAllowedRoles})">
				<div id="editForm" class="${errors != null ? '': 'hide'}">
					<form:form method="post" action="ups/update" commandName="ups">
						<form:hidden path="id" />
						<div class="ul_data editable only_data">
							<ul>
								<li><strong><form:label path="seriesNumber">
											<spring:message code="label.ups.seriesNumber" />
															*
														</form:label></strong> <form:input class='form-tf-grey' path="seriesNumber" maxlength="30"/>
														<form:errors path="seriesNumber" element="div"
										cssClass="error top" /> <c:if test="${duplicatedSeriesNumber == true}">
										<div class="error top">
											<spring:message code="label.ups.duplicatedSeriesNumber" />
										</div>
									</c:if></li>
								<li><strong><form:label path="ip">
											<spring:message code="label.ups.ip" />
														</form:label></strong> <form:input class='form-tf-grey' path="ip" maxlength="23" />

									<form:errors path="ip" element="div" cssClass="error top" /></li>
								<li><strong> <form:label path="model">

											<spring:message code="label.ups.model" />

										</form:label>
								</strong> <form:input class='form-tf-grey' path="model" maxlength="30" />

									<form:errors path="model" element="div" cssClass="error top" /></li>
								<li><strong> <form:label path="alarmMsg">

											<spring:message code="label.ups.alarmMsg" />

										</form:label>
								</strong> <form:input class='form-tf-grey' path="alarmMsg" maxlength="30" />

									<form:errors path="alarmMsg" element="div" cssClass="error top" /></li>
								<li><strong> <form:label path="audFmo">

											<spring:message code="label.ups.audFmo" />

										</form:label>
								</strong> <form:input class='form-tf-grey' path="audFmo" maxlength="30" />

									<form:errors path="audFmo" element="div" cssClass="error top" /></li>
								<li><strong> <form:label path="autonomyMillisec">

											<spring:message code="label.ups.autonomyMillisec" />

										</form:label>
								</strong> <form:input class='form-tf-grey' path="autonomyMillisec" maxlength="30" />

									<form:errors path="autonomyMillisec" element="div" cssClass="error top" /></li>
								<li><strong> <form:label path="chargePercentage">

											<spring:message code="label.ups.chargePercentage" />

										</form:label>
								</strong> <form:input class='form-tf-grey' path="chargePercentage" maxlength="30" />

									<form:errors path="chargePercentage" element="div" cssClass="error top" /></li>
								<li><strong> <form:label path="expensePercentage">

											<spring:message code="label.ups.expensePercentage" />

										</form:label>
								</strong> <form:input class='form-tf-grey' path="expensePercentage" maxlength="30" />

									<form:errors path="expensePercentage" element="div" cssClass="error top" /></li>
								<li><strong> <form:label path="firmware">

											<spring:message code="label.ups.firmware" />

										</form:label>
								</strong> <form:input class='form-tf-grey' path="firmware" maxlength="30" />

									<form:errors path="firmware" element="div" cssClass="error top" /></li>
								<li><strong> <form:label path="generalStatusMsg">

											<spring:message code="label.ups.generalStatusMsg" />

										</form:label>
								</strong> <form:input class='form-tf-grey' path="generalStatusMsg" maxlength="30" />

									<form:errors path="generalStatusMsg" element="div" cssClass="error top" /></li>
								<li><strong> <form:label path="lastExecutionDate">

											<spring:message code="label.ups.lastExecutionDate" />

										</form:label>
								</strong> <form:input class='form-tf-grey' path="lastExecutionDate" maxlength="30" />

									<form:errors path="lastExecutionDate" element="div" cssClass="error top" /></li>
								<li><strong> <form:label path="numPosition">

											<spring:message code="label.ups.numPosition" />

										</form:label>
								</strong> <form:input class='form-tf-grey' path="numPosition" maxlength="30" />

									<form:errors path="numPosition" element="div" cssClass="error top" /></li>
								<li><strong> <form:label path="runningStatus">

											<spring:message code="label.ups.runningStatus" />

										</form:label>
								</strong> <form:input class='form-tf-grey' path="runningStatus" maxlength="30" />

									<form:errors path="runningStatus" element="div" cssClass="error top" /></li>
								<li><strong> <form:label path="runningTimeMillisec">

											<spring:message code="label.ups.runningTimeMillisec" />

										</form:label>
								</strong> <form:input class='form-tf-grey' path="runningTimeMillisec" maxlength="30" />

									<form:errors path="runningTimeMillisec" element="div" cssClass="error top" /></li>
								<li><strong> <form:label path="type">

											<spring:message code="label.ups.type" />

										</form:label>
								</strong> <form:input class='form-tf-grey' path="type" maxlength="30" />

									<form:errors path="type" element="div" cssClass="error top" /></li>
							</ul>
							<div class="botonera">

								<button class="btn" onclick="loadInnerSectionFromForm('#ups', '#primary'); return false;" >
									<spring:message code="label.ups.updateUps"/> </button>
								<input id="cancelEdit" type="reset" class="cancel right"
									value="<spring:message code="label.cancel"/>" />
							</div>

						</div>
					</form:form>
				</div>
			</sec:authorize>
			<div id="showUps"
				class="ul_data only_data ${errors  != null ? 'hide': ''}">
				<ups:upsSummary/>

				<div class="botonera">
					<sec:authorize
						access="hasAnyRole(${upsManagementAllowedRoles})">
						<button id="editUpsButton" class="btn"><spring:message code="label.ups.editUps"/></button>
					</sec:authorize>
				</div>

			</div>
			<!-- //ul-data -->


		<!-- //ul-data -->

						</div>
						<!-- // collapsible -->
					</div>
		<!-- // /action_box -->																			
<script type="text/javascript">
	 	 function callInit(){
	 		 $("#editUpsButton").click(function(event) {
	                $("#showUps").hide();
	                $("#editForm").show();
		       });
	            $("#cancelEdit").click(function(event) {
	                $("#showUps").show();
	                $("#editForm").hide();
		        });
		}

	    function initPageJS() {
			callInit();
	 	 }

	    function autoResize(id,newheight,isMobile){
			if(!isMobile){
			    var newheight;
		       	document.getElementById(id).height=newheight + "px";
		    }
	    }
</script>