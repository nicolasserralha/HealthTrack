<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="pressao" tagdir="/WEB-INF/tags"%>
<pressao:templateLogado title="Pressão">
	<jsp:attribute name="content">
		
		<ol class="breadcrumb">
		  	<li><a href="index.jsp">Home</a></li>
		  	<li class="active">Pressão Arterial</li>
		</ol>
		
		<div class="line"></div>
		
		<div class="jumbotron">
			<div class="container-fluid">
		  		<h1>Gerencie sua Pressão Arterial</h1>
		  		<p>Adicione, altere ou remova informações</p>
	  		</div>
		</div>
		
		<div class="line"></div>
	
		<section class="container-fluid" id="section-pressao">
			<div class="panel panel-default">
			  	<div class="panel-heading panel-gray"><h3>Lista de Pressão Arterial</h3></div>
		  		<div class="table-responsive">	
			  		<table class="table table-striped">
			  			<thead>
					    	<tr>
							    <th>Data</th>
							    <th>Pressão Sistólica (mmHg)</th>
							    <th>Pressão Diastólica (mmHg)</th>
							    <th>Observação</th>
							    <th>Situação</th>
							    <th>Alterar</th>
							    <th>Excluir</th>
					  		</tr>
				  		</thead>
				  		<tbody>
				  			<!--inicio do registro -->
					  		<tr>
							    <td>21/03/2017</td>
							    <td>141</td> 
							    <td>91</td>
							    <td>Alguma observação sobre a medição.</td>
							    <td>Elevada</td>
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
							    <td>130</td> 
							    <td>90</td>
							    <td>Alguma observação sobre a medição.</td>
							    <td>Normal</td>
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
							    <td>110</td> 
							    <td>70</td>
							    <td>Alguma observação sobre a medição.</td>
							    <td>Abaixo do normal</td>
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
							    <td>18/03/2017</td>
							    <td>120</td> 
							    <td>80</td>
							    <td>Alguma observação sobre a medição.</td>
							    <td>Normal</td>
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
				    	</tbody>
			  		</table>
			    	<div class="container-fluid" id="submit-tabela">
			  			<button type="button" class="btn btn-success btn-xs">Add <span class="glyphicon glyphicon-plus"></span></button>
			  		</div>
		  		</div>
			</div>
		</section>
	
		<div class="line"></div>
		
		<section id="section-dicas">
			<div class="container-fluid" id="container-dicas">
				<h2>Dicas sobre Pressão Arterial</h2>
			</div>
			<div class="container-fluid">
				<div class="row">
				    <div class="col-sm-6 col-md-4">
				  	  	<figure class="thumbnail">
				    		<img src="resources/img/pressao/cigarro_1920.jpg" alt="Quebrando cigarro ao meio">
					      	<figcaption class="caption">
						       	<h3>Cigarro</h3>
						       	<p>O cigarro deve ser mantido apagado - e bem longe - se o desejo é permanecer distante dos riscos da hipertensão. O fumo é um dos principais fatores de risco para doença arterial coronariana. As substâncias tóxicas do cigarro provocam o enrijecimento das artérias, fato que compromete a passagem de fluxo sanguíneo e faz a pressão subir.</p>
					      	</figcaption>
					    </figure>
					</div>
					<div class="col-sm-6 col-md-4">
				  	  	<figure class="thumbnail">
				    		<img src="resources/img/pressao/lady_1920.jpg" alt="Mulher praticando exercício físico">
					      	<figcaption class="caption">
					        	<h3>Exercícios Físicos</h3>
					        	<p>A prática regular de exercícios ajuda no controle dos níveis da pressão arterial, porque melhora o condicionamento físico do coração, fazendo com que ele não fique sobrecarregado.<br>
					        	Alem disso, a prática regular de atividades provoca um efeito anti-hipertensivo por ajudar a queimar os quilos extras.</p>
					      	</figcaption>
					    </figure>
					</div>
				    <div class="col-sm-6 col-md-4">
				  	  	<figure class="thumbnail">
				    		<img src="resources/img/alimentacao/cenoura_1920.jpg" alt="Alimentação Saudável">
					      	<figcaption class="caption">
						        <h3>Alimentação Saudável</h3>
						        <p>Há uma gama de alimentos que podem desencadear ou agravar a doença. O excesso de sal e de gorduras saturadas, assim como a ingestão de gorduras trans são amigos da hipertensão. Evitá-los é fundamental para manter a doença longe e ou para controlá-la.</p>		    
					      	</figcaption>
					    </figure>
					</div>
				</div>
			</div>
		</section>
	
		</jsp:attribute>
</pressao:templateLogado>