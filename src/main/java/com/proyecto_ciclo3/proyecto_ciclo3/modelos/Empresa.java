package com.proyecto_ciclo3.proyecto_ciclo3.modelos;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    private String nombre;

    @Column(unique = true)
    private String NIT;  // documento empresa

    private String telefono;

    private String direccion;

    /*@OneToMany
    //private List<Empresa> usuario = new ArrayList<>();

    //@OneToMany
    private List <MovimientoDinero> movimientosDinero =  new ArrayList<>();*/

    //private Date createdAt;

    //private Date updatedAt;

    // constructor vacío porque debe usar entity
    public Empresa() {
    }

    // constructor lleno
    public Empresa(String nombre, String NIT, String telefono, String direccion/*, List<Empresa> usuario, List<MovimientoDinero> movimientosDinero Date createdAt, Date updatedAt*/) {
        this.nombre = nombre;
        this.NIT = NIT;
        this.telefono = telefono;
        this.direccion = direccion;
        //this.usuario = usuario;
        //this.movimientosDinero = movimientosDinero;
        //this.createdAt = createdAt;
        //this.updatedAt = updatedAt;
    }

    // getters & setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /*public List<Empresa> getUsuario() {
        return usuario;
    }

    public void setUsuario(List<Empresa> usuario) {
        this.usuario = usuario;
    }

    public List<MovimientoDinero> getMovimientosDinero() {
        return movimientosDinero;
    }

    public void setMovimientosDinero(List<MovimientoDinero> movimientosDinero) {
        this.movimientosDinero = movimientosDinero;
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
    } */
}
