package com.proyecto_ciclo3.proyecto_ciclo3.controller;

import com.proyecto_ciclo3.proyecto_ciclo3.model.Employee;
import com.proyecto_ciclo3.proyecto_ciclo3.model.Enterprise;
import com.proyecto_ciclo3.proyecto_ciclo3.model.Enum_RoleName;
import com.proyecto_ciclo3.proyecto_ciclo3.model.ObjectResponse;
import com.proyecto_ciclo3.proyecto_ciclo3.service.EmployeeList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
public class EmployeeController {

    private EmployeeList employeeList = new EmployeeList();

    //GET ALL EMPLOYESS
    @GetMapping("/employees")
    public ResponseEntity<ArrayList<Employee>> getEmployees(){
        return new ResponseEntity<>(employeeList.getAllEmployees(), HttpStatus.OK);
    }

    //GET EMPLOYEE BY ID
//    @GetMapping("/employee/{id}")
//    public ResponseEntity<Object> getUsers(@PathVariable long id){
//        try{
//            EmployeeList employeeList = new EmployeeList();
//            Employee employees = employeeList.getEmployee(id);
//            return new ResponseEntity<>(employees, HttpStatus.OK);
//        }catch (Exception e){
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<ObjectResponse> getUsers(@PathVariable long id){
        try{
            EmployeeList employeeList = new EmployeeList();
            Employee employees = employeeList.getEmployee(id);
            return new ResponseEntity<>(new ObjectResponse("Found! Details below:", employees), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ObjectResponse(e.getMessage(),null), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //    ANOTHER WAY TO INSTANCE EmployeeList OBJECT
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


    //CREATE NEW EMPLOYEE
    @PostMapping("/employees")
    public ResponseEntity<String> postEmployee(@RequestBody Employee employeePost){
        try {
            String message = employeeList.setEmployee(employeePost);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //UPDATE EMPLOYEE
    @PatchMapping("/employee/{id}")
    public ResponseEntity<ObjectResponse> putEmployee(@RequestBody Employee updateEmployee, @PathVariable long id){
        try {
            Employee employee = employeeList.updateEmployee(updateEmployee, id);
            return new ResponseEntity<>(new ObjectResponse("Ok", employee), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ObjectResponse(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //DELETE EMPLOYEE BY ID
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<ObjectResponse> deleteEmployee(@PathVariable long id){
        try {
            String message = employeeList.deleteEmployee(id);
            return  new ResponseEntity<>(new ObjectResponse(message, null),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ObjectResponse(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
