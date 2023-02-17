package com.in28minutes.springboot.myFirstWebApp.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.ModelMap;

@Controller
public class LoginController {

    @RequestMapping("login")
    public String loginJsp(@RequestParam String name, ModelMap model) {
        System.out.println("Request param is " + name); //NOT RECOMMENDED FOR PROD CODE
        return "login";
    }
}
