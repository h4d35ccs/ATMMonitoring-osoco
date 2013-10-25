<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<style>
  .ui-state-highlight {
      width: 21%;
      background-color: #efefef;
      border: 2px dashed #aaaaaa;
  }
</style>

<t:osoco-wrapper titleCode="label.terminalsManager" userMsg="${userMsg}" section="dashboard">

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
            </article>
        </div>
        <!-- /primary -->
    </div>
    <!-- /#main -->

</t:osoco-wrapper>
