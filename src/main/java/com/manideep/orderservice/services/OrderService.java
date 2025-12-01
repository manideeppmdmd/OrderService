package com.manideep.orderservice.services;

import com.manideep.orderservice.clients.ProductServiceClient;
import com.manideep.orderservice.dto.CreateOrderResponseDTO;
import com.manideep.orderservice.dto.OrderItemDTO;
import com.manideep.orderservice.dto.OrderRequestDTO;
import com.manideep.orderservice.dto.ProductDTO;
import com.manideep.orderservice.entity.Order;
import com.manideep.orderservice.entity.OrderItem;
import com.manideep.orderservice.mappers.OrderItemMapper;
import com.manideep.orderservice.mappers.OrderMapper;
import com.manideep.orderservice.repository.OrderRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService {

  private final OrderRepository orderRepository;
  private final ProductServiceClient productClient;

  public OrderService(
    OrderRepository _orderRepository,
    ProductServiceClient _client
  ) {
    this.orderRepository = _orderRepository;
    this.productClient = _client;
  }

  @Override
  public CreateOrderResponseDTO create(OrderRequestDTO dto) {
    Order order = OrderMapper.toEntity(dto);

    List<OrderItem> items = new ArrayList<>();

    for (OrderItemDTO itemDto : dto.getItems()) {
      ProductDTO product = productClient.getProductById(itemDto.getProductId());
      double pricePerUnit = product.getPrice();
      double totalPrice = itemDto.getQuantity() * pricePerUnit;

      items.add(
        OrderItemMapper.toEntity(itemDto, order, totalPrice, totalPrice)
      );
    }

    order.setItems(items);

    this.orderRepository.save(OrderMapper.toEntity(dto));

    return OrderMapper.toDto(order);
  }
}
