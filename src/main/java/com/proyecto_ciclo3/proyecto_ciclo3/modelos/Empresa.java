package com.proyecto_ciclo3.proyecto_ciclo3.modelos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "empresa")
public class Empresa {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //private long id; lo tenía con el id pero es nit
    private long Id;

    @Column(name = "nombre", nullable = false, unique = true, length = 50)
    private String nombre;

    @Column(name = "documento", nullable = false, unique = true, length = 50)
    private String documento;

    @Column(name = "telefono", length = 20)
    private String telefono;

    @Column(name = "direccion", nullable = false, length = 50)
    private String direccion;

    @OneToMany(mappedBy = "empleado_id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Empresa> empleado;  // @OneToMany una empresa puede tener muchos usuarios por eso List aquí en esta relacións

    @OneToMany(mappedBy = "empresa_id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //private List <MovimientoDinero> movimientosDinero =  new ArrayList<>();
    @JsonManagedReference
    private List<MovimientoDinero> movimientosDinero;

    @CreationTimestamp // yo no agrego estos datos entran desde el inicio
    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    @UpdateTimestamp  // yo no agrego estos datos entran desde el inicio
    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;

    // constructor vacío porque debe usar entity
    public Empresa() {
    }

    // constructor lleno

    public Empresa(long id, String nombre, String documento, String telefono, String direccion, List<Empresa> empleado, List<MovimientoDinero> movimientosDinero, LocalDateTime createdAt, LocalDateTime updatedAt) {
        Id = id;
        this.nombre = nombre;
        this.documento = documento;
        this.telefono = telefono;
        this.direccion = direccion;
        this.empleado = empleado;
        this.movimientosDinero = movimientosDinero;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // setters & getters
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

    public List<Empresa> getEmpleado() {
        return empleado;
    }

    public void setEmpleado(List<Empresa> empleado) {
        this.empleado = empleado;
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
    }
}
