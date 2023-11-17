/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package upeu.edu.pe.TechnoShop.app.repository;

import java.util.List;
import upeu.edu.pe.TechnoShop.infrastructure.entity.ProductEntity;
import upeu.edu.pe.TechnoShop.infrastructure.entity.StockEntity;

/**
 *
 * @author LAB-2
 */
public interface StockRepository {
    StockEntity saveStock(StockEntity stockEntity);
    List<StockEntity> getStockByProductEntity(ProductEntity productEntity);  
}
