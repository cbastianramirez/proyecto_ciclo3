package com.proyecto_ciclo3.proyecto_ciclo3.service;

import com.proyecto_ciclo3.proyecto_ciclo3.Repository.EmployeeRepository;
import com.proyecto_ciclo3.proyecto_ciclo3.Repository.TransactionRepository;
import com.proyecto_ciclo3.proyecto_ciclo3.model.Employee;
import com.proyecto_ciclo3.proyecto_ciclo3.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository repository;

    public List<Transaction> getTransactions() {
        return repository.findAllByOrderByTransactionIdAsc();
    }

    public Transaction getTransactionById(Long id){
        return repository.findByTransactionId(id);
    }


    public String createTransaction(Transaction transaction) throws Exception {
        repository.save(transaction);
        return "Transaction succesfully created.";
    }

    public Transaction updateTransactionById(Transaction update_Transaction, Long id) throws Exception {

        Transaction transaction_db = getTransactionById(id);

        if(update_Transaction.getConcept() != null && !update_Transaction.getConcept().equals("")){
            transaction_db.setConcept(update_Transaction.getConcept());
        }

        if(update_Transaction.getAmount() != 0){
            transaction_db.setAmount(update_Transaction.getAmount());
        }

        return repository.save(transaction_db);
    }

    public String deleteTransactionById(Long id){
        repository.deleteById(id);
        return "Transaction succesfully deleted";
    }

    public List<Transaction> getTransactionByEmployeeId(Long employeeId){
        return repository.findByEmployeeEmployeeId(employeeId);
    }
}
