<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>


<t:osoco-wrapper titleCode="label.terminalsManager" userMsg="${userMsg}" section="dashboard">

  <jsp:attribute name="header">
    <script type='text/javascript' src='https://www.google.com/jsapi'></script>
    <script type="text/javascript" src="resources/js/json2html.js"></script>
    <script type="text/javascript" src="resources/js/jquery.json2html.js"></script>
    <script type='text/javascript' src='resources/js/dashboard.js'></script>
  </jsp:attribute>

  <jsp:body>
          <div id="header_g">
            <div id="components">
              <div id="my_components" class="desplegable">
                <div class="txt content_hide">
                  <span>Mis componentes</span>
                </div>
                <ul id="myCharts" class="collapsible"></ul>
              </div>
              <a class="iframe cboxElement btn add" href="dashboard/newWidget">
                Nuevo componente
              </a>

            </div>
            <div id="columns" class="columns_botonera">
              <nav>
                <ul>
                  <c:forEach items="${columnOptions}" var="option">
                    <li class="column${option.getColumns()} ${((option.getColumns() == dashboard.getColumns()) ? 'current' : '')}" data-columns="${option.getColumns()}">
                      <a href="#">
                        <span>${option.getColumns()} columnas</span>
                      </a>
                    </li>
                  </c:forEach>
                </ul>
              </nav>
            </div>
          </div>
          <ul id="sortable" class="ui-sortable column${dashboard.getColumns()}"></ul>
          <div id="noCharts" class="message left hide">
            <p>Desde esta pantalla de inicio, podrás crear y administrar tus componentes, para que te resulte más útil a la hora de gestionar tus terminales, recoger datos, etc.</p>
          </div>
  </jsp:body>

</t:osoco-wrapper>
