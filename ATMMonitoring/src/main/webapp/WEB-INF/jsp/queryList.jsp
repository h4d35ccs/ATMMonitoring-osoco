<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<t:osoco-wrapper titleCode="label.terminalsManager" userMsg="${userMsg}" section="query">

    <div id="main">
        <div id="primary">
            <article>
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
                        <ul>
                            <li><a href="queries/create" class="btn add">Nueva Consulta</a></li>
                        </ul>
                    </div>
                    <table>
                    	<tr>
                    		<th>Nombre de la consulta</th>
                    		<th>Fecha de creación</th>
                    		<th>Descripción</th>
                    	</tr>
                    	<tr>
                    		<td>Madrid Windows XP</td>
                    		<td>21-10-2013</td>
                    		<td>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Est, suscipit, debitis, quis quasi eum quo saepe quibusdam dolorem nesciunt iure alias a possimus facere laborum totam architecto animi? Eos, velit!</td>
                    	</tr>
                    	<tr>
                    		<td>Madrid Windows XP</td>
                    		<td>21-10-2013</td>
                    		<td>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Est, suscipit, debitis, quis quasi eum quo saepe quibusdam dolorem nesciunt iure alias a possimus facere laborum totam architecto animi? Eos, velit!</td>
                    	</tr>
                    	<tr>
                    		<td>Madrid Windows XP</td>
                    		<td>21-10-2013</td>
                    		<td>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Est, suscipit, debitis, quis quasi eum quo saepe quibusdam dolorem nesciunt iure alias a possimus facere laborum totam architecto animi? Eos, velit!</td>
                    	</tr>
                    	<tr>
                    		<td>Madrid Windows XP</td>
                    		<td>21-10-2013</td>
                    		<td>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Est, suscipit, debitis, quis quasi eum quo saepe quibusdam dolorem nesciunt iure alias a possimus facere laborum totam architecto animi? Eos, velit!</td>
                    	</tr>
                    	<tr>
                    		<td>Madrid Windows XP</td>
                    		<td>21-10-2013</td>
                    		<td>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Est, suscipit, debitis, quis quasi eum quo saepe quibusdam dolorem nesciunt iure alias a possimus facere laborum totam architecto animi? Eos, velit!</td>
                    	</tr>
                    	<tr>
                    		<td>Madrid Windows XP</td>
                    		<td>21-10-2013</td>
                    		<td>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Est, suscipit, debitis, quis quasi eum quo saepe quibusdam dolorem nesciunt iure alias a possimus facere laborum totam architecto animi? Eos, velit!</td>
                    	</tr>
                    	
                    </table>
                </div>
                <div class="pagination">
                        <div>200 Consultas | Página</div>
                        <ul>
                            <li><a href="#">1</a></li>
                            <li><a href="#">2</a></li>
                            <li><a href="#">3</a></li>
                            <li><a href="#">4</a></li>
                            <li><a href="#">5</a></li>
                            <li><a href="#">6</a></li>
                            <li><a href="#">7</a></li>
                            <li><a href="#">8</a></li>
                            <li><a href="#">9</a></li>
                            <li><a href="#">...</a></li>
                        </ul>
                    </div>
            </article>
        </div>
    </div>


</t:osoco-wrapper>
