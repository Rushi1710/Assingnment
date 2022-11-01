package com.springBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.springBoot.entity.Teacher;
import com.springBoot.service.TeacherService;

@SpringBootApplication
public class SpringBootDemoApplication {

//	@Autowired
//	private Teacher teacher;
//	
//	@Autowired
//	private TeacherService teacherService;
	
	
	public static void main(String[] args) 
	{
		System.out.println("Start Program");
		SpringApplication.run(SpringBootDemoApplication.class, args);
//		Teacher teacher = context.getBean(Teacher.class);
		
		
		
	}

}
