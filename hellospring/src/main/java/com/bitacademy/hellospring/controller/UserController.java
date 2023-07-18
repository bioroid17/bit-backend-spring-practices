package com.bitacademy.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 *  @RequestMapping
 *  클래스 + 메소드(핸들러) 매핑
 *  강추!
 */
@Controller
@RequestMapping("/user")	// 공통 url은 여기 작성
public class UserController {

	// joinform -> join
	// url의 수는 적을 수록 좋다.
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		return "/WEB-INF/views/join.jsp";
	}

	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(UserVo userVo) {
		// userVo의 필드 명과 jsp 파일의 input name을 일치시키면 파라미터를 userVo 하나로 한 번에 받는 것이 가능
		// 단, getter, setter는 구현해야 한다.
		System.out.println(userVo);
		return "redirect:/";
	}
	
	@ResponseBody
	@RequestMapping("/list")	// 메소드 별 url
	public String list() {
		return "UserController.list()";
	}
	
	@ResponseBody
	@RequestMapping("/logout")
	public String logout() {
		return "UserController.logout()";
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public String update(@RequestParam("n") String name) {
		// Java 변수 이름은 긴 게 좋지만, 반대로 url은 짧은게 좋다. 특히 해커들의 유추를 막을 수 있단 점에서 더더욱
		// @RequestParam을 이용해서 n이 url로 넘어오면 name이란 이름으로 받는다.
		// 만일 n이라는 이름의 파라미터가 없으면 400 bad request 에러가 발생한다.
		// 실제로 에러를 발생시키는 것은 좋은 방법이 아니다.
		return "UserController.update("+name+")";
	}
	
	@ResponseBody
	@RequestMapping("/update2")
	public String update2(@RequestParam(value="n", required=false) String name) {
		// n이 없으면 null이 넘어온다.
		return "UserController.update2("+name+")";
	}

	@ResponseBody
	@RequestMapping("/update3")
	public String update3(@RequestParam(value="n", required=true, defaultValue="") String name) {
		// n이 없으면 기본값인 빈 문자열을 저장한다.
		return "UserController.update3("+name+")";
	}

	@ResponseBody
	@RequestMapping("/list")
	public String list(@RequestParam(value="p", required=true, defaultValue="1") int pageNo) {
		// n이 없으면 기본값인 빈 문자열을 저장한다.
		return "UserController.list("+pageNo+")";
	}
	
}
