package com.proyecto_ciclo3.proyecto_ciclo3.controller;

import com.proyecto_ciclo3.proyecto_ciclo3.model.Employee;
import com.proyecto_ciclo3.proyecto_ciclo3.model.ObjectResponse;
import com.proyecto_ciclo3.proyecto_ciclo3.model.Transaction;
import com.proyecto_ciclo3.proyecto_ciclo3.service.EmployeeList;
import com.proyecto_ciclo3.proyecto_ciclo3.service.TransactionList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
public class TransactionController {

    private TransactionList transactionList = new TransactionList();

    //GET ALL TRANSACTIONS
    @GetMapping("/enterprises/transactions")
    public ResponseEntity<ArrayList<Transaction>> getTransactions(){
        return new ResponseEntity<>(transactionList.getAllTransactions(), HttpStatus.OK);
    }

    //GET TRANSACTION BY ID
    @GetMapping("/enterprises/{id}/transactions")
    public ResponseEntity<Object> getTransactions(@PathVariable long id){

        try{
            TransactionList transactionList = new TransactionList();
            Transaction transactions = transactionList.getTransaction(id);
            return new ResponseEntity<>(transactions, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    //CREATE NEW TRANSACTION
    @PostMapping("/enterprises/transactions")
    public ResponseEntity<String> postTransaction(@RequestBody Transaction transactionPost){
        try {
            String message = transactionList.setTransaction(transactionPost);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //UPDATE TRANSACTION
    @PatchMapping("/enterprises/{id}/transactions")
    public ResponseEntity<ObjectResponse> putTransaction(@RequestBody Transaction updateTransaction, @PathVariable long id){
        try {
            Transaction transaction = transactionList.updateTransaction(updateTransaction, id);
            return new ResponseEntity<>(new ObjectResponse("Ok", transaction), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ObjectResponse(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //DELETE TRANSACTION BY ID
    @DeleteMapping("/enterprises/{id}/transactions")
    public ResponseEntity<ObjectResponse> deleteTransaction(@PathVariable long id){
        try {
            String message = transactionList.deleteTransaction(id);
            return  new ResponseEntity<>(new ObjectResponse(message, null),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ObjectResponse(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
