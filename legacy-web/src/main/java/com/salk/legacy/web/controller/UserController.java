package com.salk.legacy.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.salk.legacy.domain.User;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	@RequestMapping("/add_user.html")
public String addUser(ModelAndView view,User user){
		//user
	return "";
}
public String editUser(ModelAndView view,User user){
	return null;
	
}
@RequestMapping("/user_list.html")
public String list(ModelAndView view,User user){
	
	return "user/user_list";
}
}
