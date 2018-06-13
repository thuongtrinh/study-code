package com.txt.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.txt.dao.BrandDAO;
import com.txt.dao.CategoryDAO;
import com.txt.dao.ProductDAO;
import com.txt.dto.User;
import com.txt.service.UserService;

@Controller
public class HomeController {

	// @Autowired
	// private CategoryService categoryService;
	@Autowired
	private UserService userService;
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private BrandDAO brandDAO;
	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value = { "/home", "/", "/index" })
	public String home(Model model) {
		model.addAttribute("categories", categoryDAO.list());
		model.addAttribute("brands", brandDAO.list());
		model.addAttribute("products", productDAO.list());
		return "index";
	}

	@RequestMapping(value = "/contact-us")
	public String contact(Model model) {
		return "contact-us";
	}

	@RequestMapping(value = "/notfound")
	public String notfound(Model model) {
		return "404";
	}

	@RequestMapping(value = "/cart")
	public String cart(Model model) {
		return "cart";
	}

	@RequestMapping(value = "/product-details")
	public String productDetails(Model model) {
		return "product-details";
	}

	@RequestMapping(value = "/checkout")
	public String checkout(Model model) {
		return "checkout";
	}

	@RequestMapping(value = "/shop")
	public String shop(Model model) {
		return "shop";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(Model model) {
		User user = new User();
		user.setEnable(true);
		model.addAttribute("user", user);
		return "login";
	}

/*	@RequestMapping(value = "/register")
	public String register(Model model) {
		User user = new User();
		user.setEnable(true);
		model.addAttribute("user", user);
		return "register";
	}*/

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(@Valid @ModelAttribute("user") User user, BindingResult result) {
		if (result.hasErrors()) {
			return "login";
		}
		userService.saveUser(user);
		return "index";
	}

}
