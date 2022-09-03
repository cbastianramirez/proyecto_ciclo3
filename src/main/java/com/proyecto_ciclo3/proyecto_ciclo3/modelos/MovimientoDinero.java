package com.proyecto_ciclo3.proyecto_ciclo3.modelos;

import javax.persistence.*;
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
    //private Date createdAt;

    //private Date updatedAt;


    // constructor vacío porque debe usar entity
    public MovimientoDinero() {
    }

    // constructor lleno
    public MovimientoDinero(String concepto, float monto, /*Empleado usuario, Empresa empresa,*/ String usuario,String empresa /*, Date createdAt, Date updatedAt*/) {
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

    /*public Date getCreatedAt() {
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
    }*/
}
