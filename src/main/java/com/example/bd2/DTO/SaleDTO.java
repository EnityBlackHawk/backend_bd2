package com.example.bd2.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class SaleDTO {

    @Setter
    @Getter
    Timestamp time;

    @Setter
    @Getter
    float totalValue;

    @Setter
    @Getter
    EmployeeDTO employee;

    @Setter
    @Getter
    List<ItemsDTO> items;

}
