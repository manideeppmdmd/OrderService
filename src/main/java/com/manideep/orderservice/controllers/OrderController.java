package com.manideep.orderservice.controllers;

import com.manideep.orderservice.dto.CreateOrderResponseDTO;
import com.manideep.orderservice.dto.OrderRequestDTO;
import com.manideep.orderservice.services.IOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

  private final IOrderService orderService;

  public OrderController(IOrderService _orderService) {
    this.orderService = _orderService;
  }

  @PostMapping
  public ResponseEntity<CreateOrderResponseDTO> createOrder(
    @RequestBody OrderRequestDTO order
  ) {
    CreateOrderResponseDTO response = orderService.create(order);
    return ResponseEntity.ok(response);
  }
}
