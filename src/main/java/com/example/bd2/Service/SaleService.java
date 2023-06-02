package com.example.bd2.Service;

import com.example.bd2.DTO.SaleDTO;
import com.example.bd2.Model.Sale;
import com.example.bd2.Repository.SaleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;


    public List<SaleDTO> GetAll()
    {
        var sales = repository.findAll();
        ModelMapper mm = new ModelMapper();
        List<SaleDTO> ret = new ArrayList<>();
        sales.forEach(s ->
        {
            ret.add(mm.map(s, SaleDTO.class));
        });
        return ret;
    }

}
