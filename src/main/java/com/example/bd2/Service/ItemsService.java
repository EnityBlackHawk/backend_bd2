package com.example.bd2.Service;

import com.example.bd2.Model.Items;
import com.example.bd2.Repository.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemsService {

    @Autowired
    private ItemsRepository repository;


    public void Add(Items items)
    {
        repository.save(items);
    }

    public void Add(Iterable<Items> items)
    {
        repository.saveAll(items);
    }

}
