package com.example.bd2.Service;

import com.example.bd2.DTO.SaleDTO;
import com.example.bd2.DTO.add.SaleAddDTO;
import com.example.bd2.Exception.ProductNotAvailableException;
import com.example.bd2.Exception.ProductNotFoundException;
import com.example.bd2.Model.Items;
import com.example.bd2.Model.Sale;
import com.example.bd2.Repository.SaleRepository;
import jakarta.transaction.Transactional;
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

    @Autowired
    private ProductService productService;
    @Autowired
    private EmployeeService employeeService;


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


    public SaleDTO Add(SaleAddDTO dto) {

        ModelMapper mm = new ModelMapper();
        Sale sale = mm.map(dto, Sale.class);

        sale.setTime(Timestamp.valueOf(LocalDateTime.now()));
        sale.setTotalValue(0.0f);

        for (Items item : sale.getItems()) {
            item.setSale(sale);
            var product = item.getProduct();

            product = productService.FindById(product.getCode());

            if(product == null) {
                throw new ProductNotFoundException("Produto não encontrado");
            }

            if (product.getQuantity() < item.getQuantity()) {
                throw new ProductNotAvailableException("Quantidade insuficiente em estoque");
            }

            product.setQuantity(product.getQuantity() - item.getQuantity());

            product = productService.update(product);

            item.setProduct(product);

            var partialValue = product.getValue() * item.getQuantity();
            item.setPartialValue(partialValue);
            sale.setTotalValue(sale.getTotalValue() + partialValue);

        }

        var emp = employeeService.findById(sale.getEmployee().getId());
        if(emp != null) {
            sale.setEmployee(emp);
        }

        sale = repository.save(sale);
        itemsService.Add(sale.getItems());


        return mm.map(sale, SaleDTO.class);
    }

}
