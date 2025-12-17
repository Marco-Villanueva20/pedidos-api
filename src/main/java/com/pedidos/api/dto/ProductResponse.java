package com.pedidos.api.dto;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

public record ProductResponse(
        Long id,
        String name,
        BigDecimal originalPrice,
        BigDecimal offerPrice,
        String imageUrl,
        Boolean hasDiscount,
        String description
) {
}
