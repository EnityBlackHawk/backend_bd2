package com.example.bd2.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_produtos")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productGen")
    @SequenceGenerator(name = "productGen", sequenceName = "tb_produtos_seq", allocationSize = 1)
    @Setter
    @Getter
    @Column(name = "pro_codigo")
    private Long code;

    @Setter
    @Getter
    @Column(name = "pro_descricao")
    private String description;

    @Setter
    @Getter
    @Column(name = "pro_valor")
    private float value;

    @Setter
    @Getter
    @Column(name = "pro_quantidade")
    private int quantity;

    @ManyToOne
    @Setter
    @Getter
    @JoinColumn(name = "fornecedor")
    private Supplier supplier;

}
