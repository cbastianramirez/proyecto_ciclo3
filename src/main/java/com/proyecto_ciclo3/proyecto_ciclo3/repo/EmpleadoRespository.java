package com.proyecto_ciclo3.proyecto_ciclo3.repo;

import com.proyecto_ciclo3.proyecto_ciclo3.modelos.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface EmpleadoRespository extends JpaRepository<Empleado,Long> {

    @Modifying
    @Query("UPDATE Usuario u SET u.nombre= :nombre, u.password= :password WHERE u.nombreUsuario= :id")//creación query ---> UPDATE + nombre tabla ese Usuario es el obj de java, variable u, debe estar = q esta en el obj con mayu y minu =  , con :+parametro cambia lo q uno desee para poder hacer el mapeo

    public int update(String nombre, String password, String id);
}
