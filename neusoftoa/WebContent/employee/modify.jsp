<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" href="../style/css/ch-ui.admin.css">
	<link rel="stylesheet" href="../style/font/css/font-awesome.min.css">
</head>
<body>
    <!--面包屑导航 开始-->
    <div class="crumb_warp">
        <!--<i class="fa fa-bell"></i> 欢迎使用登陆网站后台，建站的首选工具。-->
        <i class="fa fa-home"></i> <a href="#">首页</a> &raquo; <a href="#">员工管理</a> &raquo; 修改员工
    </div>
    <!--面包屑导航 结束-->

	<!--结果集标题与导航组件 开始-->
    
    <div class="result_wrap">
        <form action="modify.do" method="post">
            <table class="add_tab">
                <tbody>
                    <tr>
                        <th><i class="require">*</i>员工编码：</th>
                        <td>
                            <input type="text" name="code" value="${employeebyno.code }">
                            <span><i class="fa fa-exclamation-circle yellow"></i>员工编号不能为空</span>
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require">*</i>员工姓名：</th>
                        <td>
                            <input type="text" name="name" value="${employeebyno.name }">
                            <span><i class="fa fa-exclamation-circle yellow"></i>员工姓名不能为空</span>
                        </td>
                    </tr>
                    <tr>
                        <th width="120"><i class="require">*</i>员工性别：</th>
                        <td>
                        <c:if test="${employeebyno.sex=='男' }">
                            <label for=""><input type="radio" name="sex" value="男" checked="checked">男</label>
                            <label for=""><input type="radio" name="sex" value="女">女</label>
                        </c:if>
                        <c:if test="${employeebyno.sex=='女' }">
                        	<label for=""><input type="radio" name="sex" value="男">男</label>
                            <label for=""><input type="radio" name="sex" value="女" checked="checked">女</label>
                        </c:if>
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require">*</i>员工年龄：</th>
                        <td>
                            <input type="text" name="age" value="${employeebyno.age }">
                            <span><i class="fa fa-exclamation-circle yellow"></i>员工年龄不能为空</span>
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require">*</i>员工工资：</th>
                        <td>
                            <input type="text" name="salary" value="${employeebyno.salary }">
                            <span><i class="fa fa-exclamation-circle yellow"></i>员工工资不能为空</span>
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require">*</i>员工生日：</th>
                        <td>
                            <input type="text" name="birthday" value="${employeebyno.birthday }">
                            <span><i class="fa fa-exclamation-circle yellow"></i>员工生日格式为：2018-07-30</span>
                        </td>
                    </tr>
                    <tr>
                        <th>员工简历：</th>
                        <td>
                            <textarea class="lg" name="desc">${employeebyno.desc }</textarea>
                            <span><i class="fa fa-exclamation-circle yellow"></i>简历字数在500个字以内</span>
                        </td>
                    </tr>
                    <tr>
                        <th></th>
                        <td>
                        	<input type="hidden" name = "no" value="${employeebyno.no }">
                            <input type="submit" value="提交">
                            <input type="button" class="back" onclick="history.go(-1)" value="返回">
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
    </div>

</body>
</html>