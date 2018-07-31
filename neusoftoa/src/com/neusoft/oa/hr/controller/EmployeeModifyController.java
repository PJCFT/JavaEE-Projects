package com.neusoft.oa.hr.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.oa.hr.factory.ServiceFactory;
import com.neusoft.oa.hr.model.EmployeeModel;
import com.neusoft.oa.hr.service.IEmployeeService;

/**
 * Servlet implementation class EmployeeModifyController
 */
@WebServlet(description = "员工修改操作", urlPatterns = { "/employee/modify.do" })
public class EmployeeModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IEmployeeService employeeService = null;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		employeeService = ServiceFactory.createEmployeeService();
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		
		int no;
		String sno = request.getParameter("no");
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String sage = request.getParameter("age");
		String sbirthday = request.getParameter("birthday");
		String ssalary = request.getParameter("salary");
		String desc = request.getParameter("desc");
		
		try {
			if(sno == null || sno.equals("")) {
				response.sendRedirect("tolistbyall.do");
				return;
			}
			no = Integer.parseInt(sno);
			
			if(code == null || code.equals("")) {
				response.sendRedirect("tomodify.do?no="+no);
				
				return;
			}
			if(name == null || name.equals("")) {
				response.sendRedirect("tomodify.do?no="+no);
				return;
			}
			if(sage == null || sage.equals("")) {
				response.sendRedirect("tomodify.do?no="+no);
				return;
			}
			if(ssalary == null || ssalary.equals("")) {
				response.sendRedirect("tomodify.do?no="+no);
				return;
			}
			if(sbirthday == null || sbirthday.equals("")) {
				response.sendRedirect("tomodify.do?no="+no);
				return;
			}
			//类型转换
			int age = Integer.parseInt(sage);
			double salary = Double.parseDouble(ssalary);
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date birthday = df.parse(sbirthday);
			//创建model对象
			EmployeeModel employee = new EmployeeModel();
			
			employee.setNo(no);
			employee.setCode(code);
			employee.setName(name);
			employee.setSex(sex);
			employee.setAge(age);
			employee.setSalary(salary);
			employee.setBirthday(birthday);
			employee.setDesc(desc);
			
			//进行更新操作
			employeeService.modify(employee);
			
			//跳转到指定的View对象
			response.sendRedirect("tolistbyall.do");
		}catch(Exception e) {
			e.printStackTrace();
			response.sendRedirect("../error/error.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
