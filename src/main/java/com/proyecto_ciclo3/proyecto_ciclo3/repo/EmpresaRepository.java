package com.proyecto_ciclo3.proyecto_ciclo3.repo;

import com.proyecto_ciclo3.proyecto_ciclo3.modelos.Empresa;
import com.proyecto_ciclo3.proyecto_ciclo3.modelos.Enum_RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface EmpresaRepository extends JpaRepository<Empresa,Long> {

    @Modifying
    @Query("UPDATE Empresa u SET u.nombre= :nombre, u.documento= :documento, u.telefono = :telefono, u.direccion = :direccion, u.updatedAt = :updatedAt WHERE u.id= :id")

    public int update(long id, String nombre, String documento, String telefono, String direccion, LocalDateTime updateAt); // será un long en public
}
