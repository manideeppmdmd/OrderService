package com.manideep.orderservice.clients;

import com.manideep.orderservice.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Value; // create this DTO
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class ProductServiceClient {

  private final RestClient restClient;

  public ProductServiceClient(
    RestClient.Builder restClientBuilder,
    @Value(
      "${product.service.base-url:http://ECOMMERCESPRING}"
    ) String productServiceBaseUrl
  ) {
    this.restClient = restClientBuilder.baseUrl(productServiceBaseUrl).build();
  }

  public ProductDTO getProductById(Long productId) {
    return restClient
      .get()
      .uri("/api/products/{id}", productId)
      .retrieve()
      .body(ProductDTO.class);
  }
}
