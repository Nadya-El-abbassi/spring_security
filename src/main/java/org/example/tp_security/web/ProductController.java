package org.example.tp_security.web;


import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.example.tp_security.entities.Product;
import org.example.tp_security.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping("/index")
    public String index(Model model) {
      List<Product> products=productRepository.findAll();
      model.addAttribute("productList",products);
        return "products";
    }
    @GetMapping("/")
    public String home() {

        return "redirect:/index";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam(name ="id") Long id) {
        productRepository.deleteById(id);
        return "redirect:/index";
}}
