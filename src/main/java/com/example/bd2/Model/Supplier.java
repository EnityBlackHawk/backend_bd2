package com.example.bd2.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
public class Supplier {

    @Id
    @Setter
    @Getter
    private Long id;

    @Setter
    @Getter
    private String description;
}
