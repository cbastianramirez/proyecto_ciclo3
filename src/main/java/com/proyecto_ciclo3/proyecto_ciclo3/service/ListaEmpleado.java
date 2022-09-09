package com.proyecto_ciclo3.proyecto_ciclo3.service;

import com.proyecto_ciclo3.proyecto_ciclo3.modelos.Empleado;
import com.proyecto_ciclo3.proyecto_ciclo3.modelos.Empresa;
import com.proyecto_ciclo3.proyecto_ciclo3.modelos.Enum_RoleName;
import com.proyecto_ciclo3.proyecto_ciclo3.modelos.MovimientoDinero;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ListaEmpleado{
    private ArrayList<Empleado> empleados;


    public ListaEmpleado(){ // esta es la lista q aparece en controladorempleado en set

        this.empleados = new ArrayList<>();

        this.empleados.add(new Empleado(1,"Pepe Perez", "email@email.com",Enum_RoleName.Admin,"Alfagres"));
        this.empleados.add(new Empleado(2,"Margarot Ramirez", "email@microsoft.com", Enum_RoleName.Operario, "Corona"));
        this.empleados.add(new Empleado(3,"William Levy", "williamlevy@microsoft.com", Enum_RoleName.Admin, "Oma"));

    }

    //Todos los empleados
    public ArrayList<Empleado> getAllEmpleados(){
        return empleados;
    }

    //Empleado por id
    public Empleado getEmpleado(long id) throws Exception {
        for(Empleado empleados: this.empleados){
            if(empleados.getId() == id){
                return empleados;
            }
        }
        throw new Exception("Empleado no encontrado");
    }

    //Creación empleado
    public String setEmpleado(Empleado empleadoPost) throws Exception { // devuelve un string entonces debe ser string
        try {
            getEmpleado(empleadoPost.getId());
        } catch (Exception e){
            this.empleados.add(empleadoPost);
            return"creacion del usuario exitosa";
        }
        throw new Exception("Usuario Existe");
    }

    // patch edición atributos de forma específica
    public Empleado updateEmpleado(Empleado updateEmpleado, long id) throws Exception {
        try {
            Empleado bdEmpleado = getEmpleado(id);

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

    //Delete | eliminación por id
    public String deleteEmpleado(long id) throws Exception {
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
