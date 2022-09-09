package com.proyecto_ciclo3.proyecto_ciclo3.controlador;

import com.proyecto_ciclo3.proyecto_ciclo3.modelos.Empleado;
import com.proyecto_ciclo3.proyecto_ciclo3.modelos.ObjetoRespuesta;
import com.proyecto_ciclo3.proyecto_ciclo3.service.ListaEmpleado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ControladorEmpleado {

    private ListaEmpleado listaEmpleado = new ListaEmpleado();


    @GetMapping("/empleados")
    public ResponseEntity<ArrayList<Empleado>> getEmpleados(){
        return new ResponseEntity<>(listaEmpleado.getAllEmpleados(),HttpStatus.ACCEPTED);
    }

    // Get empresa por id
    @GetMapping("/empleado/{id}") // asocia una url a una función q es getEmpleado()
    public ResponseEntity<Object> getEmpleado(@PathVariable long id){
        try{
            //ListaEmpleado listaEmpleado = new ListaEmpleado().getEmpleado(id);
            Empleado empleado = new ListaEmpleado().getEmpleado(id);
            //Empleado empleados = listaEmpleado.getEmpleado(id);

            return new ResponseEntity<>(empleado, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // post

    @PostMapping("/empleado")
    public ResponseEntity<String> postEmpleado(@RequestBody Empleado empleadoPost){  // SÍ ES STRING porq le envíamos un mensaje
        try {
            String info = listaEmpleado.setEmpleado(empleadoPost);
            return new ResponseEntity<>(info, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //update
    @PatchMapping("/empleado/{id}")
    public ResponseEntity<ObjetoRespuesta> putEmpleado(@RequestBody Empleado updateEmpleado, @PathVariable long id){ // objetorespuesta me ayuda atrapar el error, coloq el id en ""
        try {
            Empleado bdEmpleado = listaEmpleado.updateEmpleado(updateEmpleado, id); /* revisar aquí profe clase antes 29 de agosto */
            return new ResponseEntity<>(new ObjetoRespuesta("Confirmado, resgistro empleado", bdEmpleado), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/empleados/{id}")
    public ResponseEntity<ObjetoRespuesta> deleteEmpleado(@PathVariable long id){
        try {
            String info = listaEmpleado.deleteEmpleado(id);
            return new ResponseEntity<>(new ObjetoRespuesta(info,null),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
