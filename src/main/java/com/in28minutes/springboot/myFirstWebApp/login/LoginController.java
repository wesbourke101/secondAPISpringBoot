package com.in28minutes.springboot.myFirstWebApp.login;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private AuthenticationService authenticationService;

    public LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @RequestMapping(value="login", method = RequestMethod.GET)
    public String loginJsp() {
        return "login";
    }
    @RequestMapping(value="login", method = RequestMethod.POST)
    public String welcomeJsp(@RequestParam String name,
                                @RequestParam String password, ModelMap model) {

        if(authenticationService.authenticate(name, password)) {

            model.put("name", name);
            model.put("password", password);

            //Authentication Logic
            //name - Wes
            //Password - Dummy
            return "welcome";
        }
        return "login";
    }
}
