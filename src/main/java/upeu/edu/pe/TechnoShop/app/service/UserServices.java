/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.TechnoShop.app.service;

import upeu.edu.pe.TechnoShop.app.repository.UserRepository;
import upeu.edu.pe.TechnoShop.infrastructure.entity.UserEntity;

/**
 *
 * @author LAB-2
 */
public class UserServices {
     private final UserRepository userRepository;

    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity createUser(UserEntity user){
        return userRepository.createUser(user);
    }
    public UserEntity findByEmail(String email){
        return userRepository.findByEmail(email);
    }
    public UserEntity findById (Integer id){
        return userRepository.findById(id);
    }
}
