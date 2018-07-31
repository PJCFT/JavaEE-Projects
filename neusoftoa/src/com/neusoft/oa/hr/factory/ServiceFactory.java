package com.neusoft.oa.hr.factory;

import com.neusoft.oa.hr.service.IEmployeeService;
import com.neusoft.oa.hr.service.impl.EmployeeServiceImpl;

//Hr模块的业务工厂类
public class ServiceFactory {
	
	public static IEmployeeService createEmployeeService() {
		return new EmployeeServiceImpl();
	}
}
