package com.salk.legacy.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salk.legacy.booking.service.UserService;
import com.salk.legacy.domain.User;

@Controller
public class LoginController extends BaseController {
	@Autowired
	private UserService userService;

	@RequestMapping("/logon.html")
	public String logon(Model model, User user, HttpServletRequest request) {
		User login = userService.login(user);
		if (login == null) {
			model.addAttribute("errorMessage", "用戶名或密碼不正確");
			return "login";
		} else {
			request.getSession().setAttribute("loginInfo", login);
			return "redirect:/index";

		}
	}

	@RequestMapping("/login.html")
	public String login(Model model, User user, HttpServletRequest request) {
		return "login";
	}
}
