package com.example.bd2.DTO;

import com.example.bd2.Model.Product;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class ItemsDTO {

    @Setter
    @Getter
    @Column(name = "ite_quantidade")
    int quantity;

    @Setter
    @Getter
    @Column(name = "ite_valor_parcial")
    float partialValue;

    @ManyToOne
    @Setter
    @Getter
    @JoinColumn(name = "produto")
    Product product;

}
