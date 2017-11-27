<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="title" required="true" rtexprvalue="true"%>
<%@ attribute name="content" fragment="true"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${title }</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources\css\custom.css">
	<link rel="stylesheet" type="text/css" href="resources\css\estilos.css">
    <link rel="stylesheet" type="text/css" href="resources\css\dashboard.css">
</head>
<body>
	<div class="wrapper">
   	<!-- Sidebar Holder -->
	    <nav id="sidebar">
	        <div class="sidebar-header" id="sidebarCollapse">
	            <h3>Health Track</h3>
	            <strong>HT</strong>
	        </div>
	
	        <ul class="list-unstyled components">
	            <li class="active">
	                <a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false">
	                    <i class="glyphicon glyphicon-home"></i>
	                    Home
	                </a>
	                <ul class="collapse list-unstyled" id="homeSubmenu">
	                    <li><a href="index.jsp">Home</a></li>
	                </ul>
	            </li>
	            <li>
	                <a href="#">
	                    <i class="glyphicon glyphicon-briefcase"></i>
	                    About
	                </a>
	                <a href="#pageSubmenu" data-toggle="collapse" aria-expanded="false">
	                    <i class="glyphicon glyphicon-duplicate"></i>
	                    Pages
	                </a>
	                <ul class="collapse list-unstyled" id="pageSubmenu">
	                   	    <li><a href="dashboard.jsp">Dashboard</a></li>
	                        <li><a href="alimentacao.jsp">Alimentação</a></li>
	                        <li><a href="atividade.jsp">Atividade Física</a></li>
	                        <li><a href="pressao.jsp">Pressão Arterial</a></li>
	                        <li><a href="peso.jsp">Peso</a></li>
	                        <li><a href="perfil.jsp">Meu Perfil</a></li>
	                </ul>
	            </li>
	            <li>
	                <a href="#">
	                    <i class="glyphicon glyphicon-link"></i>
	                    Portfolio
	                </a>
	            </li>
	            <li>
	                <a href="#">
	                    <i class="glyphicon glyphicon-paperclip"></i>
	                    FAQ
	                </a>
	            </li>
	            <li>
	                <a href="#">
	                    <i class="glyphicon glyphicon-send"></i>
	                    Contact
	                </a>
	            </li>
	        </ul>
	    </nav>

    <!-- Page Content Holder -->
	    <div id="content">
	        <nav class="navbar navbar-default">
	            <div class="container-fluid">
	                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	                    <ul class="nav navbar-nav navbar-right">
	                   	    <li><a href="dashboard.jsp">Dashboard</a></li>
	                        <li><a href="alimentacao.jsp">Alimentação</a></li>
	                        <li><a href="atividade.jsp">Atividade Física</a></li>
	                        <li><a href="pressao.jsp">Pressão Arterial</a></li>
	                        <li><a href="peso.jsp">Peso</a></li>
	                    </ul>
	                </div>
	            </div>
	        </nav>
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
	<!-- <script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
	
	<script type="text/javascript" src="resources\js\jquery-3.2.1.js"></script>
	<script type="text/javascript" src="resources\js\bootstrap.min.js"></script>
	<script type="text/javascript" src="resources\js\scroll.js"></script>
   	<script type="text/javascript">
    $(document).ready(function () {
        $('#sidebarCollapse').on('click', function () {
            $('#sidebar').toggleClass('active');
        });
    });
	</script>
</body>
</html>

