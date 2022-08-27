package com.proyecto_ciclo3.proyecto_ciclo3.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Transaction {

    @Id
    private long id;

    private String concept;
    private float amount;
    private Employee user;
    private Enterprise enterprise;
    private Date createdAt;
    private Date updatedAt;

    public Transaction() {
    }

    public Transaction(long id, String concept, float amount, Employee user, Enterprise enterprise, Date createdAt, Date updatedAt) {
        this.setId(id);
        this.setConcept(concept);
        this.setAmount(amount);
        this.setUser(user);
        this.setEnterprise(enterprise);
        this.setCreatedAt(createdAt);
        this.setUpdatedAt(updatedAt);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
