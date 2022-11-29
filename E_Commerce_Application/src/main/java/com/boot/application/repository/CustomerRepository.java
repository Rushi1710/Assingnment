package com.boot.application.repository;

import org.springframework.data.repository.CrudRepository;

import com.boot.application.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, String> {

	public boolean existsByEmail(String email);
	
	public boolean existsByContact(String password);
}
