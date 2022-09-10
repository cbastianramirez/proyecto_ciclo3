package com.proyecto_ciclo3.proyecto_ciclo3.controller;

import com.proyecto_ciclo3.proyecto_ciclo3.model.Employee;
import com.proyecto_ciclo3.proyecto_ciclo3.model.Enterprise;
import com.proyecto_ciclo3.proyecto_ciclo3.model.ObjectResponse;
import com.proyecto_ciclo3.proyecto_ciclo3.service.EmployeeList;
import com.proyecto_ciclo3.proyecto_ciclo3.service.EnterpriseList;
import net.bytebuddy.asm.Advice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class EnterpriseController {

    private EnterpriseList enterpriseList = new EnterpriseList();

    //GET ALL ENTERPRISES
    @GetMapping("/enterprises")
    public ResponseEntity<ArrayList<Enterprise>> getEnterprises(){
        return new ResponseEntity<>(enterpriseList.getAllEnterprises(), HttpStatus.OK);
    }

    //GET ENTERPRISE BY ID
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

    //CREATE NEW ENTERPRISE
    @PostMapping("/enterprises")
    public ResponseEntity<String> postEnterprise(@RequestBody Enterprise enterprisePost){
        try {
            String message = enterpriseList.setEnterprise(enterprisePost);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //UPDATE ENTERPRISE
    @PatchMapping("/enterprise/{id}")
    public ResponseEntity<ObjectResponse> putEnterprise(@RequestBody Enterprise updateEnterprise, @PathVariable long id){
        try {
            Enterprise enterprise = enterpriseList.updateEnterprise(updateEnterprise, id);
            return new ResponseEntity<>(new ObjectResponse("Ok", enterprise), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ObjectResponse(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //DELETE ENTERPRISE BY ID
    @DeleteMapping("/enterprise/{id}")
    public ResponseEntity<ObjectResponse> deleteEnterprise(@PathVariable long id){
        try {
            String message = enterpriseList.deleteEnterprise(id);
            return  new ResponseEntity<>(new ObjectResponse(message, null),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ObjectResponse(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}


