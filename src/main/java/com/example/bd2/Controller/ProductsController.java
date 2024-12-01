package com.example.bd2.Controller;

import com.example.bd2.Model.Product;
import com.example.bd2.Service.ProductFeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    private final ProductFeignClient productFeignClient;

    public ProductsController(ProductFeignClient productFeignClient) {
        this.productFeignClient = productFeignClient;
    }

    @GetMapping()
    public List<Product> getProducts(){
        return productFeignClient.getAll();
    }

}