<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="style/css/ch-ui.admin.css">
    <link rel="stylesheet" href="style/font/css/font-awesome.min.css">
    <script type="text/javascript" src="style/js/jquery.js"></script>
    <script type="text/javascript" src="style/js/ch-ui.admin.js"></script>
    <script type="text/javascript" src="style/js/layer/layer.js"></script>
</head>
<body>
<!--头部 开始-->
<div class="top_box">
	<div class="top_left">
		<div class="logo">OA自动化管理系统</div>
		<ul>
			<li><a href="#" class="active">首页</a></li>
			<li><a href="#" target="main">管理页</a></li>
		</ul>
	</div>
	<div class="top_right">
		<ul>
			<li>管理员：admin</li>
			<li><a href="#" target="main">修改密码</a></li>
			<li><a href="#">退出</a></li>
		</ul>
	</div>
</div>
<!--头部 结束-->

<!--左侧导航 开始-->
<div class="menu_box">
	<ul>
		<li>
			<h3><i class="fa fa-fw fa-clipboard"></i>部门管理</h3>
			<ul class="sub_menu">
				<li><a href="<%=request.getContextPath()+"/employee/tolistbyall.do"%>" target="main"><i class="fa fa-fw fa-plus-square"></i>员工列表</a></li>
				<li><a href="#" target="main"><i class="fa fa-fw fa-list-ul"></i>添加员工</a></li>
			</ul>
		</li>
		<li>
			<h3><i class="fa fa-fw fa-clipboard"></i>员工管理</h3>
			<ul class="sub_menu">
				<li><a href="<%=request.getContextPath()+"/employee/tolistbyall.do"%>" target="main"><i class="fa fa-fw fa-list-ul"></i>所有员工列表</a></li>
				<li><a href="<%=request.getContextPath()+"/employee/tolistbyagescope.do"%>" target="main"><i class="fa fa-fw fa-list-ul"></i>按年龄检索员工</a></li>
				<li><a href="<%=request.getContextPath()+"/employee/toadd.do"%>" target="main"><i class="fa fa-fw fa-plus-square"></i>添加员工</a></li>
				

			</ul>
		</li>
		<li>
			<h3><i class="fa fa-fw fa-clipboard"></i>级别管理</h3>
			<ul class="sub_menu">
				<li><a href="#" target="main"><i class="fa fa-fw fa-list-ul"></i>文章列表</a></li>
				<li><a href="#" target="main"><i class="fa fa-fw fa-plus-square"></i>添加文章</a></li>

			</ul>
		</li>
		<li>
			<h3><i class="fa fa-fw fa-clipboard"></i>友情链接管理</h3>
			<ul class="sub_menu">
				<li><a href="#" target="main"><i class="fa fa-fw fa-list-ul"></i>友情链接列表</a></li>
				<li><a href="#" target="main"><i class="fa fa-fw fa-plus-square"></i>添加友情链接</a></li>

			</ul>
		</li>
		<li>
			<h3><i class="fa fa-fw fa-clipboard"></i>自定义导航管理</h3>
			<ul class="sub_menu">
				<li><a href="#" target="main"><i class="fa fa-fw fa-list-ul"></i>导航列表</a></li>
				<li><a href="#" target="main"><i class="fa fa-fw fa-plus-square"></i>添加自定义导航</a></li>

			</ul>
		</li>
		<li>
			<h3><i class="fa fa-fw fa-cog"></i>网站配置</h3>
			<ul class="sub_menu">
				<li><a href="#" target="main"><i class="fa fa-fw fa-cubes"></i>网站配置列表</a></li>
				<li><a href="#" target="main"><i class="fa fa-fw fa-list-ul"></i>添加配置项</a></li>
				<li><a href="#" target="main"><i class="fa fa-fw fa-database"></i>备份还原</a></li>
			</ul>
		</li>
	</ul>
</div>
<!--左侧导航 结束-->

<!--主体部分 开始-->
<div class="main_box">
	<iframe src="./employee/listbyall.jsp" frameborder="0" width="100%" height="100%" name="main"></iframe>
</div>
<!--主体部分 结束-->

<!--底部 开始-->
<div class="bottom_box">
	CopyRight © 2018. Powered By PJC.
</div>
<!--底部 结束-->
</body>
</html>