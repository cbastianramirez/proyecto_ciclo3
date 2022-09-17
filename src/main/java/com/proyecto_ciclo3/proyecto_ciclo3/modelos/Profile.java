package com.proyecto_ciclo3.proyecto_ciclo3.modelos;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "profile")
public class Profile {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private String id;

    @Column(name = "imagen")
    private String imagen;

    @Column(name = "telefono")
    private String telefono;

    @OneToOne (mappedBy = "empleado_id")
    private Empresa usuario;    //List<Empresa> usuario;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    @Column(name = "updatedAt")
    private LocalDateTime updateAt;


    // constructor vacío
    public Profile() {
    }

    // constructor lleno
    public Profile(String imagen, String telefono, Empresa usuario, LocalDateTime createdAt, LocalDateTime updateAt) {
        this.imagen = imagen;
        this.telefono = telefono;
        this.usuario = usuario;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    //setters  getters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Empresa getUsuario() {
        return usuario;
    }

    public void setUsuario(Empresa usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }
}


