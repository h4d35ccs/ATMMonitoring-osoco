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
    <div id="main">
        <div id="primary">
            <article>
                <div id="header_g">
                    <div id="components">
                        <div id="my_components" class="desplegable">
                            <div class="txt content_hide">
                                <span>Mis componentes</span>
                            </div>
                            <ul id="myCharts" class="collapsible"></ul>
                        </div>
                        <div id="add_components">
                            <a class="iframe cboxElement" href="index_componentes.html">
                                <span>Nuevo componente</span>
                            </a>
                        </div>
                    </div>
                    <div id="columns">
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
                <div class="message left">
                    <p>Desde esta pantalla de inicio, podrás crear y administrar tus componentes, para que te resulte más útil a la
                    hora de gestionar tus terminales, recoger datos, etc.</p>
                </div>
            </article>
        </div>
        <!-- /primary -->
    </div>
    <!-- /#main -->

  </jsp:body>

</t:osoco-wrapper>
