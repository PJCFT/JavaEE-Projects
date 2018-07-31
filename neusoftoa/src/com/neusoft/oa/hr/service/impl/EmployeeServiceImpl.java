package com.neusoft.oa.hr.service.impl;

import java.util.List;

import com.neusoft.oa.hr.dao.IEmployeeDao;
import com.neusoft.oa.hr.factory.DaoFactory;
import com.neusoft.oa.hr.model.EmployeeModel;
import com.neusoft.oa.hr.service.IEmployeeService;
//员工的业务实现类
public class EmployeeServiceImpl implements IEmployeeService {
	
	private IEmployeeDao employeeDao = DaoFactory.createEmployeeDao();

	@Override
	public void add(EmployeeModel employee) throws Exception {
		// TODO Auto-generated method stub
		employeeDao.create(employee);
	}

	@Override
	public void modify(EmployeeModel employee) throws Exception {
		// TODO Auto-generated method stub
		employeeDao.update(employee);
	}

	@Override
	public void delete(EmployeeModel employee) throws Exception {
		// TODO Auto-generated method stub
		employeeDao.delete(employee);
	}

	@Override
	public boolean validate(String code, String password) throws Exception {
		// TODO Auto-generated method stub
		boolean result = false;
		List<EmployeeModel> list = employeeDao.selectListByAll();
		
		for(EmployeeModel employee:list) {
			if(employee.getCode() != null && employee.getCode().equals(code)&&employee.getPassword() != null && employee.getPassword().equals(password)) {
				result = true;
				break;
			}
		}
		return result;
	}

	@Override
	public void changePassword(int no, String password) throws Exception {
		// TODO Auto-generated method stub
		EmployeeModel employee = employeeDao.selectByNo(no);
		
		employee.setPassword(password);
		employeeDao.update(employee);

	}

	@Override
	public List<EmployeeModel> getListByAllWithPage(int rows, int page) throws Exception {
		// TODO Auto-generated method stub
		return employeeDao.selectListByAllWithPage(rows, page);
	}

	@Override
	public List<EmployeeModel> getListByAgeScopeWithPage(int low, int hight, int rows, int page) throws Exception {
		// TODO Auto-generated method stub
		return employeeDao.selectListByAgeScopeWithPage(low, hight, rows, page);
	}

	@Override
	public int getCountByAll() throws Exception {
		// TODO Auto-generated method stub
		return employeeDao.selectCountByAll();
	}

	@Override
	public int getCountByAgeScope(int low, int hight) throws Exception {
		// TODO Auto-generated method stub
		return employeeDao.selectCountByAgeScope(low, hight);
	}

	@Override
	public int getPageCountByAll(int rows) throws Exception {
		// TODO Auto-generated method stub
		int pageCount = 0;
		int count = this.getCountByAll();
		if(count%rows == 0) {
			pageCount = count/rows;
		}else {
			pageCount = count/rows+1;
		}
		return pageCount;
	}

	@Override
	public int getPageCountByAgeScope(int low, int hight, int rows) throws Exception {
		// TODO Auto-generated method stub
		int pageCount = 0;
		int count = this.getCountByAgeScope(low, hight);
		if(count%rows == 0) {
			pageCount = count/rows;
		}else {
			pageCount = count/rows + 1;
		}
		return pageCount;
	}

	@Override
	public EmployeeModel selectByNo(int no) throws Exception {
		// TODO Auto-generated method stub
		return employeeDao.selectByNo(no);
	}

}
