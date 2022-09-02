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


@RestController
public class EmployeeController {

    @GetMapping("/users")
    public EmployeeList Employee(){
        EmployeeList allEmployees = new EmployeeList();
        return allEmployees;
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Object> getUsers(@PathVariable long id){

        try{
            EmployeeList employeeList = new EmployeeList();
            Employee employees = employeeList.getEmployee(id);
            return new ResponseEntity<>(employees, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

//    OTRA FORMA PARA INSTANCIAR EL OBJETO EmployeeList
//    @GetMapping("/users/{id}")
//    public ResponseEntity<Object> getUsers(@PathVariable long id){
//
//        try{
//            Employee employees = new EmployeeList().getEmployee(id);
//            return new ResponseEntity<>(employees, HttpStatus.OK);
//        }catch (Exception e){
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//    }

}
