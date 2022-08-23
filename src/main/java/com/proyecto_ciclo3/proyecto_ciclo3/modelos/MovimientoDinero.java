package com.proyecto_ciclo3.proyecto_ciclo3.modelos;

import javax.persistence.Id;

public class MovimientoDinero {
    @Id
    private int id;
    private long monto;
    private String concepto;

    private Empresa usuario;



    // constructor vacío
    public MovimientoDinero() {
    }

    // constructor lleno
    public MovimientoDinero(long monto, String concepto, Empresa usuario) {
        this.monto = monto;
        this.concepto = concepto;
        this.usuario = usuario;
    }

    // setters & getters

    public long getMonto() {
        return monto;
    }

    public void setMonto(long monto) {
        this.monto = monto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Empresa getUsuario() {
        return usuario;
    }

    public void setUsuario(Empresa usuario) {
        this.usuario = usuario;
    }
}
