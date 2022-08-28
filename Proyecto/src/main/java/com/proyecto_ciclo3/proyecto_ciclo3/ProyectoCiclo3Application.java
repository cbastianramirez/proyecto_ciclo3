package com.proyecto_ciclo3.proyecto_ciclo3;

import com.proyecto_ciclo3.proyecto_ciclo3.model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ProyectoCiclo3Application {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoCiclo3Application.class, args);

		System.out.println("");
		System.out.println("----------------------------Enterprise/Empresa----------------------------------");

		Enterprise enterprise1 = new Enterprise(1234567, "Makro", "3005005050", "Calle 4 # 45-34");
		Enterprise enterprise2 = new Enterprise(8585953, "Flamingo", "55555555", "Carrera 8 # 4-54");
		System.out.println(enterprise1);
		enterprise1.setName("Exito");
		enterprise1.setAddress("Av 12 #12a-43");
		enterprise1.setPhone("3001234567");
		enterprise1.setId(83748585);
		System.out.println(enterprise1);

		System.out.println("--------------------------Employee/Empleado------------------------------------");

		Employee employee1 = new Employee(123456, "Pepe Perez", "email@email.com", Enum_RoleName.ADMIN, enterprise1);
		Employee employee2 = new Employee(785845, "Margarot Ramirez", "email@microsoft.com", Enum_RoleName.OPERARIO, enterprise1);
		System.out.println(employee1);
		employee1.setName("Andrew McFly");
		employee1.setEmail("correo@correo.net");
		employee1.setEnterprise(enterprise2);
		employee1.setRole(Enum_RoleName.OPERARIO);
		System.out.println(employee1);

		System.out.println("-------------------Transaction/MovimientoDinero---------------------------------");

		Transaction transaction1 = new Transaction("Ventas Abril", 150000, employee1);
		System.out.println(transaction1);
		transaction1.setAmount(450800);
		System.out.println(transaction1);
		transaction1.setAmount(-250450);
		System.out.println(transaction1);
		transaction1.setConcept("Pago de deuda a Bancolombia");
		System.out.println(transaction1);
		transaction1.setUser(employee2);
		System.out.println(transaction1);
	}


}
