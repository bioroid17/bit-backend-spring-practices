package com.bitacademy.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitacademy.guestbook.repository.GuestbookRepository;
import com.bitacademy.guestbook.vo.GuestbookVo;

@Controller
public class GuestbookController {
	
	@Autowired
	private GuestbookRepository guestbookRepository;

	@RequestMapping("/")
	public String list(Model model) {
		List<GuestbookVo> list = guestbookRepository.findAll();
		int count = list.size();
		
		model.addAttribute("list", list);
		model.addAttribute("count", count);
		
		return "/WEB-INF/views/index.jsp";
	}

	@RequestMapping("/add")
	public String add(GuestbookVo vo) {
		guestbookRepository.insert(vo);
		
		return "redirect:/";
	}

	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(String no, Model model) {

		model.addAttribute("no", no);
		return "/WEB-INF/views/delete.jsp";
	}

	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(String no, String password, Model model) {
		boolean equal = guestbookRepository.checkPassword(no, password);
		if (equal){
			guestbookRepository.delete(no);
			return "redirect:/";
		} else {
			model.addAttribute("status", "비밀번호가 일치하지 않습니다.");
			model.addAttribute("no", no);
			return "/WEB-INF/views/delete.jsp";
		}
		
	}
}
