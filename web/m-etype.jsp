<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+'/';
%>


<!DOCTYPE html>
<html>
<head>

	<base href="<%=basePath%>">
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
				<a class="navbar-brand" href="#"><span>Charge</span>system</a>
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
        
         <li ><a href="index.jsp"><span class="glyphicon glyphicon-stats"></span> 系统概况</a></li>
   
   <li ><a href="#"><span class="glyphicon glyphicon-pencil"></span> 收费登记</a></li>
              
               
               
<li class="parent ">
			<a href="#">
	<span class="glyphicon glyphicon-list"></span>缴费情况<span data-toggle="collapse" href="#sub-item-1" class="icon pull-right"><em class="glyphicon glyphicon-s glyphicon-plus"></em></span> 
				</a>
				<ul class="children collapse" id="sub-item-1">
					<li>
						<a class="" href="#">
							<span class="glyphicon glyphicon-ban-circle"></span>欠费用户
						</a>
					</li>
                    
                    
				<li class="active">
						<a class="" href="#">
							<span class="glyphicon glyphicon-zoom-in"></span>未交费用户
						</a>
					</li>
					<li>
						<a class="" href="#">
							<span class="glyphicon glyphicon-stats"></span>费用统计
						</a>
					</li>
                  
				</ul>
			</li>  
                        
               
               
<li class="parent active">
			<a href="#">	
	<span class="glyphicon glyphicon-cog"></span> 信息管理 <span data-toggle="collapse" href="#sub-item-2" class="icon pull-right"><em class="glyphicon glyphicon-s glyphicon-plus"></em></span> 
				</a>
				<ul class="children collapse" id="sub-item-2">
					<li>
						<a class="" href="m-client.jsp">
							<span class="glyphicon glyphicon-edit"></span>客户管理
						</a>
					</li>
				
					<li>
						<a class="" href="m-e.jsp">
							<span class="glyphicon glyphicon-edit"></span>员工管理
						</a>
					</li>
                    	<li>
						<a class="" href="m-user.jsp">
							<span class="glyphicon glyphicon-edit"></span>管理员管理
						</a>
					</li>
                    
                    	<li>
                        
						<a class="" href="m-etype.jsp">
							<span class="glyphicon glyphicon-edit"></span>用电类型管理
						</a>
					</li>
				</ul>
			</li>


			<li role="presentation" class="divider"></li>
            
			<li><a href="login.jsp"><span class="glyphicon glyphicon-user"></span>切换用户</a></li>
			<li><a href="reg.jsp"><span class="glyphicon glyphicon-plus"></span>新增管理员</a></li>


			

			<li><a><span></span></a></li>

		</ul>
        
        
        
		<div class="attribution">电力公司收费管理信息系统</div>
	</div>

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
			 <h1 class="page-header">用电类型管理</h1>
		 </div>
	 </div><!--/.row-->
       <!--网页内容主体！！！！！-->
 <div class="table-responsive">
	 <table class="table">

		 <thead>
		 <tr>
			 <th>序号</th>
			 <th>类型</th>
			 <th>单价</th>
			 <th>最后修改时间</th>
		 </tr>
		 </thead>
		 <tbody>
<c:forEach items="${etypelist}" var="et">
<tr>
			 <td>${et.etno}</td>
			 <td>${et.etname}</td>
			 <td>${et.price}</td>
	          <td>${et.create_at}</td>

		 </tr>
</c:forEach>
		 </tbody>
	 </table>
 </div>




			

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
