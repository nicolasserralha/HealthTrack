<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="alimentacao" tagdir="/WEB-INF/tags"%>
<alimentacao:template title="Alimentação">
	<jsp:attribute name="content">
	
		<ol class="breadcrumb">
		  	<li><a href="index.jsp">Home</a></li>
		  	<li class="active">Alimentação</li>
		</ol>
		
		<div class="line"></div>
		
		<div class="jumbotron">
			<div class="container-fluid">
		  		<h1>Gerencie sua Alimentação</h1>
		  		<p>Adicione, altere ou remova informações</p>
	  		</div>
		</div>
		
		<div class="line"></div>
		
		<section class="container-fluid" id="section-alimentos">
		<div class="panel panel-default">
		  	<div class="panel-heading panel-gray"><h3>Lista de Alimentos Consumidos</h3></div>
	  		<div class="table-responsive">	
		  		<table class="table table-striped">
		  			<thead>
				    	<tr>
						    <th>Data</th>
						    <th>Horário</th> 
						    <th>Tipo</th>
						    <th>Descrição</th>
						    <th>Calorias</th>
						    <th>Alterar</th>
						    <th>Excluir</th>
				  		</tr>
			  		</thead>
			  		<tbody>
			  			<!--inicio do registro -->
				  		<tr>
						    <td>21/03/2017</td>
						    <td>08:30</td> 
						    <td>
						    	<select>
								    <option value="cafe">Café da manhã</option>
								    <option value="almoço">Almoço</option>
								    <option value="jantar">Jantar</option>
								    <option value="lanche">Lanche leve</option>
								    <option value="fruta">Fruta</option>
						    	</select>
						    </td>
						    <td>Descrição da refeição</td>
						    <td>450</td>
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
						    <td>
						    	<select>
								    <option value="cafe">Café da manhã</option>
								    <option value="almoço">Almoço</option>
								    <option value="jantar">Jantar</option>
								    <option value="lanche">Lanche leve</option>
								    <option value="fruta">Fruta</option>
						    	</select>
						    </td>
						    <td>Descrição da refeição</td>
						    <td>450</td>
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
						    <td>
						    	<select>
								    <option value="cafe">Café da manhã</option>
								    <option value="almoço">Almoço</option>
								    <option value="jantar">Jantar</option>
								    <option value="lanche">Lanche leve</option>
								    <option value="fruta">Fruta</option>
						    	</select>
						    </td>
						    <td>Descrição da refeição</td>
						    <td>450</td>
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
						    <td>
						    	<select>
								    <option value="cafe">Café da manhã</option>
								    <option value="almoço">Almoço</option>
								    <option value="jantar">Jantar</option>
								    <option value="lanche">Lanche leve</option>
								    <option value="fruta">Fruta</option>
						    	</select>
						    </td>
						    <td>Descrição da refeição</td>
						    <td>450</td>
						    
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
		    	<div class="container-fluid" id="submit-tabela">
		  			<button type="button" class="btn btn-success btn-xs">Add <span class="glyphicon glyphicon-plus"></span>
		  			</button>
		  		</div>
	  		</div>
		</div>
	</section>
		
		<div class="line"></div>
		
		<section id="section-dicas">
			<div class="container-fluid" id="container-dicas">
				<h2>Dicas de Alimentação</h2>
			</div>
			<div class="container-fluid">
			<div class="row">
			    <div class="col-sm-6 col-md-4">
			  	  	<figure class="thumbnail">
			    		<img src="resources/img/alimentacao/folhas_1920.jpg" alt="Salada">
				      	<figcaption class="caption">
					       	<h3>Agrião</h3>
					       	<p>Com um sabor peculiar e levemente picante, este alimento é riquíssimo em vitaminas e benefícios para a saúde. Também conhecido como agrião do brejo, agrião da europa e cardomo dos rios, a planta de nome científico Nasturtium officinale, além de alimento, serve como erva medicinal.</p>
				      	</figcaption>
				    </figure>
				</div>
				<div class="col-sm-6 col-md-4">
			  	  	<figure class="thumbnail">
			    		<img src="resources/img/alimentacao/frutas_1920.jpg" alt="Frutas">
				      	<figcaption class="caption">
				        	<h3>Frutas Cítricas</h3>
				        	<p>As frutas cítricas fortalecem o sistema imunológico, são importantes para evitar doenças, como o escorbuto, e para aumentar a absorção de ferro, ajudando assim a combater a anemia.<br>
							Outros benefícios das frutas cítricas envolvem: Manter uma pele bonita e saudável; Ajudar a emagrecer; Diminuir a prisão de ventre.</p>
				      	</figcaption>
				    </figure>
				</div>
			    <div class="col-sm-6 col-md-4">
			  	  	<figure class="thumbnail">
			    		<img src="resources/img/alimentacao/cenoura_1920.jpg" alt="Legumes">
			    		<figcaption class="caption">
					        <h3>Prato Colorido</h3>
					        <p>Variar no tipo de alimento e fazer um prato colorido ajuda muito a manter a alimentação saudável. A variedade de cores garante uma refeição rica em qualidade e quantidade de nutrientes essenciais para o bom funcionamento do organismo.<br>
					        Os alimentos estão divididos em seis grupos de cores. Para cada grupo, existe uma propriedade e vitamina importante para a alimentação.</p>
				      	</figcaption>
				    </figure>
				</div>
			</div>
		</div>
		</section>		
	
		</jsp:attribute>
</alimentacao:template>