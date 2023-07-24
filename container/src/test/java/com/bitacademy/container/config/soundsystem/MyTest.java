package com.bitacademy.container.config.soundsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MyTest {
	// @Test가 있어면 테스트용 메소드라는 의미
	@Test
	public void test01() {
		int i = 10;
		// 테스트 통과 조건을 반드시 작성해야 한다.
		assertTrue(i - 10 <= 10);	// 참이 되는 조건
	}

	@Test
	public void test02() {
		int i = 10;
		assertEquals(10, i);	// i는 10과 같아야 한다는 의미
	}
}
