package com.proyecto_ciclo3.proyecto_ciclo3.service;

import com.proyecto_ciclo3.proyecto_ciclo3.modelos.Empleado;
import com.proyecto_ciclo3.proyecto_ciclo3.repo.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ListaEmpleado implements EmpleadoInterface{
    @Autowired
    private EmpleadoRepository empleadoRepository;

    //Todos los empleados
    @Override
    public List<Empleado> getAllEmpleados(){
        return empleadoRepository.findAll();
    }

    //Empleado por id
    @Override
    public Empleado getEmpleado(long id) throws Exception{
        Optional<Empleado> bdEmpleado = empleadoRepository.findById(id);
        if (bdEmpleado.isPresent()){
            return bdEmpleado.get();
        }
        throw new Exception("Empleado No existe");
    }

    //Creación empleado
    @Override
    public String setEmpleado(Empleado empleadoPost) {
        empleadoRepository.save(empleadoPost);
        return "Creado empleado con éxito";
    }

    // put
    @Transactional
    @Override
    public Empleado updateAllEmpleado(Empleado updateAllEmpleado, long id) throws Exception{
        empleadoRepository.update(updateAllEmpleado.getNombre(),
                updateAllEmpleado.getCorreo(), updateAllEmpleado.getEnum_roleName(),
                updateAllEmpleado.getEmpresa(),id);
        return getEmpleado(id);
    }

    // patch edición atributos de forma específica
    @Override
    public Empleado updateEmpleado(Empleado updateEmpleado, long id) throws Exception{
        Empleado bdEmpleado = getEmpleado(id);
        if(updateEmpleado.getNombre() != null && !updateEmpleado.getNombre().equals("")){
            bdEmpleado.setNombre(updateEmpleado.getNombre());
        }
        if(updateEmpleado.getCorreo() != null && !updateEmpleado.getCorreo().equals("")) {
            bdEmpleado.setCorreo(updateEmpleado.getCorreo());
        }
        if(updateEmpleado.getEmpresa() == updateEmpleado.getEmpresa()) { //Aquí la empresa es objeto q recibe empresas
            bdEmpleado.setEmpresa(updateEmpleado.getEmpresa());
        }
            /*if(updateEmpleado.getProfile() != null && !updateEmpleado.getProfile().equals("")) { // este debe ir en profile?
                bdEmpleado.setProfile(updateEmpleado.getProfile());
            }*/
        return empleadoRepository.save(bdEmpleado);

    }

    //Delete | eliminación por id
    @Override
    public String deleteEmpleado(long id){
        empleadoRepository.deleteById(id);
        return "Empleado fue eliminado con éxito";
    }

}
