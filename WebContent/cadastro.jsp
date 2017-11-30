<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="index" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<index:templateCadastroLogin title="Index">
	<jsp:attribute name="content">
	
	<section id="cadastro">
	
		<c:if test="${not empty msg }">
    		<div class="alert alert-success">${msg}</div>
  		</c:if>
		<c:if test="${not empty erro }">
    		<div class="alert alert-danger">${erro}</div>
  		</c:if>
	
		<form method="post" action="cadastrar">
			<div class="form-group">
				<label for="nome">Nome:</label>
				<div class="input-group">
					<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
					<input type="text" class="form-control" name="nome" id="nome" placeholder="Nome completo" required>
				</div>
			</div>

			<div class="form-group">
				<label for="data-nascimento">Data Nascimento:</label>
				<div class="input-group">
					<input type="text" class="form-control" name="data-nascimento" id="data-nascimento" placeholder="dd/mm/aaaa" required
					 pattern="(^(((0[1-9]|1[0-9]|2[0-8])[\/](0[1-9]|1[012]))|((29|30|31)[\/](0[13578]|1[02]))|((29|30)[\/](0[4,6,9]|11)))[\/](19|[2-9][0-9])\d\d$)|(^29[\/]02[\/](19|[2-9][0-9])(00|04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96)$)">
				</div>
			</div>

 			<div class="form-group">
    			<label for="altura">Altura:</label>
    			<div class="input-group">
    				<input type="text" class="form-control" name="altura" id="altura" placeholder="em metros" required 
    				pattern="^[0-9]([.,][0-9]{1,3})?$">
 				</div>
 			</div>  						

			<div class="form-group">
				<label for="radio-genero">Gênero:</label>
				<div class="input-group">
  					<label class="radio-inline"><input type="radio" name="radio-genero" id="radio-genero" value="M" required>Masculino</label>
					<label class="radio-inline"><input type="radio"	name="radio-genero" id="radio-genero" value="F">Feminino</label>
 				</div>
			</div>
                   	
			<div class="form-group">
				<label for="email">Email:</label>
   				<div class="input-group">
   					<span class="input-group-addon" id="basic-addon1">@</span>
   					<input type="email" class="form-control" name="email" id="email" placeholder="Email" required>
				</div>	
 			</div>

			<div class="form-group">
			    <label for="pwd">Senha:</label>
			    <input type="password" class="form-control" name="pwd" id="pwd" placeholder="6 dígitos, entre letras e números" required
			    pattern="^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{4,}$" onchange="form.pwd2.pattern = this.value;">
		  	</div>

		  	<div class="form-group">
			    <input type="password" class="form-control" id="pwd" name="pwd2" placeholder="Confirmar senha"
			    onchange="this.setCustomValidity(this.validity.patternMismatch ? 'As senhas não conferem' : '')">
		  	</div>

		  	<button type="submit" class="btn btn-default">Submit</button>

		</form>
	</section>

	</jsp:attribute>
</index:templateCadastroLogin>