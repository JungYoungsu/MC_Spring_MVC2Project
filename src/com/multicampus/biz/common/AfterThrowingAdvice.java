package com.multicampus.biz.common;

import java.sql.SQLException;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Service;

@Service("afterThrowing")
public class AfterThrowingAdvice {

	public void exceptionLog(JoinPoint jp, Exception exceptObj) {
		String method = jp.getSignature().getName();
		
		System.out.println("[���� ó��] " + method  + "() �޼ҵ� ���� �� ���� �߻�");
		
		if(exceptObj instanceof IllegalArgumentException) {
			System.out.println("0�� ���� ����� �� �������?");
		} else if(exceptObj instanceof ArithmeticException) {
			System.out.println("0���� ���ڸ� ���� �� �������?");
		} else if(exceptObj instanceof SQLException) {
			System.out.println("SQL ������ ������ �ֳ�����.");
		} else {
			System.out.println("���� �� ���� �߻�!!!");
		}
		
	}
}
