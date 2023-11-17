/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.TechnoShop.infrastructure.controller;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import upeu.edu.pe.TechnoShop.app.service.RegistrationService;
import upeu.edu.pe.TechnoShop.infrastructure.dto.UserDto;

/**
 *
 * @author LAB-2
 */
@Controller
@RequestMapping("/register")
public class RegisterController {
    private final RegistrationService registrationService;      
    private final Logger log = LoggerFactory.getLogger(RegisterController.class);

    

    public RegisterController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }
    @GetMapping
    public String register(UserDto userDto){
        return "register";
    }
    
     @PostMapping
    public String registerUser(@Valid UserDto userDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
//        user.setDateCreated(LocalDateTime.now());
//        user.setUserType(UserType.USER);
//        user.setUsername(user.getEmail());

        if(bindingResult.hasErrors()){
            bindingResult.getAllErrors().forEach(
                    e->{ log.info( "Error {}", e.getDefaultMessage() ); }
            );
            return "register";
        }
        registrationService.register(userDto.userDtoToUser());
        redirectAttributes.addFlashAttribute("success", "Usuario creado correctamente");
        return "redirect:/login";
    }
    
    
}
