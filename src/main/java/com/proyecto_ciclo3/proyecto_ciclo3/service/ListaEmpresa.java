package com.proyecto_ciclo3.proyecto_ciclo3.service;

import com.proyecto_ciclo3.proyecto_ciclo3.modelos.Empresa;
import com.proyecto_ciclo3.proyecto_ciclo3.repo.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ListaEmpresa implements EmpresaInterface{

    @Autowired
    private EmpresaRepository empresaRepository;

    //Todas las empresas
   @Override
   public List<Empresa> getAllEmpresas(){
       return empresaRepository.findAll();
   }

    //Empresa por id
    @Override
    public Empresa getEmpresa(long id) throws Exception {
        Optional<Empresa> bdEmpresa = empresaRepository.findById(id);
        if (bdEmpresa.isPresent()){
            return  bdEmpresa.get();
        }
        throw new Exception("La empresa no fue encontrada");
    }

    //Creación empresa
    @Override
    public String setEmpresa(Empresa empresaPost){
       empresaRepository.save(empresaPost);
       return "creacion de la empresa exitosa";
   }

    // patch actualización atributos de forma específica
    @Override
    public Empresa updateEmpresa(Empresa updateEmpresa, long id) throws Exception {
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
            return empresaRepository.save(bdEmpresa);
    }

    // put
    @Transactional
    @Override
    public Empresa updateAllEmpresa(Empresa updateAllEmpresa, long id) throws Exception{
        empresaRepository.update(id, updateAllEmpresa.getNombre(),
                updateAllEmpresa.getDocumento(), updateAllEmpresa.getTelefono(),
                updateAllEmpresa.getDireccion(), updateAllEmpresa.getUpdatedAt());// tendría q ponerse usuarios?
        return getEmpresa(id);
    }

    //Delete| eliminación por id
    public String deleteEmpresa(long id){
       empresaRepository.deleteById(id);
       return "Empresa fue eliminada con éxito";
    }

}
