package com.example.bd2.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_fornecedores")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supplierGen")
    @SequenceGenerator(name = "supplierGen", sequenceName = "tb_fornecedores_seq", allocationSize = 1)
    @Column(name = "for_codigo")
    @Setter
    @Getter
    private Long id;

    @Setter
    @Getter
    @Column(name = "for_descricao")
    private String description;
}
