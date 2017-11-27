<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="index" tagdir="/WEB-INF/tags"%>
<index:templateCadastroLogin title="Index">
	<jsp:attribute name="content">
	
	<section id="cadastro">
		<form>
			<div class="form-group">
				<label for="nome">Nome:</label>
				<div class="input-group">
					<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span>
					<input type="text" class="form-control" id="nome"
							placeholder="Nome completo">
				</div>
			</div>

			<div class="form-group">
				<label for="data-nascimento">Data Nascimento:</label>
				<div class="input-group">
					<input type="text" class="form-control" id="data-nascimento" placeholder="dd/mm/aaaa">
				</div>
			</div>

 			<div class="form-group">
    			<label for="altura">Altura:</label>
    			<div class="input-group">
    				<input type="text" class="form-control" id="altura" placeholder="em metros">
 				</div>
 			</div>  						

			<div class="form-group">
				<label for="radio-genero">Gênero:</label>
				<div class="input-group">
  					<label class="radio-inline"><input type="radio" name="optradio" id="radio-genero">Masculino</label>
					<label class="radio-inline"><input type="radio"	name="optradio" id="radio-genero">Feminino</label>
 				</div>
			</div>
                   	
			<div class="form-group">
				<label for="email">Email:</label>
   				<div class="input-group">
   					<span class="input-group-addon" id="basic-addon1">@</span>
   					<input type="email" class="form-control" id="email" placeholder="Email">
				</div>	
 			</div>

			<div class="form-group">
			    <label for="pwd">Senha:</label>
			    <input type="password" class="form-control" id="pwd" placeholder="6 dígitos, entre letras e números">
		  	</div>

		  	<div class="form-group">
			    <input type="password" class="form-control" id="pwd" placeholder="Confirmar senha">
		  	</div>

		  	<button type="submit" class="btn btn-default">Submit</button>

		</form>
	</section>

	</jsp:attribute>
</index:templateCadastroLogin>