package com.proyecto_ciclo3.proyecto_ciclo3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class ProyectoCiclo3Application {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoCiclo3Application.class, args);
	}

}
