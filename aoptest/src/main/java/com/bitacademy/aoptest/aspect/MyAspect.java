package com.bitacademy.aoptest.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component	// 스캔해서 Bean을 생성
@Aspect		// 관점 설정
public class MyAspect {
	
	// 접근 지시자 리턴타입 패키지.클래스.메소드(파라미터) throws XXException
	@Before("execution(* *..*.ProductService.find(String))")
	public void adviceBefore() {
		System.out.println("--- Before Advice ---");
	}

	@After("execution(* *..*.ProductService.find(String))")	// 패키지 이름 생략
	public void adviceAfter() {
		System.out.println("--- After Advice ---");
	}

	@AfterReturning("execution(* *..*.ProductService.find(String))")
	public void adviceAfterReturning() {
		System.out.println("--- AfterReturning Advice ---");
	}

	@AfterThrowing(value="execution(* *..*.ProductService.find(..))", throwing="ex")	// 파라미터 생략
	public void adviceAfterThrowing(Throwable ex) {
		System.out.println("--- AfterThrowing Advice :" + ex + " ---");
	}

	@Around("execution(* *..*.ProductService.find(..))")	// 파라미터 생략
	public Object adviceAround(ProceedingJoinPoint pjp) throws Throwable{
		/* before */
		System.out.println("--- Around(Before) Advice ---");
		
		/* Point Cut Method 실행 */
		
		// Object[] parameters = {"Camera"};
		// Object result = pjp.proceed(parameters);
		
		Object result = pjp.proceed();	// find 실행
		
		/* after */
		System.out.println("--- Around(After) Advice ---");
		
		return result;
	}
}
