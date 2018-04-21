package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Hung V. PHAM
 *
 */
@Controller
public class LoginController {

    @GetMapping("/loginpage")
    public String showLogin() {
        return "login";
    }

}
