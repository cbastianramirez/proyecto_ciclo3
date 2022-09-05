package com.proyecto_ciclo3.proyecto_ciclo3.modelos;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String nombre;

    @Column(unique = true)
    private String correo;

    // lo creo pero sin getters setters
    //@OneToOne                 // este no va aquí según explico el profe porq el empleado no contiene fk del profile es al contrario(mappedBy = "empleado")
    //private Profile profile;
    @OneToMany
    private Enum_RoleName enum_roleName;

    @Column
    private String empresa;
    /*@ManyToOne
    private Empresa empresa;

    @OneToMany
    private List <MovimientoDinero> movimientosDinero =  new ArrayList<>();

    private Date updateAt;

    private Date createdAt;
    */
    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    @Column(name = "updatedAt")
    private LocalDateTime updateAt;



    // constructor vacío porque debe usar entity

    public Empleado() {
    }

    // constructor lleno

    public Empleado(String nombre, String correo, /*Profile profile,*/ Enum_RoleName enum_roleName, String empresa /*, Empresa empresa , List<MovimientoDinero> movimientosDinero,  Date updateAt, Date createdAt */) {
        this.nombre = nombre;
        this.correo = correo;
        //this.profile = profile;
        this.enum_roleName = enum_roleName;
        this.empresa = empresa;
        //this.movimientosDinero = movimientosDinero;
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

    /*public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }*/

    public Enum_RoleName getEnum_roleName() {
        return enum_roleName;
    }

    public void setEnum_roleName(Enum_RoleName enum_roleName) {
        this.enum_roleName = enum_roleName;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    /*public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public List<MovimientoDinero> getMovimientosDinero() {
        return movimientosDinero;
    }

    public void setMovimientosDinero(List<MovimientoDinero> movimientosDinero) {
        this.movimientosDinero = movimientosDinero;
    }


     */
    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}