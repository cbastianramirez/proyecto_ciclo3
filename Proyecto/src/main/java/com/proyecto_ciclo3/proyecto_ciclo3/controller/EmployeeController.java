package com.proyecto_ciclo3.proyecto_ciclo3.controller;

import com.proyecto_ciclo3.proyecto_ciclo3.model.Employee;
import com.proyecto_ciclo3.proyecto_ciclo3.model.Enterprise;
import com.proyecto_ciclo3.proyecto_ciclo3.model.Enum_RoleName;
import com.proyecto_ciclo3.proyecto_ciclo3.service.EmployeeList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Objects;

@RestController
public class EmployeeController {

//    @GetMapping("/users/{id}")
//    public String Employee(){
//        Employee employee1 = new Employee(123456, "Pepe Perez", "email@email.com", Enum_RoleName.ADMIN, new Enterprise());
//        return employee1.toString();
//    }

    @GetMapping("/users")
    public ResponseEntity<Object> getUsers(@PathVariable long id){

        try{
            //Error relacionado con método no estático
            Employee employees = EmployeeList.getEmployees(id);
            return new ResponseEntity<>(employees, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
