package com.neusoft.oa.hr.factory;

import com.neusoft.oa.hr.dao.IEmployeeDao;
import com.neusoft.oa.hr.dao.impl.EmployeeDaoImpl;

//HR模块的DAO工厂类
public class DaoFactory {
	public static IEmployeeDao createEmployeeDao() {
		return new EmployeeDaoImpl();
	}
	
}
