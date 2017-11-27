<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="perfil" tagdir="/WEB-INF/tags"%>
<perfil:template title="Perfil">
	<jsp:attribute name="content">
	
		<ol class="breadcrumb">
		  	<li><a href="index.jsp">Home</a></li>
		  	<li class="active">Perfil</li>
		</ol>
		
		<div class="line"></div>
	
		<div class="jumbotron">
			<div class="container-fluid">
		  		<h1>Gerencie seu perfil</h1>
	  		</div>
		</div>
		
		<div class="line"></div>
	
		<section id="perfil" class="template bg-gray text-center">
	        <div class="container-fluid">
	            <div class="row">
	                <div class="col-md-8">
	                    <form id="form">
	                    	<div id="botao-editar-perfil">
	                    		<button type="button" class="btn btn-default btn-sm btn-success">
							    	<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
							    </button>
	                    	</div>
	                    	<div class="form-group">
		    					<label for="nome">Nome:</label>
		    					<div class="input-group">
		    						<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
		    						<input type="text" class="form-control" id="nome" placeholder="Ex: Nícolas Serralha de Camargo">
	  							</div>
	  						</div>
	
	  						<div class="form-group">
		    					<label for="data-nascimento">Data Nascimento:</label>
		    					<div class="input-group">
		    						<input type="text" class="form-control" id="data-nascimento" placeholder="Ex: 22/03/1991">
	  							</div>
	  						</div>
	
	  						<div class="form-group">
		    					<label for="altura">Altura:</label>
		    					<div class="input-group">
		    						<input type="text" class="form-control" id="altura" placeholder="Ex: 1.84">
	  							</div>
	  						</div>  						
	
	  						<div class="form-group">
		    					<label for="radio-genero">Gênero:</label>
		    					<div class="input-group">
		  							<label class="radio-inline"><input type="radio" name="optradio" id="radio-genero">Masculino</label>
									<label class="radio-inline"><input type="radio" name="optradio" id="radio-genero">Feminino</label>
	  							</div>
	  						</div>
	                    	
	  						<div class="form-group">
		    					<label for="email">Email:</label>
		    					<div class="input-group">
		    						<span class="input-group-addon" id="basic-addon1">@</span>
		    						<input type="email" class="form-control" id="email" placeholder="Ex: nicolas.serralha@hotmail.com">
	  							</div>	
	  						</div>

							 <div class="form-group">
								<label for="pwd">Senha:</label>
								<input type="password" class="form-control" id="pwd" placeholder="Digite a senha atual">
							</div>
							<div class="form-group">
								<input type="password" class="form-control" id="pwd" placeholder="Nova senha">
							</div>
							<div class="form-group">
								<input type="password" class="form-control" id="pwd" placeholder="Confirmar nova senha">
							</div>
							<button type="submit" class="btn btn-default">Submit</button>
						</form>
					</div>
				</div>
	        </div>
	    </section>
	
	</jsp:attribute>
</perfil:template>