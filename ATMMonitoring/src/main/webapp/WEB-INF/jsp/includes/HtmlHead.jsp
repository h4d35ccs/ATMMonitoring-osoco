        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <meta http-equiv="Cache-Control" Content="public,max-age=31536000" />
        <base href="${base}"/>
        <link rel="stylesheet" type="text/css" href="resources/css/ncr_screen.css">
        <link rel="stylesheet" type="text/css" href="resources/css/fullcalendar.css"/>
    	<link rel="stylesheet" type="text/css" href="resources/css/fullcalendar.print.css" media="print"/>
    	<link rel="stylesheet" type="text/css" href="resources/css/ncr_fullcalendar.css"/>
         <script src="resources/js/jquery-1.8.3.min.js"></script>
		<c:if test="${empty error}">
			<script type="text/javascript">
					$(window).load(function() {
						$(".loader").fadeOut("slow");
					}); 
			</script>
		</c:if>
		<c:if test="${!empty error}">
			<script type="text/javascript">
			$(window).load(function() {
				$(".loader").removeClass("loader");
			}); 
			</script>
		</c:if>
	    <script type='text/javascript' src="resources/js/jquery-ui.min.js"></script>
	    <script type='text/javascript' src="resources/js/jquery.ui.touch-punch.min.js"></script>
	    <script type='text/javascript' src='resources/js/jquery.colorbox-min.js'></script>
	    <script type='text/javascript' src='resources/js/jquery.chromatable.js'></script>
	    <script type='text/javascript' src='resources/js/jquery.collapsible.min.js'></script>
	    <script type='text/javascript' src='resources/js/jquery.spin.js'></script>
	    <script type='text/javascript' src='resources/js/jquery.blockUI.js'></script>
	    <script type="text/javascript" src="resources/js/json2html.js"></script>
		<script type="text/javascript" src="resources/js/jquery.json2html.js"></script>
        <script type='text/javascript' src="resources/js/windowLocationHenhancer.js"></script>
        <script type='text/javascript' src="resources/js/menu.js"></script>
        <script type='text/javascript' src='resources/js/jsapi.js'></script> 
        <script type="text/javascript" src="resources/js/fullcalendar.min.js"></script>
    	<script type="text/javascript" src="resources/js/scheduled.js"></script>
    	<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
		<script src="resources/js/markerClusterer.js"></script>
	 	<script type="text/javascript">
	 	 	google.load('visualization', '1', {'packages': ['corechart', 'geochart', 'table']});   
	 	 	var Timeline_urlPrefix = 'resources/timeline/api/';
			var Timeline_ajax_url= 'resources/timeline/ajax/simile-ajax-api.js';
			//variables for headers or dialogs that depends on spring
			var schUpDeleteConfirmation ="<spring:message code="label.scheduledUpdate.confirmDeletion"/>";
			var terminalsUpdate = "<spring:message code="label.terminal.requestSnmpUpdateFrameTitle"/>";
			var terminalsUpdateError = "<spring:message code="label.terminal.error.requestSnmpUpdate"/>";
    	</script>
    	<script type='text/javascript' src="resources/js/application.js"></script>
    	<script type="text/javascript" src="resources/js/purl.js"></script>
        <title><spring:message code="label.baseTitle"/></title>   
        <!--[if lt IE 9]>
        <script type="text/javascript">
            document.createElement("nav");
            document.createElement("header");
            document.createElement("footer");
            document.createElement("section");
            document.createElement("article");
            document.createElement("aside");
            document.createElement("hgroup");
        </script>
        <![endif]-->