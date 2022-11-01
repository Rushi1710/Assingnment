package com.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springcore.entity.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		// System.out.println( "Hello World!" );
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		Student s1 = context.getBean("student1", Student.class);
		System.out.println("----By using setter Injection----");
		System.out.println(s1);

		System.out.println("-----By using Constuctor Injection-----");
		Student s2 = context.getBean("student2", Student.class);
		System.out.println(s2);
		System.out.println("---------------------------------");
		Student s3 = context.getBean("student3", Student.class);
		System.out.println(s3);
		
		
		// Call reversename method
		System.out.println(s3.reversname());
		
		
	}
}
