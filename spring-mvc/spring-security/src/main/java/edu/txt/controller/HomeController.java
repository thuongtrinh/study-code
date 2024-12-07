package edu.txt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = {"/admin"})
    public String adminPage(Model model) {
//		model.addAttribute("Hello admin");
        return "admin";
    }

    @RequestMapping(value = {"/manager"})
    public String managerPage(Model model) {
//		model.addAttribute("Hello manager");
        return "manager";
    }

    @RequestMapping(value = {"/user"})
    public String userPage(Model model) {
//		model.addAttribute("Hello user");
        return "user";
    }

}
