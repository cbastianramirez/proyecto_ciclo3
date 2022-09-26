package com.proyecto_ciclo3.proyecto_ciclo3.service;

import com.proyecto_ciclo3.proyecto_ciclo3.modelos.Empleado;
import com.proyecto_ciclo3.proyecto_ciclo3.repo.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService{
    @Autowired
    EmpleadoRepository empleadoRepository;

    // método para ver todos los empleados registrados
    public List<Empleado> getAllEmpleado(){
        List<Empleado>empleadoList = new ArrayList<>();
        empleadoRepository.findAll().forEach(empleado -> empleadoList.add(empleado));
        return empleadoList;

    }

    // método para buscar empleados por ID 31/08/2022
    //el optional es generico encuentreme lo q encuentre con optional si no lo encuentra no daña nada (si encuentra trae sino pues no pasa nada)
    // ES EL MISMO DE EMPRESA SOLO Q REGRE UN OPTIONAL Q PUEDE SER UN EMPLEADO, EL DE ARRIBA RETORNABA UNA EMPRESA
    public Optional<Empleado> getEmpleadoById(Long id) {
        return empleadoRepository.findById(id);
    }


    //método para buscar empleados por empresa
    public ArrayList<Empleado> obtenerPorEmpresa(Long id){
        return empleadoRepository.findByEmpresa(id);
    }


    //método guardar o actualizar registros en empleados

    public boolean saveOrUpdateEmpleado(Empleado empl){
        Empleado emp=empleadoRepository.save(empl);
        if (empleadoRepository.findById(emp.getId())!=null){
            return true;
        }
        return false;
    }


    //método para eliminar
    public boolean deleteEmpleado(Long id){
        empleadoRepository.deleteById(id);
        if(this.empleadoRepository.findById(id).isPresent()) {
            return false;
        }
        return true;
    }

}
