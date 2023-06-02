package com.example.bd2.Model;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
public class Items {

    @Id
    @Setter
    @Getter
    Long code;

    @Setter
    @Getter
    int quantity;

    @Setter
    @Getter
    float partialValue;

    @OneToMany
    @Setter
    @Getter
    Product product;

    @OneToMany
    @Setter
    @Getter
    Sale sale;

}
