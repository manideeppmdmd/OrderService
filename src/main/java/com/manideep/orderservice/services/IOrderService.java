package com.manideep.orderservice.services;

import com.manideep.orderservice.dto.CreateOrderResponseDTO;
import com.manideep.orderservice.dto.OrderRequestDTO;

public interface IOrderService {
  public CreateOrderResponseDTO create(OrderRequestDTO order);
}
