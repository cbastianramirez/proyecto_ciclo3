package com.proyecto_ciclo3.proyecto_ciclo3.service;

import com.proyecto_ciclo3.proyecto_ciclo3.modelos.MovimientoDinero;
import com.proyecto_ciclo3.proyecto_ciclo3.repo.MovimientoDineroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovimientoDineroService {
    @Autowired
    MovimientoDineroRepository movimientoDineroRepository;

    public List<MovimientoDinero> getAllMovimientos(){
        List<MovimientoDinero> movimientosList = new ArrayList<>();
        movimientoDineroRepository.findAll().forEach(movimiento -> movimientosList.add(movimiento));
        return movimientosList;
    }

    public MovimientoDinero getMovimientoById(Long id){
        return movimientoDineroRepository.findById(id).get();
    }

    public boolean saveOrUpdateMovimiento(MovimientoDinero movimientoDinero){
        MovimientoDinero mov=movimientoDineroRepository.save(movimientoDinero);
        return movimientoDineroRepository.findById(mov.getId()).isPresent();
    }

    public boolean deleteMovimiento(Long id){
        movimientoDineroRepository.deleteById(id);
        if(this.movimientoDineroRepository.findById(id).isPresent()){
            return false;
        }
        return true;
    }

    public ArrayList<MovimientoDinero> obtenerPorEmpleado(Long id) {
        return movimientoDineroRepository.findByEmpleado(id);
    }

    public ArrayList<MovimientoDinero> obtenerPorEmpresa(Long id) {
        return movimientoDineroRepository.findByEmpresa(id);
    }

    //Suma de todos los montos
    public Long obtenerSumaMontos(){
        return movimientoDineroRepository.SumarMonto();
    }

    //Suma los montos por empleado
    public Long MontosPorEmpleado(Long id){
        return movimientoDineroRepository.MontosPorEmpleado(id);
    }

    //Suma los montos por empresa
    public Long MontosPorEmpresa(Long id){
        return movimientoDineroRepository.MontosPorEmpresa(id);
    }
}
