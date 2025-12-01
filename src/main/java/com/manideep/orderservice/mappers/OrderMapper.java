package com.manideep.orderservice.mappers;

import com.manideep.orderservice.dto.CreateOrderResponseDTO;
import com.manideep.orderservice.dto.OrderRequestDTO;
import com.manideep.orderservice.entity.Order;
import com.manideep.orderservice.enums.OrderStatus;

public class OrderMapper {

  public static Order toEntity(OrderRequestDTO dto) {
    return Order.builder()
      .userId(dto.getUserId())
      .status(OrderStatus.PENDING)
      .build();
  }

  public static CreateOrderResponseDTO toDto(Order order) {
    return CreateOrderResponseDTO.builder()
      .orderId(order.getId())
      .status(order.getStatus())
      .build();
  }
}
