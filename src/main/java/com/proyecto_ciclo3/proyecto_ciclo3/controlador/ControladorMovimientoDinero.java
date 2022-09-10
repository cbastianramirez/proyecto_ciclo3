package com.proyecto_ciclo3.proyecto_ciclo3.controlador;

import com.proyecto_ciclo3.proyecto_ciclo3.modelos.Empleado;
import com.proyecto_ciclo3.proyecto_ciclo3.modelos.MovimientoDinero;
import com.proyecto_ciclo3.proyecto_ciclo3.modelos.ObjetoRespuesta;
import com.proyecto_ciclo3.proyecto_ciclo3.service.ListaMovimientoDinero;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ControladorMovimientoDinero {

    private ListaMovimientoDinero  listaMovimientoDinero = new ListaMovimientoDinero ();

    @GetMapping("/movimientos")
    public ResponseEntity<ArrayList<MovimientoDinero>> getMovimiento(){
        return new ResponseEntity<>(listaMovimientoDinero.getAllMovimientos(),HttpStatus.OK);
    }

    // Get movimientos por id

    @GetMapping("/movimiento/{id}")
    public ResponseEntity<Object> getMovimiento(@PathVariable long id){
        try{
            //ListaMovimientoDinero listaMovimientoDinero = new ListaMovimientoDinero().getMovimiento(id);
            MovimientoDinero movimiento = new ListaMovimientoDinero().getMovimiento(id);
            //MovimientoDinero movimiento = listaMovimientoDinero.getMovimiento(id);

            return new ResponseEntity<>(movimiento, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    // post
    @PostMapping("/movimiento") // SÍ ES STRING porq le envíamos un mensaje
    public ResponseEntity<String> postMovimiento(@RequestBody MovimientoDinero movimientoPost){
        try {
            String info = listaMovimientoDinero.setMovimiento(movimientoPost);
            return new ResponseEntity<>(info, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //update
    @PatchMapping("/movimiento/{id}")
    public ResponseEntity<ObjetoRespuesta> putMovimientos(@RequestBody MovimientoDinero updateMovimientos, @PathVariable long id){ // objetorespuesta me ayuda atrapar el error, coloq el id en ""
        try {
            MovimientoDinero bdMovimiento = listaMovimientoDinero.updateMovimiento(updateMovimientos, id); /* revisar aquí profe clase antes 29 de agosto */
            return new ResponseEntity<>(new ObjetoRespuesta("Confirmado, movimiento", bdMovimiento), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Delete
    @DeleteMapping("/movimientos/{id}")
    public ResponseEntity<ObjetoRespuesta> deleteEmpleado(@PathVariable long id){
        try {
            String info = listaMovimientoDinero.deleteMovimientoDinero(id);
            return new ResponseEntity<>(new ObjetoRespuesta(info,null),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
