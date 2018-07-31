package com.neusoft.oa.hr.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.oa.factory.ConnectionFactory;
import com.neusoft.oa.hr.dao.IEmployeeDao;
import com.neusoft.oa.hr.model.EmployeeModel;

public class EmployeeDaoImpl implements IEmployeeDao {
	//插入单条记录
	@Override
	public void create(EmployeeModel em) throws Exception {
		// TODO Auto-generated method stub
		Connection cn = ConnectionFactory.getConnection();
		String sql = "insert into Employee values (EMPLOYEE_NEXTNO_SQ.nextval,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = cn.prepareStatement(sql);
		ps.setString(1, em.getCode());
		ps.setString(2, em.getName());
		ps.setInt(3, em.getAge());
		ps.setDouble(4, em.getSalary());
		ps.setDate(5, new Date(em.getBirthday().getTime()));
		ps.setString(6, em.getDesc());
		ps.setBlob(7, em.getPhoto());
		ps.setString(8, em.getFileName());
		ps.setString(9, em.getContentType());
		ps.setString(10, em.getSex());
		ps.setString(11, em.getPassword());
		
		ps.executeUpdate();
		ps.close();
		cn.close();
		
		

	}
	//修改单条记录
	@Override
	public void update(EmployeeModel em) throws Exception {
		// TODO Auto-generated method stub
		Connection cn = ConnectionFactory.getConnection();
		String sql = "update Employee set EMPCODE=?,EMPNAME=?,AGE=?,SALARY=?,BIRTHDAY=?,EMPDESC=?,PHOTO=?,PHOTOCONTENTTYPE=?,PHOTOFILENAME=?,SEX=?,EMPPASSWORD=? where EMPNO=?";
		PreparedStatement ps = cn.prepareStatement(sql);
		ps.setString(1, em.getCode());
		ps.setString(2, em.getName());
		ps.setInt(3, em.getAge());
		ps.setDouble(4, em.getSalary());
		ps.setDate(5, new Date(em.getBirthday().getTime()));
		ps.setString(6, em.getDesc());
		ps.setBlob(7, em.getPhoto());
		ps.setString(8, em.getFileName());
		ps.setString(9, em.getContentType());
		ps.setString(10, em.getSex());
		ps.setString(11, em.getPassword());
		ps.setInt(12, em.getNo());
		
		ps.executeUpdate();
		ps.close();
		cn.close();
	}
	//删除单条记录
	@Override
	public void delete(EmployeeModel em) throws Exception {
		// TODO Auto-generated method stub
		Connection cn = ConnectionFactory.getConnection();
		String sql = "delete from Employee where EMPNO=?";
		PreparedStatement ps = cn.prepareStatement(sql);
		ps.setInt(1, em.getNo());
		ps.executeUpdate();
		ps.close();
		cn.close();
	}
	//取得所有员工对象的列表
	@Override
	public List<EmployeeModel> selectListByAll() throws Exception {
		// TODO Auto-generated method stub
		List<EmployeeModel> list = new ArrayList<EmployeeModel>();
		Connection cn = ConnectionFactory.getConnection();
		
		String sql = "select * from EMPLOYEE";
		PreparedStatement ps = cn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			EmployeeModel em = new EmployeeModel();
			em.setNo(rs.getInt("EMPNO"));
			em.setCode(rs.getString("EMPCODE"));
			em.setName(rs.getString("EMPNAME"));
			em.setAge(rs.getInt("AGE"));
			em.setSalary(rs.getDouble("SALARY"));
			em.setBirthday(rs.getDate("Birthday"));
			em.setDesc(rs.getString("EMPDESC"));
			em.setContentType(rs.getString("PHOTOCONTENTTYPE"));
			em.setFileName(rs.getString("PHOTOFILENAME"));
			em.setSex(rs.getString("SEX"));
			list.add(em);
		}
		rs.close();
		ps.close();
		cn.close();
		
		return list;
	}
	//取得所有有分页
	@Override
	public List<EmployeeModel> selectListByAllWithPage(int rows, int page) throws Exception {
		// TODO Auto-generated method stub
		List<EmployeeModel> list = new ArrayList<EmployeeModel>();
		Connection cn = ConnectionFactory.getConnection();
		
		String sql = "select * from (select A.*, rownum rn from (select * from EMPLOYEE) A where rownum <= ?) where rn >= ?";
		PreparedStatement ps = cn.prepareStatement(sql);
		ps.setInt(1, rows*page);
		ps.setInt(2, rows*(page-1)+1);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			EmployeeModel em = new EmployeeModel();
			em.setNo(rs.getInt("EMPNO"));
			em.setCode(rs.getString("EMPCODE"));
			em.setName(rs.getString("EMPNAME"));
			em.setAge(rs.getInt("AGE"));
			em.setSalary(rs.getDouble("SALARY"));
			em.setBirthday(rs.getDate("Birthday"));
			em.setDesc(rs.getString("EMPDESC"));
			em.setContentType(rs.getString("PHOTOCONTENTTYPE"));
			em.setFileName(rs.getString("PHOTOFILENAME"));
			em.setSex(rs.getString("SEX"));
			list.add(em);
		}
		
		rs.close();
		ps.close();
		cn.close();
		
		return list;
	}
	//有年龄区间的无分页查询
	@Override
	public List<EmployeeModel> selectListByAgeScope(int low, int hight) throws Exception {
		// TODO Auto-generated method stub
		List<EmployeeModel> list = new ArrayList<EmployeeModel>();
		Connection cn = ConnectionFactory.getConnection();
		
		String sql = "select * from EMPLOYEE where AGE between ? and ?";
		PreparedStatement ps = cn.prepareStatement(sql);
		ps.setInt(1, low);
		ps.setInt(2, hight);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			EmployeeModel em = new EmployeeModel();
			em.setNo(rs.getInt("EMPNO"));
			em.setCode(rs.getString("EMPCODE"));
			em.setName(rs.getString("EMPNAME"));
			em.setAge(rs.getInt("AGE"));
			em.setSalary(rs.getDouble("SALARY"));
			em.setBirthday(rs.getDate("Birthday"));
			em.setDesc(rs.getString("EMPDESC"));
			em.setContentType(rs.getString("PHOTOCONTENTTYPE"));
			em.setFileName(rs.getString("PHOTOFILENAME"));
			em.setSex(rs.getString("SEX"));
			list.add(em);
		}
		rs.close();
		ps.close();
		cn.close();
		
		return list;
	}
	//带年龄区间的有分页查询
	@Override
	public List<EmployeeModel> selectListByAgeScopeWithPage(int low, int hight, int rows, int page) throws Exception {
		// TODO Auto-generated method stub
		List<EmployeeModel> list = new ArrayList<EmployeeModel>();
		Connection cn = ConnectionFactory.getConnection();
		
		String sql="SELECT * FROM  (SELECT A.*, ROWNUM RN  FROM (SELECT * FROM EMPLOYEE where AGE between ? and ? order by EMPNO) A  WHERE ROWNUM <=?)  WHERE RN >=?";
		PreparedStatement ps = cn.prepareStatement(sql);
		ps.setInt(1, low);
		ps.setInt(2, hight);
		ps.setInt(3, rows*page);
		ps.setInt(4, rows*(page-1)+1);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			EmployeeModel em = new EmployeeModel();
			em.setNo(rs.getInt("EMPNO"));
			em.setCode(rs.getString("EMPCODE"));
			em.setName(rs.getString("EMPNAME"));
			em.setAge(rs.getInt("AGE"));
			em.setSalary(rs.getDouble("SALARY"));
			em.setBirthday(rs.getDate("Birthday"));
			em.setDesc(rs.getString("EMPDESC"));
			em.setContentType(rs.getString("PHOTOCONTENTTYPE"));
			em.setFileName(rs.getString("PHOTOFILENAME"));
			em.setSex(rs.getString("SEX"));
			list.add(em);
		}
		rs.close();
		ps.close();
		cn.close();
		
		return list;
	}
	//取单条数据
	@Override
	public EmployeeModel selectByNo(int employeeno) throws Exception {
		// TODO Auto-generated method stub
		Connection cn = ConnectionFactory.getConnection();
		String sql = "select * from EMPLOYEE where EMPNO = ?";
		EmployeeModel em = new EmployeeModel();
		PreparedStatement ps = cn.prepareStatement(sql);
		ps.setInt(1, employeeno);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			em.setNo(rs.getInt("EMPNO"));
			em.setCode(rs.getString("EMPCODE"));
			em.setName(rs.getString("EMPNAME"));
			em.setAge(rs.getInt("AGE"));
			em.setSalary(rs.getDouble("SALARY"));
			em.setBirthday(rs.getDate("Birthday"));
			em.setDesc(rs.getString("EMPDESC"));
			em.setPhoto(rs.getBlob("PHOTO"));
			em.setContentType(rs.getString("PHOTOCONTENTTYPE"));
			em.setFileName(rs.getString("PHOTOFILENAME"));
			em.setSex(rs.getString("SEX"));
		}
		
		rs.close();
		ps.close();
		cn.close();
		
		return em;
	}

	@Override
	public int selectCountByAll() throws Exception {
		// TODO Auto-generated method stub
		int count = 0;
		Connection cn = ConnectionFactory.getConnection();
		String sql = "select count(*) EMPNOCOUNT from EMPLOYEE";
		PreparedStatement ps = cn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			count = rs.getInt("EMPNOCOUNT");
		}
		return count;
	}

	@Override
	public int selectCountByAgeScope(int low, int hight) throws Exception {
		// TODO Auto-generated method stub
		int count = 0;
		Connection cn = ConnectionFactory.getConnection();
		String sql = "select count(*) EMPNOCOUNT from EMPLOYEE where age between ? and ?";
		PreparedStatement ps = cn.prepareStatement(sql);
		ps.setInt(1, low);
		ps.setInt(2, hight);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			count = rs.getInt("EMPNOCOUNT");
		}
		return count;
	}

}
