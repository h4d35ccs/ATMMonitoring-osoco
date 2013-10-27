<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<t:osoco-wrapper titleCode="label.terminalsManager" userMsg="${userMsg}" section="query">

                <div id="header_g">
                    <nav id="breadcrumb">
                        <ul>
                            <li><a href="dasthboard">inicio</a></li>
                            <li><a href="terminals">Terminales</a></li>
                            <li>Mis Consultas</li>
                        </ul>
                    </nav>
                </div>

                <div class="content">
                    <h1>Mis Consultas</h1>
                    <div class="botonera">
                       <a href="queries/create" class="btn right">Nueva consulta</a>
                    </div>
                    <table class="link">
                    	<tr>
                    		<th>Nombre de la consulta</th>
                    		<th>Fecha de creación</th>
                    		<th>Descripción</th>
                    	</tr>

			 <c:forEach items="${pagedListHolder.pageList}" var="query">


			 <tr>
				<td class="editable w33">
                    		    <div class="relative">
				        <div class="icons_action"><a href="queries/delete?queryId=${query.id}" class="delete" onclick="return confirm('¿Estás seguro que quieres borrar la consulta?')"><span>Eliminar</span></a></div>
                    			<a href="queries/show?queryId=${query.id}">${query.name}</a></div></td>

                    		<td class="nowrap">TODO:21-10-2013</td>
                    		<td>TODO:Lorem ipsum dolor sit amet, consectetur adipisicing elit. Est, suscipit, debitis, quis quasi eum quo saepe quibusdam dolorem nesciunt iure alias a possimus facere laborum totam architecto animi? Eos, velit!</td>
              
                </tr>
            </c:forEach>
                    </table>
                </div>
                <div class="pagination"> 
                    <div class="t_number"><span class="text">${pagedListHolder.source.size()} Consultas</span></div>
		    <c:if test="${pagedListHolder.getPageCount() >1 }">
                    <div class="p_number"><span class="text">Página</span><t:paging pagedListHolder="${pagedListHolder}" pagedLink="queries/list?p=~"/></div>
                    </c:if>
                </div>

</t:osoco-wrapper>