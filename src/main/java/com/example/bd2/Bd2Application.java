package com.example.bd2;

import com.example.bd2.Model.Supplier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Bd2Application {

	public static void main(String[] args) {
		SpringApplication.run(Bd2Application.class, args);
	}
}
