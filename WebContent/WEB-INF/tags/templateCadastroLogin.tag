<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="title" required="true" rtexprvalue="true"%>
<%@ attribute name="content" fragment="true"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${title }</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/css/custom.css">
    <link rel="stylesheet" type="text/css" href="resources/css/customCL.css">
	<link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Catamaran:100,200,300,400,500,600,700,800,900" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Muli" rel="stylesheet">
</head>
<body>
	<header>
		<nav class="navbar navbar-default navbar-fixed-top blue">
	  		<div class="container-fluid">
		    	<div class="navbar-header blue">
			      	<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse-1" aria-expanded="false">
				        <span class="sr-only">Toggle navigation</span>
				        <span class="icon-bar"></span>
				        <span class="icon-bar"></span>
				        <span class="icon-bar"></span>
			      	</button>
			      	<a class="navbar-brand page-scroll blue" href="#header">HealthTrack</a>
		    	</div>


		    	<div class="collapse navbar-collapse blue" id="navbar-collapse-1">
			      	<ul class="nav navbar-nav blue">
			      		<li><a href="#header" class="page-scroll blue">Home</a></li>
			      		<li><a href="#footer" class="page-scroll blue">Contato</a></li>
			      		<li><a class="page-scroll blue" href="#cadastro">Cadastrar</a></li>
		      		</ul>
		      	<!-- Parte da Direita -->
				<span class="navbar-text text-danger" style="margin-right:10px" >
	          		${erro }
	      		</span> 
		      	<form class="form-inline nav navbar-nav navbar-right" action="logar" method="post">
		      		<input class="form-control mr-sm-2" type="text" name="email" placeholder="E-mail">
		        	<input class="form-control mr-sm-2" type="password" name="senha" placeholder="Senha">
		        	<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Entrar</button>
		      	</form>

				</div><!-- /.navbar-collapse -->
			</div><!-- /.container-fluid -->
		</nav>
	</header>
	
	<div class="wrapper">
	    <div id="content">
	        <jsp:invoke fragment="content"></jsp:invoke>
		</div>
	</div>
    <div class="wrapper">
		<footer id="footer">
			<address>
			    <strong>HealthTrack</strong><br>
			    Avenida Ernesto Igel, 307, Vila Leopoldina<br>
			    São Paulo, SP<br>
			    Tel: (11) xxxx-xxxx ou xxxx-xxxx
			</address>
			<address>
		     Email: contato@healthtrack.com.br
			</address>
		</footer>
	</div>
<!-- 	<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
	<script type="text/javascript" src="resources\js\jquery-3.2.1.js"></script>
	<script type="text/javascript" src="resources\js\bootstrap.min.js"></script>
	<script type="text/javascript" src="resources\js\scroll.js"></script>
	<script type="text/javascript" src="resources\js\jquery.easing.min.js"></script>
   	<script type="text/javascript">
    $(document).ready(function () {
        $('#sidebarCollapse').on('click', function () {
            $('#sidebar').toggleClass('active');
        });
    });
	</script>
</body>
</html>

