/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package upeu.edu.pe.TechnoShop.infrastructure.adapter;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import upeu.edu.pe.TechnoShop.infrastructure.entity.ProductEntity;
import upeu.edu.pe.TechnoShop.infrastructure.entity.StockEntity;

/**
 *
 * @author LAB-2
 */
public interface StockCrudRepository extends CrudRepository<StockEntity, Integer>{
       List<StockEntity> getStockByProductEntity(ProductEntity productEntity);  
 
}
