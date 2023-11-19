/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.TechnoShop.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.context.WebApplicationContext;
import upeu.edu.pe.TechnoShop.app.repository.OrderProductRepository;
import upeu.edu.pe.TechnoShop.app.repository.OrderRepository;
import upeu.edu.pe.TechnoShop.app.repository.ProductRepository;
import upeu.edu.pe.TechnoShop.app.repository.StockRepository;
import upeu.edu.pe.TechnoShop.app.repository.UserRepository;
import upeu.edu.pe.TechnoShop.app.service.CartService;
import upeu.edu.pe.TechnoShop.app.service.LoginService;
import upeu.edu.pe.TechnoShop.app.service.LogoutService;
import upeu.edu.pe.TechnoShop.app.service.OrderProductService;
import upeu.edu.pe.TechnoShop.app.service.OrderService;
import upeu.edu.pe.TechnoShop.app.service.ProductService;
import upeu.edu.pe.TechnoShop.app.service.RegistrationService;
import upeu.edu.pe.TechnoShop.app.service.StockService;
import upeu.edu.pe.TechnoShop.app.service.UploadFile;
import upeu.edu.pe.TechnoShop.app.service.UserServices;
import upeu.edu.pe.TechnoShop.app.service.ValidateStock;
import upeu.edu.pe.TechnoShop.infrastructure.adapter.OrderProductCrudRepository;
import upeu.edu.pe.TechnoShop.infrastructure.adapter.UserCrudRepository;

/**
 *
 * @author LAB-2
 */
@Configuration
public class BeanConfiguration {

    @Bean
    public ProductService productService(ProductRepository productRepository, UploadFile uploadFile) {
        return new ProductService(productRepository, uploadFile);
    }

    @Bean
    public StockService stockService(StockRepository stockRepository) {
        return new StockService(stockRepository);
    }

    @Bean
    public UploadFile uploadFile() {
        return new UploadFile();
    }

    @Bean
    public ValidateStock validateStock(StockService stockService) {
        return new ValidateStock(stockService);
    }

    @Bean
    public OrderService orderService(OrderRepository orderRepository, OrderProductCrudRepository orderProductCrudRepository) {
        return new OrderService(orderRepository, orderProductCrudRepository);
    }

    @Bean
    public OrderProductService orderProductService(OrderProductRepository orderProductRepository) {
        return new OrderProductService(orderProductRepository);
    }

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public CartService cartService() {
        return new CartService();
    }

    @Bean
    public UserServices userService(UserRepository userRepository) {
        return new UserServices(userRepository);
    }

    @Bean
    public LoginService loginService(UserServices userService) {
        return new LoginService(userService);
    }

    @Bean
    public LogoutService logoutService() {
        return new LogoutService();
    }

    @Bean
    public RegistrationService registrationService(UserServices userService, UserCrudRepository userCrudRepository, PasswordEncoder passwordEncoder) {
        return new RegistrationService(userService, userCrudRepository, passwordEncoder);
    }

}
