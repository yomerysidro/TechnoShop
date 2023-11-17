/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.TechnoShop.infrastructure.adapter;

import org.springframework.stereotype.Repository;
import upeu.edu.pe.TechnoShop.app.repository.OrderRepository;
import upeu.edu.pe.TechnoShop.infrastructure.entity.OrderEntity;
import upeu.edu.pe.TechnoShop.infrastructure.entity.UserEntity;

/**
 *
 * @author LAB-2
 */
@Repository
public class OrderRepositoryImpl implements OrderRepository {
    private final OrderCrudRepository orderCrudRepository;

    public OrderRepositoryImpl(OrderCrudRepository orderCrudRepository) {
        this.orderCrudRepository = orderCrudRepository;
    }
    

    @Override
    public OrderEntity createOrder(OrderEntity order) {
        return orderCrudRepository.save(order);
    }

    @Override
    public Iterable<OrderEntity> getOrders() {
        return orderCrudRepository.findAll();
    }

    @Override
    public Iterable<OrderEntity> getOrdersByUser(UserEntity user) {
        return orderCrudRepository.findByUser(user);
    }
}
