package com.neusoft.oa.factory;

import java.sql.Connection;
import java.sql.DriverManager;

//辅助类-数据库连接工厂
public class ConnectionFactory {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws Exception{
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:product","neusoftoa","123456");
		
	}
}
