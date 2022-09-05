package com.proyecto_ciclo3.proyecto_ciclo3.controlador;

import com.proyecto_ciclo3.proyecto_ciclo3.modelos.MovimientoDinero;
import com.proyecto_ciclo3.proyecto_ciclo3.modelos.ObjetoRespuesta;
import com.proyecto_ciclo3.proyecto_ciclo3.service.ListaMovimientoDinero;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControladorMovimientoDinero {
    @GetMapping("/movimientos")
    public ListaMovimientoDinero listaMovimientoDinero(){
        ListaMovimientoDinero allMovimientos = new ListaMovimientoDinero();
        return allMovimientos;
    }

    // Get movimientos por id

    @GetMapping("/movimiento/{id}") // asocia una url a una función q es getMovimiento()
    public ResponseEntity<Object> getMovimiento(@PathVariable long id){
        try{
            //ListaMovimientoDinero listaMovimientoDinero = new ListaMovimientoDinero().getMovimiento(id);
            MovimientoDinero movimiento = new ListaMovimientoDinero().getMovimientos(id);  // me pidio migrar ya no de ResponseEntity<Object>
            //MovimientoDinero movimiento = listaMovimientoDinero.getMovimiento(id);

            return new ResponseEntity<>(movimiento, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    // post
    @PostMapping("/movimiento") // debe requerir el id cambie de Object por String
    public ResponseEntity<String> postMovimiento(@RequestBody MovimientoDinero movimientoPost){
        try {
            String info = listaMovimientoDinero().setMovimientos(movimientoPost);
            return new ResponseEntity<>(info, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //update
    @PutMapping("/movimiento/{id}")
    public ResponseEntity<ObjetoRespuesta> putMovimiento(@RequestBody MovimientoDinero updateMovimiento, @PathVariable("id") long id){ // objetorespuesta me ayuda atrapar el error, coloq el id en ""
        try {
            MovimientoDinero bdMovimiento = listaMovimientoDinero().updateMovimientos(updateMovimiento); /* revisar aquí profe clase antes 29 de agosto */
            return new ResponseEntity<>(new ObjetoRespuesta("Confirmado, movimiento", bdMovimiento), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
