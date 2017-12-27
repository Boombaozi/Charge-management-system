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
						<a class="" href="${pageContext.request.contextPath}/web/clientlist">
							<span class="glyphicon glyphicon-edit"></span>客户信息管理
						</a>
					</li>

					<li>
						<a class="" href="${pageContext.request.contextPath}/web/elist">
							<span class="glyphicon glyphicon-edit"></span>业务员管理
						</a>
					</li>
					<li>
						<a class="" href="${pageContext.request.contextPath}/web/einfolist">
							<span class="glyphicon glyphicon-edit"></span>客户用电信息管理
						</a>
					</li>
					<li>
						<a class="" href="${pageContext.request.contextPath}/web/pmlist">
							<span class="glyphicon glyphicon-edit"></span>客户用电费用管理
						</a>
					</li>


					<li>

						<a class="" href="${pageContext.request.contextPath}/web/etypelist">
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
		
        
       <!--网页内容主体！！！！！--> 
    
       
        <!--当前页面标题-->   
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">客户信息</li>
			</ol>
		</div><!--/.row-->
        
         <!--网页内容！！！！--> 
		
<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">客户信息管理</h1>
			</div>
		</div><!--/.row-->

		<!--表格主体开始-->
		<div class="panel panel-default">
			<div class="panel-heading">
				<!--表格头部-->
				<div class="pull-left">
					<button class="btn btn-success glyphicon glyphicon-plus" data-toggle="modal" data-target="#add1">New</button>
					<button class="btn btn-primary glyphicon glyphicon-upload"data-toggle="modal" data-target="#updata1">update</button>
					<button class="btn btn-danger glyphicon glyphicon-trash"data-toggle="modal" data-target="#delete1">Delete</button>
				</div>
			</div>

			<div class="table-responsive">

				<table class="table">

					<thead>
					<tr>
						<th>客户号</th>
						<th>姓名</th>
						<th>地址</th>
						<th>联系电话</th>
						<th>账户余额</th>
						<th>最后修改时间</th>
					</tr>
					</thead>
					<tbody>
					<c:forEach items="${client}" var="cl">
						<tr>
							<td>${cl.cno}</td>
							<td>${cl.cname}</td>
							<td>${cl.addr}</td>
							<td>${cl.ctel}</td>
							<td>${cl.money}</td>
							<td>${cl.create_at}</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>


			</div>


		</div>
		<!--表格主体结束-->



		<!--添加功能弹出狂主体-->
		<div class="modal fade" id="add1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>

					</div>
					<div class="modal-body">
						<div class="login-panel panel panel-default">
							<div class="panel-heading">添加用电类型</div>
							<div class="panel-body">


								<form role="form" action="${pageContext.request.contextPath }/web/clientadd" method="post">

										<div class="form-group">
											<input class="form-control" placeholder="客户号" name="cno" type="text" >
										</div>
										<div class="form-group">
											<input class="form-control" placeholder="姓名" name="cname" type="text" >
										</div>
										<div class="form-group">
											<input class="form-control" placeholder="地址" name="addr" type="text" >
										</div>
										<div class="form-group">
											<input class="form-control" placeholder="联系电话" name="ctel" type="text" >
										</div>


										<input type="submit" class="btn btn-primary" value="增加">


								</form>


							</div>
						</div>




					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary">Save</button>
					</div>
				</div>
			</div>
		</div>
		<!--弹出框结束-->

		<!--删除功能弹出狂主体-->
		<div class="modal fade" id="delete1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">

					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>

					</div>
					<div class="modal-body">
						<div class="login-panel panel panel-default">
							<div class="panel-heading">请输入要删除的id</div>
							<div class="panel-body">


								<form role="form" action="${pageContext.request.contextPath }/web/clientdelete" method="post">

										<div class="form-group">
											<input class="form-control" placeholder="客户号" name="cno" type="text" >
										</div>


										<input type="submit" class="btn btn-primary" value="删除">


								</form>


							</div>
						</div>




					</div>
					<div class="modal-footer">

						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>

					</div>
				</div>
			</div>
		</div>
		<!--弹出框结束-->

		<!--更新功能弹出狂主体-->
		<div class="modal fade" id="updata1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">

					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>

					</div>
					<div class="modal-body">
						<div class="login-panel panel panel-default">
							<div class="panel-heading">请输入正确的序号进行更新</div>
							<div class="panel-body">


								<form role="form" action="${pageContext.request.contextPath }/web/clientupdate" method="post">

										<div class="form-group">
											<input class="form-control" placeholder="客户号" name="cno" type="text" >
										</div>
										<div class="form-group">
											<input class="form-control" placeholder="姓名" name="cname" type="text" >
										</div>
										<div class="form-group">
											<input class="form-control" placeholder="地址" name="addr" type="text" >
										</div>
										<div class="form-group">
											<input class="form-control" placeholder="联系电话" name="ctel" type="text" >
										</div>
										6


										<input type="submit" class="btn btn-primary" value="更改">

								</form>


							</div>
						</div>




					</div>
					<div class="modal-footer">

						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>

					</div>
				</div>
			</div>
		</div>
		<!--弹出框结束-->

	</div><!--当前页面主题结束-->
		
		
			

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
