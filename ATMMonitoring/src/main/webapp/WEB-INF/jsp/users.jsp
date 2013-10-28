<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<t:wrapper titleCode="label.usersManager" userMsg="${userMsg}">

<h1><spring:message code="label.usersManager"/></h1>
<div class="margin-box">
<div class="box">
	<h2><spring:message code="label.users"/></h2>
	<div class="box-tableContainer">
		<c:if  test="${empty usersList}">
		<div class="empty-list"><spring:message code="label.user.noUsers"/></div>
		</c:if>
		<c:if  test="${!empty usersList}">
		<c:choose>
		<c:when  test="${usersList.size() > 10}">
		
		<style type="text/css">
		/* define height and width of scrollable area. Add 16px to width for scrollbar          */
		div.tableContainer {
			height: 361px;
			width: 539px;
		}
		
		/* define width of table. IE browsers only                 */
		div.tableContainer table {
			width: 539px
		}
		
		html>body tbody.scrollContent {
			height: 330px;
		}
		</style>
		<div id="tableContainer" class="tableContainer">
		<table class="data">
		<thead class="fixedHeader">
		</c:when>
		<c:otherwise>
		<table class="data">
		</c:otherwise>
		</c:choose>
		<tr>
		    <th width="200px"><i><spring:message code="label.user.name"/></i></th>
		    <th width="100px"><i><spring:message code="label.user.username"/></i></th>
		    <th width="90px"><i><spring:message code="label.user.role"/></i></th>
			<c:choose>
			<c:when  test="${usersList.size() > 10}">
			<th width="85px">
			</c:when>
			<c:otherwise>
			<th width="70px">
			</c:otherwise>
			</c:choose>
			&nbsp;</th>
		</tr>
		<c:if  test="${usersList.size() > 10}">
		</thead>
		<tbody class="scrollContent">
		</c:if>
		<c:set var="alt" value="${false}"/>
		<c:forEach items="${usersList}" var="user">
		    <tr <c:if test="${alt}">class="alt"</c:if>>
			    <td width="200px"><a href="users/details/${user.id}">${user.lastname}, ${user.firstname}</a></td>
		        <td width="100px">${user.username}</td>
		        <td width="90px">${user.role.name}</td>
				<td width="70px" class="center-cell">
			        <c:choose>
			        <c:when test="${user.role.manageable == true}">
						<button onClick="deleteUser(${user.id})" class="form-submit"><spring:message code="label.user.deleteUser"/></button>
					</c:when>
					<c:otherwise>
						<button onClick="deleteUser(${user.id})" class="form-submit" disabled="disabled"><spring:message code="label.user.deleteUser"/></button>
					</c:otherwise>
					</c:choose>
				</td>	
		    </tr>
			<c:set var="alt" value="${!alt}"/>
		</c:forEach>
		<c:choose>
		<c:when  test="${usersList.size() > 10}">
		</tbody>
		</table>
		</div>
		</c:when>
		<c:otherwise>
		</table>
		</c:otherwise>
		</c:choose>
		</c:if>
	</div>
</div>
</div>
<div class="margin-box">
<div class="box">
	<h2><spring:message code="label.newUser"/></h2>
	 
	<form:form method="post" action="users/list" commandName="user">
	
	    <table class="form">
	    <tr>
	        <td class="header first-header"><form:label path="firstname"><i><spring:message code="label.user.firstName"/></i></form:label></td>
	        <td><form:input path="firstname" class='form-tf-grey' maxlength="30"/></td>
	    </tr>
	    <tr>
	        <td class="header"><form:label path="lastname"><i><spring:message code="label.user.lastName"/></i></form:label></td>
	        <td><form:input path="lastname" class='form-tf-grey' maxlength="60"/></td>
	    </tr>
	    <tr>
	        <td class="header"><form:label path="username"><i><spring:message code="label.user.username"/> *</i></form:label></td>
	        <td><form:input path="username" class='form-tf-grey' maxlength="20"/></td>
	        <td class="error-td"><form:errors path="username"/>
	        <c:if test="${duplicatedUsername == true}">
	        <spring:message code="label.user.duplicatedUsername"/>
	        </c:if></td>
	    </tr>
	    <tr>
	        <td class="header"><form:label path="password"><i><spring:message code="label.user.password"/> *</i></form:label></td>
	        <td><form:password id="password1" class='form-tf-grey' path="password" maxlength="20" autocomplete="off" onkeyup="checkPasswordRetype()"/></td>
	        <td class="error-td"><form:errors path="password"/></td>
	    </tr>
	    <tr>
	        <td class="header"><i><spring:message code="label.user.retypePassword"/></i></td>
	        <td><input id="password2" type="password" class='form-tf-grey' maxlength="20" onkeyup="checkPasswordRetype()"/></td>
	        <td id="retype-password-error" class="error-td" style="display: none;"><spring:message code="label.user.retypePasswordError"/></td>
	    </tr>
	    <tr>
	    	<td class="header last-header"><form:label path="role"><i><spring:message code="label.user.role"/> *</i></form:label></td>
	    	<td>
	    		<form:select path="role.id" style="width: 100%;">
					<form:options items="${manageableRolesList}" itemValue="id" itemLabel="name" />
				</form:select>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<font size="2"><i><spring:message code="label.requiredFields"/></i></font>
				<input type="submit" id="form-submit" class="form-submit" value="<spring:message code="label.user.addUser"/>" style="float: right;"/>
			</td>
		</tr>
	</table> 
	
	</form:form>
</div>

<!-- DEBUG CODE FOR SHOWING THE ROLES
	<h2><spring:message code="label.roles"/></h2>
	<c:if  test="${empty rolesList}">
	<div class="empty-list"><spring:message code="label.role.noRoles"/></div>
	</c:if>
	<c:if  test="${!empty rolesList}">
	<table class="data">
	<tr>
	    <th><i><spring:message code="label.id"/></i></th>
	    <th><i><spring:message code="label.role.name"/></i></th>
	    <th><i><spring:message code="label.role.manageable"/></i></th>
	</tr>
	<c:forEach items="${rolesList}" var="role">
	    <tr>
	        <td>${role.id}</td>
	        <td>${role.name}</td>
	        <td>${role.manageable}</td>
	    </tr>
	</c:forEach>
	</table>
	</c:if>
-->
<script type="text/javascript">
	$(document).ready(function(){
		$('#form-submit').addClass('ui-state-disabled');
		$('#form-submit').addClass('ui-button-disabled');
	});
	function deleteUser(id) {
		var confirm = window.confirm('<spring:message code="label.user.confirmDeletion"/>');
		if (confirm == true) {
			self.location = 'users/delete/' + id;
		};
	};
	function checkPasswordRetype() {
		if (($("#password1").val() == $("#password2").val())
				&& ($("#password1").val() != '')) {
			$('#form-submit').prop('disabled', false);
			$('#form-submit').removeClass('ui-state-disabled');
			$('#form-submit').removeClass('ui-button-disabled');
			$('#retype-password-error').css('display', 'none');
		} else {
			$('#form-submit').prop('disabled', true);
			$('#form-submit').addClass('ui-state-disabled');
			$('#form-submit').addClass('ui-button-disabled');
			$('#retype-password-error').css('display', '');
		}
	};
</script>
</div>

</t:wrapper>