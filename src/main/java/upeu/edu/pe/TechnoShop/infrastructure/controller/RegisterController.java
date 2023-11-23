/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.TechnoShop.infrastructure.controller;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import upeu.edu.pe.TechnoShop.app.service.RegistrationService;
import upeu.edu.pe.TechnoShop.infrastructure.dto.UserDto;
import upeu.edu.pe.TechnoShop.infrastructure.entity.UserEntity;

/**
 *
 * @author LAB-2
 */
@Controller
@RequestMapping("/register")
public class RegisterController {

    private JavaMailSender javaMailSender;
    private final RegistrationService registrationService;
    private final Logger log = LoggerFactory.getLogger(RegisterController.class);

    public RegisterController(JavaMailSender javaMailSender, RegistrationService registrationService) {
        this.javaMailSender = javaMailSender;
        this.registrationService = registrationService;
    }

    @GetMapping
    public String register(UserDto userDto, Model model) {
        long userCount = registrationService.getUserCount();
        System.out.println("User Count: " + userCount);
        model.addAttribute("userCount", userCount);
        // Imprime el contenido del modelo
        model.asMap().forEach((key, value) -> System.out.println(key + ": " + value));

        return "register";
    }

    @PostMapping
    public String registerUser(@Valid UserDto userDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
//        user.setDateCreated(LocalDateTime.now());
//        user.setUserType(UserType.USER);
//        user.setUsername(user.getEmail());
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(
                    e -> {
                        log.info("Error {}", e.getDefaultMessage());
                    }
            );
            return "register";
        }
        UserEntity registeredUser = registrationService.register(userDto.userDtoToUser());
        // Envía el correo de registro exitoso
        enviarEmail(registeredUser.getEmail());
        redirectAttributes.addFlashAttribute("success", "Usuario creado correctamente. Se ha enviado un correo de confirmación.");
        return "redirect:/login";
    }

    private void enviarEmail(String userEmail) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(userEmail);
        mailMessage.setSubject("Registro Exitoso");
        mailMessage.setText("¡Gracias por registrarte en TechnoShop! Tu cuenta ha sido creada exitosamente.");

        javaMailSender.send(mailMessage);
    }
}
