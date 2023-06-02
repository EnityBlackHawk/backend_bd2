package com.example.bd2.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_fornecedores")
public class Supplier {

    @Id
    @Column(name = "for_codigo")
    @Setter
    @Getter
    private Long id;

    @Setter
    @Getter
    @Column(name = "for_descricao")
    private String description;
}
