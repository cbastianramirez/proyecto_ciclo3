package com.proyecto_ciclo3.proyecto_ciclo3.modelos;

import javax.persistence.*;

@Entity
@Table(name = "Enum_RoleName")
@OneToOne
@Column(name = "enum_RoleName")
public enum Enum_RoleName{

    Admin,
    Operario;s
}
