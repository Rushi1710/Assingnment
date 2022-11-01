package com.aop.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.aop.App;

@Aspect
@Component
public class MyAspect {

	static Logger logger=Logger.getLogger(App.class);
	
	public MyAspect() {
		//System.out.println("default constuctor of Myaspect class");
	}
	
	@Pointcut("execution(* com.aop.services.PaymentImp.makePayment())")
	public void pointCutMethod() {
		}
	
	@Pointcut("execution(public int com.aop.services.PaymentImp.addTwoNumbers(..))")
	public void addTwoNumbers() {
		}
	
	@Pointcut("execution(public int com.aop.services.PaymentImp.checkNumberEvenorOdd(..))")
	public void checkNumberEvenorOdd() {
		}
	
	@Before("pointCutMethod()")
	public void printMsgBeforePayment() {
		logger.info("Before Payment Started");
	}
	
	@After("execution(* com.aop.services.PaymentImp.makePayment())")
	public void printMsgAfterPayment() {
		logger.info("After payment Done");
	}
	
	@AfterReturning(pointcut = "addTwoNumbers()",returning = "result")
	public void additionNumber(int result) 
	{
		System.out.println("result = " + result);
		logger.info(result);
	}
	
	@AfterThrowing(pointcut ="checkNumberEvenorOdd()",throwing = "ex")
	public void ExceptionCheck(Exception ex) {
		logger.error("Exception from chevknumber");
	}
	
}
