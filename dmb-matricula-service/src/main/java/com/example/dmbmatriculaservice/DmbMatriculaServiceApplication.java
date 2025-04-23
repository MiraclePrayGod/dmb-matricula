package com.example.dmbmatriculaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@EnableFeignClients  // Habilitar Feign en la aplicación
@SpringBootApplication
public class DmbMatriculaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DmbMatriculaServiceApplication.class, args);
	}

}
