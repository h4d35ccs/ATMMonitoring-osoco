<%@tag description="Xfs Component Details" pageEncoding="UTF-8"%>
<%@attribute name="xfsComponent" required="true" type="com.ncr.ATMMonitoring.pojo.XfsComponent"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="box">
<h2><spring:message code="label.xfsComponentDetails"/></h2>

<div class="margin-box">
<table class="form-disabled-generic">
<c:if test="${xfsComponent.logicalName != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.logicalName"/></label></i></td>
    <td><label>${xfsComponent.logicalName}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.xfsClass != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.xfsClass"/></label></i></td>
    <td><label>${xfsComponent.xfsClass}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.acceptMedia != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.acceptMedia"/></label></i></td>
    <td><label>${xfsComponent.acceptMedia}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.algorithms != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.algorithms"/></label></i></td>
    <td><label>
	<c:forEach items="${xfsComponent.algorithmsSplit}" var="split">
    	${split}<br>
    </c:forEach>
    </label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.autofix != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.autofix"/></label></i></td>
    <td><label>${xfsComponent.autofix}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.auxiliaries != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.auxiliaries"/></label></i></td>
    <td><label>${xfsComponent.auxiliaries}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.backImageColorFormat != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.backImageColorFormat"/></label></i></td>
    <td><label>
	<c:forEach items="${xfsComponent.backImageColorFormatSplit}" var="split">
    	${split}<br>
    </c:forEach>
    </label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.cameras != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.cameras"/></label></i></td>
    <td><label>${xfsComponent.cameras}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.camdata != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.camdata"/></label></i></td>
    <td><label>${xfsComponent.camdata}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.canOpenSafeDoor != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.canOpenSafeDoor"/></label></i></td>
    <td><label>${xfsComponent.canOpenSafeDoor}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.cards != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.cards"/></label></i></td>
    <td><label>
	<c:forEach items="${xfsComponent.cardsSplit}" var="split">
    	${split}<br>
    </c:forEach>
    </label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.cashUnits != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.cashUnits"/></label></i></td>
    <td><label>
	<c:forEach items="${xfsComponent.cashUnitsSplit}" var="split">
    	${split}<br>
    </c:forEach>
    </label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.cenVersion != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.cenVersion"/></label></i></td>
    <td><label>${xfsComponent.cenVersion}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.charSupport != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.charSupport"/></label></i></td>
    <td><label>${xfsComponent.charSupport}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.chipio != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.chipio"/></label></i></td>
    <td><label>${xfsComponent.chipio}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.chipPower != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.chipPower"/></label></i></td>
    <td><label>${xfsComponent.chipPower}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.chipProtocol != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.chipProtocol"/></label></i></td>
    <td><label>
	<c:forEach items="${xfsComponent.chipProtocolSplit}" var="split">
    	${split}<br>
    </c:forEach>
    </label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.codeLineFormat != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.codeLineFormat"/></label></i></td>
    <td><label>
	<c:forEach items="${xfsComponent.codeLineFormatSplit}" var="split">
    	${split}<br>
    </c:forEach>
    </label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.compound != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.compound"/></label></i></td>
    <td><label>${xfsComponent.compound}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.comparemagneticstripe != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.comparemagneticstripe"/></label></i></td>
    <td><label>${xfsComponent.comparemagneticstripe}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.control != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.control"/></label></i></td>
    <td><label>${xfsComponent.control}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.cursor != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.cursor"/></label></i></td>
    <td><label>${xfsComponent.cursor}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.deptransport != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.deptransport"/></label></i></td>
    <td><label>${xfsComponent.deptransport}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.derivationAlgorithms != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.derivationAlgorithms"/></label></i></td>
    <td><label>
	<c:forEach items="${xfsComponent.derivationAlgorithmsSplit}" var="split">
    	${split}<br>
    </c:forEach>
    </label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.dispensePaper != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.dispensePaper"/></label></i></td>
    <td><label>${xfsComponent.dispensePaper}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.display != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.display"/></label></i></td>
    <td><label>
	<c:forEach items="${xfsComponent.displaySplit}" var="split">
    	${split}<br>
    </c:forEach>
    </label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.displayLight != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.displayLight"/></label></i></td>
    <td><label>${xfsComponent.displayLight}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.doors != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.doors"/></label></i></td>
    <td><label>${xfsComponent.doors}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.encoder != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.encoder"/></label></i></td>
    <td><label>${xfsComponent.encoder}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.encodenames != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.encodenames"/></label></i></td>
    <td><label>${xfsComponent.encodenames}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.endorser != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.endorser"/></label></i></td>
    <td><label>${xfsComponent.endorser}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.envelopesupply != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.envelopesupply"/></label></i></td>
    <td><label>${xfsComponent.envelopesupply}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.exchangeTypes != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.exchangeTypes"/></label></i></td>
    <td><label>
	<c:forEach items="${xfsComponent.exchangeTypesSplit}" var="split">
    	${split}<br>
    </c:forEach>
    </label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.extents != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.extents"/></label></i></td>
    <td><label>
	<c:forEach items="${xfsComponent.extentsSplit}" var="split">
    	${split}<br>
    </c:forEach>
    </label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.extra != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.extra"/></label></i></td>
    <td><label>
	<c:forEach items="${xfsComponent.extraSplit}" var="split">
    	${split}<br>
    </c:forEach>
    </label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.flux != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.flux"/></label></i></td>
    <td><label>${xfsComponent.flux}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.fontnames != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.fontnames"/></label></i></td>
    <td><label>${xfsComponent.fontnames}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.forms != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.forms"/></label></i></td>
    <td><label>${xfsComponent.forms}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.frontImageColorFormat != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.frontImageColorFormat"/></label></i></td>
    <td><label>
	<c:forEach items="${xfsComponent.frontImageColorFormatSplit}" var="split">
    	${split}<br>
    </c:forEach>
    </label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.guidlights != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.guidlights"/></label></i></td>
    <td><label>${xfsComponent.guidlights}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.hasCashBox != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.hasCashBox"/></label></i></td>
    <td><label>${xfsComponent.hasCashBox}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.hasInsertedSensor != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.hasInsertedSensor"/></label></i></td>
    <td><label>${xfsComponent.hasInsertedSensor}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.hasShutter != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.hasShutter"/></label></i></td>
    <td><label>${xfsComponent.hasShutter}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.hasTakenSensor != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.hasTakenSensor"/></label></i></td>
    <td><label>${xfsComponent.hasTakenSensor}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.idConnect != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.idConnect"/></label></i></td>
    <td><label>${xfsComponent.idConnect}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.imagecapture != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.imagecapture"/></label></i></td>
    <td><label>${xfsComponent.imagecapture}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.idKey != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.idKey"/></label></i></td>
    <td><label>${xfsComponent.idKey}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.imageSource != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.imageSource"/></label></i></td>
    <td><label>
	<c:forEach items="${xfsComponent.imageSourceSplit}" var="split">
    	${split}<br>
    </c:forEach>
    </label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.imageType != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.imageType"/></label></i></td>
    <td><label>
	<c:forEach items="${xfsComponent.imageTypeSplit}" var="split">
    	${split}<br>
    </c:forEach>
    </label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.indicators != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.indicators"/></label></i></td>
    <td><label>${xfsComponent.indicators}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.intermediateStacker != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.intermediateStacker"/></label></i></td>
    <td><label>${xfsComponent.intermediateStacker}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.keyCheckModes != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.keyCheckModes"/></label></i></td>
    <td><label>
	<c:forEach items="${xfsComponent.keyCheckModesSplit}" var="split">
    	${split}<br>
    </c:forEach>
    </label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.keyLock != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.keyLock"/></label></i></td>
    <td><label>${xfsComponent.keyLock}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.keyNum != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.keyNum"/></label></i></td>
    <td><label>${xfsComponent.keyNum}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.magneticstriperead != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.magneticstriperead"/></label></i></td>
    <td><label>${xfsComponent.magneticstriperead}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.magneticstripewrite != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.magneticstripewrite"/></label></i></td>
    <td><label>${xfsComponent.magneticstripewrite}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.maxCashInItems != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.maxCashInItems"/></label></i></td>
    <td><label>${xfsComponent.maxCashInItems}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.maxdatalength != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.maxdatalength"/></label></i></td>
    <td><label>${xfsComponent.maxdatalength}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.maxDispenseItems != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.maxDispenseItems"/></label></i></td>
    <td><label>${xfsComponent.maxDispenseItems}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.maxMediaOnStacker != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.maxMediaOnStacker"/></label></i></td>
    <td><label>${xfsComponent.maxMediaOnStacker}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.maxnumchars != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.maxnumchars"/></label></i></td>
    <td><label>${xfsComponent.maxnumchars}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.maxpictures != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.maxpictures"/></label></i></td>
    <td><label>${xfsComponent.maxpictures}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.maxRetract != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.maxRetract"/></label></i></td>
    <td><label>${xfsComponent.maxRetract}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.mediaTaken != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.mediaTaken"/></label></i></td>
    <td><label>${xfsComponent.mediaTaken}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.micr != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.micr"/></label></i></td>
    <td><label>${xfsComponent.micr}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.moveItems != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.moveItems"/></label></i></td>
    <td><label>${xfsComponent.moveItems}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.multiPage != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.multipage"/></label></i></td>
    <td><label>${xfsComponent.multiPage}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.numLeds != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.numLeds"/></label></i></td>
    <td><label>${xfsComponent.numLeds}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.ocr != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.ocr"/></label></i></td>
    <td><label>${xfsComponent.ocr}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.paperSources != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.paperSources"/></label></i></td>
    <td><label>
	<c:forEach items="${xfsComponent.paperSourcesSplit}" var="split">
    	${split}<br>
    </c:forEach>
    </label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.pinFormats != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.pinFormats"/></label></i></td>
    <td><label>
	<c:forEach items="${xfsComponent.pinFormatsSplit}" var="split">
    	${split}<br>
    </c:forEach>
    </label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.powerOff != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.powerOff"/></label></i></td>
    <td><label>${xfsComponent.powerOff}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.powerOn != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.powerOn"/></label></i></td>
    <td><label>${xfsComponent.powerOn}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.presentationAlgorithms != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.presentationAlgorithms"/></label></i></td>
    <td><label>
	<c:forEach items="${xfsComponent.presentationAlgorithmsSplit}" var="split">
    	${split}<br>
    </c:forEach>
    </label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.printer != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.printer"/></label></i></td>
    <td><label>${xfsComponent.printer}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.printonretracts != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.printonretracts"/></label></i></td>
    <td><label>${xfsComponent.printonretracts}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.programaticallydeactivate != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.programaticallydeactivate"/></label></i></td>
    <td><label>${xfsComponent.programaticallydeactivate}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.readForm != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.readForm"/></label></i></td>
    <td><label>${xfsComponent.readForm}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.readTracks != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.readTracks"/></label></i></td>
    <td><label>
	<c:forEach items="${xfsComponent.readTracksSplit}" var="split">
    	${split}<br>
    </c:forEach>
    </label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.readWriteAfterEject != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.readWriteAfterEject"/></label></i></td>
    <td><label>${xfsComponent.readWriteAfterEject}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.refill != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.refill"/></label></i></td>
    <td><label>${xfsComponent.refill}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.resolution != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.resolution"/></label></i></td>
    <td><label>${xfsComponent.resolution}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.resolutions != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.resolutions"/></label></i></td>
    <td><label>${xfsComponent.resolutions}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.retractAreas != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.retractAreas"/></label></i></td>
    <td><label>
	<c:forEach items="${xfsComponent.retractAreasSplit}" var="split">
    	${split}<br>
    </c:forEach>
    </label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.retractBins != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.retractBins"/></label></i></td>
    <td><label>
	<c:forEach items="${xfsComponent.retractBinsSplit}" var="split">
    	${split}<br>
    </c:forEach>
    </label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.retractenvelope != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.retractenvelope"/></label></i></td>
    <td><label>${xfsComponent.retractenvelope}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.retractStackerActions != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.retractStackerActions"/></label></i></td>
    <td><label>
	<c:forEach items="${xfsComponent.retractStackerActionsSplit}" var="split">
    	${split}<br>
    </c:forEach>
    </label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.retractTransportActions != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.retractTransportActions"/></label></i></td>
    <td><label>
	<c:forEach items="${xfsComponent.retractTransportActionsSplit}" var="split">
    	${split}<br>
    </c:forEach>
    </label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.securityType != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.securityType"/></label></i></td>
    <td><label>${xfsComponent.securityType}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.sensors != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.sensors"/></label></i></td>
    <td><label>${xfsComponent.sensors}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.serviceProvider != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.serviceProvider"/></label></i></td>
    <td><label>${xfsComponent.serviceProvider}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.shutterControl != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.shutterControl"/></label></i></td>
    <td><label>${xfsComponent.shutterControl}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.stamp != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.stamp"/></label></i></td>
    <td><label>${xfsComponent.stamp}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.supportedPositions != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.supportedPositions"/></label></i></td>
    <td><label>
	<c:forEach items="${xfsComponent.supportedPositionsSplit}" var="split">
    	${split}<br>
    </c:forEach>
    </label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.toner != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.toner"/></label></i></td>
    <td><label>${xfsComponent.toner}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.type != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.type"/></label></i></td>
    <td><label>
	<c:forEach items="${xfsComponent.typeSplit}" var="split">
    	${split}<br>
    </c:forEach>
    </label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.validationAlgorithms != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.validationAlgorithms"/></label></i></td>
    <td><label>
	<c:forEach items="${xfsComponent.validationAlgorithmsSplit}" var="split">
    	${split}<br>
    </c:forEach>
    </label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.vendor != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.vendor"/></label></i></td>
    <td><label>${xfsComponent.vendor}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.writeForm != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.writeForm"/></label></i></td>
    <td><label>${xfsComponent.writeForm}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.writeMode != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.writeMode"/></label></i></td>
    <td><label>${xfsComponent.writeMode}</label></td>
</tr>
</c:if>
<c:if test="${xfsComponent.writeTracks != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.xfsComponent.writeTracks"/></label></i></td>
    <td><label>
	<c:forEach items="${xfsComponent.writeTracksSplit}" var="split">
    	${split}<br>
    </c:forEach>
    </label></td>
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
			<th style="width: 50px;"><i><spring:message code="label.logicalCashUnits.type"/></i></th>
			<th style="width: 35px;"><i><spring:message code="label.logicalCashUnits.unitId"/></i></th>
			<th style="width: 55px;"><i><spring:message code="label.logicalCashUnits.currencyId"/></i></th>
			<th style="width: 35px;"><i><spring:message code="label.logicalCashUnits.values"/></i></th>
			<th style="width: 40px;"><i><spring:message code="label.logicalCashUnits.minimum"/></i></th>
			<th style="width: 45px;"><i><spring:message code="label.logicalCashUnits.maximum"/></i></th>
		</tr>
		<tr>
	        <td style="width: 50px;"><label>${logicalCashUnit.type}</label></td>
	        <td style="width: 35px;"><label>${logicalCashUnit.unitId}</label></td>
	        <td style="width: 55px;"><label>${logicalCashUnit.currencyId}</label></td>
	        <td style="width: 35px;"><label>
				<c:forEach items="${logicalCashUnit.valuesSplit}" var="split">
			    	${split}<br>
			    </c:forEach>
	    	</label></td>
	        <td style="width: 40px;"><label>${logicalCashUnit.minimum}</label></td>
	        <td style="width: 45px;"><label>${logicalCashUnit.maximum}</label></td>
		</tr>
	</table>
	<c:if test="${!empty logicalCashUnit.physicalCashUnits}">
		<h5><spring:message code="label.physicalCashUnits"/></h5>
		<table class="data subform">
		<tr>
		    <th><i><spring:message code="label.physicalCashUnit.name"/></i></th>
		    <th><i><spring:message code="label.physicalCashUnit.unitId"/></i></th>
		    <th><i><spring:message code="label.physicalCashUnit.maximum"/></i></th>
		    <th><i><spring:message code="label.physicalCashUnit.hardwareSensor"/></i></th>
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
</c:if>