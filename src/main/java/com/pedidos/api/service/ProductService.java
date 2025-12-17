package com.pedidos.api.service;

import com.pedidos.api.dto.ProductRequest;
import com.pedidos.api.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> findAllProducts();
    ProductResponse create(ProductRequest request);
    void update(ProductRequest request, Long idRequest);
}
