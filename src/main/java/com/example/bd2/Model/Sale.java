package com.example.bd2.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_vendas")
public class Sale {

    @Id
    @Setter
    @Getter
    @Column(name = "ven_codigo")
    Long code;

    @Setter
    @Getter
    @Column(name = "ven_horario")
    Timestamp time;

    @Setter
    @Getter
    @Column(name = "ven_valor_total")
    float totalValue;

    @ManyToOne
    @Setter
    @Getter
    @JoinColumn(name = "funcionario")
    Employee employee;

    @OneToMany(mappedBy = "sale")
    @Setter
    @Getter
    List<Items> items;

}
