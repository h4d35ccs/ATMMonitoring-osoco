<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<t:osoco-wrapper titleCode="label.terminalsManager" userMsg="${userMsg}" section="dashboard">

    <div id="main">
        <div id="primary">
            <article>
                <div id="header_g">
                    <div id="components">
                        <div id="my_components" class="desplegable">
                            <div class="txt hide">
                                <span>Mis componentes</span>
                            </div>
                            <ul class="ocultable">
                                <li class="off">Geo - ATM Mundo</li>
                                <li>
                                    <a href="#">Proveedores</a>
                                </li>
                                <li class="off">ATM S.O.</li>
                                <li>
                                    <a href="#">Sistemas operativos</a>
                                </li>
                                <li>
                                    <a href="#">Cajeros Madrid</a>
                                </li>
                                <li class="off">ATM S.O. Madrid</li>
                                <li class="off">Idiomas</li>
                                <li class="off">Historico S.O. Macrid</li>
                                <li class="off">Historico S.O. Barcelona</li>
                                <li class="off">Historico S.O. Valencia</li>
                                <li class="off">ATM España</li>
                            </ul>
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
                                <li class=" column1">
                                    <a href="#">
                                        <span>2 columnas</span>
                                    </a>
                                </li>
                                <li class=" column2">
                                    <a href="#">
                                        <span>2 columnas</span>
                                    </a>
                                </li>
                                <li class="column3">
                                    <a href="#">
                                        <span>3 columnas</span>
                                    </a>
                                </li>
                                <li class="current column4">
                                    <a href="#">
                                        <span>4 columnas</span>
                                    </a>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div>
                <ul id="sortable" class="ui-sortable column4">
                    <li class="ui-state-default">
                        <div class="content">
                            <div class="icons_bg">
                                <div class="close">
                                    <span>cerrar</span>
                                </div>
                                <nav class="icons_menu desplegable">
                                    <div class="icon16 config hide txt">
                                        <span>Opciones</span>
                                    </div>
                                    <ul class="ocultable">
                                        <li>
                                            <a href="#">Editar</a>
                                        </li>
                                        <li>
                                            <a href="#">Compartir</a>
                                        </li>
                                        <li>
                                            <a href="#">Eliminar</a>
                                        </li>
                                    </ul>
                                </nav>
                            </div>
                            <div class="graph" id="chart_div"></div>
                        </div>
                    </li>
                    <li class="ui-state-default">
                        <div class="content">
                            <div class="icons_bg">
                                <div class="close">
                                    <span>cerrar</span>
                                </div>
                                <nav class="icons_menu desplegable">
                                    <div class="icon16 config hide txt">
                                        <span>Opciones</span>
                                    </div>
                                    <ul class="ocultable">
                                        <li>
                                            <a href="#">Editar</a>
                                        </li>
                                        <li>
                                            <a href="#">Compartir</a>
                                        </li>
                                        <li>
                                            <a href="#">Eliminar</a>
                                        </li>
                                    </ul>
                                </nav>
                            </div>
                            <div class="graph" id="piechart_3d"></div>
                        </div>
                    </li>
                    <li class="ui-state-default">
                        <div class="content">
                            <div class="icons_bg">
                                <div class="close">
                                    <span>cerrar</span>
                                </div>
                                <nav class="icons_menu desplegable">
                                    <div class="icon16 config hide txt">
                                        <span>Opciones</span>
                                    </div>
                                    <ul class="ocultable">
                                        <li>
                                            <a href="#">Editar</a>
                                        </li>
                                        <li>
                                            <a href="#">Compartir</a>
                                        </li>
                                        <li>
                                            <a href="#">Eliminar</a>
                                        </li>
                                    </ul>
                                </nav>
                            </div>
                            <div class="graph" id="donutchart"></div>
                        </div>
                    </li>
                    <li class="ui-state-default">
                        <div class="content">
                            <div class="icons_bg">
                                <div class="close">
                                    <span>cerrar</span>
                                </div>
                                <nav class="icons_menu desplegable">
                                    <div class="icon16 config hide txt">
                                        <span>Opciones</span>
                                    </div>
                                    <ul class="ocultable">
                                        <li>
                                            <a href="#">Editar</a>
                                        </li>
                                        <li>
                                            <a href="#">Compartir</a>
                                        </li>
                                        <li>
                                            <a href="#">Eliminar</a>
                                        </li>
                                    </ul>
                                </nav>
                            </div>
                            <div class="graph" id="piechart"></div>
                        </div>
                    </li>
                    <li class="ui-state-default">
                        <div class="content">
                            <div class="icons_bg">
                                <div class="close">
                                    <span>cerrar</span>
                                </div>
                                <nav class="icons_menu desplegable">
                                    <div class="icon16 config hide txt">
                                        <span>Opciones</span>
                                    </div>
                                    <ul class="ocultable">
                                        <li>
                                            <a href="#">Editar</a>
                                        </li>
                                        <li>
                                            <a href="#">Compartir</a>
                                        </li>
                                        <li>
                                            <a href="#">Eliminar</a>
                                        </li>
                                    </ul>
                                </nav>
                            </div>
                            <div class="graph" id="Graph01"></div>
                        </div>
                    </li>
                    <li class="ui-state-default">
                        <div class="content">
                            <div class="icons_bg">
                                <div class="close">
                                    <span>cerrar</span>
                                </div>
                                <nav class="icons_menu desplegable">
                                    <div class="icon16 config hide txt">
                                        <span>Opciones</span>
                                    </div>
                                    <ul class="ocultable">
                                        <li>
                                            <a href="#">Editar</a>
                                        </li>
                                        <li>
                                            <a href="#">Compartir</a>
                                        </li>
                                        <li>
                                            <a href="#">Eliminar</a>
                                        </li>
                                    </ul>
                                </nav>
                            </div>
                            <div class="graph" id="Graph02"></div>
                        </div>
                    </li>
                    <li class="ui-state-default">
                        <div class="content">
                            <div class="icons_bg">
                                <div class="close">
                                    <span>cerrar</span>
                                </div>
                                <nav class="icons_menu desplegable">
                                    <div class="icon16 config hide txt">
                                        <span>Opciones</span>
                                    </div>
                                    <ul class="ocultable">
                                        <li>
                                            <a href="#">Editar</a>
                                        </li>
                                        <li>
                                            <a href="#">Compartir</a>
                                        </li>
                                        <li>
                                            <a href="#">Eliminar</a>
                                        </li>
                                    </ul>
                                </nav>
                            </div>
                            <div class="graph" id="Graph03"></div>
                        </div>
                    </li>
                    <li class="ui-state-default">
                        <div class="content">
                            <div class="icons_bg">
                                <div class="close">
                                    <span>cerrar</span>
                                </div>
                                <nav class="icons_menu desplegable">
                                    <div class="icon16 config hide txt">
                                        <span>Opciones</span>
                                    </div>
                                    <ul class="ocultable">
                                        <li>
                                            <a href="#">Editar</a>
                                        </li>
                                        <li>
                                            <a href="#">Compartir</a>
                                        </li>
                                        <li>
                                            <a href="#">Eliminar</a>
                                        </li>
                                    </ul>
                                </nav>
                            </div>
                            <div class="graph" id="Graph04"></div>
                        </div>
                    </li>
                </ul>
            </article>
        </div>
        <!-- /primary -->
    </div>
    <!-- /#main -->

</t:osoco-wrapper>
