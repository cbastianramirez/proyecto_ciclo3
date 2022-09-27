package com.proyecto_ciclo3.proyecto_ciclo3.service;

import com.proyecto_ciclo3.proyecto_ciclo3.modelos.MovimientoDinero;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface MovimientoDineroInterface {

    public List<MovimientoDinero> getAllMovimientos();

    public MovimientoDinero getMovimiento(long id) throws Exception;

    public String setMovimiento(MovimientoDinero movimientoPost);

    public MovimientoDinero updateMovimiento(MovimientoDinero updateMovimiento, long id) throws Exception;

    public MovimientoDinero updateAllMovimientos(MovimientoDinero updateAllMovimientos, long id) throws Exception;

    public String deleteMovimientoDinero(long id);

    MovimientoDinero getMovimientoById(Long id);

    ArrayList<MovimientoDinero> obtenerPorEmpleado(Long id);

    ArrayList<MovimientoDinero> movimientoEmpleado(Long id);

    Optional<MovimientoDinero> obtenerPorEmpresa(Long id);

    ArrayList<MovimientoDinero> movimientEmpresa(Long id);

    Optional<MovimientoDinero> obtenerEmpleado(Long id);

    Optional<MovimientoDinero> obtenerEmpresa(Long id);

    Optional<MovimientoDinero> movIdEmpleado(Long id);

    Optional<MovimientoDinero> movIdEmpresa(Long id);

    Long obtenerTotalMontos();

    Long totalMontos();

    //Servicio para ver la suma de los montos por empleado
    Long MontosEmpleado(Long id);

    //Servicio para ver la suma de los montos por empresa
    Long MontosEmpresa(Long id);
}
