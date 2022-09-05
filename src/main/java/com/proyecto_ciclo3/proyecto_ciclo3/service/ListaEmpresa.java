package com.proyecto_ciclo3.proyecto_ciclo3.service;

import com.proyecto_ciclo3.proyecto_ciclo3.modelos.Empleado;
import com.proyecto_ciclo3.proyecto_ciclo3.modelos.Empresa;
import com.proyecto_ciclo3.proyecto_ciclo3.modelos.Enum_RoleName;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ListaEmpresa {
    private ArrayList<Empresa> empresa;


    public ListaEmpresa(){

        this.empresa = new ArrayList<>();

        Empresa enterprise1 = new Empresa("Karen", "84540390", "3005005050", "Calle 4 # 45-34"/*, "new LocalDateTime()" , "new LocalDateTime()"*/);
        Empresa enterprise2 = new Empresa("Andrés", "59801230231", "55555555", "Carrera 8 # 4-54" /*, "new LocalDateTime()","new LocalDateTime()"*/);


        this.empresa.add(enterprise1);
        this.empresa.add(enterprise2);

    }

    public ArrayList<Empresa> getAllEmpresas(){

        return this.empresa;
    }

    public Empresa getEmpresa(long id) throws Exception {
        for(Empresa empresa: this.empresa){
            if(empresa.getId() == id){
                return empresa;
            }
        }
        throw new Exception("Empresa no encontrada");
    }

    public String setEmpresa(Empresa empresaPost) throws Exception {
        try {
            getEmpresa(empresaPost.getId());
        } catch (Exception e){
            this.empresa.add(empresaPost);
            return"creacion de la empresa exitosa";
        }
        throw new Exception("La empresa ya Existe");
    }

    // patch
    public Empresa updateEmpresa(Empresa updateEmpresa) throws Exception {
        try {
            Empresa bdEmpresa = getEmpresa(updateEmpresa.getId());

            if(updateEmpresa.getNombre() != null && !updateEmpresa.getNombre().equals("")){
                bdEmpresa.setNombre(updateEmpresa.getNombre());
            }
            if(updateEmpresa.getNIT() != null && !updateEmpresa.getNIT().equals("")) {
                bdEmpresa.setNIT(updateEmpresa.getNIT());
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

    //put
        /*bdEmpleado.setNombre(updateEmpleado.getNombre());
        bdEmpleado.setCorreo(updateEmpleado.getCorreo());
        bdEmpleado.setEmpresa(updateEmpleado.getEmpresa());*/



    //constructor lleno

    public ListaEmpresa(ArrayList<Empresa> empresa) {
        this.empresa = empresa;
    }


    // getters & setters

    public ArrayList<Empresa> getEmpresa() {
        return empresa;
    }

    public void setEmpresa(ArrayList<Empresa> empresa) {
        this.empresa = empresa;
    }
}
