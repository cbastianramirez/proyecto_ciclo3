package com.proyecto_ciclo3.proyecto_ciclo3.service;

import com.proyecto_ciclo3.proyecto_ciclo3.modelos.Empleado;
import com.proyecto_ciclo3.proyecto_ciclo3.modelos.Empresa;
import com.proyecto_ciclo3.proyecto_ciclo3.modelos.Enum_RoleName;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ListaEmpleado{
    private ArrayList<Empleado> empleados;


    public ListaEmpleado(){ // esta es la lista q aparece en controladorempleado en set

        this.empleados = new ArrayList<>();

        this.empleados.add(new Empleado(1,"Pepe Perez", "email@email.com",Enum_RoleName.Admin,"Alfagres"));
        this.empleados.add(new Empleado(2,"Margarot Ramirez", "email@microsoft.com", Enum_RoleName.Operario, "Corona"));

    }

    public ArrayList<Empleado> getAllEmpleados(){
        return empleados;
    }

    public Empleado getEmpleado(long id) throws Exception {
        for(Empleado empleados: this.empleados){
            if(empleados.getId() == id){
                return empleados;
            }
        }
        throw new Exception("Empleado no encontrado");
    }

    public String setEmpleado(Empleado empleadoPost) throws Exception { // devuelve un string entonces debe ser string
        try {
            getEmpleado(empleadoPost.getId());
        } catch (Exception e){
            this.empleados.add(empleadoPost);
            return"creacion del usuario exitosa";
        }
        throw new Exception("Usuario Existe");
    }

    // patch
        public Empleado updateEmpleado(Empleado updateEmpleado) throws Exception {
        try {
            Empleado bdEmpleado = getEmpleado(updateEmpleado.getId()); // este si porq es el q no cambia id

            if(updateEmpleado.getNombre() != null && !updateEmpleado.getNombre().equals("")){
                bdEmpleado.setNombre(updateEmpleado.getNombre());
            }
            if(updateEmpleado.getCorreo() != null && !updateEmpleado.getCorreo().equals("")) {
                bdEmpleado.setCorreo(updateEmpleado.getCorreo());
            }
            if(updateEmpleado.getEmpresa() != null && !updateEmpleado.getEmpresa().equals("")) {
                bdEmpleado.setEmpresa(updateEmpleado.getEmpresa());
            }
            /*if(updateEmpleado.getProfile() != null && !updateEmpleado.getProfile().equals("")) {
                bdEmpleado.setProfile(updateEmpleado.getProfile());
            }*/
            return bdEmpleado;
        } catch (Exception e) {
            throw new Exception("Empleado NO existe, imposible actualizar datos");
        }
    }

    //put
        /*bdEmpleado.setNombre(updateEmpleado.getNombre());
        bdEmpleado.setCorreo(updateEmpleado.getCorreo());
        bdEmpleado.setEmpresa(updateEmpleado.getEmpresa());*/



    public String deletEmpleado(Long id) throws Exception {
        try {
            Empleado empleado = getEmpleado(id);

            this.empleados.remove(empleado);

            return "Eliminado con éxito";
        } catch (Exception e) {
            throw new Exception("El empleado NO Existe para ser eliminado");
        }
    }


    // constructor lleno
    public ListaEmpleado(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    //getters & setters
    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }
}
