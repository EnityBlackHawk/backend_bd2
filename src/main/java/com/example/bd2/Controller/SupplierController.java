package com.example.bd2.Controller;

import com.example.bd2.Model.Supplier;
import com.example.bd2.Service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping(value = "/add")
    public ResponseEntity<Boolean> Add(@RequestBody Supplier supplier)
    {
        return ResponseEntity.ok(supplierService.Add(supplier));
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<Supplier>> GetAll()
    {
        return ResponseEntity.ok(supplierService.FindAll());
    }

}
