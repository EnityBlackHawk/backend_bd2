package com.example.bd2.Controller;

import com.example.bd2.DTO.SaleDTO;
import com.example.bd2.DTO.add.SaleAddDTO;
import com.example.bd2.Model.Sale;
import com.example.bd2.Service.SaleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/sale")
public class SaleController {

    @Autowired
    private SaleService service;

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<SaleDTO>> GetAll()
    {
        return ResponseEntity.ok(service.GetAll());
    }

    @PostMapping(value = "/add")
    public ResponseEntity<SaleDTO> Add(@Valid @RequestBody SaleAddDTO sale) {return ResponseEntity.ok(service.Add(sale));}

}
