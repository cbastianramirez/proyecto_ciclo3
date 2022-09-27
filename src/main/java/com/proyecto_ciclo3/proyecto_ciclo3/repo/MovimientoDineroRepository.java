package com.proyecto_ciclo3.proyecto_ciclo3.repo;


import com.proyecto_ciclo3.proyecto_ciclo3.modelos.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public interface MovimientoDineroRepository extends JpaRepository<MovimientoDinero,Long> {

    @Query(value = "select * from movimientos WHERE empleado_id= ?1",nativeQuery = true)
    public abstract ArrayList<MovimientoDinero> findByEmpleado(Long id);
    // select * from movimientos WHERE empleado_id=2   --> probado en postgres

    // el ?1 le informa a la query q es id-- el 1er argumento de esa query sentencia


    // Método para filtrar movimientos por empresa ----> esta sentencia esta adentro select id from empleado where empresa_id=1
    @Query(value = "select * from movimientos where empleado_id in (select id from empleado where empresa_id=1)", nativeQuery = true)  // evaluada en prostgres con la de arriba
    public abstract ArrayList<MovimientoDinero> findByEmpresa(Long id);

    //Total movimientos
    @Query(value = "SELECT SUM(monto) from movimientos", nativeQuery = true)
    public abstract long TotalMonto();

    // Total movimientos por empleado
    @Query(value = "SELECT SUM(monto) from movimientos where empleado_id=?1", nativeQuery = true)
    public abstract long MontosEmpleado(Long id);

    // Método para suma total movimientos por empresa
    @Query(value = "select sum(monto) from movimientos where empleado_id in (select id from empleado where empresa_id=1)", nativeQuery = true)  // que pasa si este no tiene join pues traigo la query larga de arriba y cambio * por sum q ya esta y monto
    public abstract long MontosEmpresa(Long id);


    /* @Modifying
    @Query("UPDATE MovimientoDinero u SET u.concepto= :concepto, u.monto= :monto WHERE u.id= :id")

    public int update( String concepto, float monto, long id); */

}
