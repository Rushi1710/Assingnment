package com.springJdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.springJdbc.dao.EmployeeDao;
import com.springJdbc.entity.Department;
import com.springJdbc.entity.Employee;


@Configuration
@ComponentScan
public class App 
{
    public static void main( String[] args )
    {

    	 
		ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
		System.out.println("Start......");
		
		EmployeeDao dao = context.getBean(EmployeeDao.class);
		
		Employee emp = context.getBean(Employee.class);
		
		Department dep = context.getBean(Department.class);
		
	// Insrt Data
//		emp.setEname("raj");
//		emp.setDeptno(20);
//		emp.setEid(103);
//		dep.setDepartlocation("Panvel");
//		dep.setDeptno(30);
//		
//		dao.insertData(emp, dep);
		
		//Update Data 
		
//		emp.setDeptno(30);
//		emp.setEid(103);
//		emp.setEname("Rakesh");
//		dep.setDeptno(30);
//		dep.setDepartlocation("Pune");
//		
//		dao.updateData(emp, dep);
		
		
		// Delete Data
		emp.setEid(102);
		
		
		dao.deleteData(emp);
		
        
    }
    
    @Bean
	public DataSource getDataDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		System.out.println("datasources creating");
//		ds.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//		ds.setUrl("jdbc:sqlserver://CSS-D-212;databaseName=Rushi_Database");
//		ds.setUsername("sa");
//		ds.setPassword("sqlserver@1");
		
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/rushikesh");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;

		
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource ds) 
	{
		//System.out.println(ds);
		System.out.println("JdbcTemplet");
		return new JdbcTemplate(ds);

	}
}

