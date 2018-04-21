package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;

/**
 * @author Hung V. PHAM
 *
 */
@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @GetMapping({ "/add-product" })
    public String getPageAddProduct(Model model) {
        Product product = new Product();
        List<Category> categories = categoryService.findAll();
        model.addAttribute("product", product);
        model.addAttribute("categories", categories);

        return "add-product";
    }

    @PostMapping({ "/add-product" })
    public String addProduct(@ModelAttribute Product product) {
        productService.addProduct(product);

        return "redirect:/home";
    }

    @GetMapping({ "/delete-product" })
    public String deleteProduct(@RequestParam int id) {
        productService.deleteProduct(id);

        return "redirect:/home";
    }

    @GetMapping({ "/edit-product" })
    public String getPageUpdateProduct(Model model, @RequestParam int id) {
        Product product = productService.findById(id);
        List<Category> categories = categoryService.findAll();
        model.addAttribute("product", product);
        model.addAttribute("categories", categories);

        return "edit-product";
    }

    @PostMapping({ "/edit-product" })
    public String updateProduct(@ModelAttribute Product product) {
        productService.updateProduct(product);

        return "redirect:/home";
    }

}
