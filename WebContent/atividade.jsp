<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="atividade" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<atividade:templateLogado title="Atividade Física">
	<jsp:attribute name="content">
		
		<ol class="breadcrumb">
		  	<li><a href="#">Home</a></li>
		  	<li class="active">Atividade Física</li>
		</ol>
	
		<div class="line"></div>
	
		<div class="jumbotron">
			<div class="container-fluid">
		  		<h1>Gerencie seus exercícios</h1>
		  		<p>Adicione, altere ou remova informações</p>
	  		</div>
		</div>

		<div class="line"></div>

		<section class="container-fluid" id="section-alimentos">
			<div class="panel panel-default">
			  	<div class="panel-heading panel-gray"><h3>Lista de Atividades</h3></div>
		  		<div class="table-responsive">	
			  		<table class="table table-striped">
			  			<thead>
					    	<tr>
							    <th>Data</th>
							    <th>Horário</th> 
							    <th>Tipo</th>
							    <th>Descrição</th>
							    <th>Calorias Queimadas</th>
							    <th>Alterar</th>
							    <th>Excluir</th>
					  		</tr>
				  		</thead>
				  		<tbody>
	
				  			<!--inicio do registro -->
				  			
				  			<c:forEach items="${lista}" var="obj">
			  						
						  		<tr>
								    <td><fmt:formatDate pattern="dd/MM/yyyy" value="${obj.dt_atividade.getTime()}" /></td>
								    <td><fmt:formatDate pattern="HH:mm:ss" value="${obj.dt_atividade.getTime()}" /></td>
									<td><c:out value="${obj.categoria.getDs_cat_atividade()}"></c:out></td>
								    <td><c:out value="${obj.ds_atividade}"></c:out></td>
								    <td><c:out value="${obj.nr_caloria}"></c:out></td>
								    
								    <td>
								    	<button type="button" class="btn btn-default btn-sm btn-warning" name="alterar">
								    		<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
								    	</button>
								    </td>
		
								    <td>
								    	<button type="button" class="btn btn-default btn-sm btn-danger" name="remover">
								    		<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
								    	</button>
								    </td>
							  	</tr>
							  	<!--fim do registro -->
							</c:forEach>	
							
				    	</tbody>
			  		</table>
			    	<div class="container-fluid" id="submit-tabela">
			  			<button type="button" class="btn btn-success btn-xs" name="adicionar">Add <span class="glyphicon glyphicon-plus"></span></button>
			  		</div>
		  		</div>
			</div>
		</section>

		<div class="line"></div>
	
		<section id="section-dicas">
		<div class="container-fluid" id="container-dicas">
			<h2>Dicas de Exercícios Físicos</h2>
		</div>
		<div class="container-fluid">
			<div class="row">
			    <div class="col-sm-6 col-md-4">
			  	  	<figure class="thumbnail">
			    		<img src="resources\img\atividades\treino_1920.jpg" alt="Salada">
				      	<figcaption class="caption">
					       	<h3>Fracione o treino</h3>
					       	<p>Alguns estudos recentes vêm demonstrando que sessões de exercícios curtas e cumulativas durante o dia são tão benéficas quanto períodos longos e isolados de treino. O mais recente deles, realizado Centro de Pesquisas de Estilo de Vida Saudável da Universidade do Estado do Arizona (EUA), mostrou que o treino dividido em três sessões curtas por dia foi significativamente mais eficiente que uma sessão única de meia hora para controlar a pressão arterial.</p>
				      	</figcaption>
				    </figure>
				</div>
				<div class="col-sm-6 col-md-4">
			  	  	<figure class="thumbnail">
			    		<img src="resources\img\atividades\alongamento_1920.jpg" alt="Frutas">
				      	<figcaption class="caption">
				        	<h3>Alongar antes e depois</h3>
				        	<p>Antes do exercício físico, o alongamento serve, principalmente, como um fator de prevenção contra lesões musculares durante a atividade. 
							É uma forma de preparar o corpo para se exercitar, deixando-o mais flexível e ampliando seus movimentos. Depois do exercício, sua função é relaxar a musculatura, evitando as dores posteriores à atividade.</p>
				      	</figcaption>
				    </figure>
				</div>
			    <div class="col-sm-6 col-md-4">
			  	  	<figure class="thumbnail">
			    		<img src="resources\img\atividades\agua_1920.jpg" alt="Legumes">
				      	<figcaption class="caption">
					        <h3>Água</h3>
					        <p> Mantenha uma boa hidratação: a ingestão de líquidos deve acontecer antes, durante e após os exercícios. A perda excessiva de líquidos e a desidratação constituem a principal causa de mal-estar durante o exercício.</p>
				      	</figcaption>
				    </figure>
				</div>
			</div>
		</div>
	</section>

	</jsp:attribute>
</atividade:templateLogado>