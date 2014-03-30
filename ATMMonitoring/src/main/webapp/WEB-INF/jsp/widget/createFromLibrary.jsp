<%@include file="../includes/JspImports.jsp"%>
<%@taglib tagdir="/WEB-INF/tags/widget/" prefix="widget" %>
<div id="helpLayout">
	<div class="contentFrame">
 		<span class="goHelp">
 			<a id="goHelp" class="info inline cboxElement" href="#"><sping:message code="label.help.go"/> </a>
 		</span>
		<widget:libraryCategories 
			formAction="dashboard/addFromLibrary" 
			messageKey="create.from" 
			selectCategory="${false}"/>
	</div>
	<div class="contentFrame">
    	<a id="returnFromHelp" href="#"> << <sping:message code="label.help.return"/>  </a>
    	<div id="help">
    		<h2> <spring:message code="library.widget.help.title" /></h2>
    		<p>
    			<spring:message code="library.widget.help.p1" />
			</p>
			
			<p>
				<spring:message code="library.widget.help.p2" />
			</p>
		</div>
    </div>
</div>

   	      
      	  
      
      	  
    