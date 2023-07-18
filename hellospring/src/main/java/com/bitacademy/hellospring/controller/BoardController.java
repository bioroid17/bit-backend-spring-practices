package com.bitacademy.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 *  @RequestMapping
 *  메소드(핸들러) 단독 매핑
 */
@Controller
public class BoardController {
	
	@ResponseBody
	@RequestMapping("/board/write")
	public String write() {
		return "BoardController.write()";
	}
	
	@ResponseBody
	@RequestMapping("/board/view")
	public String view(@RequestParam(value="no", required=true, defaultValue="0") Long no) {
		return "BoardController.view("+no+")";
	}
	
	@ResponseBody
	@RequestMapping("/board/{no}")
	public String view2(@PathVariable Long no) {
		return "BoardController.view()";
	}
}
