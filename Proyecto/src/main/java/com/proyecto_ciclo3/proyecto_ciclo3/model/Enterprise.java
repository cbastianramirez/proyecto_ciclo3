package com.proyecto_ciclo3.proyecto_ciclo3.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CollectionId;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "enterprise")
public class Enterprise {

    @Id
    private Long enterpriseId;

    @Column
    private String name;
    @Column
    private String phone;
    @Column
    private String address;

    @JsonIgnore
    @OneToMany(mappedBy = "enterprise", cascade = CascadeType.REMOVE)
    private List<Employee> employees;

    public Enterprise() {
    }

    public Enterprise(Long enterpriseId, String name, String phone, String address, List<Employee> employees) {
        this.enterpriseId = enterpriseId;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.employees = employees;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
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

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
