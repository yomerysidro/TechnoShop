/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package upeu.edu.pe.TechnoShop.infrastructure.adapter;

import org.springframework.data.repository.CrudRepository;
import upeu.edu.pe.TechnoShop.infrastructure.entity.ProductEntity;
import upeu.edu.pe.TechnoShop.infrastructure.entity.UserEntity;

/**
 *
 * @author LAB-2
 */
public interface ProductCrudRepository extends CrudRepository<ProductEntity, Integer>{
       Iterable<ProductEntity> findByUserEntity(UserEntity userEntity);
 
}
