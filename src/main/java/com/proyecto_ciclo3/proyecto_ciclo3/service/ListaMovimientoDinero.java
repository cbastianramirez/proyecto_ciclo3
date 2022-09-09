package com.proyecto_ciclo3.proyecto_ciclo3.service;

import com.proyecto_ciclo3.proyecto_ciclo3.modelos.Empleado;
import com.proyecto_ciclo3.proyecto_ciclo3.modelos.Empresa;
import com.proyecto_ciclo3.proyecto_ciclo3.modelos.MovimientoDinero;
import com.proyecto_ciclo3.proyecto_ciclo3.modelos.ObjetoRespuesta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Service
public class ListaMovimientoDinero {
    private ArrayList<MovimientoDinero> movimientos;


    public ListaMovimientoDinero(){

        this.movimientos = new ArrayList<>();

        this.movimientos.add(new MovimientoDinero(1,"Debe", -60000, "Juan", "chcocolat cali"/*, "new LocalDateTime()" , "new LocalDateTime()"*/));
        this.movimientos.add(new MovimientoDinero(2,"realizada", 5000000, "Andrés", "Buga la grande" /*, "new LocalDateTime()","new LocalDateTime()"*/));

    }

    public ArrayList<MovimientoDinero> getAllMovimientos(){

        return movimientos;
    }

    public MovimientoDinero getMovimiento(long id) throws Exception {
        for(MovimientoDinero movimientos: this.movimientos){
            if(movimientos.getId() == id){
                return movimientos;
            }
        }
        throw new Exception("movimiento no encontrado");
    }

    public String setMovimiento(MovimientoDinero movimientoPost) throws Exception {
        try {
            getMovimiento(movimientoPost.getId());
        } catch (Exception e){
            this.movimientos.add(movimientoPost);
            return"Transacción exitosa";
        }
        throw new Exception("La transacción ya fue realizada");
    }

    // patch
    public MovimientoDinero updateMovimientos(MovimientoDinero updateMovimientos) throws Exception {
        try {
            MovimientoDinero bdMovimiento = getMovimientos(updateMovimientos.getId());

            if(updateMovimientos.getUsuario() != null && !updateMovimientos.getUsuario().equals("")){
                bdMovimiento.setUsuario(updateMovimientos.getUsuario());
            }
            if(updateMovimientos.getConcepto() != null && !updateMovimientos.getConcepto().equals("")) {
                bdMovimiento.setConcepto(updateMovimientos.getConcepto());
            }
            if(updateMovimientos.getEmpresa() != null && !updateMovimientos.getEmpresa().equals("")) {
                bdMovimiento.setEmpresa(updateMovimientos.getEmpresa());
            }
            /*if(updateEmpresa.getDireccion() != null && !updateEmpresa.getDireccion().equals("")) {
                bdEmpresa.setDireccion(updateEmpresa.getDireccion());
            }   que se hace con el monto sería ==  */
            return bdMovimiento;
        } catch (Exception e) {
            throw new Exception("Empresa NO existe, imposible actualizar datos");
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