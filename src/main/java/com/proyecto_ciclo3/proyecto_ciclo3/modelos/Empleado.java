package com.proyecto_ciclo3.proyecto_ciclo3.modelos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "empleado")
public class Empleado {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "correo",unique = true,  length = 50)
    private String correo;

    // lo creo pero sin getters setters
    @OneToOne                 // este no va aquí según explico el profe porq el empleado no contiene fk del profile es al contrario(mappedBy = "empleado")
    private Profile profile;

    //@ManyToOne, por lo q ya no existe relación quito el @JoinColumn
    @Enumerated(EnumType.STRING)
    @Column(name = "enum_roleName", nullable = false)
    private Enum_RoleName enum_roleName;

    @ManyToOne
    @JoinColumn (name = "empresa_id")
    private Empresa empresa;

    @OneToMany(mappedBy = "empleado_id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)  // el profe Juan @OneToMany // @OneToMany una empresa puede tener muchos usuarios por eso List aquí en esta relacións
    //private List <MovimientoDinero> movimientosDinero =  new ArrayList<>(); // yo no lo debo colocar en update atributo solo forkey
    @JsonManagedReference
    private List<MovimientoDinero> movimientosDinero;


    @CreationTimestamp // yo no agrego estos datos entran desde el inicio
    @Column(name = "createdAt")
    private LocalDateTime createdAt;


    @UpdateTimestamp  // yo no agrego estos datos entran desde el inicio
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
