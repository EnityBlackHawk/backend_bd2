package com.example.bd2.Model;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.sql.Timestamp;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
public class Sale {

    @Id
    @Setter
    @Getter
    Long code;

    @Setter
    @Getter
    Timestamp time;

    @Setter
    @Getter
    float totalValue;

    @OneToMany
    @Setter
    @Getter
    Employee employee;

}
