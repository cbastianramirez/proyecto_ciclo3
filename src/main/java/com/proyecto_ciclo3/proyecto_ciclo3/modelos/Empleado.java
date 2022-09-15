package com.proyecto_ciclo3.proyecto_ciclo3.modelos;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "correo",unique = true)
    private String correo;

    // lo creo pero sin getters setters
    //@OneToOne                 // este no va aquí según explico el profe porq el empleado no contiene fk del profile es al contrario(mappedBy = "empleado")
    //private Profile profile;
    @ManyToOne
    @Column(name = "enum_roleName")
    private Enum_RoleName enum_roleName;

    /*
    @Column (name = "empresa")
    private String empresa;
     */

    @ManyToOne
    @Column (name = "empresa_id") //@JoinColumn
    private Empresa empresa;

    @OneToMany(mappedBy = "empleado")  // el profe Juan @OneToMany
    //private List <MovimientoDinero> movimientosDinero =  new ArrayList<>(); // yo no lo debo colocar en update atributo solo forkey
    private List<MovimientoDinero> movimientosDinero;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    @Column(name = "updatedAt")
    private LocalDateTime updateAt;


    // constructor vacío porque debe usar entity

    public Empleado() {
    }

    // constructor lleno

    public Empleado(long id, String nombre, String correo, Enum_RoleName enum_roleName, Empresa empresa, List<MovimientoDinero> movimientosDinero, LocalDateTime createdAt, LocalDateTime updateAt) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.enum_roleName = enum_roleName;
        this.empresa = empresa;
        this.movimientosDinero = movimientosDinero;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    // setters & getters
    public long getId() {
        return id;
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

    public void setMovimientosDinero(List<MovimientoDinero> movimientosDinero) {  //creo q debe quitarse el set porq no puede cambiarse el movimientoDinero
        this.movimientosDinero = movimientosDinero;
    }

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
