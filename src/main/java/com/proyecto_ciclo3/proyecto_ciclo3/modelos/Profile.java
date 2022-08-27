package com.proyecto_ciclo3.proyecto_ciclo3.modelos;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Profile")
public class Profile {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String imagen;

    private String telefono;

    @OneToOne
    private Empleado usuario;

    private Date createdAt;

    private Date updateAt;

}
