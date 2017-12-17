<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="test.utils.datainfo" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>电力公司收费管理信息系统</title>

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
        
         <li class="active"><a href="index.jsp"><span class="glyphicon glyphicon-list-alt"></span> 系统信息状态</a></li> 
   
   <li ><a href="1.jsp"><span class="glyphicon glyphicon-list-alt"></span> 客户信息管理</a></li>              
                <li ><a href="my.jsp"><span class="glyphicon glyphicon-list-alt"></span> 测试页面</a></li> 
                
				<ul class="children collapse" id="sub-item-1">
					<li>
						<a class="" href="#">
							<span class="glyphicon glyphicon-share-alt"></span> Sub Item 1
						</a>
					</li>
					<li>
						<a class="" href="#">
							<span class="glyphicon glyphicon-share-alt"></span> Sub Item 2
						</a>
					</li>
					<li>
						<a class="" href="#">
							<span class="glyphicon glyphicon-share-alt"></span> Sub Item 3
						</a>
					</li>
				</ul>
			</li>




			<li role="presentation" class="divider"></li>
			<li><a href="login.jsp"><span class="glyphicon glyphicon-user"></span>管理员登录</a></li>
			<%
				String a1="0";

				//获取客户端保存的最后访问时间
				Cookie[] cookies = request.getCookies();//获取客户端的所有Cookie对象

				for (int i = 0;cookies!=null && i < cookies.length; i++) {
					if("lastAccessTime".equals(cookies[i].getName())){//判断当前Cookie中的name是否是想要的cookie
						long l = Long.parseLong(cookies[i].getValue());//如果是想要的Cookie，则把Cookie中的value取出

						a1=("你的最后访问时间为："+new Date(l).toLocaleString());//yyyy-MM-dd
					}
				}

				//创建cookie，
				Cookie ck = new Cookie("lastAccessTime",System.currentTimeMillis()+"");
				//设置cookie的有效时间,单位是秒
				ck.setMaxAge(60*5);//保存时间为5分钟
				//设置cookie的path
				//ck.setPath("/day10_00_cookie");
				//ck.setPath(request.getContextPath());//  /day10_00_cookie
				ck.setPath("/");//  /day10_00_cookie
				//把cookie信息写回到客户端
				response.addCookie(ck);
			%>

			<li><a><span></span><%out.write(a1); %>	</a></li>

		</ul>
        
        
        
		<div class="attribution">电力公司收费管理信息系统</div>
	</div>
		
        
       <!--网页内容主体！！！！！--> 
    
       
        <!--当前页面标题-->   
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">系统状态信息</li>
			</ol>
		</div><!--/.row-->
        
         <!--网页内容！！！！--> 
		
<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">系统概况</h1>
			</div>
		</div><!--/.row-->
									
		<div class="row">
			<div class="col-xs-12 col-md-6 col-lg-3">
				<div class="panel panel-blue panel-widget ">
					<div class="row no-padding">
						<div class="col-sm-3 col-lg-5 widget-left">
							<em class="glyphicon glyphicon-user glyphicon-l"></em>
						</div>
						<div class="col-sm-9 col-lg-7 widget-right">
							<div class="large">0</div>
							<div class="text-muted">未使用</div>
						</div>
					</div>
				</div>
			</div>
			
            
            
			<div class="col-xs-12 col-md-6 col-lg-3">
				<div class="panel panel-orange panel-widget">
					<div class="row no-padding">
						<div class="col-sm-3 col-lg-5 widget-left">
							<em class="glyphicon glyphicon-transfer glyphicon-l"></em>
						</div>
						<div class="col-sm-9 col-lg-7 widget-right">
							<div class="large">0</div>
							<div class="text-muted">未使用</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-xs-12 col-md-6 col-lg-3">
				<div class="panel panel-teal panel-widget">
					<div class="row no-padding">
						<div class="col-sm-3 col-lg-5 widget-left">
							<em class="glyphicon glyphicon-ok glyphicon-l"></em>
						</div>
						<div class="col-sm-9 col-lg-7 widget-right">
							<div class="large">0</div>
							<div class="text-muted">未使用</div>
						</div>
					</div>
				</div>
			</div>
            
            <% String a;
				a=datainfo.getdatainfo(request,response) ; %>



			<div class="col-xs-12 col-md-6 col-lg-3">
				<div class="panel panel-red panel-widget">
					<div class="row no-padding">
						<div class="col-sm-3 col-lg-5 widget-left">
							<em class="glyphicon glyphicon-remove glyphicon-l"></em>
						</div>
						<div class="col-sm-9 col-lg-7 widget-right">
							<div class="large"><%out.write(a);%></div>
							<div class="text-">用电类型</div>
						</div>
					</div>
				</div>
			</div>
		</div><!--/.row-->   		
		
		
		
			

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
