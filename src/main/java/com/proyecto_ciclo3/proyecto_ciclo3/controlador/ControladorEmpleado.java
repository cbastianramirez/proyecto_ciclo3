package com.proyecto_ciclo3.proyecto_ciclo3.controlador;

import com.proyecto_ciclo3.proyecto_ciclo3.modelos.Empleado;
import com.proyecto_ciclo3.proyecto_ciclo3.modelos.ObjetoRespuesta;
import com.proyecto_ciclo3.proyecto_ciclo3.service.ListaEmpleado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControladorEmpleado {

    // Get empresa
    @GetMapping("empleados")
    public ListaEmpleado listaEmpleados(){
        ListaEmpleado allEmpleados = new ListaEmpleado();
        return allEmpleados;
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
    /* @GetMapping("/empleado/{id}") // dice q requiere id
    public ResponseEntity<Object> getEmpleadoPath(@PathVariable long id) {
        return new ResponseEntity<>(id, HttpStatus.OK);
    }*/

    // post
    @PostMapping("/empleado") // debe requerir el id cambie de Object por String
    public ResponseEntity<String> postEmpleado(@RequestBody Empleado empleadoPost){
        try {
            String info = listaEmpleados().setEmpleado(empleadoPost);
            return new ResponseEntity<>(info, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //update
    @PutMapping("/empleado/{id}")
    public ResponseEntity<ObjetoRespuesta> putEmpleado(@RequestBody Empleado updateEmpleado, @PathVariable("id") long id){ // objetorespuesta me ayuda atrapar el error, coloq el id en ""
        try {
            Empleado bdEmpleado = listaEmpleados().updateEmpleado(updateEmpleado); /* revisar aquí profe clase antes 29 de agosto */
            return new ResponseEntity<>(new ObjetoRespuesta("Confirmado, resgistro empleado", bdEmpleado), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}