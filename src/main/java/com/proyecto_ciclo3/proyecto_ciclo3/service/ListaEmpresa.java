package com.proyecto_ciclo3.proyecto_ciclo3.service;

import com.proyecto_ciclo3.proyecto_ciclo3.modelos.Empleado;
import com.proyecto_ciclo3.proyecto_ciclo3.modelos.Empresa;
import com.proyecto_ciclo3.proyecto_ciclo3.modelos.Enum_RoleName;
import com.proyecto_ciclo3.proyecto_ciclo3.modelos.MovimientoDinero;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
public class ListaEmpresa {
    private ArrayList<Empresa> empresas;

    public ListaEmpresa(){

        this.empresas = new ArrayList<>();

        this.empresas.add(new Empresa(1,"Emma Borbón","63863","Enum_RoleName.Admin","calle 25 con 4"));
        this.empresas.add(new Empresa(3,"Karen Ducatti","54321","Enum_RoleName.Operario","calle 25 con 4"));
        this.empresas.add(new Empresa(2,"George Clone","98765","Enum_RoleName.Admin","Av. el Dorado calle 26 con 68"));

    }

    //Todas las empresas
    public ArrayList<Empresa> getAllEmpresas(){

        return empresas;
    }

    //Empresa por id
    public Empresa getEmpresa(long id) throws Exception {
        for(Empresa empresa: this.empresas){
            if(empresa.getId() == id){
                return empresa;
            }
        }
        throw new Exception("Empresa no encontrada");
    }

    //Creación empresa
    public String setEmpresa(Empresa empresaPost) throws Exception {
        try {
            getEmpresa(empresaPost.getId());
        } catch (Exception e){
            this.empresas.add(empresaPost);
            return"creacion de la empresa exitosa";
        }
        throw new Exception("La empresa ya Existe");
    }

    // patch actualización atributos de forma específica
    public Empresa updateEmpresa(Empresa updateEmpresa, long id) throws Exception {
        try {
            Empresa bdEmpresa = getEmpresa(id);

            if(updateEmpresa.getNombre() != null && !updateEmpresa.getNombre().equals("")){
                bdEmpresa.setNombre(updateEmpresa.getNombre());
            }
            if(updateEmpresa.getDocumento() != null && !updateEmpresa.getDocumento().equals("")) {
                bdEmpresa.setDocumento(updateEmpresa.getDocumento());
            }
            if(updateEmpresa.getTelefono() != null && !updateEmpresa.getTelefono().equals("")) {
                bdEmpresa.setTelefono(updateEmpresa.getTelefono());
            }
            if(updateEmpresa.getDireccion() != null && !updateEmpresa.getDireccion().equals("")) {
                bdEmpresa.setDireccion(updateEmpresa.getDireccion());
            }
            return bdEmpresa;
        } catch (Exception e) {
            throw new Exception("Empresa NO existe, imposible actualizar datos");
        }
    }

    //Delete| eliminación por id
    public String deleteEmpresa(long id) throws Exception {
        try {
            Empresa empresa = getEmpresa(id);
            this.empresas.remove(empresa);
            return "Eliminado con éxito";
        } catch (Exception e) {
            throw new Exception("El empleado NO Existe para ser eliminado");
        }
    }


    // constructor lleno
    public ListaEmpresa(ArrayList<Empresa> empresas) {
        this.empresas = empresas;
    }

    // getters & setters
    public ArrayList<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(ArrayList<Empresa> empresas) {
        this.empresas = empresas;
    }
}
