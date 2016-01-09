package com.hg.student.model;

import java.io.Serializable;
import java.util.Map;

public class Student implements Serializable{

	@Override
	public String toString() {
		return "Student [id=" + id + ", stuName=" + stuName + ", gender=" + gender + ", address=" + address + ", age="
				+ age + "]";
	}
	private static final long serialVersionUID = -4985675631275290625L;
	private int id;
	private String stuName;
	private int gender;
	private String address;
	private int age;
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getStuName() {
		return stuName;
	}


	public void setStuName(String stuName) {
		this.stuName = stuName;
	}


	public int getGender() {
		return gender;
	}


	public void setGender(int gender) {
		this.gender = gender;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}

	public Student(int id, String stuName, int gender, String address, int age) {
		super();
		this.id = id;
		this.stuName = stuName;
		this.gender = gender;
		this.address = address;
		this.age = age;
	}
	public Student(Map<String, Object> map) {
		this.id = (int) map.get("id");
		this.stuName = (String)map.get("stu_name");
		this.age = (int)map.get("age");
		this.gender = (int)map.get("gender");
		this.address = (String)map.get("address");
		
	}


	public Student() {
	}


}
