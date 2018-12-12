package com.multicampus.biz.common;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Service;

import com.multicampus.biz.user.UserVO;

@Service("afterReturning")
public class AfterReturningAdvice {

	public void afterLog(JoinPoint jp, Object returnObj) { 
		String method = jp.getSignature().getName();
		
		System.out.println("[사후 처리] " + method + 
			"() 메소드 리턴 값 : " + returnObj.toString());
		
		if(returnObj instanceof UserVO) {
			UserVO user = (UserVO) returnObj;
			if(user.getRole().equals("Admin")) {
				System.out.println("###" + user.getName() + " 관리자님 환영해요.###");
			}
		}
	}
}
