package com.example.bd2.Service;

import com.example.bd2.Model.Product;
import com.example.bd2.Repository.ProductRepository;
import com.example.bd2.Repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SupplierService supplierService;


    public boolean Add(Product product)
    {
        if(supplierService.FindById(product.getSupplier().getId()) == null)
            supplierService.Add(product.getSupplier());
        return productRepository.save(product) != null;
    }

    public Product FindById(Long id)
    {
        return  productRepository.findById(id).orElse(null);
    }

    public List<Product> GetAll()
    {
        return productRepository.findAll();
    }



}