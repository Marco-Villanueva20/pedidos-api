package com.pedidos.api.service.impl;

import com.pedidos.api.dto.ProductRequest;
import com.pedidos.api.dto.ProductResponse;
import com.pedidos.api.entity.Product;
import com.pedidos.api.mapper.ProductMapper;
import com.pedidos.api.repository.ProductRepository;
import com.pedidos.api.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    ;

    @Override
    public List<ProductResponse> findAllProducts() {
        return productRepository.findAll().stream().map(productMapper::toResponse
        ).toList();
    }

    @Override
    public ProductResponse create(ProductRequest request) {
        return productMapper.toResponse(productRepository.save(productMapper.toEntity(request)));
    }

    @Override
    public void update(ProductRequest request, Long idRequest) {
        Product product = productRepository.findById(idRequest)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        productMapper.updateEntity(product, request);
        productRepository.save(product);
    }


}
