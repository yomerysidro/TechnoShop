/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.TechnoShop.infrastructure.controller;

import java.util.List;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import upeu.edu.pe.TechnoShop.app.service.OrderService;
import upeu.edu.pe.TechnoShop.app.service.ProductService;
import upeu.edu.pe.TechnoShop.app.service.RegistrationService;
import upeu.edu.pe.TechnoShop.app.service.UserServices;
import upeu.edu.pe.TechnoShop.infrastructure.adapter.ProductCrudRepository;
import upeu.edu.pe.TechnoShop.infrastructure.adapter.UserCrudRepository;
import upeu.edu.pe.TechnoShop.infrastructure.entity.OrderEntity;
import upeu.edu.pe.TechnoShop.infrastructure.entity.ProductEntity;
import upeu.edu.pe.TechnoShop.infrastructure.entity.UserEntity;

/**
 *
 * @author LAB-2
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    private final ProductService productService;
    private final RegistrationService registrationService;
    private final UserServices userService;
    private final OrderService orderService;
    private final UserCrudRepository userCrudRepository;
    private final ProductCrudRepository productCrudRepository;

    public AdminController(ProductService productService, RegistrationService registrationService, UserServices userService, OrderService orderService, UserCrudRepository userCrudRepository, ProductCrudRepository productCrudRepository) {
        this.productService = productService;
        this.registrationService = registrationService;
        this.userService = userService;
        this.orderService = orderService;
        this.userCrudRepository = userCrudRepository;
        this.productCrudRepository = productCrudRepository;
    }

    @GetMapping
    public String Template(Model model) {
        // Obtener el nombre del usuario autenticado
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        // Obtener el nombre del usuario desde la base de datos
        UserEntity user = userService.findByEmail(username);
        String fullName = user.getFirtName();
        // Agregar el nombre del usuario al modelo
        model.addAttribute("useradmin", fullName);

        //Mostrar la cantidad de usuarios registrados
        long userCount = registrationService.getUserCount();
        model.addAttribute("userCount", userCount);
        long orderCount = orderService.getOrderCount();  // orden
        model.addAttribute("orderCount", orderCount);

        System.out.println("User Count: " + userCount);
        //mostrando toda la lista de los pedidos
        Iterable<OrderEntity> orders = orderService.getOrders();
        model.addAttribute("orders", orders);

        // Obtener la lista de todos los usuarios registrados
        Iterable<UserEntity> registeredUsers = userCrudRepository.findAll();
        model.addAttribute("registeredUsers", registeredUsers);

        // Obtener la cantidad total de productos registrados
        long totalProducts = productCrudRepository.count();
        model.addAttribute("totalProducts", totalProducts);

        return "admin/templates_admin";
    }

    @GetMapping("/products")
    public String home(Model model) {
        model.addAttribute("products", productService.getProducts());
        return "admin/home_admin";

    }

}
