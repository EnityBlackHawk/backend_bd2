package com.example.bd2.DTO.add;

import com.example.bd2.Model.Product;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Data
@NoArgsConstructor
public class ItemsAddDTO {

    @NotNull
    @Range(min = 1, message = "The quantity must be greater than 0")
    private int quantity;
    @NotNull(message = "The Product must not be null")
    private ProductAddDTO product;

}
