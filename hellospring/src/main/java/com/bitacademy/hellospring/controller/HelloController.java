package com.bitacademy.hellospring.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String hello() {
		return "/WEB-INF/views/hello.jsp";
	}

	@RequestMapping("/hello2")
	public String hello2(String name) {
		System.out.println("name:"+name);
		return "/WEB-INF/views/hello.jsp";
	}

	@RequestMapping("/hello3")
	public ModelAndView hello3(String name) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", name);
		mav.setViewName("/WEB-INF/views/hello3.jsp");
		return mav;
	}

	@RequestMapping("/hello4")
	public String hello4(String name, Model model) {
		model.addAttribute("name", name);
		return "/WEB-INF/views/hello3.jsp";
	}

	@ResponseBody
	@RequestMapping("/hello5")
	public String hello5() {
		// @ResponseBody가 붙어있으므로 String만 받는다.
		// String의 형식(json, xml 등)이 달라도 MessageConverter가 실행
		// ajax에서 쓰기 유용하다.
		return "<h1>Hello World</h1>";
	}

	@RequestMapping("/hello6")
	public String hello6() {
		// redirect 하는 방법
		// 기술 비침투: Spring은 새로운 기술의 침투를 허용하지 않는다.
		return "redirect:/hello";
	}
	
	@RequestMapping("/hello7")
	public void hello7(HttpServletRequest request, HttpServletResponse response, Writer out) throws IOException{
		// 일단 Spring에서 지원하지만, 좋은 코드가 아니다.
		// Spring은 JavaEE와 결별하려고 하고 있음
		// Servlet을 쓰는 것은 Spring의 기술 비침투 원칙을 위반하는 것
		
		String name = request.getParameter("name");
		out.write("hello " + name);
	}
}
