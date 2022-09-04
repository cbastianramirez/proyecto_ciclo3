package com.proyecto_ciclo3.proyecto_ciclo3.service;

import com.proyecto_ciclo3.proyecto_ciclo3.modelos.Empleado;
import com.proyecto_ciclo3.proyecto_ciclo3.modelos.Empresa;
import com.proyecto_ciclo3.proyecto_ciclo3.modelos.Enum_RoleName;

import java.util.ArrayList;

public class ListaEmpleado {
    private ArrayList<Empleado> empleados;

    public ListaEmpleado(){

        this.empleados = new ArrayList<>();

        Empresa enterprise1 = new Empresa("Karen", "84540390", "3005005050", "Calle 4 # 45-34","","");
        Empresa enterprise2 = new Empresa("Andrés", "59801230231", "55555555", "Carrera 8 # 4-54","","");

        Empleado employee1 = new Empleado("Pepe Perez", "email@email.com",Enum_RoleName.Admin,"Alfagres");
        Empleado employee2 = new Empleado("Margarot Ramirez", "email@microsoft.com", Enum_RoleName.Operario, "Corona");

        this.empleados.add(employee1);
        this.empleados.add(employee2);

    }

    public ArrayList<Empleado> getAllEmpleados(){
        return this.empleados;
    }

    public Empleado getEmpleado(long id) throws Exception {
        for(Empleado empleados: this.empleados){
            if(empleados.getId() == id){
                return empleados;
            }
        }
        throw new Exception("Empleado no encontrado");
    }

    public String setEmpleado(Empleado empleadoPost) throws Exception {
        try {
            getEmpleado(empleadoPost.getId());
        } catch (Exception e){
            this.empleados.add(empleadoPost);
            return"creacion del usuario exitosa";
        }
        throw new Exception("Usuario Existe");
    }

    // path
        public Empleado updateEmpleado(Empleado updateEmpleado) throws Exception {
        try {
            Empleado bdEmpleado = getEmpleado(updateEmpleado.getId());

            if(updateEmpleado.getNombre() != null && !updateEmpleado.getNombre().equals("")){
                bdEmpleado.setNombre(updateEmpleado.getNombre());
            }
            if(updateEmpleado.getCorreo() != null && !updateEmpleado.getCorreo().equals("")) {
                bdEmpleado.setCorreo(updateEmpleado.getCorreo());
            }
            if(updateEmpleado.getEmpresa() != null && !updateEmpleado.getEmpresa().equals("")) {
                bdEmpleado.setEmpresa(updateEmpleado.getEmpresa());
            }
            return bdEmpleado;
        } catch (Exception e) {
            throw new Exception("Empleado NO existe, imposible actualizar datos");
        }
    }

    //put
        /*bdEmpleado.setNombre(updateEmpleado.getNombre());
        bdEmpleado.setCorreo(updateEmpleado.getCorreo());
        bdEmpleado.setEmpresa(updateEmpleado.getEmpresa());*/



    //constructor lleno
    public ListaEmpleado(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    // getters & setters
    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }
}
