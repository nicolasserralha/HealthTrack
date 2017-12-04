<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="peso" tagdir="/WEB-INF/tags"%>
<peso:templateLogado title="Peso">
	<jsp:attribute name="content">
	
		<ol class="breadcrumb">
		  	<li><a href="index.jsp">Home</a></li>
		  	<li class="active">Peso</li>
		</ol>
		
		<div id="page-wrapper">
		
			<div class="jumbotron">
				<div class="container-fluid">
			  		<h1>Gerencie seu Peso</h1>
			  		<p>Adicione, altere ou remova informações</p>
		  		</div>
			</div>
		
			<section>
		  		<div class="table-responsive">	
			  		<table class="table table-striped">
			  			<thead>
					    	<tr>
							    <th>Data</th>
							    <th>Horário</th>
							    <th>Descrição</th>
							    <th>Pesagem (kg)</th>
							    <th>Alterar</th>
							    <th>Excluir</th>
					  		</tr>
				  		</thead>
				  		<tbody>
				  			<!--inicio do registro -->
					  		<tr>
							    <td>21/03/2017</td>
							    <td>08:30</td> 
							    <td>Observação</td>
							    <td>78,8</td>
							    <td>
							    	<button type="button" class="btn btn-default btn-sm btn-warning">
							    		<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
							    	</button>
							    </td>
							    <td>
							    	<button type="button" class="btn btn-default btn-sm btn-danger">
							    		<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
							    	</button>
							    </td>
						  	</tr>
						  	<!--fim do registro -->
	
				  			<!--inicio do registro -->
					  		<tr>
							    <td>20/03/2017</td>
							    <td>08:30</td>
							    <td>Observação</td>
							    <td>79,0</td>
							    <td>
							    	<button type="button" class="btn btn-default btn-sm btn-warning">
							    		<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
							    	</button>
							    </td>
							    <td>
							    	<button type="button" class="btn btn-default btn-sm btn-danger">
							    		<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
							    	</button>
							    </td>
						  	</tr>
						  	<!--fim do registro -->
	
				  			<!--inicio do registro -->
					  		<tr>
							    <td>19/03/2017</td>
							    <td>08:30</td> 
							    <td>Observação</td>
							    <td>79,6</td>
							    <td>
							    	<button type="button" class="btn btn-default btn-sm btn-warning">
							    		<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
							    	</button>
							    </td>
							    <td>
							    	<button type="button" class="btn btn-default btn-sm btn-danger">
							    		<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
							    	</button>
							    </td>
						  	</tr>
						  	<!--fim do registro -->					  						  	
	
						  	<tr>
							    <td>18/03/2017</td>
							    <td>08:30</td>
							    <td>Observação</td>
							    <td>80,0</td>
							    <td>
							    	<button type="button" class="btn btn-default btn-sm btn-warning">
							    		<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
							    	</button>
							    </td>
							    <td>
							    	<button type="button" class="btn btn-default btn-sm btn-danger">
							    		<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
							    	</button>
							    </td>
						  	</tr>
				    	</tbody>
			  		</table>
				<button type="button" class="btn btn-primary btn-md" id="btn-todo" name="adicionar" onClick="redireciona('PesoServlet','action', 'adicionar')">Add </button>
		  		</div>
		</section>
	
		<section id="section-dicas">
			<div id="container-dicas">
				<h2>Dicas de Exercícios Físicos</h2>
			</div>
			<div>
				<div class="row">
				    <div class="col-sm-6 col-md-4">
				  	  	<figure class="thumbnail">
				    		<img src="resources/img/atividades/treino_1920.jpg" alt="Salada">
					      	<figcaption class="caption">
						       	<h3>Fracione o treino</h3>
						       	<p>Alguns estudos recentes vêm demonstrando que sessões de exercícios curtas e cumulativas durante o dia são tão benéficas quanto períodos longos e isolados de treino. O mais recente deles, realizado Centro de Pesquisas de Estilo de Vida Saudável da Universidade do Estado do Arizona (EUA), mostrou que o treino dividido em três sessões curtas por dia foi significativamente mais eficiente que uma sessão única de meia hora para controlar a pressão arterial.</p>
					      	</figcaption>
					    </figure>
					</div>
					<div class="col-sm-6 col-md-4">
				  	  	<figure class="thumbnail">
				    		<img src="resources/img/atividades/alongamento_1920.jpg" alt="Frutas">
					      	<figcaption class="caption">
					        	<h3>Alongar antes e depois</h3>
					        	<p>Antes do exercício físico, o alongamento serve, principalmente, como um fator de prevenção contra lesões musculares durante a atividade. 
								É uma forma de preparar o corpo para se exercitar, deixando-o mais flexível e ampliando seus movimentos. Depois do exercício, sua função é relaxar a musculatura, evitando as dores posteriores à atividade.</p>
					      	</figcaption>
					    </figure>
					</div>
				    <div class="col-sm-6 col-md-4">
				  	  	<figure class="thumbnail">
				    		<img src="resources/img/atividades/agua_1920.jpg" alt="Legumes">
					      	<figcaption class="caption">
						        <h3>Água</h3>
						        <p> Mantenha uma boa hidratação: a ingestão de líquidos deve acontecer antes, durante e após os exercícios. A perda excessiva de líquidos e a desidratação constituem a principal causa de mal-estar durante o exercício.</p>
					      	</figcaption>
					    </figure>
					</div>
				</div>
			</div>
		</section>
		</div>

		</jsp:attribute>
</peso:templateLogado>