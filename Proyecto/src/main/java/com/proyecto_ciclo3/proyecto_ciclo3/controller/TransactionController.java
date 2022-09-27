package com.proyecto_ciclo3.proyecto_ciclo3.controller;

import com.proyecto_ciclo3.proyecto_ciclo3.model.Enterprise;
import com.proyecto_ciclo3.proyecto_ciclo3.model.Transaction;
import com.proyecto_ciclo3.proyecto_ciclo3.service.EmployeeService;
import com.proyecto_ciclo3.proyecto_ciclo3.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TransactionController {

    @Autowired
    private TransactionService transactionService;
    @Autowired
    private EmployeeService employeeService;

    //LIST ALL TRANSACTIONS IN DB
    @GetMapping("/web_transactions")
    public String web_transactions(Model model) {
        model.addAttribute("transactions", transactionService.getTransactions());
        model.addAttribute("employees", employeeService.getEmployees());

        return "transactions";
    }

    //DELETE TRANSACTION FROM LIST
    @DeleteMapping("/transaction/delete/{id}")
    public String deleteEnterprise(@PathVariable Long id, Model model){
        transactionService.deleteTransactionById(id);
        return "redirect:/web_transactions";
    }

    //UPDATE SELECTED TRANSACTION FROM LIST
    @PutMapping("/transaction/update")
    public String putEnterprise(@ModelAttribute("transactionUpdate") Transaction transaction){
        try {
            transactionService.updateTransactionById(transaction, transaction.getTransactionId());
            return "redirect:/web_transactions";
        } catch (Exception e) {
            return  "redirect:/error";
        }
    }

    //CREATE TRANSACTION
    @PostMapping("/transaction/create")
    public String createEnterprise(@ModelAttribute("transactionCreate") Transaction transaction){
        try {
            String message = transactionService.createTransaction(transaction);
            return "redirect:/web_transactions";
        } catch (Exception e){
            e.printStackTrace();
            new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return "redirect:/error";
    }

}
