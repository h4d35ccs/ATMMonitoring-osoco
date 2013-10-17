<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<t:osoco-wrapperWoMenu titleCode="label.login">

    <style type="text/css" media="screen">
      #scene {
        perspective: 800px;
        -webkit-perspective: 800px;
      }
      #login_box {
        transition: transform 1s;
        -webkit-transition: -webkit-transform 1s;
        backface-visibility: hidden;
        -webkit-backface-visibility: hidden;
        transform-origin: right center;
        -webkit-transform-origin: right center;
        transform-style: preserve3d;
        -webkit-transform-style: preserve3d;
        transform: translateX(30%) translateZ(-250px) rotateY(90deg);
        -webkit-transform: translateX(30%) translateZ(-250px) rotateY(90deg);
      }
      #login_box.flipped {
        transform: translateX(0) translateZ(0) rotateY(0deg);
        -webkit-transform: translateX(0) translateZ(0) rotateY(0deg);
      }
    </style>

    <div id="scene">
      <div id="login_box" >
        <h1><img src="resources/images/general/logo.png"/><span>NCR</span> <strong>HASM</strong></h1>

        <c:if test="${error == true}">
        <div class="error bottom">
            ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
        </div>
        </c:if>

	    <form name='f' action="<c:url value='j_spring_security_check' />" method='POST'>
            <div class="row">
                <label for="username"><spring:message code="label.username"/>: </label>
                <input id="username" type="text" name="j_username"/>
            </div>
            <div class="row">
                <label for="password"><spring:message code="label.password"/>: </label>
                <input type="password" type="password" name="j_password"/>
            </div>
            <div class="botonera">
                <input name="submit" type="submit" class="btn" value="acceder"/>
                <input name="reset" type="reset" value="cancelar" class="btn cancel"/>
            </div>
        </form>
      </div>
    </div>

    <script type="text/javascript">
      $(document).ready(function() {
        window.setTimeout(function(){
          $("#login_box").addClass("flipped");
        }, 1000);
      });
    </script>

</t:osoco-wrapperWoMenu>
