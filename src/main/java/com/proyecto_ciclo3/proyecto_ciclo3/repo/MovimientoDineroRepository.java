package com.proyecto_ciclo3.proyecto_ciclo3.repo;


import com.proyecto_ciclo3.proyecto_ciclo3.modelos.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public interface MovimientoDineroRepository extends JpaRepository<MovimientoDinero,Long> {

    // metodo para filtrar movimientos por empleado
    @Query(value = "select * from movimientos WHERE empleado_id= ?1",nativeQuery = true)
    public abstract ArrayList<MovimientoDinero> findByEmpleado(Long id);


    // Método para filtrar movimientos por empresa ----> esta sentencia esta adentro select id from empleado where empresa_id=1
    @Query(value = "select * from movimientos where empleado_id in (select id from empleado where empresa_id=1)", nativeQuery = true)  // evaluada en prostgres con la de arriba
    public abstract ArrayList<MovimientoDinero> findByEmpresa(Long id);

    //la relación real en movimiento es con el empleado NO con empresa



    // Método para suma total movimientos  ----> esta sentencia esta adentro select id from empleado where empresa_id=1
    @Query(value = "SELECT SUM(monto) from movimientos", nativeQuery = true)  // evaluada en prostgres con la de arriba
    public abstract long SumarMonto(); // REGRESA UN LONG



    // Método para suma total movimientos por empleado ----> esta sentencia esta adentro select id from empleado where empresa_id=1
    @Query(value = "SELECT SUM(monto) from movimientos where empleado_id=?1", nativeQuery = true)  // evaluada en prostgres con la de arriba
    public abstract long MontosPorEmpleado(Long id); // REGRESA UN LONG, colocar parámetros q le envío en la query osea Long id

    // Método para suma total movimientos por empresa ----> esta sentencia esta adentro select id from empleado where empresa_id=1
    @Query(value = "select sum(monto) from movimientos where empleado_id in (select id from empleado where empresa_id=1)", nativeQuery = true)  // que pasa si este no tiene join pues traigo la query larga de arriba y cambio * por sum q ya esta y monto
    public abstract long MontosPorEmpresa(Long id); // REGRESA UN LONG, , colocar parámetros


}
