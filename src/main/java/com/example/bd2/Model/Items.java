package com.example.bd2.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_itens")
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemsGen")
    @SequenceGenerator(name = "itemsGen", sequenceName = "tb_itens_seq", allocationSize = 1)
    @Setter
    @Getter
    @Column(name = "ite_codigo")
    Long code;

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

    @ManyToOne
    @Setter
    @Getter
    @JoinColumn(name = "venda")
    Sale sale;

}
