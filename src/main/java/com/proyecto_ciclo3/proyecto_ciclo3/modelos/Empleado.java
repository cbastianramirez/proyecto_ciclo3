package com.proyecto_ciclo3.proyecto_ciclo3.modelos;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nombre;

    @Column(unique = true)
    private String correo;

    // lo creo pero sin getters setters
    @OneToOne
    private Profile profile;
    @OneToMany
    private Enum_RoleName enum_roleName;

    @ManyToOne
    private Empresa empresa;

    @OneToMany
    private List <MovimientoDinero> movimientosDinero =  new ArrayList<>();

    private Date updateAt;

    private Date createdAt;



    // constructor vacío porque debe usar entity
    public Empleado() {

    }

    // constructor lleno

    public Empleado(String nombre, String correo, Profile profile, Enum_RoleName enum_roleName, Empresa empresa, List<MovimientoDinero> movimientosDinero, Date updateAt, Date createdAt) {
        this.nombre = nombre;
        this.correo = correo;
        this.profile = profile;
        this.enum_roleName = enum_roleName;
        this.empresa = empresa;
        this.movimientosDinero = movimientosDinero;
        this.updateAt = updateAt;
        this.createdAt = createdAt;
    }


    // setters & getters
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Enum_RoleName getEnum_roleName() {
        return enum_roleName;
    }

    public void setEnum_roleName(Enum_RoleName enum_roleName) {
        this.enum_roleName = enum_roleName;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<MovimientoDinero> getMovimientosDinero() {
        return movimientosDinero;
    }

    public void setMovimientosDinero(List<MovimientoDinero> movimientosDinero) {
        this.movimientosDinero = movimientosDinero;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
