package com.example.bd2.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    @Setter
    @Getter
    @NotNull
    @Range(min = 1)
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
