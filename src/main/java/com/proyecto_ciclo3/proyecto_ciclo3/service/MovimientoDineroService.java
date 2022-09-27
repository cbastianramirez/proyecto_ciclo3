package com.proyecto_ciclo3.proyecto_ciclo3.service;

import com.proyecto_ciclo3.proyecto_ciclo3.modelos.MovimientoDinero;
import com.proyecto_ciclo3.proyecto_ciclo3.repo.MovimientoDineroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovimientoDineroService {
    @Autowired
    MovimientoDineroRepository movimientoDineroRepository;

    public List<MovimientoDinero> getAllMovimientos() {
        List<MovimientoDinero> movimientosList = new ArrayList<>();
        movimientoDineroRepository.findAll().forEach(movimiento -> movimientosList.add(movimiento));
        return movimientosList;
    }

    public MovimientoDinero getMovimientoById(Long id) {
        return movimientoDineroRepository.findById(id).get();
    }

    public boolean saveOrUpdateMovimiento(MovimientoDinero movimientoDinero) {
        MovimientoDinero mov = movimientoDineroRepository.save(movimientoDinero);
        return movimientoDineroRepository.findById(mov.getId()).isPresent();
    }

    public boolean deleteMovimiento(Long id) {
        movimientoDineroRepository.deleteById(id);
        if (this.movimientoDineroRepository.findById(id).isPresent()) {
            return false;
        }
        return true;
    }

    public String deleteMovimientoDinero(long id) {
        movimientoDineroRepository.deleteById(id);
        return "Movimiento Dinero eliminado con éxito";
    }

  /*
    public MovimientoDinero getMovimientoById(Long id) { //Ver movimientos por id
        return movimientoDineroRepository.findById(id).get();
    }
*/

    public ArrayList<MovimientoDinero> obtenerPorEmpleado(Long id) {
        return null;
    }


    public ArrayList<MovimientoDinero> movimientoEmpleado(Long id) {
        return movimientoDineroRepository.findByEmpleado(id);
    }


    public Optional<MovimientoDinero> obtenerPorEmpresa(Long id) {
        return Optional.empty();
    }


    public ArrayList<MovimientoDinero> movimientEmpresa(Long id) {
        return movimientoDineroRepository.findByEmpresa(id);
    }


    public Optional<MovimientoDinero> obtenerEmpleado(Long id) {
        return Optional.empty();
    }


    public Optional<MovimientoDinero> obtenerEmpresa(Long id) {
        return Optional.empty();
    }


    public Optional<MovimientoDinero> movIdEmpleado(Long id) { //Obterner teniendo en cuenta el id del empleado
        return movimientoDineroRepository.findById(id);
    }



    public Optional<MovimientoDinero> movIdEmpresa(Long id) { //Obtener movimientos teniendo en cuenta el id de la empresa a la que pertencen los empleados que la registraron
        return movimientoDineroRepository.findById(id);
        //MontosPorEmpresa(id);
    }


    public Long obtenerTotalMontos() {
        return null;
    }


    public Long totalMontos() {
        return movimientoDineroRepository.TotalMonto();
    }

    //Servicio para ver la suma de los montos por empleado

    public Long MontosEmpleado(Long id) {
        return movimientoDineroRepository.MontosEmpleado(id);
    }

    //Servicio para ver la suma de los montos por empresa

    public Long MontosEmpresa(Long id) {
        return movimientoDineroRepository.MontosEmpresa(id);
    }

}
