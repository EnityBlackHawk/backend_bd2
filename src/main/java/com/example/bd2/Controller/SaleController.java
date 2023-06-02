package com.example.bd2.Controller;

import com.example.bd2.DTO.SaleDTO;
import com.example.bd2.Model.Sale;
import com.example.bd2.Service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
