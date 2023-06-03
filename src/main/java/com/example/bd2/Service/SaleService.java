package com.example.bd2.Service;

import com.example.bd2.DTO.SaleDTO;
import com.example.bd2.Model.Sale;
import com.example.bd2.Repository.SaleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;

    @Autowired
    private ItemsService itemsService;


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

    public Boolean Add(Sale sale)
    {
        sale.setTime(Timestamp.valueOf(LocalDateTime.now()));
        var id = repository.save(sale).getCode();
        sale.setCode(id);
        for (var i : sale.getItems())
        {
            i.setSale(sale);
            i.setPartialValue(i.getProduct().getValue() * i.getQuantity());
            itemsService.Add(i);

        }
        return true;
    }

}
