package com.proyecto_ciclo3.proyecto_ciclo3.model;

import javax.persistence.*;

@Entity
public class Enterprise {

    @Id
    private long id;

    @Column(name = "name", unique = true)
    private String name;
    private String phone;
    private String address;

    public Enterprise() {
    }

    public Enterprise(long id, String name, String phone, String address) {
        this.setId(id);
        this.setName(name);
        this.setPhone(phone);
        this.setAddress(address);
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

    @Override
    public String toString() {
        return "Enterprise{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
