package com.example.bd2.Service;

import com.example.bd2.Model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@FeignClient(name = "product-api", url = "${product-api.url}")
public interface ProductFeignClient {

    @GetMapping("/product/getAll")
    List<Product> getAll();

    @GetMapping("/product/{id}")
    Product getById(@PathVariable Long id);

    @PutMapping("/product/{id}")
    Product update(@PathVariable Long id, Product product);
}
