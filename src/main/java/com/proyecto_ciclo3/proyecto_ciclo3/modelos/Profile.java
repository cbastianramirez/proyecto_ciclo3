package com.proyecto_ciclo3.proyecto_ciclo3.modelos;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "profile")
public class Profile {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column
    private String imagen;

    @Column
    private String telefono;

    //@OneToOne (mappedBy = "usuario")
    //private List<Empresa> usuario =  new ArrayList<>();

    @Column
    private Date createdAt;

    @Column
    private Date updateAt;



    // constructor vacío
    public Profile() {
    }

    // constructor lleno
    public Profile(String imagen, String telefono, /*List<Empresa> usuario,*/ Date createdAt, Date updateAt) {
        this.imagen = imagen;
        this.telefono = telefono;
        //this.usuario = usuario;
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

    /*public List<Empresa> getUsuario() {
        return usuario;
    }

    public void setUsuario(List<Empresa> usuario) {
        this.usuario = usuario;
    }*/

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}


