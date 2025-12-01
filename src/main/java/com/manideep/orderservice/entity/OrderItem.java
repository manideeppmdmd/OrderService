package com.manideep.orderservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class OrderItem extends BaseEntity {

  private Long productId;

  private int quantity;

  private double pricePerUnit;

  private double totalPrice;

  @ManyToOne
  @JoinColumn(name = "order_id")
  private Order order;
}
