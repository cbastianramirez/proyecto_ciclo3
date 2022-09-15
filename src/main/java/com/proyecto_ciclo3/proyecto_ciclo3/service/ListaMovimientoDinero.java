package com.proyecto_ciclo3.proyecto_ciclo3.service;

import com.proyecto_ciclo3.proyecto_ciclo3.modelos.Empleado;
import com.proyecto_ciclo3.proyecto_ciclo3.modelos.Empresa;
import com.proyecto_ciclo3.proyecto_ciclo3.modelos.MovimientoDinero;
import com.proyecto_ciclo3.proyecto_ciclo3.modelos.ObjetoRespuesta;
import com.proyecto_ciclo3.proyecto_ciclo3.repo.EmpleadoRespository;
import com.proyecto_ciclo3.proyecto_ciclo3.repo.MovimientoDineroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Service
public class ListaMovimientoDinero {
    @Autowired
    private MovimientoDineroRepository movimientoDineroRepository;

    //Todas los movimientos
    public ArrayList<MovimientoDinero> getAllMovimientos(){
        return movimientos;
    }

    //Movimientos por id
    public MovimientoDinero getMovimiento(long id) throws Exception {
        for(MovimientoDinero movimientos: this.movimientos){
            if(movimientos.getId() == id){
                return movimientos;
            }
        }
        throw new Exception("movimiento no encontrado");
    }

    //Creación de movimientos
    public String setMovimiento(MovimientoDinero movimientoPost) throws Exception {
        try {
            getMovimiento(movimientoPost.getId());

        } catch (Exception e){
            this.movimientos.add(movimientoPost);
            return "Creación de movimiento éxitosa";
        }
        throw new Exception("La transacción ya fue realizada");
    }

    // patch actualización de forma específica
    public MovimientoDinero updateMovimiento(MovimientoDinero updateMovimientos,long id) throws Exception {
        try {
            //MovimientoDinero bdMovimiento = getMovimiento(updateMovimientos.getId());
            MovimientoDinero bdMovimiento = getMovimiento(id);

            if(updateMovimientos.getMonto() == 0 ){
                bdMovimiento.setMonto(updateMovimientos.getMonto());
            }
            if(updateMovimientos.getMonto() == updateMovimientos.getMonto()){
                bdMovimiento.setMonto(updateMovimientos.getMonto());
            }
            if(updateMovimientos.getUsuario() != null && !updateMovimientos.getUsuario().equals("")){
                bdMovimiento.setUsuario(updateMovimientos.getUsuario());
            }
            if(updateMovimientos.getConcepto() != null && !updateMovimientos.getConcepto().equals("")) {
                bdMovimiento.setConcepto(updateMovimientos.getConcepto());
            }
            if(updateMovimientos.getEmpresa() != null && !updateMovimientos.getEmpresa().equals("")) {
                bdMovimiento.setEmpresa(updateMovimientos.getEmpresa());
            }

            return bdMovimiento;
        } catch (Exception e) {
            throw new Exception("Empresa NO existe, imposible actualizar datos");
        }
    }

    //Delete | eliminación por id
    public String deleteMovimientoDinero(long id) throws Exception {
        try {
            MovimientoDinero movimientoDinero = getMovimiento(id);
            this.movimientos.remove(movimientoDinero);
            return "Eliminado con éxito";
        } catch (Exception e) {
            throw new Exception("El empleado NO Existe para ser eliminado");
        }
    }

    // constructor lleno
    public ListaMovimientoDinero(ArrayList<MovimientoDinero> movimientos) {
        this.movimientos = movimientos;
    }

    // getters & setters
    public ArrayList<MovimientoDinero> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(ArrayList<MovimientoDinero> movimientos) {
        this.movimientos = movimientos;
    }
}
