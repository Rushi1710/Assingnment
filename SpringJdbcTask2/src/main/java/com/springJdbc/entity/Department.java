package com.springJdbc.entity;

import org.springframework.stereotype.Component;

@Component
public class Department 
{

	private int deptno;
	private String  departlocation;
	
	public Department() {
		// TODO Auto-generated constructor stub
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDepartlocation() {
		return departlocation;
	}

	public void setDepartlocation(String departlocation) {
		this.departlocation = departlocation;
	}

	public Department(int deptno, String departlocation) {
		super();
		this.deptno = deptno;
		this.departlocation = departlocation;
	}

	@Override
	public String toString() {
		return "Department [deptno=" + deptno + ", departlocation=" + departlocation + "]";
	}
	
	
}
