<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Lumino - Dashboard</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/datepicker3.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">

<!--[if lt IE 9]>
<script src="js/html5shiv.js"></script>
<script src="js/respond.min.js"></script>
<![endif]-->

</head>

<body>



 <!--这是用户登录，退出--> 

	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><span>Charge</span> management system</a>
				<ul class="user-menu">
					<li class="dropdown pull-right">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span>管理员<span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							
							<li><a href="#"><span class="glyphicon glyphicon-log-out"></span> 退出</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</div><!-- /.container-fluid -->
	</nav>
		
        
        
        
  <!--这是搜索栏-->      
	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<form role="search">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="查找">
			</div>
		</form>
        
        
        
 <!--这是菜单列表-->       
		<ul class="nav menu">
        
         <li ><a href="index.jsp"><span class="glyphicon glyphicon-stats"></span> 系统信息状态</a></li> 
   
   <li ><a href="1.jsp"><span class="glyphicon glyphicon-list-alt"></span> 客户信息管理</a></li> 
    <li ><a href="index.jsp"><span class="glyphicon glyphicon-stats"></span>用电类型管理</a></li>
   
                <li class="active"><a href="my.jsp"><span class="glyphicon glyphicon-list-alt"></span> 测试页面</a></li>  
                    
				</ul>
                
                
			</li>
			<li role="presentation" class="divider"></li>
			<li><a href="login.jsp"><span class="glyphicon glyphicon-user"></span>管理员登录</a></li>
            
		</ul>
        
        
        
		<div class="attribution">电力公司收费管理信息系统</div>
	</div>
		
        
       <!--网页内容主体！！！！！--> 
       
       
        <!--当前页面标题-->   
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">测试页面</li>
			</ol>
		</div><!--/.row-->
        
         <!--网页内容！！！！--> 
		
		
		
		
		
			

	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/chart.min.js"></script>
	<script src="js/chart-data.js"></script>
	<script src="js/easypiechart.js"></script>
	<script src="js/easypiechart-data.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script>
		$('#calendar').datepicker({
		});

		!function ($) {
		    $(document).on("click","ul.nav li.parent > a > span.icon", function(){          
		        $(this).find('em:first').toggleClass("glyphicon-minus");      
		    }); 
		    $(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
		}(window.jQuery);

		$(window).on('resize', function () {
		  if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
		})
		$(window).on('resize', function () {
		  if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
		})
	</script>	
</body>

</html>
