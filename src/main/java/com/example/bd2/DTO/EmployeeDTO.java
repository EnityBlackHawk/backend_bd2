package com.example.bd2.DTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    @Setter
    @Getter
    private Long id;

    @Setter
    @Getter
    @Column(name = "fun_nome")
    private String name;

    @Setter
    @Getter
    @Column(name = "fun_funcao")
    private String role;

}
