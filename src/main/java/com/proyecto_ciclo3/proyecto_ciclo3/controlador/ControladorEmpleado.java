package com.proyecto_ciclo3.proyecto_ciclo3.controlador;

import com.proyecto_ciclo3.proyecto_ciclo3.modelos.Empleado;
import com.proyecto_ciclo3.proyecto_ciclo3.modelos.ObjetoRespuesta;
import com.proyecto_ciclo3.proyecto_ciclo3.service.EmpleadoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControladorEmpleado {

    @Autowired
    //@GetMapping("/empleado")
    private EmpleadoInterface listaEmpleado;

    @GetMapping("/empleado/empleados") // "empleados"
    public ResponseEntity<List<Empleado>> getAllEmpleados(){
        return new ResponseEntity<>(listaEmpleado.getAllEmpleados(),HttpStatus.OK);
    }

    /*@GetMapping("/empleado")
    public ResponseEntity<Object> getEmpleado(@RequestParam long id){
        try{
            Empleado empleado = listaEmpleado.getEmpleado(id);
            return new ResponseEntity<>(empleado, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/

    // Get empresa por id
    @GetMapping("/empleado/{id}")
    public ResponseEntity<Object> getEmpleado(@PathVariable long id) {

        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    // post
    @PostMapping("/empleado")
    public ResponseEntity<String> postEmpleado(@RequestBody Empleado empleadoPost){
        try {
            String mensaje = listaEmpleado.setEmpleado(empleadoPost);
            return new ResponseEntity<>(mensaje, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //update
    @PatchMapping("/empleado/{id}")
    public ResponseEntity<ObjetoRespuesta> patchEmpleado(@RequestBody Empleado updateEmpleado, @PathVariable long id){
        try {
            Empleado bdEmpleado = listaEmpleado.updateEmpleado(updateEmpleado, id);
            return new ResponseEntity<>(new ObjetoRespuesta("Actualización éxitosa", bdEmpleado), HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();// muestra el error
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //updateAll
    // actualizar tod la info del usuario con update -- put
    @PutMapping("/empleado/{id}")
    public ResponseEntity<ObjetoRespuesta> putEmpleado(@RequestBody Empleado updateAllEmpleado, @PathVariable long id){
        try {
            Empleado bdEmpleado = listaEmpleado.updateAllEmpleado(updateAllEmpleado, id);
            return new ResponseEntity<>(new ObjetoRespuesta("Actualización realizada", bdEmpleado), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Delete
    @DeleteMapping("/empleados/{id}")
    public ResponseEntity<ObjetoRespuesta> deleteEmpleado(@PathVariable long id) {
        try {
            String mensaje = listaEmpleado.deleteEmpleado(id);

            return new ResponseEntity<>(new ObjetoRespuesta(mensaje, null), HttpStatus.OK);// se responde con ObjetoRespuesta con mensaje q llega y objeto nulo porq no existe obje porq no hay info
        } catch (Exception e){
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);// en caso de error se sabe q no existe el usuario
        }
    }
}
