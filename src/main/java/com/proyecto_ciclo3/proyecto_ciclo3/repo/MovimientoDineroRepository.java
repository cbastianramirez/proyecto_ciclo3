package com.proyecto_ciclo3.proyecto_ciclo3.repo;

import com.proyecto_ciclo3.proyecto_ciclo3.modelos.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface MovimientoDineroRepository extends JpaRepository<MovimientoDinero,Long> {

    @Modifying
    @Query("UPDATE MovimientoDinero u SET u.concepto= :concepto, u.monto= :monto, u.updatedAt = :updatedAt WHERE u.id= :id")

    public int update(long id, String concepto, float monto, LocalDateTime updateAt); // No sería un long al inicio public long


}
