package com.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.springcore.entity.Employee;

@Configuration
@ComponentScan(basePackages =  "com.springcore.entity")
public class AppAnnotation {

	public static void main(String[] args) {
		System.out.println("By using Annotation");
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppAnnotation.class);
		
		Employee e1 = context.getBean(Employee.class);
		System.out.println(e1);
		
		e1.checkeIdPalindrom();

	}

}
