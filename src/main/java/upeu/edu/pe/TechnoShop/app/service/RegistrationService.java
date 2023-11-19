/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.TechnoShop.app.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import upeu.edu.pe.TechnoShop.infrastructure.adapter.UserCrudRepository;
import upeu.edu.pe.TechnoShop.infrastructure.entity.UserEntity;

/**
 *
 * @author LAB-2
 */
public class RegistrationService {
    private final UserServices userServices;
    private final UserCrudRepository userCrudRepository;
    private final PasswordEncoder passwordEncoder;

    public RegistrationService(UserServices userServices, UserCrudRepository userCrudRepository, PasswordEncoder passwordEncoder) {
        this.userServices = userServices;
        this.userCrudRepository = userCrudRepository;
        this.passwordEncoder = passwordEncoder;
    }

 
    
    public void register(UserEntity user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userServices.createUser(user);
    }
        public long getUserCount() {
        return userCrudRepository.count();
    }
    
}
