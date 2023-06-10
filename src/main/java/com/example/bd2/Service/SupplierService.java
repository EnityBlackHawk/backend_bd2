package com.example.bd2.Service;

import com.example.bd2.Model.Supplier;
import com.example.bd2.Repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository repository;


    public boolean Add(Supplier s)
    {
        return repository.save(s) != null;
    }

    public Supplier FindById(Long id)
    {
        return repository.findById(id).orElse(null);
    }

    public List<Supplier> FindAll() {return repository.findAll();}

}
