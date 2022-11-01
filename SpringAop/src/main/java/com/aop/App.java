package com.aop;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.aop.services.PaymentImp;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class App {

	public static void main(String[] args) {
		// System.out.println("Hello World!");
		ApplicationContext context = new AnnotationConfigApplicationContext(App.class);

		PaymentImp paymentImp = context.getBean(PaymentImp.class);

		// print payment Started

		paymentImp.makePayment();
		paymentImp.addTwoNumbers(12, 32);
		
		System.out.println("inter a number");
		
		Scanner sc = new Scanner(System.in);
		int  a = sc.nextInt();
		try {
		paymentImp.checkNumberEvenorOdd(a);
		}catch(Exception e) {
			
		}

	}
}
