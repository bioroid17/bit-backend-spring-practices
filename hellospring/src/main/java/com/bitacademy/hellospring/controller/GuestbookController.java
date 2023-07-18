package com.bitacademy.hellospring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 *  @RequestMapping
 *  클래스 단독 매핑
 *  Spring MVC 4.x에서만 지원
 *  Spring MVC 4.x 이상에서는 deprecated -> 사용 금지
 */

// Spring MVC 5.x 이상 오류
// @Controller
@RequestMapping("/guestbook/*")
public class GuestbookController {

	@ResponseBody	// 이건 테스트 용도로 붙인 것
	@RequestMapping	// @RequestMapping이 붙어있어야 handler이다.
	public String list() {
		return "Guestbook.list()";
	}

	@ResponseBody	// 이건 테스트 용도로 붙인 것
	@RequestMapping	// @RequestMapping이 붙어있어야 handler이다.
	public String delete() {
		return "Guestbook.delete()";
	}
}
