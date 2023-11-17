/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.TechnoShop.infrastructure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import upeu.edu.pe.TechnoShop.app.service.LoginService;

/**
 *
 * @author LAB-2
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }
    @GetMapping
    public String login(){
        return "login";
    }
}
