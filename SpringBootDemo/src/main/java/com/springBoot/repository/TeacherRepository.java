package com.springBoot.repository;

import org.springframework.data.repository.CrudRepository;

import com.springBoot.entity.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher, Integer> {

}
