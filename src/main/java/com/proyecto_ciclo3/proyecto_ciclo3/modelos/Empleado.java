package com.proyecto_ciclo3.proyecto_ciclo3.modelos;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity

public class Empleado {

   @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "correo",unique = true,  length = 50)
    private String correo;

    /*@JsonIgnore
    @OneToOne
    private Profile profile;*/

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Enum_RoleName.class, fetch = FetchType.EAGER)
    private List<Enum_RoleName> enum_roleName;

    //@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "empresa_id") //NECESITO ESTE JOIN Q TRAE LOS DATOS DE UNA VEZ
    private Empresa empresa;

    /*@JsonIgnore
    @OneToMany//(mappedBy = "empleado_id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private MovimientoDinero movimientosDinero;*/


    @CreationTimestamp
    @Column(name = "createdAt")
    private LocalDateTime createdAt;


    @UpdateTimestamp
    @Column(name = "updatedAt")
    private LocalDateTime updateAt;


    // constructor vacío porque debe usar entity
    public Empleado() {
    }

    // constructor lleno


    public Empleado(long id, String nombre, String correo, List<Enum_RoleName> enum_roleName, Empresa empresa,  LocalDateTime createdAt, LocalDateTime updateAt) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.enum_roleName = enum_roleName;
        this.empresa = empresa;

        this.createdAt = createdAt;
        this.updateAt = updateAt;
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

    public List<Enum_RoleName> getEnum_roleName() {
        return enum_roleName;
    }

    public void setEnum_roleName(List<Enum_RoleName> enum_roleName) {
        this.enum_roleName = enum_roleName;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
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
