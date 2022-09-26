package com.proyecto_ciclo3.proyecto_ciclo3.modelos;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity

public class Empresa {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //private long id; lo tenía con el id pero es nit
    private long id;

    @Column(name = "nombre", nullable = false, unique = true, length = 50)
    private String nombre;

    @Column(name = "documento", nullable = false, unique = true, length = 50)
    private String documento;

    @Column(name = "telefono", length = 20)
    private String telefono;

    @Column(name = "direccion", nullable = false, length = 50)
    private String direccion;


    /*@JsonIgnore
    @OneToMany//(mappedBy = "empleado_id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Empresa empleado;

    @JsonIgnore
    @OneToMany//(mappedBy = "empresa", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private MovimientoDinero movimientosDinero;*/

    @CreationTimestamp
    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;

    // constructor vacío porque debe usar entity
    public Empresa() {
    }

    // constructor lleno


    public Empresa(long id, String nombre, String documento, String telefono, String direccion, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.nombre = nombre;
        this.documento = documento;
        this.telefono = telefono;
        this.direccion = direccion;

        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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
    }
}
