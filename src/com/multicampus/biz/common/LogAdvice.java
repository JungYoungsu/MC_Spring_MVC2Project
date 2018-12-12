package com.multicampus.biz.common;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Service;

@Service("log")
//@Aspect
public class LogAdvice {
//	@Pointcut("execution(* com.multicampus.biz..*Impl.*(..))")
//	public void allPointcut() {}
	
//	@Before("allPointcut()")
	public void printLog(JoinPoint jp) {
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		
		System.out.println("[���� ó��] " + method + 
			"() �޼ҵ� ARGS ���� : " + args[0].toString());
	}
}
