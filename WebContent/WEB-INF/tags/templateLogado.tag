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
	<!--Custom Font-->
	<link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
	<!--[if lt IE 9]>
	<script src="js/html5shiv.js"></script>
	<script src="js/respond.min.js"></script>
	<![endif]-->
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
					<!-- <ul class="nav navbar-top-links navbar-right">
						<li class="dropdown"><a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
							<em class="fa fa-envelope"></em><span class="label label-danger">15</span>
						</a>
							<ul class="dropdown-menu dropdown-messages">
								<li>
									<div class="dropdown-messages-box"><a href="profile.html" class="pull-left">
										<img alt="image" class="img-circle" src="http://placehold.it/40/30a5ff/fff">
										</a>
										<div class="message-body"><small class="pull-right">3 mins ago</small>
											<a href="#"><strong>John Doe</strong> commented on <strong>your photo</strong>.</a>
										<br /><small class="text-muted">1:24 pm - 25/03/2015</small></div>
									</div>
								</li>
								<li class="divider"></li>
								<li>
									<div class="dropdown-messages-box"><a href="profile.html" class="pull-left">
										<img alt="image" class="img-circle" src="http://placehold.it/40/30a5ff/fff">
										</a>
										<div class="message-body"><small class="pull-right">1 hour ago</small>
											<a href="#">New message from <strong>Jane Doe</strong>.</a>
										<br /><small class="text-muted">12:27 pm - 25/03/2015</small></div>
									</div>
								</li>
								<li class="divider"></li>
								<li>
									<div class="all-button"><a href="#">
										<em class="fa fa-inbox"></em> <strong>All Messages</strong>
									</a></div>
								</li>
							</ul>
						</li>
						<li class="dropdown"><a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
							<em class="fa fa-bell"></em><span class="label label-info">5</span>
						</a>
							<ul class="dropdown-menu dropdown-alerts">
								<li><a href="#">
									<div><em class="fa fa-envelope"></em> 1 New Message
										<span class="pull-right text-muted small">3 mins ago</span></div>
								</a></li>
								<li class="divider"></li>
								<li><a href="#">
									<div><em class="fa fa-heart"></em> 12 New Likes
										<span class="pull-right text-muted small">4 mins ago</span></div>
								</a></li>
								<li class="divider"></li>
								<li><a href="#">
									<div><em class="fa fa-user"></em> 5 New Followers
										<span class="pull-right text-muted small">4 mins ago</span></div>
								</a></li>
							</ul>
						</li>
					</ul> -->
				</div>
			</div><!-- /.container-fluid -->
		</nav>
	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<div class="profile-sidebar">
			<div class="profile-userpic">
				<img src="http://placehold.it/50/30a5ff/fff" class="img-responsive" alt="">
			</div>
			<div class="profile-usertitle">
			
			    <c:if test="${not empty user }">
			   		<div class="profile-usertitle-name">${user }</div>
			    </c:if>	
			    
				<div class="profile-usertitle-status"><span class="indicator label-success"></span>Online</div>
			</div>
			<div class="clear"></div>
		</div>
		<div class="divider"></div>
<!-- 		<form role="search">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Search">
			</div>
		</form> -->
		<ul class="nav menu">
			<li><a href="dashboard.jsp"><em class="fa fa-dashboard">&nbsp;</em> Dashboard</a></li>
			<li><a href="atividade.jsp"><em class="fa fa-calendar">&nbsp;</em> Atividade</a></li>
			<li><a href="alimentacao.jsp"><em class="fa fa-bar-chart">&nbsp;</em> Alimentação</a></li>
			<li><a href="peso.jsp"><em class="fa fa-toggle-off">&nbsp;</em> Peso</a></li>
			<li><a href="pressao.jsp"><em class="fa fa-clone">&nbsp;</em> Pressão</a></li>
			<!-- <li class="parent "><a data-toggle="collapse" href="#sub-item-1">
				<em class="fa fa-navicon">&nbsp;</em> Multilevel <span data-toggle="collapse" href="#sub-item-1" class="icon pull-right"><em class="fa fa-plus"></em></span>
				</a>
				<ul class="children collapse" id="sub-item-1">
					<li><a class="" href="#">
						<span class="fa fa-arrow-right">&nbsp;</span> Sub Item 1
					</a></li>
					<li><a class="" href="#">
						<span class="fa fa-arrow-right">&nbsp;</span> Sub Item 2
					</a></li>
					<li><a class="" href="#">
						<span class="fa fa-arrow-right">&nbsp;</span> Sub Item 3
					</a></li>
				</ul>
			</li> -->
		    <c:if test="${not empty user }">
				<li><a href="logar"><em class="fa fa-power-off">&nbsp;</em> Sair</a></li>
		    </c:if>
		</ul>
	</div><!--/.sidebar-->
	
	
	
	
		<%-- <nav class="navbar navbar-default navbar-fixed-top blue">
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
				
				<!-- Parte da Esquerda -->	
				<c:if test="${empty user }">
		    		<ul class="nav navbar-nav blue">
			      		<li><a href="index.jsp" class="page-scroll blue">Home</a></li>
			      		<li><a href="#footer" class="page-scroll blue">Contato</a></li>
			      		<li><a class="page-scroll blue" href="cadastro.jsp">Cadastrar</a></li>
		      		</ul>
		      	</c:if>	
		      	
		      	<c:if test="${not empty user }">
		      		<ul class="nav navbar-nav blue">
			      		<li><a href="index.jsp" class="page-scroll blue">Home</a></li>
			      		<li><a href="dashboard.jsp" class="page-scroll blue">Dashboard</a></li>
			      		<li><a href="atividade.jsp" class="page-scroll blue">Atividade</a></li>
			      		<li><a href="alimentacao.jsp" class="page-scroll blue">Alimentação</a></li>
			      		<li><a href="peso.jsp" class="page-scroll blue">Peso</a></li>
			      		<li><a href="pressao.jsp" class="page-scroll blue">Pressão</a></li>
		      		</ul>
		      	</c:if>
		      	
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
	    <div id="content" class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
	        <jsp:invoke fragment="content"></jsp:invoke>
		</div>
	</div>
<!--     <div class="wrapper">
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
	</div> -->
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

