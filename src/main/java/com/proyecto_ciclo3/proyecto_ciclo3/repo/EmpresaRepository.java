package com.proyecto_ciclo3.proyecto_ciclo3.repo;

import com.proyecto_ciclo3.proyecto_ciclo3.modelos.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa,Long> {



}
