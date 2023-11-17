/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package upeu.edu.pe.TechnoShop.app.repository;

import upeu.edu.pe.TechnoShop.infrastructure.entity.ProductEntity;
import upeu.edu.pe.TechnoShop.infrastructure.entity.UserEntity;

/**
 *
 * @author LAB-2
 */
public interface ProductRepository {
    //lista de todos los productos
    Iterable<ProductEntity> getProducts();
    //lista de productos por usuario
    Iterable<ProductEntity> getProductsByUser(UserEntity user);
    ProductEntity getProductById(Integer id);
    ProductEntity saveProduct(ProductEntity product);
    void deleteProductById(Integer id); 
}
