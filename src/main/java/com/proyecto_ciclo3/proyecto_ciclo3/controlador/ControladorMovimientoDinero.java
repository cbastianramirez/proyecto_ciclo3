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

    private ControladorMovimientoDinero controladorMovimientoDinero = new ControladorMovimientoDinero();

    @GetMapping("/movimientos")
    public ResponseEntity<ArrayList<MovimientoDinero>> getMovimientos(){
        return new ResponseEntity<>(controladorMovimientoDinero.getAllMovimientos(),HttpStatus.ACCEPTED);
    }


    // Get movimientos por id

    @GetMapping("/movimiento/{id}") // asocia una url a una función q es getMovimiento()
    public ResponseEntity<Object> getMovimiento(@PathVariable long id){
        try{
            //ListaMovimientoDinero listaMovimientoDinero = new ListaMovimientoDinero().getMovimiento(id);
            MovimientoDinero movimiento = new ListaMovimientoDinero().getMovimiento(id);  // me pidio migrar ya no de ResponseEntity<Object>
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
            String info = listaMovimientoDinero().setMovimiento(movimientoPost);
            return new ResponseEntity<>(info, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //update
    @PutMapping("/movimiento/{id}")
    public ResponseEntity<ObjetoRespuesta> putMovimientos(@RequestBody MovimientoDinero updateMovimiento, @PathVariable("id") long id){ // objetorespuesta me ayuda atrapar el error, coloq el id en ""
        try {
            MovimientoDinero bdMovimiento = listaMovimientoDinero().updateMovimientos(updateMovimiento); /* revisar aquí profe clase antes 29 de agosto */
            return new ResponseEntity<>(new ObjetoRespuesta("Confirmado, movimiento", bdMovimiento), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
