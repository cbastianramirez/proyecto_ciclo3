package com.proyecto_ciclo3.proyecto_ciclo3.modelos;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Enum_RoleName")
//@ManyToOne
public enum Enum_RoleName{

    Admin,
    Operario;
}
