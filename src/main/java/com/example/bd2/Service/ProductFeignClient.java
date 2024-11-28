package com.example.bd2.Service;

import com.example.bd2.Model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "product-api", url = "${product-api.url}")
public interface ProductFeignClient {

    @GetMapping("/product/getAll")
    List<Product> getAll();

}
