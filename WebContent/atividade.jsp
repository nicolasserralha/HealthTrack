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
	
		<div id="page-wrapper">
		
			<div class="jumbotron">
				<div class="container-fluid">
			  		<h1>Gerencie seus exercícios</h1>
			  		<p>Adicione, altere ou remova informações</p>
		  		</div>
			</div>

			<section>
			  		<div class="table-responsive">	
				  		<table class="table table-striped">
				  			<thead>
						    	<tr>
						    		<th style="display:none">Código</th>
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
		
								<c:if test="${not empty mensagemRemover }">
						    		<div class="alert alert-success">${mensagemRemover}</div>
						  		</c:if>
								<c:if test="${not empty erro }">
						    		<div class="alert alert-danger">${erro}</div>
						  		</c:if>
								<c:if test="${not empty mensagemSucesso }">
						    		<div class="alert alert-success">${mensagemSucesso}</div>
						  		</c:if>
					  			<!--inicio do registro -->
					  			
					  			<c:forEach items="${lista}" var="obj">
				  						
							  		<tr>
							  			<td style="display:none"><c:out value="${obj.cd_atividade}"></c:out></td>
									    <td><fmt:formatDate pattern="dd/MM/yyyy" value="${obj.dt_atividade.getTime()}" /></td>
									    <td><fmt:formatDate pattern="HH:mm:ss" value="${obj.dt_atividade.getTime()}" /></td>
										<td><c:out value="${obj.categoria.getDs_cat_atividade()}"></c:out></td>
									    <td><c:out value="${obj.ds_atividade}"></c:out></td>
									    <td><c:out value="${obj.nr_caloria}"></c:out></td>
									    
									    <td>
									    	<button type="button" class="btn btn-default btn-sm btn-warning" name="alterar" onClick="redireciona('AtividadeServlet','action', 'alterar', '${obj.cd_atividade}' )">
									    		<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
									    	</button>
									    </td>
			
									    <td>
									    	<button type="button" class="btn btn-default btn-sm btn-danger" name="remover" onClick="redireciona('AtividadeServlet','action', 'excluir', '${obj.cd_atividade}' )">
									    		<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
									    	</button>
									    </td>
								  	</tr>
								  	<!--fim do registro -->
								</c:forEach>	
													
				      			<c:if test="${not empty alterar }">
									<tr>
										<td style="display:none"><input type="text" name="codigo" class="form-control" id="codigo" value="${requestScope.objeto.cd_atividade}"></td>
				     			    	<td><input type="date" name="data" class="form-control" id="data" value="${dataObjeto}"></td>
				     			    	<td> <input type="time" name="hora" class="form-control" id="hora" placeholder="horário" value="${horaObjeto}"> </td>
				     			    	<td>
									   		<select name="categoria" onchange="test(this)" id="categoria">
											    <option value="1" selected>Caminhada</option>
											    <option value="2">Corrida</option>
											    <option value="3">Pedalada</option>
											    <option value="4">Musculação</option>
								    		</select>
									    </td>
										<td><input type="text" name="descricao" class="form-control" id="descricao" value="${requestScope.objeto.ds_atividade}"></td>
										<td><input type="number" name="calorias" class="form-control" id="calorias" value="${requestScope.objeto.nr_caloria}"></td>
										<td>
											<button type="button" class="btn btn-success btn-sm" onClick="alterarAtividade('AtividadeServlet','action', 'atualizarRegistro', 'codigo', 'data', 'hora', 'categoria', 'descricao', 'calorias' )">
									    		<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
									    	</button>
									    </td>
									</tr>
								</c:if>
								
								<c:if test="${not empty novoRegistro }">
									<tr>
										<td> <input type="date" name="data" class="form-control" id="data" placeholder="data"> </td>
										<td> <input type="time" name="hora" class="form-control" id="hora" placeholder="horário"> </td>
				     			    	<td>
									   		<select name="categoria" onchange="test(this)" id="categoria">
											    <option value="1" selected>Caminhada</option>
											    <option value="2">Corrida</option>
											    <option value="3">Pedalada</option>
											    <option value="4">Musculação</option>
								    		</select>
									    </td>
										<td> <input type="text" name="descricao" class="form-control" id="descricao" placeholder="descrição"> </td>
										<td> <input type="number" name="calorias" class="form-control" id="calorias" placeholder="calorias"> </td>
										<td>
										<!-- <form action="AtividadeServlet" method="GET"> -->
										<div>
											<button type="button" class="btn btn-success btn-sm" onClick="adicionarAtividade('AtividadeServlet','action', 'atualizarRegistro', 'data' , 'hora', 'categoria', 'descricao', 'calorias' )">
									    		<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
									    	</button>
									    </div>
								    	<!-- </form> -->
									    </td>
									</tr>
								</c:if>
								
					    	</tbody>
				  		</table>
			    		<button type="button" class="btn btn-primary btn-md" id="btn-todo" onClick="redireciona('AtividadeServlet','action', 'adicionar')">Add </button>
			  		</div>
				<!-- </div> -->
			</section>

		<section id="section-dicas">
			<div id="container-dicas">
				<h2>Dicas de Exercícios Físicos</h2>
			</div>
			<div>
				<div class="row">
				    <div class="col-sm-6 col-md-4">
				  	  	<figure class="thumbnail">
				    		<!-- <img src="resources\img\atividades\treino_1920.jpg" alt="Treino"> -->
				    		<img src="resources/img/alimentacao/folhas_1920.jpg" alt="Salada">
					      	<figcaption class="caption">
						       	<h3>Fracione o treino</h3>
						       	<p>Alguns estudos recentes vêm demonstrando que sessões de exercícios curtas e cumulativas durante o dia são tão benéficas quanto períodos longos e isolados de treino. O mais recente deles, realizado Centro de Pesquisas de Estilo de Vida Saudável da Universidade do Estado do Arizona (EUA), mostrou que o treino dividido em três sessões curtas por dia foi significativamente mais eficiente que uma sessão única de meia hora para controlar a pressão arterial.</p>
					      	</figcaption>
					    </figure>
					</div>
					<div class="col-sm-6 col-md-4">
				  	  	<figure class="thumbnail">
				    		<!-- <img src="resources/img/atividades/alongamento_1920.jpg" alt="Alongamento"> -->
				    		<img src="resources/img/alimentacao/folhas_1920.jpg" alt="Salada">
					      	<figcaption class="caption">
					        	<h3>Alongar antes e depois</h3>
					        	<p>Antes do exercício físico, o alongamento serve, principalmente, como um fator de prevenção contra lesões musculares durante a atividade. 
								É uma forma de preparar o corpo para se exercitar, deixando-o mais flexível e ampliando seus movimentos. Depois do exercício, sua função é relaxar a musculatura, evitando as dores posteriores à atividade.</p>
					      	</figcaption>
					    </figure>
					</div>
				    <div class="col-sm-6 col-md-4">
				  	  	<figure class="thumbnail">
				    		<!-- <img src="resources/img/atividades/agua_1920.jpg" alt="Agua"> -->
							<img src="resources/img/alimentacao/folhas_1920.jpg" alt="Salada">
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
	
	<script>
		function adicionarAtividade(param, nomeDoCampo, valorASerPassado, data, hora, categoria, descricao, calorias){
			
			var valorData = $('#data').val();
			var valorHora = $('#hora').val();
			var valorCategoria = $('#categoria').val();
			var valorDescricao = $('#descricao').val();
			var valorCalorias = $('#calorias').val();
		  	
			location.href=param+"?"+nomeDoCampo+"="+valorASerPassado+"&"+"data"+"="+valorData+"&"+"hora"+"="+valorHora+"&"+"categoria"+"="+valorCategoria+"&"+"descricao"+"="+valorDescricao+"&"+"calorias"+"="+valorCalorias;
		}
	</script>
		<script>
		function alterarAtividade(param, nomeDoCampo, valorASerPassado, codigo, data, hora, categoria, descricao, calorias){
			
			var valorCodigo = $('#codigo').val();
			var valorData = $('#data').val();
			var valorHora = $('#hora').val();
			var valorCategoria = $('#categoria').val();
			var valorDescricao = $('#descricao').val();
			var valorCalorias = $('#calorias').val();
		  	
			location.href=param+"?"+nomeDoCampo+"="+valorASerPassado+"&"+"codigo"+"="+valorCodigo+"&"+"data"+"="+valorData+"&"+"hora"+"="+valorHora+"&"+"categoria"+"="+valorCategoria+"&"+"descricao"+"="+valorDescricao+"&"+"calorias"+"="+valorCalorias;
		}
	</script>
	<script>
		function redireciona(param, nomeDoCampo, valorASerPassado, codigo){
			  location.href=param+"?"+nomeDoCampo+"="+valorASerPassado +"&"+"codigo"+"="+codigo;
			}
	</script>
	</jsp:attribute>
</atividade:templateLogado>