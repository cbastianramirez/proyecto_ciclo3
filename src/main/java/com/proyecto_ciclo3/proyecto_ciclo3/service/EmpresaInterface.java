package com.proyecto_ciclo3.proyecto_ciclo3.service;

import com.proyecto_ciclo3.proyecto_ciclo3.modelos.Empresa;

import java.util.List;

public interface EmpresaInterface {
    public List<Empresa> getAllEmpresas();

    public Empresa getEmpresa(long id) throws Exception;

    public String setEmpresa(Empresa empresaPost);

    public Empresa updateAllEmpresa(Empresa updateAllEmpresa, long id) throws Exception;

    public Empresa updateEmpresa(Empresa updateEmpresa, long id) throws Exception;

    public String deleteEmpresa(long id);

}
