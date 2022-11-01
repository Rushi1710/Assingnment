package com.spring.mvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.mvc.entity.User;

@Repository
public class UseService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public boolean inseretUser(User user) {

		try {
			String sql = "insert into user values(?,?,?)";
			int a = jdbcTemplate.update(sql, user.getUserId(), user.getUserEmail(), user.getUserPassword());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean validateUser(String email,String userpassword) {

		String sql = "select userpassword from user where useremail=?";
		String password = jdbcTemplate.queryForObject(sql, String.class, email);
		System.out.println("Call ValidateUser Method");
		if (password != null && password.equals(userpassword)) {
			return true;
		}
		return false;
	}

}
