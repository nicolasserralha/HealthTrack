<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="alimentacao" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<alimentacao:templateLogado title="Alimentação">
	<jsp:attribute name="content">
	
		<ol class="breadcrumb">
		  	<li><a href="index.jsp">Home</a></li>
		  	<li class="active">Alimentação</li>
		</ol>
		
		<div id="page-wrapper">
		
			<div class="jumbotron">
				<div class="container-fluid">
			  		<h1>Gerencie sua Alimentação</h1>
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
							    <th>Tipo</th>
							    <th>Descrição</th>
							    <th>Calorias</th>
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
						  			<td style="display:none"><c:out value="${obj.cd_alimento}"></c:out></td>
								    <td><fmt:formatDate pattern="dd/MM/yyyy" value="${obj.dt_alimento.getTime()}" /></td>
								    <td><fmt:formatDate pattern="HH:mm:ss" value="${obj.dt_alimento.getTime()}" /></td>
									<td><c:out value="${obj.categoria.getDs_cat_alimento()}"></c:out></td>
								    <td><c:out value="${obj.ds_alimento}"></c:out></td>
								    <td><c:out value="${obj.nr_caloria}"></c:out></td>
								    
								    <td>
								    	<button type="button" class="btn btn-default btn-sm btn-warning" name="alterar" onClick="redireciona('AlimentoServlet','action', 'alterar', '${obj.cd_alimento}' )">
								    		<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
								    	</button>
								    </td>
		
								    <td>
								    	<button type="button" class="btn btn-default btn-sm btn-danger" name="remover" onClick="redireciona('AlimentoServlet','action', 'excluir', '${obj.cd_alimento}' )">
								    		<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
								    	</button>
								    </td>
							  	</tr>
							  	<!--fim do registro -->
							</c:forEach>	
								
							<c:if test="${not empty alterar }">
									<tr>
				     			    	<td> <input type="date" name="data" class="form-control" id="data" value="${dataObjeto}"> </td>
				     			    	<td> <input type="time" name="hora" class="form-control" id="hora" placeholder="horário" value="${horaObjeto}"> </td>
				     			    	<td>
									   		<select name="categoria" id="categoria">
											    <option value="1" selected>Café da Manhã</option>
											    <option value="2">Almoço</option>
											    <option value="3">Jantar</option>
											    <option value="4">Lanche Leve</option>
											    <option value="5">Fruta</option>
								    		</select>
									    </td>
										<td><input type="text" name="descricao" class="form-control" id="descricao" value="${requestScope.objeto.ds_alimento}"></td>
										<td><input type="number" name="calorias" class="form-control" id="calorias" value="${requestScope.objeto.nr_caloria}"></td>
										<td>
										<!-- <form action="AtividadeServlet" method="GET"> -->
											<button type="button" class="btn btn-success btn-sm" name="adicionarAtividade" onClick="adicionarAlimento('AlimentoServlet','action', 'atualizarRegistro', 'data' , 'hora', 'categoria', 'descricao', 'calorias' )">
									    		<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
									    	</button>
								    	<!-- </form> -->
									    </td>
									</tr>
								</c:if>
								
								<c:if test="${not empty novoRegistro }">
									<tr>
										<td> <input type="date" name="data" class="form-control" id="data" placeholder="data"> </td>
										<td> <input type="time" name="hora" class="form-control" id="hora" placeholder="horário"> </td>
				     			    	<td>
				     			    	<td>
									   		<select name="categoria" id="categoria">
											    <option value="1" selected>Café da Manhã</option>
											    <option value="2">Almoço</option>
											    <option value="3">Jantar</option>
											    <option value="4">Lanche Leve</option>
											    <option value="5">Fruta</option>
								    		</select>
									    </td>
										<td> <input type="text" name="descricao" class="form-control" id="descricao" placeholder="descrição"> </td>
										<td> <input type="number" name="calorias" class="form-control" id="calorias" placeholder="calorias"> </td>
										<td>
										<!-- <form action="AtividadeServlet" method="GET"> -->
										<div>
											<button type="button" class="btn btn-success btn-sm" name="adicionarAtividade" onClick="adicionarAlimento('AlimentoServlet','action', 'adicionarRegistro', 'data' , 'hora', 'categoria', 'descricao', 'calorias' )">
									    		<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
									    	</button>
									    </div>
								    	<!-- </form> -->
									    </td>
									</tr>
								</c:if>	  	
				    	</tbody>
			  		</table>
					<button type="button" class="btn btn-primary btn-md" id="btn-todo" name="adicionar" onClick="redireciona('AlimentoServlet','action', 'adicionar')">Add </button>
		  		</div>
		</section>
		
		<section id="section-dicas">
			<div id="container-dicas">
				<h2>Dicas de Alimentação</h2>
			</div>
			<div>
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
	</div>
	<script>
		function adicionarAlimento(param, nomeDoCampo, valorASerPassado, data, hora, categoria, descricao, calorias){
			
			var valorData = $('#data').val();
			var valorHora = $('#hora').val();
			var valorCategoria = $('#categoria').val();
			var valorDescricao = $('#descricao').val();
			var valorCalorias = $('#calorias').val();
		  	
			location.href=param+"?"+nomeDoCampo+"="+valorASerPassado+"&"+"data"+"="+valorData+"&"+"hora"+"="+valorHora+"&"+"categoria"+"="+valorCategoria+"&"+"descricao"+"="+valorDescricao+"&"+"calorias"+"="+valorCalorias;
		}
	</script>
	<script>
		function redireciona(param, nomeDoCampo, valorASerPassado, codigo){
			  location.href=param+"?"+nomeDoCampo+"="+valorASerPassado +"&"+"codigo"+"="+codigo;
			}
	</script>
		</jsp:attribute>
</alimentacao:templateLogado>