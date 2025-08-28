package com.example.ws.api;

import com.example.ws.domain.Product;
import com.example.ws.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductApi {

    private final ProductService productService;

    public ProductApi(ProductService productService) {
        this.productService = productService;
    }

    // http://localhost:9090/api/products
    @GetMapping
    public List<Product> findAll(){
        return productService.loadAll();
    }

    // http://localhost:9090/api/products/search?name=
    @GetMapping("/search")
    public List<Product> search(@RequestParam String x){
        return productService.search(x);
    }

    @PostMapping
    public ResponseEntity<Product> addNew(@RequestBody Product product){
      productService.insert(product);
        return ResponseEntity.status(201).body(product);
    }
}
