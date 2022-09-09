package com.proyecto_ciclo3.proyecto_ciclo3.controlador;

import com.proyecto_ciclo3.proyecto_ciclo3.modelos.Empleado;
import com.proyecto_ciclo3.proyecto_ciclo3.modelos.Empresa;
import com.proyecto_ciclo3.proyecto_ciclo3.modelos.ObjetoRespuesta;
import com.proyecto_ciclo3.proyecto_ciclo3.service.ListaEmpleado;
import com.proyecto_ciclo3.proyecto_ciclo3.service.ListaEmpresa;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
public class ControladorEmpresa {

    private ControladorEmpresa controladorEmpresa = new ControladorEmpresa();

    @GetMapping("/empresas")
    public ResponseEntity<ArrayList<Empresa>> getAllEmpresas(){
        return new ResponseEntity<>(controladorEmpresa.getAllEmpresas(),HttpStatus.ACCEPTED);
    }

    // Get empresa por id
    @GetMapping("/empresa/{id}")
    public ResponseEntity<Object> getEmpresa(@PathVariable long id){
        try{
            Empresa empresas = new ListaEmpresa().getEmpresa(id);

            return new ResponseEntity<>(empresas, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/empresa")  // SÍ ES STRING porq le envíamos un mensaje
    public ResponseEntity<String> postEmpresa(@RequestBody Empresa empresaPost){
        try {
            String info = listaEmpresa().setEmpresa(empresaPost);
            return new ResponseEntity<>(info, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //update
    @PatchMapping("empresa/{id}")
    public ResponseEntity<ObjetoRespuesta> putEmpresa(@RequestBody Empresa updateEmpresa, @PathVariable("id") long id){ // objetorespuesta me ayuda atrapar el error, coloq el id en ""
        try {
            Empresa bdEmpresa = listaEmpresa().updateEmpresa(updateEmpresa);
            return new ResponseEntity<>(new ObjetoRespuesta("Confirmado, resgistro empresa", bdEmpresa), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
