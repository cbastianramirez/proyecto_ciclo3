package com.proyecto_ciclo3.proyecto_ciclo3.controller;

import com.proyecto_ciclo3.proyecto_ciclo3.model.Employee;
import com.proyecto_ciclo3.proyecto_ciclo3.model.Enterprise;
import com.proyecto_ciclo3.proyecto_ciclo3.service.EmployeeList;
import com.proyecto_ciclo3.proyecto_ciclo3.service.EnterpriseList;
import net.bytebuddy.asm.Advice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnterpriseController {

    @GetMapping("/enterprises")
    public EnterpriseList Enterprise(){
        EnterpriseList allEnterprises = new EnterpriseList();
        return allEnterprises;
    }

    @GetMapping("/enterprise/{id}")
    public ResponseEntity<Object> getEnterprise(@PathVariable long id){

        try{
            EnterpriseList EnterprisesList = new EnterpriseList();
            Enterprise enterprises = EnterprisesList.getEnterprise(id);
            return new ResponseEntity<>(enterprises, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
