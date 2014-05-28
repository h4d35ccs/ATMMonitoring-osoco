<%@include file="includes/JspImports.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="includes/HtmlHead.jsp" %>
<body>
      <div id="mainContent"> 
	        <div id="main_header">
		       <h1> 
		       		<img src="resources/images/general/logo.png"/>
			        <div id="headName">
			        	<span>
			        		<acronym title="Hardware and Software Asset Management">HSAM</acronym>
			        	</span>
			         </div>
		        </h1>
	        </div>
	        <div id="main" class="btn_close">
		        <div id="primary">
			        <div class="content">
			        	<h1>NODE INFORMATION</h1>
			        	<div class="action_box data desplegable">
							<h2 class="txt last"> Details </h2>
						<div class="collapsible last" style="display: block;">
			        	 <div class="ul_data">
			        	 	<ul>
			        	 		<li>Node Position:<b> ${nodePosition} </b></li>
			        	 		<li>Local Broker URL and Port:<b> ${localUrl}</b></li>
			        	 		<li>Parent Broker URL and Port:<b> ${parentUrl}</b></li>
			        	 		<li>Router table:<b> ${routerTable}</b></li>
			           	 	</ul>
			        	 </div>
			        </div>
			        </div>
		        </div>
		     </div>
	      </div>
</body>
</html>