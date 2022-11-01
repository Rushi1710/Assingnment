package com.springJdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springJdbc.entity.Department;
import com.springJdbc.entity.Employee;

@Repository
public class EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// Insert Employess
	public void insertData(Employee emp, Department dep) {

		System.out.println(emp);
		System.out.println(dep);

		String sql1 = "insert into Department values(?,?)";
		int r1 = this.jdbcTemplate.update(sql1, dep.getDeptno(), dep.getDepartlocation());
		System.out.println("Insert Department Data =" + r1);

		String sql = "insert into Employee values(?,?,?)";
		int r = this.jdbcTemplate.update(sql, emp.getEid(), emp.getEname(), emp.getDeptno());
		System.out.println("Insert Employee Data =" + r);

	}

	// update Employee
	public void updateData(Employee emp, Department dep) {

		String sql1 = "update Department set departlocation=? where deptno=?  ";
		int r1 = this.jdbcTemplate.update(sql1, dep.getDepartlocation(), dep.getDeptno());
		System.out.println("Update Employee Data =" + r1);

		String sql = "update Employee set ename=? , deptno=? where eid=? ";
		int r = this.jdbcTemplate.update(sql, emp.getEname(), emp.getDeptno(), emp.getEid());
		System.out.println("Update Employee Data =" + r);

	}

	// Delete
	public void deleteData(Employee emp) {

		String sql = "delete from Employee where eid = ?";
		int r = this.jdbcTemplate.update(sql, emp.getEid());
		System.out.println("Delete Employee Data =" + r);

//		String sql1 = "delete from Department where deptno=?";
//		int r1 = this.jdbcTemplate.update(sql1,dep.getDeptno());
//		System.out.println("Delete Deptno Data =" + r1);

	}

	// feching data of Employee
	public List<Employee> getAllEmployee() {
		String sql = "select * from Employee";
		return this.jdbcTemplate.query(sql, new StudRowMapper());

	}

	class StudRowMapper implements RowMapper<Employee> {

		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			Employee employee = new Employee();
			employee.setEid(rs.getInt(1));
			employee.setEname(rs.getString(2));
			employee.setDeptno(rs.getInt(3));
			return employee;

		}

	}
}
