package com.neusoft.oa.hr.model;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;
//员工的Model类
public class EmployeeModel implements Serializable {
	//field变量
	private int no = 0; //序号，主键
	private String code = null; //编号
	private String password = null;//密码
	private String name = null;
	private int age = 0;
	private double salary = 0;
	private Date birthday = null;
	private String desc = null;
	private Blob photo = null; //员工照片
	private String fileName = null;//照片的文件名
	private String contentType = null; //照片的文件类型
	private String sex = null;
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	//property 简便方法，右键空白处，然后点击source->Generate getter and setter
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Blob getPhoto() {
		return photo;
	}
	public void setPhoto(Blob photo) {
		this.photo = photo;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
