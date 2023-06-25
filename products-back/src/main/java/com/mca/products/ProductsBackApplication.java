package com.mca.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ProductsBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsBackApplication.class, args);
	}

}
