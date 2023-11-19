/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.TechnoShop.infrastructure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import upeu.edu.pe.TechnoShop.app.service.ProductService;
import upeu.edu.pe.TechnoShop.app.service.RegistrationService;

/**
 *
 * @author LAB-2
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    private final ProductService productService;
    private final RegistrationService registrationService;

    public AdminController(ProductService productService, RegistrationService registrationService) {
        this.productService = productService;
        this.registrationService = registrationService;
    }

    @GetMapping
    public String Template(Model model) {
        long userCount = registrationService.getUserCount();
        model.addAttribute("userCount", userCount);
    //    long orderCount = registrationService.getOrderCount();  // Nueva línea

        
        System.out.println("User Count: " + userCount);
        // model.addAttribute("orderCount", orderCount);
        return "admin/templates_admin";
    }

    @GetMapping("/products")
    public String home(Model model) {
        model.addAttribute("products", productService.getProducts());
        return "admin/home_admin";

    }

}
