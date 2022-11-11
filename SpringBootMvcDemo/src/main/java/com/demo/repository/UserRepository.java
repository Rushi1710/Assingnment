package com.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.entity.UserData;

public interface UserRepository extends CrudRepository<UserData, String>{

}
