package com.txt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.txt.dao.CategoryDAO;
import com.txt.dao.ProductDAO;
import com.txt.dto.Category;
import com.txt.dto.Product;
import com.txt.util.FileUploadUtility;

@Controller
@RequestMapping(value = { "/manage" })
public class ManagerController {

	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private CategoryDAO categoryDAO;

	@RequestMapping(value = { "/add-product" })
	public String manageProduct(@RequestParam(name = "operation", required = false) String operation, Model model) {
		Product product = new Product();
		product.setActive(true);
		List<Category> listCategory = categoryDAO.list();
		model.addAttribute("product", product);
		model.addAttribute("categories", listCategory);

		if (operation != null) {
			if (operation.equals("product")) {
				model.addAttribute("message", "Product submitted successfully");
			} else if (operation.equals("category")) {
				model.addAttribute("message", "Category submitted successfully");
			}
		}

		return "add-product";
	}

	@RequestMapping(value = { "/products" })
	public String ProductSubmission(@Validated @ModelAttribute("product") Product product, BindingResult result,
			Model model, HttpServletRequest request) {

		if (result.hasErrors()) {
			return "add-product";
		}

		FileUploadUtility.uploadFile(product.getFile(), request, product);

		if (product.getId() == 0) {
			productDAO.add(product);
		}

		return "redirect:/manage/add-product?operation=product";
	}

}
