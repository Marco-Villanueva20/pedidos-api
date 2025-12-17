package com.pedidos.api.mapper;

import com.pedidos.api.dto.ProductRequest;
import com.pedidos.api.dto.ProductResponse;
import com.pedidos.api.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductResponse toResponse(Product entity) {
        return new ProductResponse(
                entity.getId(),
                entity.getName(),
                entity.getOriginalPrice(),
                entity.getOfferPrice(),
                entity.getImageUrl(),
                entity.getHasDiscount(),
                entity.getDescription());
    }



    public Product toEntity(ProductRequest request) {
        Product entity = new Product();
        entity.setName(request.name());
        entity.setOriginalPrice(request.originalPrice());
        entity.setOfferPrice(request.offerPrice());
        entity.setImageUrl(request.imageUrl());
        entity.setHasDiscount(request.hasDiscount());
        entity.setDescription(request.description());
        return entity;
    }

    public void updateEntity(Product product, ProductRequest request) {
        product.setName(request.name());
        product.setOriginalPrice(request.originalPrice());
        product.setOfferPrice(request.offerPrice());
        product.setImageUrl(request.imageUrl());
        product.setHasDiscount(request.hasDiscount());
        product.setDescription(request.description());
    }
}
