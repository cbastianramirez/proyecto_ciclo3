package com.proyecto_ciclo3.proyecto_ciclo3.repo;

import com.proyecto_ciclo3.proyecto_ciclo3.modelos.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface MovimientoDineroRepository extends JpaRepository<MovimientoDinero,Long> {

    @Modifying
    @Query("UPDATE MovimientoDinero u SET u.concepto= :concepto, u.monto= :monto WHERE u.id= :id")

    public int update(long id, String concepto, float monto); // No sería un long al inicio public long


}
