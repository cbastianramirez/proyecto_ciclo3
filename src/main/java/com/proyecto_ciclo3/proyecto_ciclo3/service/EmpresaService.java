package com.proyecto_ciclo3.proyecto_ciclo3.service;

import com.proyecto_ciclo3.proyecto_ciclo3.modelos.Empresa;
import com.proyecto_ciclo3.proyecto_ciclo3.repo.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class EmpresaService {
    @Autowired
    EmpresaRepository empresaRepository;

    // método q retornará la lista d empresa usando métodos heredados
    public List<Empresa> getAllEmpresas(){

        List<Empresa> empresaList = new ArrayList<>(empresaRepository.findAll());
        return empresaList;
    }

    //editar empresa pero deBE TENER EL ID PARA EDITARLE
    public  Empresa getEmpresaById(Long id){
        return empresaRepository.findById(id).get();
    }

    public boolean  saveOrUpdateEmpresa(Empresa empresa){
        Empresa emp = empresaRepository.save(empresa);
        if(empresaRepository.findById(emp.getId()) != null){
            return  true;
        }
        return false;
    }

    // método delete requiere el id para hacerle y será tipo boolean
    public boolean deleteEmpresa(Long id){
        empresaRepository.deleteById(id);
        if(getEmpresaById(id) != null){
            return false;
        }
        return true;
    }

}
