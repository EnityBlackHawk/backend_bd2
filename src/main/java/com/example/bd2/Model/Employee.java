package com.example.bd2.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_funcionarios")
public class Employee {

    @Id
    @Column(name = "fun_codigo")
    @Setter
    @Getter
    private Long id;

    @Setter
    @Getter
    @Column(name = "fun_nome")
    private String name;

    @Setter
    @Getter
    @Column(name = "fun_cpf")
    private String cpf;

    @Setter
    @Getter
    @Column(name = "fun_senha")
    private String password;

    @Setter
    @Getter
    @Column(name = "fun_funcao")
    private String role;

}
