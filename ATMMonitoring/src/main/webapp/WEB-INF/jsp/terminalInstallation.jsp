<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<t:osoco-wrapperWoMenu titleCode="label.terminalsManager" section="iframe">

<jsp:attribute name="header">
    <script type="text/javascript" src="resources/js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="resources/js/terminalInstallation.js"></script>
</jsp:attribute>

<jsp:body>

<div id="main" class="installation">

	<div id="primary" class="w50 left">
		<h1><spring:message code="label.installation.new"/></h1>
		<article>
			<div class="content">
				<div class="ul_data editable">
					<div class="row">

						<label for="inOffice"><input type="radio" id="inOffice" name="installationType" value="inOffice"><spring:message code="label.installation.inOffice"/></label>

						<label for="outOffice"><input type="radio" id="outOffice" name="installationType" value="outOffice"><spring:message code="label.installation.outOffice"/></label>
					</div>
					<ul class="">
						<li class="inOffice">
							<label for="office"><spring:message code="label.location.office"/></label>
                            <select id="office" name="location.id">
                              <option value=""></option>
							  <c:forEach items="${locations}" var="location">
                              <option value="${location.id}">${location.address}</option>
                              </c:forEach>
                            </select>
						</li>
						<li class="outOffice">
							<label for="address"><spring:message code="label.location.address"/></label>
							<input id="address" name="address" type="text"/>
						</li>
						<li class="outOffice">
							<label for="coordX"><spring:message code="label.location.coordX"/></label>
							<input id="coordX" name="coordX" type="text"/>
						</li>
						<li class="outOffice">
							<label for="coordY"><spring:message code="label.location.coordY"/></label>
							<input id="coordY" name="coordY" type="text"/>
						</li>
						<li class="outOffice">
							<label for="bankCompany"><spring:message code="label.location.bankCompany"/></label>
							<input id="bankCompany" name="bankCompany" type="text"/>
						</li>
						<li class="outOffice">
							<label for="ip"><spring:message code="label.terminal.ip"/></label>
							<input id="ip" name="ip" type="text"/>
						</li>
						<li class="outOffice">
							<label for="publicAccess"><spring:message code="label.location.publicAccess"/></label>
							<input id="publicAccess" type="checkbox" name="publicAccess"/>
						</li>
						<li>
							<label for="startDate"><spring:message code="label.installation.startDate"/></label>
                            <c:set var="now" value="<%=new java.util.Date()%>" />
							<input id="startDate" class="date" name="date" type="text" value="<fmt:formatDate value="${now}" pattern="dd/MM/yyyy"/>">
							<a href="" id="startDateButton" class="btn calendar">
								<span>
									<spring:message code="label.calendar.open"/>
								</span>
							</a>
						</li>
						<li>
							<label for="endDate"><spring:message code="label.installation.endDate"/></label>
							<input id="endDate" class="date" name="date_off" type="text">
							<a href="" id="endDateButton" class="btn calendar">
								<span>
									<spring:message code="label.calendar.open"/>
								</span>
							</a>
						</li>
						<li>
							<label for="type"><spring:message code="label.installation.type"/></label>
							<input id="type" name="type" type="text"/>
						</li>
						<li>
							<label for="post"><spring:message code="label.installation.post"/></label>
							<input id="post" name="post" type="text"/>
						</li>
						<li>
							<label for="processed"><spring:message code="label.installation.processed"/></label>
							<input id="processed" name="processed" type="checkbox"/>
						</li>
					</ul>
				</div>
			</div>
		    <div class="botonera"><a href="" class="save"><spring:message code="label.installation.addInstallation"/></a></div>
		</article>
	</div>

    <div id="map"></div>

</div>
</jsp:body>

</t:osoco-wrapperWoMenu>
