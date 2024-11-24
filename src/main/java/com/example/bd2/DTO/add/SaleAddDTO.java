package com.example.bd2.DTO.add;

import com.example.bd2.DTO.EmployeeDTO;
import com.example.bd2.DTO.ItemsDTO;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class SaleAddDTO {

    @NotNull(message = "Must have an employee")
    private EmployeeDTO employee;
    @NotNull(message = "Must have at least one item")
    private List<ItemsAddDTO> items;

}
