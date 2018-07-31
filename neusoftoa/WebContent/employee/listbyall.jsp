<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" href="../style/css/ch-ui.admin.css">
	<link rel="stylesheet" href="../style/font/css/font-awesome.min.css">
	<link rel="stylesheet" href="../style/css/common.css">
    <link rel="stylesheet" href="../style/css/index.css">
    <script type="text/javascript" src="../style/js/jquery.js"></script>
    <script type="text/javascript" src="../style/js/ch-ui.admin.js"></script>
    <script type="text/javascript" src="../style/js/jquery-1.10.2.min.js"></script>
</head>
<body>
    <!--面包屑导航 开始-->
    <div class="crumb_warp">
        <!--<i class="fa fa-bell"></i> 欢迎使用登陆网站后台，建站的首选工具。-->
        <i class="fa fa-home"></i> <a href="#">首页</a> &raquo; <a href="#">部门管理</a> &raquo; 员工列表
    </div>
    <!--面包屑导航 结束-->

	<!-- 结果页快捷搜索框 开始
	<div class="search_wrap">
	        <form action="" method="post">
	            <table class="search_tab">
	                <tr>
	                    <th width="120">选择分类:</th>
	                    <td>
	                        <select onchange="javascript:location.href=this.value;">
	                            <option value="">全部</option>
	                            <option value="http://www.baidu.com">百度</option>
	                            <option value="http://www.sina.com">新浪</option>
	                        </select>
	                    </td>
	                    <th width="70">关键字:</th>
	                    <td><input type="text" name="keywords" placeholder="关键字"></td>
	                    <td><input type="submit" name="sub" value="查询"></td>
	                </tr>
	            </table>
	        </form>
	    </div> -->
    <!--结果页快捷搜索框 结束-->

    <!-- 搜索结果页面 列表 开始
    <form action="#" method="post">
        <div class="result_wrap">
            快捷导航 开始
            <div class="result_content">
                <div class="short_wrap">
                    <a href="#"><i class="fa fa-plus"></i>新增文章</a>
                    <a href="#"><i class="fa fa-recycle"></i>批量删除</a>
                    <a href="#"><i class="fa fa-refresh"></i>更新排序</a>
                </div>
            </div>
            快捷导航 结束
      </div>
     -->
        <div class="result_wrap">
            <div class="result_content">
                <table class="list_tab">
                    <tr>
                        <th class="tc">员工编号</th>
                        <th class="tc">员工姓名</th>
                        <th class="tc">性别</th>
                        <th class="tc">年龄</th>
                        <th class="tc">工资</th>
                        <th class="text-center" width="14%">操作</th>
                    </tr>
                    <c:forEach var = "employee" items ="${employeeList}">
                    <tr>
                        <td class="tc">${employee.code}</td>
                        <td class="tc">${employee.name}</td>
                        <td class="tc">${employee.sex}</td>
                        <td class="tc">${employee.age}</td>
                        <td class="tc">${employee.salary}</td>
                        <td align="center">
                            <a href="tomodify.do?no=${employee.no}">修改</a>
                            <a href="delete.do?no=${employee.no }" class = "del">删除</a>
							<a href="toview.do?no=${employee.no }">查看</a>
                        </td>
                    </tr>
                    </c:forEach>
                </table>
		<div class="page_list" style="float:left">
			<a href="toadd.do">增加员工</a>
			员工个数：${count}	页数：${page}/${pageCount}
		</div>
		<div class="page_list" style="float:right">
			<ul>
				<li class="active"><a href="tolistbyall.do?page=1">首页</a></li>
				<li><a href="tolistbyall.do?page=${page-1}">上一页</a></li>
				<li><a href="tolistbyall.do?page=${page+1}">下一页</a></li>
				<li><a href="tolistbyall.do?page=${pageCount}">末页</a></li>
			</ul>
		</div>
    </div>
    </div>
    <!--搜索结果页面 列表 结束-->
</body>
<script type="text/javascript">
	$(function(){
		$('.del').on('click',function(){
			if(confirm('确认要删除该员工吗?')){
				window.location = $(this).attr('href');
			}
			return false;
		})
	})
</script>
</html>