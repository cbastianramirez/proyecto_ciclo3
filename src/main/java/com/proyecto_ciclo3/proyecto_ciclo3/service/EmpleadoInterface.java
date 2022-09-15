package com.proyecto_ciclo3.proyecto_ciclo3.service;

import com.proyecto_ciclo3.proyecto_ciclo3.modelos.Empleado;

import java.util.List;

public interface EmpleadoInterface {
    // pasa a cambiar el nombre de la private @Atowired en usuariocontrolador
    public List<Empleado> getAllEmpleados();
    public Empleado getEmpleado(long id) throws Exception; // me pregunto en el archivo cuando lo cambie le dí yes y aquí aparece
    public String setEmpleado(Empleado empleadoPost);
    public Empleado updateAllEmpleado(Empleado updateAllEmpleado,long id) throws Exception; // put
    public Empleado updateEmpleado(Empleado updateEmpleado, long id) throws Exception; //patch
    public String deleteEmpleado(long id);

}
