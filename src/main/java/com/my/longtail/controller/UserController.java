package com.my.longtail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value = {"/", "/login"}, method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView signin() {
		System.out.println("test test");
		ModelAndView model = new ModelAndView();
		model.setViewName("/user/login");
		
		return model;
	}
}
