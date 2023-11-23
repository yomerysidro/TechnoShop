/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.TechnoShop.app.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.*;
import upeu.edu.pe.TechnoShop.infrastructure.entity.OrderEntity;
import upeu.edu.pe.TechnoShop.infrastructure.entity.OrderProductEntity;

/**
 *
 * @author YOMER YSIDRO
 */
@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void enviarPedidoConfirmacion(String userEmail, OrderEntity order, List<OrderProductEntity> orderProducts) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(userEmail);
        mailMessage.setSubject("Confirmación de Pedido");
        mailMessage.setText(construirContenidoCorreo(order, orderProducts));

        javaMailSender.send(mailMessage);
    }

    private void enviarCorreo(SimpleMailMessage mailMessage) {
        if (javaMailSender != null) {
            javaMailSender.send(mailMessage);
        } else {
            System.err.println("Error: JavaMailSender es nulo");
        }
    }

    private String construirContenidoCorreo(OrderEntity order, List<OrderProductEntity> orderProducts) {
        // Construir el contenido del correo con los detalles de la orden y los productos
        StringBuilder contenido = new StringBuilder();
        contenido.append("Gracias por tu pedido. Aquí están los detalles:\n\n");
        contenido.append("Número de orden: ").append(order.getId()).append("\n");
        contenido.append("Nombre completo: ").append(order.getUser().getFirtName()).append(" ").append(order.getUser().getLastName()).append("\n");
        contenido.append("Dirección: ").append(order.getUser().getAddress()).append("\n");
        contenido.append("Fecha de creación: ").append(formatearFecha(order.getDateCreated())).append("\n");
        contenido.append("Productos:\n");

        for (OrderProductEntity orderProduct : orderProducts) {
            contenido.append(" - ").append(orderProduct.getProductEntity().getName())
                    .append(", Cantidad: ").append(orderProduct.getQuantity())
                    .append(", Precio unitario: ").append(orderProduct.getProductEntity().getPrice())
                    .append("\n");
        }

        contenido.append("\nTotal de la orden: ").append(calcularTotalOrden(orderProducts));

        return contenido.toString();
    }

    private String formatearFecha(LocalDateTime fecha) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return fecha.format(formatter);
    }

    private BigDecimal calcularTotalOrden(List<OrderProductEntity> orderProducts) {
        // Calcular el total de la orden sumando los precios de los productos
        return orderProducts.stream()
                .map(op -> op.getProductEntity().getPrice().multiply(new BigDecimal(op.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
