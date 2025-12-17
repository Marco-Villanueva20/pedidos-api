package com.pedidos.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record ProductRequest(
        @NotBlank(message = "El nombre es obligatorio")
        String name,
        @PositiveOrZero(message = "El precio debe ser positivo")
        BigDecimal originalPrice,
        BigDecimal offerPrice,
        @NotNull(message = "Debe de crear una imagen")
        String imageUrl,
        Boolean hasDiscount,
        String description
) {
}
