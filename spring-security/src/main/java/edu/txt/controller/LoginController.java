package edu.txt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping(value = { "/", "/index", "/login" })
	public String login(Model model) {
		return "login";
	}

	@RequestMapping(value = { "/access-denied" })
	public String logout(Model model, HttpServletRequest request, HttpServletResponse respone) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication != null){
			new SecurityContextLogoutHandler().logout(request, respone, authentication);
		}
		return "redirect:/login";
	}

}
