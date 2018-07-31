package com.neusoft.oa.hr.service;

import java.util.List;

import com.neusoft.oa.hr.model.EmployeeModel;

public interface IEmployeeService {
	public void add(EmployeeModel employee) throws Exception;
	public void modify(EmployeeModel employee) throws Exception;
	public void delete(EmployeeModel employee) throws Exception;
	
	//登录验证方法，验证员工是否合法
	public boolean validate(String code, String password) throws Exception;
	
	//更改员工密码的方法
	public void changePassword(int no, String password) throws Exception;
	
	//取得所有员工的列表，分页
	public List<EmployeeModel> getListByAllWithPage(int rows, int page) throws Exception;
	
	//取得年龄区间的员工的列表，分页
	public List<EmployeeModel> getListByAgeScopeWithPage(int low, int hight, int rows, int page) throws Exception;
	
	//取得所有员工的个数
	public int getCountByAll() throws Exception;
	
	//查询取得年龄区间的员工个数的方法
	public int getCountByAgeScope(int low, int hight) throws Exception;
	
	//查询所有员工的页数
	public int getPageCountByAll(int rows) throws Exception;
	
	//取得年龄区间内员工的页数
	public int getPageCountByAgeScope(int low, int hight, int rows) throws Exception;
	
	//取得单条数据
	public EmployeeModel selectByNo(int no) throws Exception;
	
}
