<%@tag description="Xfs Component Details" pageEncoding="UTF-8"%>
<%@attribute name="xfsComponent" required="true" type="com.ncr.ATMMonitoring.pojo.XfsComponent"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div id="main">
    <div id="primary">
<div class="box">
<h1><spring:message code="label.xfsComponentDetails"/></h1>

<div class="margin-box">
<table class="form-disabled-generic">
<c:if test="${xfsComponent.logicalName != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.logicalName"/></td>
    <td>${xfsComponent.logicalName}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.xfsClass != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.xfsClass"/></td>
    <td>${xfsComponent.xfsClass}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.acceptMedia != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.acceptMedia"/></td>
    <td>${xfsComponent.acceptMedia}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.algorithms != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.algorithms"/></td>
    <td>
	<c:forEach items="${xfsComponent.algorithmsSplit}" var="split">
    	${split}<br>
    </c:forEach>
    </td>
</tr>
</c:if>
<c:if test="${xfsComponent.autofix != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.autofix"/></td>
    <td>${xfsComponent.autofix}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.auxiliaries != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.auxiliaries"/></td>
    <td>${xfsComponent.auxiliaries}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.backImageColorFormat != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.backImageColorFormat"/></td>
    <td>
	<c:forEach items="${xfsComponent.backImageColorFormatSplit}" var="split">
    	${split}<br>
    </c:forEach>
    </td>
</tr>
</c:if>
<c:if test="${xfsComponent.cameras != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.cameras"/></td>
    <td>${xfsComponent.cameras}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.camdata != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.camdata"/></td>
    <td>${xfsComponent.camdata}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.canOpenSafeDoor != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.canOpenSafeDoor"/></td>
    <td>${xfsComponent.canOpenSafeDoor}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.cards != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.cards"/></td>
    <td>
	<c:forEach items="${xfsComponent.cardsSplit}" var="split">
    	${split}<br>
    </c:forEach>
    </td>
</tr>
</c:if>
<c:if test="${xfsComponent.cashUnits != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.cashUnits"/></td>
    <td>
	<c:forEach items="${xfsComponent.cashUnitsSplit}" var="split">
    	${split}<br>
    </c:forEach>
    </td>
</tr>
</c:if>
<c:if test="${xfsComponent.cenVersion != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.cenVersion"/></td>
    <td>${xfsComponent.cenVersion}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.charSupport != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.charSupport"/></td>
    <td>${xfsComponent.charSupport}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.chipio != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.chipio"/></td>
    <td>${xfsComponent.chipio}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.chipPower != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.chipPower"/></td>
    <td>${xfsComponent.chipPower}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.chipProtocol != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.chipProtocol"/></td>
    <td>
	<c:forEach items="${xfsComponent.chipProtocolSplit}" var="split">
    	${split}<br>
    </c:forEach>
    </td>
</tr>
</c:if>
<c:if test="${xfsComponent.codeLineFormat != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.codeLineFormat"/></td>
    <td>
	<c:forEach items="${xfsComponent.codeLineFormatSplit}" var="split">
    	${split}<br>
    </c:forEach>
    </td>
</tr>
</c:if>
<c:if test="${xfsComponent.compound != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.compound"/></td>
    <td>${xfsComponent.compound}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.comparemagneticstripe != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.comparemagneticstripe"/></td>
    <td>${xfsComponent.comparemagneticstripe}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.control != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.control"/></td>
    <td>${xfsComponent.control}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.cursor != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.cursor"/></td>
    <td>${xfsComponent.cursor}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.deptransport != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.deptransport"/></td>
    <td>${xfsComponent.deptransport}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.derivationAlgorithms != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.derivationAlgorithms"/></td>
    <td>
	<c:forEach items="${xfsComponent.derivationAlgorithmsSplit}" var="split">
    	${split}<br>
    </c:forEach>
    </td>
</tr>
</c:if>
<c:if test="${xfsComponent.dispensePaper != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.dispensePaper"/></td>
    <td>${xfsComponent.dispensePaper}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.display != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.display"/></td>
    <td>
	<c:forEach items="${xfsComponent.displaySplit}" var="split">
    	${split}<br>
    </c:forEach>
    </td>
</tr>
</c:if>
<c:if test="${xfsComponent.displayLight != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.displayLight"/></td>
    <td>${xfsComponent.displayLight}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.doors != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.doors"/></td>
    <td>${xfsComponent.doors}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.encoder != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.encoder"/></td>
    <td>${xfsComponent.encoder}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.encodenames != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.encodenames"/></td>
    <td>${xfsComponent.encodenames}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.endorser != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.endorser"/></td>
    <td>${xfsComponent.endorser}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.envelopesupply != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.envelopesupply"/></td>
    <td>${xfsComponent.envelopesupply}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.exchangeTypes != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.exchangeTypes"/></td>
    <td>
	<c:forEach items="${xfsComponent.exchangeTypesSplit}" var="split">
    	${split}<br>
    </c:forEach>
    </td>
</tr>
</c:if>
<c:if test="${xfsComponent.extents != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.extents"/></td>
    <td>
	<c:forEach items="${xfsComponent.extentsSplit}" var="split">
    	${split}<br>
    </c:forEach>
    </td>
</tr>
</c:if>
<c:if test="${xfsComponent.extra != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.extra"/></td>
    <td>
	<c:forEach items="${xfsComponent.extraSplit}" var="split">
    	${split}<br>
    </c:forEach>
    </td>
</tr>
</c:if>
<c:if test="${xfsComponent.flux != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.flux"/></td>
    <td>${xfsComponent.flux}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.fontnames != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.fontnames"/></td>
    <td>${xfsComponent.fontnames}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.forms != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.forms"/></td>
    <td>${xfsComponent.forms}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.frontImageColorFormat != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.frontImageColorFormat"/></td>
    <td>
	<c:forEach items="${xfsComponent.frontImageColorFormatSplit}" var="split">
    	${split}<br>
    </c:forEach>
    </td>
</tr>
</c:if>
<c:if test="${xfsComponent.guidlights != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.guidlights"/></td>
    <td>${xfsComponent.guidlights}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.hasCashBox != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.hasCashBox"/></td>
    <td>${xfsComponent.hasCashBox}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.hasInsertedSensor != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.hasInsertedSensor"/></td>
    <td>${xfsComponent.hasInsertedSensor}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.hasShutter != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.hasShutter"/></td>
    <td>${xfsComponent.hasShutter}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.hasTakenSensor != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.hasTakenSensor"/></td>
    <td>${xfsComponent.hasTakenSensor}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.idConnect != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.idConnect"/></td>
    <td>${xfsComponent.idConnect}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.imagecapture != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.imagecapture"/></td>
    <td>${xfsComponent.imagecapture}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.idKey != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.idKey"/></td>
    <td>${xfsComponent.idKey}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.imageSource != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.imageSource"/></td>
    <td>
	<c:forEach items="${xfsComponent.imageSourceSplit}" var="split">
    	${split}<br>
    </c:forEach>
    </td>
</tr>
</c:if>
<c:if test="${xfsComponent.imageType != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.imageType"/></td>
    <td>
	<c:forEach items="${xfsComponent.imageTypeSplit}" var="split">
    	${split}<br>
    </c:forEach>
    </td>
</tr>
</c:if>
<c:if test="${xfsComponent.indicators != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.indicators"/></td>
    <td>${xfsComponent.indicators}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.intermediateStacker != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.intermediateStacker"/></td>
    <td>${xfsComponent.intermediateStacker}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.keyCheckModes != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.keyCheckModes"/></td>
    <td>
	<c:forEach items="${xfsComponent.keyCheckModesSplit}" var="split">
    	${split}<br>
    </c:forEach>
    </td>
</tr>
</c:if>
<c:if test="${xfsComponent.keyLock != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.keyLock"/></td>
    <td>${xfsComponent.keyLock}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.keyNum != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.keyNum"/></td>
    <td>${xfsComponent.keyNum}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.magneticstriperead != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.magneticstriperead"/></td>
    <td>${xfsComponent.magneticstriperead}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.magneticstripewrite != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.magneticstripewrite"/></td>
    <td>${xfsComponent.magneticstripewrite}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.maxCashInItems != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.maxCashInItems"/></td>
    <td>${xfsComponent.maxCashInItems}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.maxdatalength != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.maxdatalength"/></td>
    <td>${xfsComponent.maxdatalength}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.maxDispenseItems != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.maxDispenseItems"/></td>
    <td>${xfsComponent.maxDispenseItems}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.maxMediaOnStacker != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.maxMediaOnStacker"/></td>
    <td>${xfsComponent.maxMediaOnStacker}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.maxnumchars != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.maxnumchars"/></td>
    <td>${xfsComponent.maxnumchars}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.maxpictures != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.maxpictures"/></td>
    <td>${xfsComponent.maxpictures}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.maxRetract != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.maxRetract"/></td>
    <td>${xfsComponent.maxRetract}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.mediaTaken != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.mediaTaken"/></td>
    <td>${xfsComponent.mediaTaken}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.micr != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.micr"/></td>
    <td>${xfsComponent.micr}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.moveItems != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.moveItems"/></td>
    <td>${xfsComponent.moveItems}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.multiPage != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.multipage"/></td>
    <td>${xfsComponent.multiPage}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.numLeds != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.numLeds"/></td>
    <td>${xfsComponent.numLeds}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.ocr != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.ocr"/></td>
    <td>${xfsComponent.ocr}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.paperSources != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.paperSources"/></td>
    <td>
	<c:forEach items="${xfsComponent.paperSourcesSplit}" var="split">
    	${split}<br>
    </c:forEach>
    </td>
</tr>
</c:if>
<c:if test="${xfsComponent.pinFormats != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.pinFormats"/></td>
    <td>
	<c:forEach items="${xfsComponent.pinFormatsSplit}" var="split">
    	${split}<br>
    </c:forEach>
    </td>
</tr>
</c:if>
<c:if test="${xfsComponent.powerOff != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.powerOff"/></td>
    <td>${xfsComponent.powerOff}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.powerOn != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.powerOn"/></td>
    <td>${xfsComponent.powerOn}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.presentationAlgorithms != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.presentationAlgorithms"/></td>
    <td>
	<c:forEach items="${xfsComponent.presentationAlgorithmsSplit}" var="split">
    	${split}<br>
    </c:forEach>
    </td>
</tr>
</c:if>
<c:if test="${xfsComponent.printer != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.printer"/></td>
    <td>${xfsComponent.printer}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.printonretracts != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.printonretracts"/></td>
    <td>${xfsComponent.printonretracts}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.programaticallydeactivate != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.programaticallydeactivate"/></td>
    <td>${xfsComponent.programaticallydeactivate}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.readForm != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.readForm"/></td>
    <td>${xfsComponent.readForm}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.readTracks != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.readTracks"/></td>
    <td>
	<c:forEach items="${xfsComponent.readTracksSplit}" var="split">
    	${split}<br>
    </c:forEach>
    </td>
</tr>
</c:if>
<c:if test="${xfsComponent.readWriteAfterEject != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.readWriteAfterEject"/></td>
    <td>${xfsComponent.readWriteAfterEject}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.refill != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.refill"/></td>
    <td>${xfsComponent.refill}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.resolution != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.resolution"/></td>
    <td>${xfsComponent.resolution}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.resolutions != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.resolutions"/></td>
    <td>${xfsComponent.resolutions}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.retractAreas != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.retractAreas"/></td>
    <td>
	<c:forEach items="${xfsComponent.retractAreasSplit}" var="split">
    	${split}<br>
    </c:forEach>
    </td>
</tr>
</c:if>
<c:if test="${xfsComponent.retractBins != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.retractBins"/></td>
    <td>
	<c:forEach items="${xfsComponent.retractBinsSplit}" var="split">
    	${split}<br>
    </c:forEach>
    </td>
</tr>
</c:if>
<c:if test="${xfsComponent.retractenvelope != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.retractenvelope"/></td>
    <td>${xfsComponent.retractenvelope}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.retractStackerActions != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.retractStackerActions"/></td>
    <td>
	<c:forEach items="${xfsComponent.retractStackerActionsSplit}" var="split">
    	${split}<br>
    </c:forEach>
    </td>
</tr>
</c:if>
<c:if test="${xfsComponent.retractTransportActions != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.retractTransportActions"/></td>
    <td>
	<c:forEach items="${xfsComponent.retractTransportActionsSplit}" var="split">
    	${split}<br>
    </c:forEach>
    </td>
</tr>
</c:if>
<c:if test="${xfsComponent.securityType != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.securityType"/></td>
    <td>${xfsComponent.securityType}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.sensors != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.sensors"/></td>
    <td>${xfsComponent.sensors}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.serviceProvider != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.serviceProvider"/></td>
    <td>${xfsComponent.serviceProvider}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.shutterControl != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.shutterControl"/></td>
    <td>${xfsComponent.shutterControl}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.stamp != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.stamp"/></td>
    <td>${xfsComponent.stamp}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.supportedPositions != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.supportedPositions"/></td>
    <td>
	<c:forEach items="${xfsComponent.supportedPositionsSplit}" var="split">
    	${split}<br>
    </c:forEach>
    </td>
</tr>
</c:if>
<c:if test="${xfsComponent.toner != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.toner"/></td>
    <td>${xfsComponent.toner}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.type != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.type"/></td>
    <td>
	<c:forEach items="${xfsComponent.typeSplit}" var="split">
    	${split}<br>
    </c:forEach>
    </td>
</tr>
</c:if>
<c:if test="${xfsComponent.validationAlgorithms != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.validationAlgorithms"/></td>
    <td>
	<c:forEach items="${xfsComponent.validationAlgorithmsSplit}" var="split">
    	${split}<br>
    </c:forEach>
    </td>
</tr>
</c:if>
<c:if test="${xfsComponent.vendor != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.vendor"/></td>
    <td>${xfsComponent.vendor}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.writeForm != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.writeForm"/></td>
    <td>${xfsComponent.writeForm}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.writeMode != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.writeMode"/></td>
    <td>${xfsComponent.writeMode}</td>
</tr>
</c:if>
<c:if test="${xfsComponent.writeTracks != null}">
<tr>
    <td class="header"><spring:message code="label.xfsComponent.writeTracks"/></td>
    <td>
	<c:forEach items="${xfsComponent.writeTracksSplit}" var="split">
    	${split}<br>
    </c:forEach>
    </td>
</tr>
</c:if>
</table>
</div>
</div>
	
<c:if test="${!empty xfsComponent.logicalCashUnits}">
<div class="box">
<h2><spring:message code="label.logicalCashUnits"/></h2>
<div class="margin-box">
<c:forEach items="${xfsComponent.logicalCashUnits}" var="logicalCashUnit">
	<div class="box">
	<h3><spring:message code="label.lcu"/> ${logicalCashUnit.name}</h3>
	<div class="margin-box">
	<table class="data subform">
		<tr>
			<th style="width: 50px;"><spring:message code="label.logicalCashUnits.type"/></th>
			<th style="width: 35px;"><spring:message code="label.logicalCashUnits.unitId"/></th>
			<th style="width: 55px;"><spring:message code="label.logicalCashUnits.currencyId"/></th>
			<th style="width: 35px;"><spring:message code="label.logicalCashUnits.values"/></th>
			<th style="width: 40px;"><spring:message code="label.logicalCashUnits.minimum"/></th>
			<th style="width: 45px;"><spring:message code="label.logicalCashUnits.maximum"/></th>
		</tr>
		<tr>
	        <td style="width: 50px;">${logicalCashUnit.type}</td>
	        <td style="width: 35px;">${logicalCashUnit.unitId}</td>
	        <td style="width: 55px;">${logicalCashUnit.currencyId}</td>
	        <td style="width: 35px;">
				<c:forEach items="${logicalCashUnit.valuesSplit}" var="split">
			    	${split}<br>
			    </c:forEach>
	    	</td>
	        <td style="width: 40px;">${logicalCashUnit.minimum}</td>
	        <td style="width: 45px;">${logicalCashUnit.maximum}</td>
		</tr>
	</table>
	<c:if test="${!empty logicalCashUnit.physicalCashUnits}">
		<h4><spring:message code="label.physicalCashUnits"/></h4>
		<table class="data subform">
		<tr>
		    <th><spring:message code="label.physicalCashUnit.name"/></th>
		    <th><spring:message code="label.physicalCashUnit.unitId"/></th>
		    <th><spring:message code="label.physicalCashUnit.maximum"/></th>
		    <th><spring:message code="label.physicalCashUnit.hardwareSensor"/></th>
		</tr>
		<c:set var="alt" value="${false}"/>
		<c:forEach items="${logicalCashUnit.physicalCashUnits}" var="physicalCashUnit">
		    <tr <c:if test="${alt}">class="alt"</c:if>>
		        <td>${physicalCashUnit.name}</td>
		        <td>${physicalCashUnit.unitId}</td>
		        <td>${physicalCashUnit.maximum}</td>
		        <td>${physicalCashUnit.hardwareSensor}</td>
		    </tr>
			<c:set var="alt" value="${!alt}"/>
		</c:forEach>
		</table>
	</c:if>
	</div>
	</div>
</c:forEach>
</div>
</div>
</div>
</div>
</c:if>