package com.proyecto_ciclo3.proyecto_ciclo3.service;

import com.proyecto_ciclo3.proyecto_ciclo3.Repository.EnterpriseRepository;
import com.proyecto_ciclo3.proyecto_ciclo3.model.Enterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EnterpriseService {

    @Autowired
    EnterpriseRepository repository;

    public List<Enterprise> getEnterprises() {
        return repository.findAllByOrderByEnterpriseIdAsc();
    }

    public Enterprise getEnterpriseById(Long id){
        return repository.findByEnterpriseId(id);
    }

    public String createEnterprise(Enterprise enterprise) throws Exception {
        repository.save(enterprise);
        return "Enterprise succesfully created.";
    }

    public Enterprise updateEnterpriseById(Enterprise update_Enterprise, Long id) throws Exception {
        Enterprise enterpise_db = getEnterpriseById(id);

        if(update_Enterprise.getName() != null && !update_Enterprise.getName().equals("")){
            enterpise_db.setName(update_Enterprise.getName());
        }

        if(update_Enterprise.getPhone() != null && !update_Enterprise.getPhone().equals("")){
            enterpise_db.setPhone(update_Enterprise.getPhone());
        }

        if(update_Enterprise.getAddress() != null && !update_Enterprise.getAddress().equals("")){
            enterpise_db.setAddress((update_Enterprise.getAddress()));
        }
        return repository.save(enterpise_db);
    }

    public String deleteEnterpriseById(Long id){
        repository.deleteById(id);
        return "Enterprise succesfully deleted";
    }
}
