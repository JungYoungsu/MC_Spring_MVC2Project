package com.multicampus.biz.common;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Service;

import com.multicampus.biz.user.UserVO;

@Service("afterReturning")
public class AfterReturningAdvice {

	public void afterLog(JoinPoint jp, Object returnObj) { 
		String method = jp.getSignature().getName();
		
		System.out.println("[���� ó��] " + method + 
			"() �޼ҵ� ���� �� : " + returnObj.toString());
		
		if(returnObj instanceof UserVO) {
			UserVO user = (UserVO) returnObj;
			if(user.getRole().equals("Admin")) {
				System.out.println("###" + user.getName() + " �����ڴ� ȯ���ؿ�.###");
			}
		}
	}
}
