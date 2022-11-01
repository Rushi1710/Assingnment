package com.aop.services;


import org.springframework.stereotype.Component;

@Component
public class PaymentImp{

	public void makePayment() {
		// Payment code 
		
		System.out.println("Amount Debited....");
		System.out.println("Ämount Credited....");
		
	}

	// adding two number 
	public int addTwoNumbers(int a,int b) {
		int c = a + b ;
		return c;
		
	}
	
	
	
	public int checkNumberEvenorOdd(int a) throws Exception {
			if(a!=0) {
				System.out.println("valid Input");
			}else {
				throw new Exception("Something is wrong with the input plese check!!");
			}
		
		
		return 0;
		
	}
}
