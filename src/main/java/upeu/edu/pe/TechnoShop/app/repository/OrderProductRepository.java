/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package upeu.edu.pe.TechnoShop.app.repository;

import java.util.List;
import upeu.edu.pe.TechnoShop.infrastructure.entity.OrderEntity;
import upeu.edu.pe.TechnoShop.infrastructure.entity.OrderProductEntity;

/**
 *
 * @author LAB-2
 */
public interface OrderProductRepository {
    public OrderProductEntity create (OrderProductEntity orderProduct);
    public Iterable<OrderProductEntity> getOrderProducts();
    public List<OrderProductEntity> getOrdersProductByOrder(OrderEntity orderEntity);
}
