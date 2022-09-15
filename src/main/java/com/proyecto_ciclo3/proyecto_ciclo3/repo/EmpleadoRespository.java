package com.proyecto_ciclo3.proyecto_ciclo3.repo;

import com.proyecto_ciclo3.proyecto_ciclo3.modelos.Empleado;
import com.proyecto_ciclo3.proyecto_ciclo3.modelos.Empresa;
import com.proyecto_ciclo3.proyecto_ciclo3.modelos.Enum_RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface EmpleadoRespository extends JpaRepository<Empleado,Long> {

    @Modifying
    @Query("UPDATE Usuario u SET u.nombre= :nombre, u.correo= :correo, u.enum_roleName = :enum_roleName, u.empresa = :empresa, u.updatedAt = :updatedAt WHERE u.id= :id")

    public int update(long id, String nombre, String correo, Enum_RoleName rol, Empresa empresa, LocalDateTime updateAt);
}
