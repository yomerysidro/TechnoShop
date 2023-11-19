/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.TechnoShop.app.service;

import upeu.edu.pe.TechnoShop.app.repository.OrderRepository;
import upeu.edu.pe.TechnoShop.infrastructure.adapter.OrderProductCrudRepository;
import upeu.edu.pe.TechnoShop.infrastructure.entity.OrderEntity;
import upeu.edu.pe.TechnoShop.infrastructure.entity.UserEntity;

/**
 *
 * @author LAB-2
 */
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderProductCrudRepository orderProductCrudRepository;

    public OrderService(OrderRepository orderRepository, OrderProductCrudRepository orderProductCrudRepository) {
        this.orderRepository = orderRepository;
        this.orderProductCrudRepository = orderProductCrudRepository;
    }

    public OrderEntity createOrder(OrderEntity order) {
        return orderRepository.createOrder(order);
    }

    public Iterable<OrderEntity> getOrders() {
        return orderRepository.getOrders();
    }

    public Iterable<OrderEntity> getOrdersByUser(UserEntity user) {
        return orderRepository.getOrdersByUser(user);

    }

    public long getOrderCount() {
        return orderProductCrudRepository.count(); 
    }
}
