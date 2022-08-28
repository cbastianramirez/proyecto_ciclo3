package com.proyecto_ciclo3.proyecto_ciclo3.model;

import javax.persistence.*;
//import java.util.Date;

@Entity
public class Employee {

     @Id
     private long id;

     private String name;
     @Column(name = "email", unique = true)
     private String email;

     private Enum_RoleName role;
     private Enterprise enterprise;


    public Employee() {
    }

    public Employee(long id, String name, String email, Enum_RoleName role, Enterprise enterprise) {
        this.setId(id);
        this.setName(name);
        this.setEmail(email);
        this.setRole(role);
        this.setEnterprise(enterprise);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", enterprise=" + enterprise +
                '}';
    }
}
