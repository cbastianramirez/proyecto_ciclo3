package com.proyecto_ciclo3.proyecto_ciclo3.model;

import javax.persistence.*;

@Entity
public class Transaction {

    private String concept;
    private float amount;
    private Employee user;


    public Transaction() {
    }

    public Transaction(String concept, float amount, Employee user) {
        this.setConcept(concept);
        this.setAmount(amount);
        this.setUser(user);
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

    public Employee getUser() {
        return user;
    }

    public void setUser(Employee user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "concept='" + concept + '\'' +
                ", amount=" + amount +
                ", user=" + user +
                '}';
    }
}
