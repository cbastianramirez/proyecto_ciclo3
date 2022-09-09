package com.proyecto_ciclo3.proyecto_ciclo3.modelos;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.lang.String;

@Entity
@Table(name = "movimiento dinero")
public class MovimientoDinero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String concepto;

    @Column
    private float monto;

    //@ManyToOne
    //private Empleado usuario;

    @Column
    private String usuario;
    //@ManyToOne
    //private Empresa empresa;

    @Column
    private String empresa;

    /*
    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;


     */

    // constructor vacío porque debe usar entity
    public MovimientoDinero() {
    }

    // constructor lleno
    public MovimientoDinero(long id, String concepto, float monto, /*Empleado usuario, Empresa empresa,*/ String usuario,String empresa  /*, LocalDateTime createdAt, LocalDateTime updatedAt*/) {
        this.id = id;
        this.concepto = concepto;
        this.monto = monto;
        this.usuario = usuario;
        this.empresa = empresa;
        //this.createdAt = createdAt;
        //this.updatedAt = updatedAt;
    }

    // setters & getters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    /*
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
    } */
}
