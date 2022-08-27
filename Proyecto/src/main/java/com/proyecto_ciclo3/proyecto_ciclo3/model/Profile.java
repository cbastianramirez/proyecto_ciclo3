package com.proyecto_ciclo3.proyecto_ciclo3.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Profile {

    @Id
    private String id;

    private String image;
    private String phone;
    private Employee user;
    private Date createdAt;
    private Date updatedAt;

    public Profile() {
    }

    public Profile(String id, String image, String phone, Employee user, Date createdAt, Date updatedAt) {
        this.setId(id);
        this.setImage(image);
        this.setPhone(phone);
        this.setUser(user);
        this.setCreatedAt(createdAt);
        this.setUpdatedAt(updatedAt);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Employee getUser() {
        return user;
    }

    public void setUser(Employee user) {
        this.user = user;
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
