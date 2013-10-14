<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<t:wrapper titleCode="label.usersManager" userMsg="${userMsg}">
 
<div class="box">
<h2><spring:message code="label.userDetails"/></h2>

<div class="margin-box">
<form:form method="post" action="users/update.html" commandName="user">
	<form:hidden path="id"/>
	<form:hidden path="password"/>

	<c:choose>
	<c:when test="${user.role.manageable || sameUser}">
    <table class="form">
    <tr>
        <td class="header first-header"><form:label path="firstname"><i><spring:message code="label.user.firstName"/></i></form:label></td>
        <td><form:input class='form-tf-grey' path="firstname" maxlength="30"/></td>
    </tr>
    <tr>
        <td class="header"><form:label path="lastname"><i><spring:message code="label.user.lastName"/></i></form:label></td>
        <td><form:input class='form-tf-grey' path="lastname" maxlength="60"/></td>
    </tr>
    <tr>
        <td class="header"><form:label path="username"><i><spring:message code="label.user.username"/> *</i></form:label></td>
        <td><form:input class='form-tf-grey' path="username" maxlength="20"/></td>
        <td class="error-td"><form:errors path="username"/>
        <c:if test="${duplicatedUsername == true}">
        <spring:message code="label.user.duplicatedUsername"/>
        </c:if></td>
    </tr>
	<c:choose>
	<c:when test="${!user.role.manageable}">
    <tr>
    	<td class="header last-header"><form:label path="role"><i><spring:message code="label.user.role"/> *</i></form:label></td>
    	<td>
    		<form:select path="role.id">
				<form:option value="${user.role.id}" label="${user.role.name}" />
			</form:select>
		</td>
	</tr>
	</c:when>
	<c:otherwise>
    <tr>
    	<td class="header last-header"><form:label path="role"><i><spring:message code="label.user.role"/> *</i></form:label></td>
    	<td>
    		<form:select path="role.id" style="width: 100%;">
				<form:options items="${manageableRolesList}" itemValue="id" itemLabel="name" />
			</form:select>
		</td>
	</tr>
	</c:otherwise>
	</c:choose>
    <tr>
		<td colspan="2">
		<font size="2"><i><spring:message code="label.requiredFields"/></i></font>
		<input type="submit" class="form-submit" value="<spring:message code="label.user.updateUser"/>" style="float: right;"/>
		</td>
    </tr>
	</table>
    </c:when>
	<c:otherwise>
    <table class="form">
    <tr>
        <td class="header first-header"><form:label path="firstname"><i><spring:message code="label.user.firstName"/></i></form:label></td>
        <td><form:input class='form-tf-grey' path="firstname" maxlength="30" readonly="true"/></td>
    </tr>
    <tr>
        <td class="header"><form:label path="lastname"><i><spring:message code="label.user.lastName"/></i></form:label></td>
        <td><form:input class='form-tf-grey' path="lastname" maxlength="60" readonly="true"/></td>
    </tr>
    <tr>
        <td class="header"><form:label path="username"><i><spring:message code="label.user.username"/></i></form:label></td>
        <td><form:input class='form-tf-grey' path="username" maxlength="20" readonly="true"/></td>
    </tr>
    <tr>
    	<td class="header last-header"><form:label path="role"><i><spring:message code="label.user.role"/></i></form:label></td>
    	<td>
    		<form:select path="role.id" disabled="true" style="width: 100%;">
				<form:option value="${user.role.id}" label="${user.role.name}" />
			</form:select>
		</td>
	</tr>
    <tr>
		<td colspan="2">
		<font size="2"><i><spring:message code="label.requiredFields"/></i></font>
		<input type="submit" class="form-submit" disabled="disabled" value="<spring:message code="label.user.updateUser"/>" style="float: right;"/>
		</td>
    </tr>
	</table>
	</c:otherwise>
	</c:choose>
</form:form>
</div>
 
<div class="margin-box">
<form:form method="post" action="users/updatepw.html" commandName="user">
	<form:hidden path="id"/>
	<form:hidden path="firstname"/>
	<form:hidden path="lastname"/>
	<form:hidden path="username"/>
	<form:hidden path="role.id"/>
	
	<c:choose>
	<c:when test="${user.role.manageable || sameUser}">
	    <table class="form">
	    <tr>
	        <td class="header first-header"><form:label path="password"><i><spring:message code="label.user.password"/></i></form:label></td>
	        <td><form:password id="password1" class='form-tf-grey' path="password" maxlength="20" autocomplete="off" onkeyup="checkPasswordRetype()"/></td><td><font color="red"><form:errors path="password"/></font></td>
	    </tr>
	    <tr>
	        <td class="header last-header"><i><spring:message code="label.user.retypePassword"/></i></td>
	        <td><input class='form-tf-grey' id="password2" type="password" maxlength="20" onkeyup="checkPasswordRetype()"/></td>
	        <td id="retype-password-error" class="error-td" style="display: none;"><spring:message code="label.user.retypePasswordError"/></td>
	    </tr>
	    <tr>
			<td colspan="2">
				<input id="form-submit" type="submit" class="form-submit" value="<spring:message code="label.user.updatePassword"/>" style="float: right;"/>
			</td>
	    </tr>
		</table>
	</c:when>
	<c:otherwise>
	    <table class="form">
	    <tr>
	        <td class="header first-header"><form:label path="password"><i><spring:message code="label.user.password"/></i></form:label></td>
	        <td><form:password path="password" class='form-tf-grey' maxlength="20" autocomplete="off" disabled="true"/></td>
	    </tr>
	    <tr>
	        <td class="header last-header"><i><spring:message code="label.user.retypePassword"/></i></td>
	        <td><input class='form-tf-grey' id="password2" disabled="disabled" "password" maxlength="20" onkeyup="checkPasswordRetype()"/></td>
	        <td id="retype-password-error" class="error-td" style="display: none;"><spring:message code="label.user.retypePasswordError"/></td>
	    </tr>
	    <tr>
			<td colspan="2">
				<input type="submit" class="form-submit" disabled="disabled" value="<spring:message code="label.user.updatePassword"/>" style="float: right;"/>
			</td>
	    </tr>
		</table>
	</c:otherwise>
	</c:choose>
</form:form>
</div>

<div class="margin-box">
<form action="users/delete/${user.id}" method="GET">
	<div>
	<c:choose>
	<c:when test="${user.role.manageable}">
		<input type="submit" class="form-submit" value="<spring:message code="label.user.deleteUser"/>">
	</c:when>
	<c:otherwise>
		<input type="submit" class="form-submit" disabled="disabled" value="<spring:message code="label.user.deleteUser"/>">
	</c:otherwise>
	</c:choose>
	</div>
</form>
</div>
</div>
<script type="text/javascript">
	$(document).ready(function(){
		$('#form-submit').addClass('ui-state-disabled');
		$('#form-submit').addClass('ui-button-disabled');
	});
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

</t:wrapper>