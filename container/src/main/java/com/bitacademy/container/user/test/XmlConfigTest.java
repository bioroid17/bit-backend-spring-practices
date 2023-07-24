package com.bitacademy.container.user.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bitacademy.container.user.User;

public class XmlConfigTest {

	public static void main(String[] args) {
		// 1. XML Auto Configuration(Annotation Configuration)
		// 자동으로 설정됨
//		testXMLAutoConfiguration();
		
		// 2. XML Explicit Configuration(Bean Configuration)
		// 개발자가 직접 XML 파일에 설정 명시
		testXMLExplicitConfiguration();
	}

	private static void testXMLExplicitConfiguration() {
		ApplicationContext ac =
				new	ClassPathXmlApplicationContext("com/bitacademy/config/user/applicationContext02.xml");
		
		User user = null;
		
		// 오류: id로 가져오기
		// 명시적 빈 설정인 경우에는 id를 자동으로 부여하지 않는다.
//		user = (User)ac.getBean("user");
//		System.out.println(user);
		
		// id로 가져오기
		user = (User) ac.getBean("user2");
		System.out.println(user);
		
		// name으로 가져오기
		user = (User) ac.getBean("usr2");
		System.out.println(user);
		
		// type으로 빈 가져오기
		// 같은 타입의 빈이 2개 이상 있으면 type으로만 가져오기는 실패
		// 1. id + type
		user = ac.getBean("user2", User.class);
		System.out.println(user);
		
		// 2. name + type
		user = ac.getBean("usr2", User.class);
		System.out.println(user);

		// 파라미터 1개인 생성자로 빈 생성하기
		user = ac.getBean("user3", User.class);
		System.out.println(user);

		// 파라미터 2개인 생성자로 빈 생성하기 01
		user = ac.getBean("user4", User.class);
		System.out.println(user);

		// 파라미터 2개인 생성자로 빈 생성하기 02
		user = ac.getBean("user5", User.class);
		System.out.println(user);

		// setter를 사용한 빈 가져오기
		user = ac.getBean("user6", User.class);
		System.out.println(user);

		// DI 된 빈 가져오기
		user = ac.getBean("user7", User.class);
		System.out.println(user);
		
	}

	private static void testXMLAutoConfiguration() {
		ApplicationContext ac =
				new	ClassPathXmlApplicationContext("com/bitacademy/config/user/applicationContext01.xml");
		
		User user = null;
		
		user = ac.getBean(User.class);
		System.out.println(user);
		
		// Annotation Scan 설정에서는 Bean id가 자동으로 부여된다.
		user = (User) ac.getBean("user");
		System.out.println(user);
	}
}
