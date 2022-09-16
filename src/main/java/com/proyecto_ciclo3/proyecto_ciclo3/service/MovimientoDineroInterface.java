package com.proyecto_ciclo3.proyecto_ciclo3.service;

import com.proyecto_ciclo3.proyecto_ciclo3.modelos.MovimientoDinero;

import java.util.List;

public interface MovimientoDineroInterface {

    public List<MovimientoDinero> getAllMovimientos();

    public MovimientoDinero getMovimiento(long id) throws Exception;

    public String setMovimiento(MovimientoDinero movimientoPost);

    public MovimientoDinero updateMovimiento(MovimientoDinero updateMovimiento, long id) throws Exception;

    public MovimientoDinero updateAllMovimientos(MovimientoDinero updateAllMovimientos, long id) throws Exception;

    public String deleteMovimientoDinero(long id);
}
