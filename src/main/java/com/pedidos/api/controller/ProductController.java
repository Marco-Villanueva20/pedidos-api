package com.pedidos.api.controller;

import com.pedidos.api.dto.ProductRequest;
import com.pedidos.api.dto.ProductResponse;
import com.pedidos.api.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@CrossOrigin(origins = "https://pedidos-app-kappa.vercel.app/")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll(){
        return ResponseEntity.ok(productService.findAllProducts());
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody ProductRequest request, UriComponentsBuilder ucb){
        ProductResponse response = productService.create(request);
        URI location = ucb.path("/api/v1/products/{id}")
                .buildAndExpand(response.id()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody ProductRequest request, @PathVariable Long id){
        productService.update(request, id);
        return ResponseEntity.noContent().build();
    }

}
