package com.demo.services;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.UserData;
import com.demo.repository.UserRepository;

@Service
public class UserServicve {

	@Autowired
	private UserRepository userRepository;

	public boolean inserUsertData(UserData user) {
		if (!this.userRepository.existsById(user.getUsername())) {
			this.userRepository.save(user);
			return true;
		}
		return false;
	}

	public boolean validateUser(String name, String password) {
		String password1 = this.userRepository.findById(name).get().getPassword();
		if (password1.equals(password))
			return true;
		return false;
	}

	public boolean updateData(String username, String mobileNo, String email) 
	{
		if (this.userRepository.existsById(username)) {
			UserData user = this.userRepository.findById(username).get();
			System.out.println("User" + user);
			user.setEmail(email);
			user.setMobile(mobileNo);
			this.userRepository.save(user);
			return true;
		}
		return false;
	}
}
