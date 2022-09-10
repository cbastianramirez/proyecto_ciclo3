package com.proyecto_ciclo3.proyecto_ciclo3.modelos;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "empresa")
public class Empresa {
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //private long id; lo tenía con el id pero es nit
    private long Id;


    @Column(unique = true)
    private String nombre;

    @Column(unique = true)
    private String documento;

    @Column
    private String telefono;

    @Column
    private String direccion;

    /*@OneToMany
    //private List<Empresa> usuario = new ArrayList<>();
    private List<Empresa> usuario;

    //@OneToMany
    private List <MovimientoDinero> movimientosDinero =  new ArrayList<>();
    private List<MovimientoDinero> movimientosDinero; */

    /*
    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;

*/
    // constructor vacío porque debe usar entity
    public Empresa() {
    }

    // constructor lleno

    public Empresa(long id, String nombre, String documento, String telefono, String direccion) {
        Id = id;
        this.nombre = nombre;
        this.documento = documento;
        this.telefono = telefono;
        this.direccion = direccion;
        //this.usuario = usuario;
        //this.movimientosDinero = movimientosDinero;
        //this.createdAt = createdAt;
        //this.updatedAt = updatedAt;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }*/
}