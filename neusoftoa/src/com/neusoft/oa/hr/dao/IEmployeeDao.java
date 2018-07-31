package com.neusoft.oa.hr.dao;

import java.util.List;

import com.neusoft.oa.hr.model.EmployeeModel;

//员工的Dao接口
public interface IEmployeeDao {
	//增加
	public void create(EmployeeModel em) throws Exception;
	//修改
	public void update(EmployeeModel em) throws Exception;
	//删除
	public void delete(EmployeeModel em) throws Exception;
	//查询-取得所有员工的列表-无分页
	public List<EmployeeModel> selectListByAll() throws Exception;
	//查询-取得所有员工的列表-有分页,rows:每页显示的个数， page：第几页
	public List<EmployeeModel> selectListByAllWithPage(int rows, int page) throws Exception;
	//查询-取得指定年龄范围内的员工的列表--无分页
	public List<EmployeeModel> selectListByAgeScope(int low, int hight) throws Exception;
	//查询-取得指定年龄范围内的员工的列表--有分页 rows:每页显示的个数， page：第几页
	public List<EmployeeModel> selectListByAgeScopeWithPage(int low, int hight,int rows, int page) throws Exception;
	
	//查询-取得单个Model对象-员工
	public EmployeeModel selectByNo(int employeeno) throws Exception;
	
	//查询-取得所有员工个数的方法
	public int selectCountByAll() throws Exception;
	
	//查询-取得年龄在指定区间的员工个数的方法
	public int selectCountByAgeScope(int low, int hight) throws Exception;
	
	
}
