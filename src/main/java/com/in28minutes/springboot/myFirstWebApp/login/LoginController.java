package com.in28minutes.springboot.myFirstWebApp.login;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.ModelMap;

@Controller
public class LoginController {


    @RequestMapping("login")
    public String loginJsp(@RequestParam String name, ModelMap model) {

        model.put("name", name);

        return "login";
    }
}
