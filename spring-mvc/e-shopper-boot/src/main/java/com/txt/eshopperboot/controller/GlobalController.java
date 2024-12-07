package com.txt.eshopperboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.txt.eshopperboot.dto.User;
import com.txt.eshopperboot.service.UserService;

@Controller
public class GlobalController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signup(@Valid @ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("Sign up account has error:\n" + result.toString());
            return "login";
        }

        userService.saveUser(user);
        return "redirect:/home";
    }

}
