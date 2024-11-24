package com.example.bd2.Service;

import com.example.bd2.Exception.SupplierNotFoundException;
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
        if( product.getSupplier().getId() == null || supplierService.FindById(product.getSupplier().getId()) == null) {
            throw new SupplierNotFoundException("Fornecedor nao encontrado - id: " + product.getSupplier().getId());
        }


        return productRepository.save(product) != null;
    }

    public Product update(Product product)
    {
        return productRepository.save(product);
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
