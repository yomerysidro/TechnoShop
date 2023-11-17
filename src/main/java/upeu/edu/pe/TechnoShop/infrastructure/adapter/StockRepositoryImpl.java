/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.TechnoShop.infrastructure.adapter;

import java.util.List;
import org.springframework.stereotype.Repository;
import upeu.edu.pe.TechnoShop.app.repository.StockRepository;
import upeu.edu.pe.TechnoShop.infrastructure.entity.ProductEntity;
import upeu.edu.pe.TechnoShop.infrastructure.entity.StockEntity;

/**
 *
 * @author LAB-2
 */
@Repository
public class StockRepositoryImpl implements StockRepository{
private final StockCrudRepository stockCrudRepository;

    public StockRepositoryImpl(StockCrudRepository stockCrudRepository) {
        this.stockCrudRepository = stockCrudRepository;
    }

    @Override
    public StockEntity saveStock(StockEntity stockEntity) {
        return stockCrudRepository.save(stockEntity);
    }

    @Override
    public List<StockEntity> getStockByProductEntity(ProductEntity productEntity) {
    return stockCrudRepository.getStockByProductEntity(productEntity);
    }
    
}
