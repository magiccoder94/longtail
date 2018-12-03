package com.my.longtail.controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {


	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public ModelAndView admin_signin() {
		ModelAndView model = new ModelAndView();
		model.setViewName("/admin/admin_login");
		return model;
	}
	
//	public ModelAndView user_signin_fail() {
//		ModelAndView model = new ModelAndView();
//		if() {
//			
//		}
//	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView welcome_admin(Authentication authentication) {
		ModelAndView model = new ModelAndView();
		model.setViewName("/admin/welcome");
		return model;
	}
	
	@RequestMapping(value = "/signout", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView user_signout() {
		ModelAndView model = new ModelAndView();
		model.setViewName("/admin/admin_login");
		return model;
	}
	
	@RequestMapping(value = "/views/view_franchise", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView view_franchse() {
		ModelAndView model = new ModelAndView();
		model.setViewName("/admin/views/view_franchise");
		return model;
	}
}
