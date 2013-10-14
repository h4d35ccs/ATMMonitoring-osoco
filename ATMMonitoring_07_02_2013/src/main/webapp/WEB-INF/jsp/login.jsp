<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<t:wrapperWoMenu titleCode="label.login">
	
	<div style="text-align:left">
	    <table style="height:500px;margin:20px 0px 20px;">
	        <tr>
	            <td style="border-right:2.5px solid #A4A4A4;">
	                <div class="home-box" style="text-align: right; margin-right: 10px;">
	                    <img src="resources/images/NCRInv.png" />
	                    <div style="margin-right: 70px; margin-top: -32px; font-size: 0.8em;">
	                        <img src="resources/images/NCR.bmp" style="vertical-align: middle; margin-right: 5px;"
	                        /><spring:message code="label.poweredBy"/></div>
	                </div>
	            </td>
	            <td>
	                <div class="home-box" style="margin-left: 40px;">
						<c:if test="${error == true}">
							<div class="error-td">
								${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
							</div>
						</c:if>
	                    <form name='f' action="<c:url value='j_spring_security_check' />" method='POST'>
	                        <table class="form" style="width: 230px;">
	                            <tr>
	                                <td style="text-align: left; padding-top: 7px;"><spring:message code="label.username"/></td>
	                                <td/>
	                            </tr>
	                            <tr>
	                                <td colspan=2>
	                                    <input type='text' name='j_username' class='form-tf-green'/>
	                                </td>
	                            </tr>
	                            <tr>
	                                <td style="text-align: left;padding-top: 7px;"><spring:message code="label.password"/></td>
	                            </tr>
	                            <tr>
	                                <td colspan=2>
	                                    <input type='password' name='j_password' class='form-tf-green'/>
	                                </td>
	                            </tr>
	                            <tr style="margin-top:20px;">
	                                <td class="button-td" style="padding-top: 7px;">
	                                    <input name="submit" type="submit" class="form-submit" value="Login" style="width: 80px;"/>
	                                </td>
	                                <td class="button-td" style="padding-top: 7px; text-align: right;">
	                                    <input name="reset" type="reset" class="form-submit" value="Reset" style="width: 80px;"/>
	                                </td>
	                            </tr>
	                        </table>
	                    </form>
	                </div>
	            </td>
	        </tr>
	    </table>
	</div>
</t:wrapperWoMenu>