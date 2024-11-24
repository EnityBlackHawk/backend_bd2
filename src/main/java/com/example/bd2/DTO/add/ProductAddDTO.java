package com.example.bd2.DTO.add;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductAddDTO {

    @NotNull(message = "The Product code must not be null")
    private Long code;

}
