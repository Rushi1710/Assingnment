package com.springJdbc.entity;

import org.springframework.stereotype.Component;

@Component
public class Employee 
{
	
	private int eid;
	private String ename;
	private int deptno;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		System.out.println("sett values");
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public Employee(int eid, String ename, int deptno) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.deptno = deptno;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", deptno=" + deptno + "]";
	}
	
	

}









//create table Department(departId int, departName varchar(20));
//alter table department ADD PRIMARY KEY(departId);
//create table employee(eId int, eName varchar(20), ePhone varchar(20), eAdd varchar(20),departId int,PRIMARY KEY (eId),    FOREIGN KEY (departId) REFERENCES department(departId));



