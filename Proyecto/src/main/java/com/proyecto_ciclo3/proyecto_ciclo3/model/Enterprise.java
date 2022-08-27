package com.proyecto_ciclo3.proyecto_ciclo3.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Enterprise {

    @Id
    private long id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "document", unique = true)
    private String document;
    private String phone;
    private String address;
    private Employee[] users;
    private Transaction[] transactions;
    private Date createdAt;
    private Date updatedAt;

    public Enterprise() {
    }

    public Enterprise(long id, String name, String document, String phone, String address, Employee[] users, Transaction[] transactions, Date createdAt, Date updatedAt) {
        this.setId(id);
        this.setName(name);
        this.setDocument(document);
        this.setPhone(phone);
        this.setAddress(address);
        this.setUsers(users);
        this.setTransactions(transactions);
        this.setCreatedAt(createdAt);
        this.setUpdatedAt(updatedAt);
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Employee[] getUsers() {
        return users;
    }

    public void setUsers(Employee[] users) {
        this.users = users;
    }

    public Transaction[] getTransactions() {
        return transactions;
    }

    public void setTransactions(Transaction[] transactions) {
        this.transactions = transactions;
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
