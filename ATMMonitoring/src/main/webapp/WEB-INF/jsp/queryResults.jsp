<%@include file="includes/JspImports.jsp"%>
	<div id="queryResultTable" class="box-tableContainer">
		<div id="content">
		<c:if  test="${empty pagedListHolder.pageList}">
		<div class="message">
		     <spring:message code="label.query.noResults"/>
                </div>
		</c:if>
		<c:if  test="${!empty pagedListHolder.pageList}">
		<h2>${pagedListHolder.source.size()} <spring:message code="label.results"/></h2>
		<div id="pagTable">
			<div id="tabs">
				<div class="content_tab">
 						<terminal:terminalsTable baseUrl="queries/results" terminals="${pagedListHolder.pageList}" query="${query}"/>
					    <script type="text/javascript">
					      $(function() {
					          $("#exportTerminals").click(function(event) {
					              $("#exportForm").submit();
					              event.preventDefault();
					          });
					      });
					    </script>  
						</div>
				</div>
			</div>
            <form:form id="exportForm" method="post" action="queries/results/export" commandName="query" target="_blank">
              <input type="hidden" name="sort" value="${sort}"/>
              <input type="hidden" name="order" value="${order}"/>
				<c:forEach var="i" begin="1" end="5">
					<form:hidden path="terminalCombo${i}1"/>
					<form:hidden path="terminalCB${i}"/>
					<form:hidden path="terminalCombo${i}2"/>
					<form:hidden path="terminalField${i}"/>
					<form:hidden path="hardwareDeviceCombo${i}1"/>
					<form:hidden path="hardwareDeviceCB${i}"/>
					<form:hidden path="hardwareDeviceCombo${i}2"/>
					<form:hidden path="hardwareDeviceCombo${i}3"/>
					<form:hidden path="hardwareDeviceField${i}"/>
					<form:hidden path="financialDeviceCombo${i}1"/>
					<form:hidden path="financialDeviceCB${i}"/>
					<form:hidden path="financialDeviceCombo${i}2"/>
					<form:hidden path="financialDeviceField${i}"/>
					<form:hidden path="operatingSystemCombo${i}1"/>
					<form:hidden path="operatingSystemCB${i}"/>
					<form:hidden path="operatingSystemCombo${i}2"/>
					<form:hidden path="operatingSystemField${i}"/>
					<form:hidden path="hotfixCombo${i}1"/>
					<form:hidden path="hotfixCB${i}"/>
					<form:hidden path="hotfixCombo${i}2"/>
					<form:hidden path="hotfixField${i}"/>
					<form:hidden path="softwareCombo${i}1"/>
					<form:hidden path="softwareCB${i}"/>
					<form:hidden path="softwareCombo${i}2"/>
					<form:hidden path="softwareField${i}"/>
					<form:hidden path="featSwCombo${i}1"/>
					<form:hidden path="featSwCB${i}"/>
					<form:hidden path="featSwCombo${i}2"/>
					<form:hidden path="featSwField${i}"/>
					<form:hidden path="xfsSwCombo${i}1"/>
					<form:hidden path="xfsSwCB${i}"/>
					<form:hidden path="xfsSwCombo${i}2"/>
					<form:hidden path="xfsSwField${i}"/>
				</c:forEach>
				<c:forEach var="i" begin="1" end="2">
					<form:hidden path="internetExplorerCombo${i}1"/>
					<form:hidden path="internetExplorerCB${i}"/>
					<form:hidden path="internetExplorerCombo${i}2"/>
					<form:hidden path="internetExplorerField${i}"/>
				</c:forEach>
            </form:form>
		</c:if>
		</div>
	</div>