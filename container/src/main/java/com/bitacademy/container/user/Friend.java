package com.bitacademy.container.user;

import org.springframework.stereotype.Component;

@Component
public class Friend {
	private Long no = 1L;
	private String name = "마이콜";
	
	// Auto Configuration(Component Scan) 빈 생성 시에는
	// 반드시 기본 생성자가 있어야 함
	public Friend() {
	}
	
	public Friend(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Friend [no=" + no + ", name=" + name + "]";
	}
}
