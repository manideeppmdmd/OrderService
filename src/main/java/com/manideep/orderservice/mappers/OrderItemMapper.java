package com.manideep.orderservice.mappers;

import com.manideep.orderservice.dto.OrderItemDTO;
import com.manideep.orderservice.entity.Order;
import com.manideep.orderservice.entity.OrderItem;

public class OrderItemMapper {

  public static OrderItem toEntity(
    OrderItemDTO dto,
    Order order,
    double productPrice,
    double totalPrice
  ) {
    return OrderItem.builder()
      .productId(dto.getProductId())
      .quantity(dto.getQuantity())
      .pricePerUnit(productPrice)
      .totalPrice(totalPrice)
      .order(order)
      .build();
  }
}
