package com.example.bd2.Model;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @Setter
    @Getter
    private Long code;

    @Setter
    @Getter
    private String description;

    @Setter
    @Getter
    private float value;

    @Setter
    @Getter
    private int quantity;

    @OneToMany
    @Setter
    @Getter
    private Supplier supplier;

}
