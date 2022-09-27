package com.proyecto_ciclo3.proyecto_ciclo3.model;

import javax.persistence.*;

@Entity
public class Transaction {

    @Id
    @Column(nullable = false, unique = true)
    private Long transactionId;

    @Column
    private String concept;
    @Column
    private float amount;

    @ManyToOne
    private Employee employee;

    @ManyToOne
    private Enterprise enterprise;


    public Transaction() {
    }

    public Transaction(Long transactionId, String concept, float amount, Employee employee) {
        this.transactionId = transactionId;
        this.concept = concept;
        this.amount = amount;
        this.employee = employee;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}

