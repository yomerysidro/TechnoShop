/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.TechnoShop.infrastructure.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author LAB-2
 */
//getter And setter
@Data
//constructor lleno
@AllArgsConstructor
//consytuctor vacio
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String firtName;
    private String lastName;
    private String email;
    private String address;
    private String cellphone;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserType userType;

    private LocalDateTime dateCreated;

    //obteniendo el nombre y apellido del cliente de la orden
    public String getFullName() {
        // Lógica para obtener el nombre completo, por ejemplo:
        return this.firtName + " " + this.lastName;
    }

}
