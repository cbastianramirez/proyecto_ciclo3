package com.proyecto_ciclo3.proyecto_ciclo3.service;

import com.proyecto_ciclo3.proyecto_ciclo3.model.Employee;
import com.proyecto_ciclo3.proyecto_ciclo3.model.Enterprise;
import com.proyecto_ciclo3.proyecto_ciclo3.model.Enum_RoleName;
import com.proyecto_ciclo3.proyecto_ciclo3.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TransactionList {


    private ArrayList<Transaction> transactions;

    public TransactionList(){

        this.transactions = new ArrayList<>();

        Enterprise enterprise1 = new Enterprise(1234567, "Makro", "3005005050",
                "Calle 4 # 45-34");
        Enterprise enterprise2 = new Enterprise(8585953, "Flamingo", "55555555",
                "Carrera 8 # 4-54");

        Employee employee1 = new Employee(123456, "Pepe Perez", "email@email.com",
                Enum_RoleName.ADMIN, enterprise1);
        Employee employee2 = new Employee(785845, "Margarot Ramirez", "email@microsoft.com",
                Enum_RoleName.OPERARIO, enterprise2);

        Transaction transaction1 = new Transaction(123456,"Pago a proveedor",-123450,employee1);
        Transaction transaction2 = new Transaction(7890,"Ventas de Agosto",2300000,employee2);

        this.transactions.add(transaction1);
        this.transactions.add(transaction2);

    }


    //GET ALL TRANSACTIONS
    public ArrayList<Transaction> getAllTransactions(){
        return transactions;
    }

    //GET TRANSACTION BY ID
    public Transaction getTransaction(long id) throws Exception {
        for (Transaction transactions: this.transactions) {
            if (transactions.getId() == id){
                return transactions;
            }
        }
        throw new Exception("Enterprise not found");
    }

    //CREATE NEW TRANSACTION
    public String setTransaction(Transaction transaction) throws Exception {
        try {
            getTransaction(transaction.getId());
        } catch (Exception e){
            this.transactions.add(transaction);
            return"Transaction was succesfully created";
        }
        throw new Exception("Transaction already exists");
    }

    //UPDATE TRANSACTION
     public Transaction updateTransaction(Transaction update_Transaction, long id) throws Exception {
         try {

             Transaction db_transaction = getTransaction(id);

             if (update_Transaction.getConcept() != null && !update_Transaction.getConcept().equals("")) {
                 db_transaction.setConcept(update_Transaction.getConcept());
             }
             if (update_Transaction.getAmount() != 0){
                 db_transaction.setAmount(update_Transaction.getAmount());
             }
             if (update_Transaction.getUser() != null){
                 db_transaction.setUser(update_Transaction.getUser());
             }

             return db_transaction;

         } catch (Exception e) {
             throw new Exception("Transaction not found");
         }
     }

    //DELETE TRANSACTION BY ID
    public String deleteTransaction(long id) throws Exception {
        try {
            Transaction transaction = getTransaction(id);

            this.transactions.remove(transaction);

            return "Successfully deleted";
        } catch (Exception e) {
            throw new Exception("Transaction not found to delete");
        }

    }
}