package com.salk.legacy.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.salk.legacy.domain.User;

@Controller
public class IndexController {
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(ModelAndView view, HttpServletRequest request) {
		User attribute = (User) request.getSession().getAttribute("loginInfo");
		if (attribute != null) {
			view.getModel().put("loginInfo", attribute);
		} else {
			return "redirect:/login.html";

		}
		return "index";
	}
}
