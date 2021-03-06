<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="title" required="true" rtexprvalue="true"%>
<%@ attribute name="content" fragment="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${title }</title>
        <link href="resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="resources/css/font-awesome.min.css" rel="stylesheet">
	<link href="resources/css/datepicker3.css" rel="stylesheet">
	<link href="resources/css/styles.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="resources/css/customCL.css">
	<!--Custom Font-->
	<link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
	<!--[if lt IE 9]>
	<script src="js/html5shiv.js"></script>
	<script src="js/respond.min.js"></script>
	<![endif]-->
	<link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Catamaran:100,200,300,400,500,600,700,800,900" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Muli" rel="stylesheet">
</head>
<body>
	<header>
		<nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse"><span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span></button>
						<a class="navbar-brand" href="#"><span>Health</span>Track</a>
						<ul class="nav navbar-nav">
				        	<li class="active" style="padding-top: 5px"><a href="cadastro.jsp">Cadastre-se <span class="sr-only">(current)</span></a></li>
						</ul>
				      	
				      	<c:if test="${empty user }">
				      		
					    	<span class="navbar-text navbar-top-links text-danger">
					    		${erroLogin }
					      	</span> 
					      	
							<form class="form-inline nav navbar-top-links navbar-right" action="logar" method="post">
							<div class="form-group" style="padding-top: 5px;">
					      		<input class="form-control mr-sm-2" type="text" name="email" placeholder="E-mail">
					        	<input class="form-control mr-sm-2" type="password" name="senha" placeholder="Senha">
					        	<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Entrar</button>
					        </div>
					      	</form>
						</c:if>
				</div>
			</div><!-- /.container-fluid -->
		</nav>
		<%-- <%-- <nav class="navbar navbar-default navbar-fixed-top blue">
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
			      		<li><a href="index.jsp" class="page-scroll blue">Home</a></li>
			      		<li><a href="#footer" class="page-scroll blue">Contato</a></li>
			      		<li><a class="page-scroll blue" href="cadastro.jsp">Cadastrar</a></li>
		      		</ul>
		      		
		      	<!-- Parte da Direita -->	
		      	<c:if test="${empty user }">
			    	<span class="navbar-text text-danger" style="margin-right:10px" >
			    		${erroLogin }
			      	</span> 
			      	
				<form class="form-inline nav navbar-nav navbar-right" action="logar" method="post">
		      		<input class="form-control mr-sm-2" type="text" name="email" placeholder="E-mail">
		        	<input class="form-control mr-sm-2" type="password" name="senha" placeholder="Senha">
		        	<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Entrar</button>
		      	</form>
				</c:if>
			    <c:if test="${not empty user }">
					<span class="navbar-text navbar-right">
			    		${user }
			        	<a href="logar" class="btn btn-outline-primary my-2 my-sm-0">Sair</a>
			      	</span> 
			    </c:if>	
		      		
				</div><!-- /.navbar-collapse -->
			</div><!-- /.container-fluid -->
		</nav> --%>
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

