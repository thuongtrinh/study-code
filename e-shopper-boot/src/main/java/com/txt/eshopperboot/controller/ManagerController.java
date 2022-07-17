package com.txt.eshopperboot.controller;

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

import com.txt.eshopperboot.dto.Category;
import com.txt.eshopperboot.dto.Product;
import com.txt.eshopperboot.repositories.CategoryRepository;
import com.txt.eshopperboot.repositories.ProductRepository;
import com.txt.eshopperboot.util.FileUploadUtility;

@Controller
@RequestMapping(value = { "/manage" })
public class ManagerController {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	@RequestMapping(value = { "/add-product" })
	public String manageProduct(@RequestParam(name = "operation", required = false) String operation, Model model) {
		Product product = new Product();
		product.setActive(true);
		List<Category> listCategory = categoryRepository.findAll();
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
			productRepository.save(product);
		}

		return "redirect:/manage/add-product?operation=product";
	}

}
