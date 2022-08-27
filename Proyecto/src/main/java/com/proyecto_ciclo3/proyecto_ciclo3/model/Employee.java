package com.proyecto_ciclo3.proyecto_ciclo3.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Employee {

     @Id
     private long id;

     @Column(name = "email", unique = true)
     private String email;
     private Profile profile;
     private Enum_RoleName role;
     private Enterprise enterprise;
     private Transaction[] transactions;
     private Date updatedAt;
     private Date createdAt;

    public Employee() {
    }

    public Employee(long id, String email, Profile profile, Enum_RoleName role, Enterprise enterprise, Transaction[] transactions, Date updatedAt, Date createdAt) {
        this.setId(id);
        this.setEmail(email);
        this.setProfile(profile);
        this.setRole(role);
        this.setEnterprise(enterprise);
        this.setTransactions(transactions);
        this.setUpdatedAt(updatedAt);
        this.setCreatedAt(createdAt);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Enum_RoleName getRole() {
        return role;
    }

    public void setRole(Enum_RoleName role) {
        this.role = role;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public Transaction[] getTransactions() {
        return transactions;
    }

    public void setTransactions(Transaction[] transactions) {
        this.transactions = transactions;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
