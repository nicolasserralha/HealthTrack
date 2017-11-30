<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="index" tagdir="/WEB-INF/tags"%>
<index:templateCadastroLogin title="Index">
	<jsp:attribute name="content">
	
		<div class="container-fluid" id="fundo">
			<div class="container-fluid top">
				<div class="row">
	                <div class="col-sm-12 col-md-12" >
	                    <div class="header-content">
	                        <div class="header-content-inner">
	                            <h1>Be HealthTrack<br>
	                            </h1>
	                            <a href="#download" class="btn btn-outline btn-xl page-scroll">Comece agora!</a>
	                        </div>
	                    </div>
	                </div>
				</div>
			</div>
		</div>
		
		<section id="download" class="template bg-primary text-center">
	        <div class="container">
	            <div class="row">
	                <div class="col-md-8 col-md-offset-2">
	                    <h2 class="section-heading">Seja saudável com o HealthTrack</h2>
	                    <p>Nosso app está disponível para qualquer dispositivo! Baixe agora!</p>
	                    <div class="badges">
	                        <a class="badge-link" href="#"><img src="resources/img/badges/google-play-badge.svg" alt=""></a>
	                        <a class="badge-link" href="#"><img src="resources/img/badges/app-store-badge.svg" alt=""></a>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </section>
		
<!-- 		<section id="cadastro" class="template bg-gray text-center">
	        <div class="container">
	            <div class="row">
	                <div class="col-md-8 col-md-offset-2">
	                    <h2 class="section-heading">Cadastre-se</h2>
	                    <p>E passe a ter mais qualidade de vida!</p>
	                    <form>
	                    	<div class="form-group">
		    					<label for="nome">Nome:</label>
		    					<div class="input-group">
		    						<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
		    						<input type="text" class="form-control" id="nome" placeholder="Nome completo">
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
									<label class="radio-inline"><input type="radio" name="optradio" id="radio-genero">Feminino</label>
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
	                </div>
	            </div>
	        </div>
    	</section>

    	<section id="login" class="template text-center">
	        <div class="container">
	            <div class="row">
	                <div id="loginbox" class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
	                	<h2 class="section-heading">Entre!</h2>
	            		<form id="loginform">
			                <div class="form-group">            
				                <div class="input-group">
				                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
				                    <input id="login-username" type="text" class="form-control" name="username" value="" placeholder="Email">                                        
				                </div>
			                </div>
			                <div class="form-group">
				                <div class="input-group">
				                    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
				                    <input id="login-password" type="password" class="form-control" name="password" placeholder="Senha">
				                </div>
				                <div class="input-group">
				                	<div class="checkbox">
				                        <label>
				                            <input id="login-remember" type="checkbox" name="remember" value="1"> Remember me
				                        </label>
				                    </div>
				                </div>
							</div>
	
			                <div class="form-group">
			                    <div class="col-sm-12 controls">
			                        <a id="btn-login" href="dashboard.jsp" class="btn btn-success">Login</a>
			                    </div>
			                </div> 
			            </form>
		            </div>
		        </div>
		    </div>
   	 </section> -->
		
	</jsp:attribute>
</index:templateCadastroLogin>