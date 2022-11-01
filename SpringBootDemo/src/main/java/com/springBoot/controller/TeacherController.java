package com.springBoot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.entity.Teacher;
import com.springBoot.service.TeacherService;

@RestController
public class TeacherController {

	@Autowired
	private TeacherService teacherService;
	
	
	@PostMapping("/teacher")
	public Teacher insertData(@RequestBody Teacher teacher) {
		
		Teacher insertTeacher = this.teacherService.insertTeacherData(teacher);
		System.out.println("Insert data = "+insertTeacher);
		return insertTeacher;
		
	}
	
	@PutMapping("/update")
	public String udateDataById(@RequestBody Teacher teacher) throws Exception
	{
		String updateTeacher = this.teacherService.updateTeacherData(teacher);
		return updateTeacher;
		
	}
	
	@GetMapping("/getdata/{id}")
	public Optional<Teacher> getById(@PathVariable int id) {
		
		return teacherService.getdataById(id);
		
		
	}
	
	@DeleteMapping("/delete/{id}")
	public String deletDataById(@PathVariable int id) {
		
		 teacherService.deletedata(id);
		 return "Data is Deleted";
		
	}
}
