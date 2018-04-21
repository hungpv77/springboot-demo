package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserService;

/**
 * @author Hung V. PHAM
 *
 */
@Controller
public class HomeController {

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @GetMapping({ "/", "/home" })
    public String showHome(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "home";
    }

}
