<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="dashboard" tagdir="/WEB-INF/tags"%>
<dashboard:templateDashboard title="Dashboard">
	<jsp:attribute name="content">
	    
		<ol class="breadcrumb">
		  	<li><a href="index.jsp">Home</a></li>
		  	<li class="active">Dashboard</li>
		</ol>
	
		<div class="line"></div>
	
        <div id="page-wrapper">
           
        <div class="jumbotron">
            <div class="container-fluid">
                <h1>Dashboard</h1>
                <p>Analise e acompanhe seus dados</p>
            </div>
        </div>
        
        <div class="line"></div>
        
        <!-- /.row -->
        <div class="row">
            <!--1-->
            <div class="col-lg-3 col-md-6">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <div class="row">
                            <div class="col-xs-3">
                                <div><h3>Último Peso</h3></div>
                            </div>
                            <div class="col-xs-9 text-right">
                                <div class="huge">80</div>
                                <div>Kg</div>
                            </div>
                        </div>
                    </div>
                    <a href="#link para peso aqui"></a>
                    <div class="panel-footer">
                        <span class="pull-left">Detalhes</span>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>
            
            <!--2-->
            <div class="col-lg-3 col-md-6">
                <div class="panel panel-success">
                    <div class="panel-heading">
                        <div class="row">
                            <div class="col-xs-3">
                                <div><h3>Último Pressão</h3></div>
                            </div>
                            <div class="col-xs-9 text-right">
                                <div class="huge">12/8</div>
                                <div>mmHg</div>
                            </div>
                        </div>
                    </div>
                    <a href="#link para peso aqui"></a>
                    <div class="panel-footer">
                        <span class="pull-left">Detalhes</span>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>

            <!--3-->
            <div class="col-lg-3 col-md-6">
                <div class="panel panel-warning">
                    <div class="panel-heading">
                        <div class="row">
                            <div class="col-xs-3">
                                <div><h3>IMC</h3></div>
                            </div>
                            <div class="col-xs-9 text-right">
                                <div class="huge">24,48</div>
                                <div>.</div>
                            </div>
                        </div>
                    </div>
                    <a href="#link para peso aqui"></a>
                    <div class="panel-footer">
                        <span class="pull-left">Detalhes</span>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>                
            
            <!--4-->
            <div class="col-lg-3 col-md-6">
                <div class="panel panel-danger">
                    <div class="panel-heading">
                        <div class="row">
                            <div class="col-xs-3">
                                <div><h3>Calorias Perdidas</h3></div>
                            </div>
                            <div class="col-xs-9 text-right">
                                <div class="huge">400</div>
                                <div>cal</div>
                            </div>
                        </div>
                    </div>
                    <a href="#link para peso aqui"></a>
                   <div class="panel-footer">
                       <span class="pull-left">Detalhes</span>
                       <div class="clearfix"></div>
                   </div>
                </div>
            </div>
        </div>

		<div class="line"></div>
		
        <div class="container-fluid" id="container-dicas">
            <h2>Gráficos</h2>
        </div>
        
		<div class="line"></div>
                
        <section class="container-fluid" id="graficos">
            <div class="row">
                <div class="col-sm-6 col-md-4">
                    <figure class="thumbnail">
                       <img src="resources/img/graficos/ascending_640.png" alt="Grafico">
                    </figure>
                </div>
                <div class="col-sm-6 col-md-4">
                    <figure class="thumbnail">
                        <img src="resources/img/graficos/chart_640.png" alt="Grafico">
                    </figure>
                </div>
                <div class="col-sm-6 col-md-4">
                    <figure class="thumbnail">
                        <img src="resources/img/graficos/pie-chart_640.jpg" alt="Grafico">
                    </figure>
                </div>
            </div>
        </section>            
    
    </div>
    <!-- /#page-wrapper -->

	</jsp:attribute>
</dashboard:templateDashboard>