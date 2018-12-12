package com.multicampus.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Service;
                
@Service("around")
//@Aspect // Aspect = Pointcut + Advice
public class AroundAdvice {
//	@Pointcut("execution(* com.multicampus.biz..*Impl.*(..))")
//	public void allPointcut() {}	
//	
//	@Pointcut("execution(* com.multicampus.biz..*Impl.get*(..))")
//	public void getPointcut() {}

//	@Around("allPointcut()")
	public Object aroundLog(ProceedingJoinPoint jp) throws Throwable { 
		String method = jp.getSignature().getName();
		Object obj = null;
		long start = System.currentTimeMillis();
		
		obj = jp.proceed();
		
		long end = System.currentTimeMillis();
		System.out.println(method + "() �޼ҵ� ���࿡ �ɸ� �ð� : " + 
		(end - start) + "(ms)��");
		return obj;
	}
}
