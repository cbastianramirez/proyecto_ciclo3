package com.proyecto_ciclo3.proyecto_ciclo3.controlador;

import com.proyecto_ciclo3.proyecto_ciclo3.modelos.Empresa;
import com.proyecto_ciclo3.proyecto_ciclo3.modelos.ObjetoRespuesta;
import com.proyecto_ciclo3.proyecto_ciclo3.service.EmpresaInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class ControladorEmpresa {

    @Autowired
    private EmpresaInterface empresaInterface;

    @GetMapping("/empresa/empresas")
    public ResponseEntity<List<Empresa>> getAllEmpresas(){
        return new ResponseEntity<>(empresaInterface.getAllEmpresas(),HttpStatus.OK);
    }

    // Get empresa por id
    @GetMapping("/empresa/{id}")
    public ResponseEntity<Object> getEmpresa(@PathVariable long id){

        return new ResponseEntity<>(id, HttpStatus.OK);
    }
    @PostMapping("/empresa")  // SÍ ES STRING porq le envíamos un mensaje
    public ResponseEntity<String> postEmpresa(@RequestBody Empresa empresaPost){
        try {
            String info = empresaInterface.setEmpresa(empresaPost);
            return new ResponseEntity<>(info, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //update
    @PatchMapping("empresa/{id}")
    public ResponseEntity<ObjetoRespuesta>patchEmpresa(@RequestBody Empresa updateEmpresa, @PathVariable long id){
        try {
            Empresa bdEmpresa = empresaInterface.updateEmpresa(updateEmpresa,id);
            return new ResponseEntity<>(new ObjetoRespuesta("Confirmado, resgistro empresa", bdEmpresa), HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace(); // muestra el error si llega a existir
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //updateAll
    // actualizar tod la info del usuario con update -- put
    @PutMapping("/empresa/{id}")
    public ResponseEntity<ObjetoRespuesta> putEmpresa(@RequestBody Empresa updateAllEmpresa, @PathVariable long id){
        try {
            Empresa bdEmpresa = empresaInterface.updateAllEmpresa(updateAllEmpresa, id);
            return new ResponseEntity<>(new ObjetoRespuesta("Actualización realizada", bdEmpresa), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Delete
    @DeleteMapping("/empresas/{id}")
    public ResponseEntity<ObjetoRespuesta> deleteEmpleado(@PathVariable long id){
        try {
            String info = empresaInterface.deleteEmpresa(id);
            return new ResponseEntity<>(new ObjetoRespuesta(info,null),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
