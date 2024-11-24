package com.example.bd2.Controller;

import com.example.bd2.Exception.ProductNotFoundException;
import com.example.bd2.Model.Product;
import com.example.bd2.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<Product>> GetAll()
    {
        return ResponseEntity.ok(service.GetAll());
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Boolean> Add(@RequestBody Product product)
    {
        return ResponseEntity.ok(service.Add(product));
    }

    public ResponseEntity<Product> FindById(@PathVariable Long id)
    {
        Product p = service.FindById(id);
        if(p == null) throw new ProductNotFoundException("Produto com id: " + id + " não encontrado");
        return ResponseEntity.ok(p);
    }

}
