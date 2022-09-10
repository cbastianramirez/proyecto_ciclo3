package com.proyecto_ciclo3.proyecto_ciclo3.service;

import com.proyecto_ciclo3.proyecto_ciclo3.model.Enterprise;
import net.bytebuddy.asm.Advice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnterpriseList {


    private ArrayList<Enterprise> enterprises;

    public EnterpriseList(){

        this.enterprises = new ArrayList<>();

        Enterprise enterprise1 = new Enterprise(1234567, "Makro", "3005005050", "Calle 4 # 45-34");
        Enterprise enterprise2 = new Enterprise(8585953, "Flamingo", "55555555", "Carrera 8 # 4-54");

        this.enterprises.add(enterprise1);
        this.enterprises.add(enterprise2);

    }


    //GET ALL ENTERPRISES
    public ArrayList<Enterprise> getAllEnterprises(){
        return enterprises;
    }

    //GET ENTERPRISE BY ID
    public Enterprise getEnterprise(long id) throws Exception {
        for (Enterprise enterprises: this.enterprises) {
            if (enterprises.getId() == id){
                return enterprises;
            }
        }
        throw new Exception("Enterprise not found");
    }

    //CREATE NEW ENTERPRISE
    public String setEnterprise(Enterprise enterprise) throws Exception {
        try {
            getEnterprise(enterprise.getId());
        } catch (Exception e){
            this.enterprises.add(enterprise);
            return"Enterprise was succesfully created";
        }
        throw new Exception("Enterprise already exists");
    }

    //UPDATE ENTERPRISE
     public Enterprise updateEnterprise(Enterprise update_Enterprise, long id) throws Exception {
         try {

             Enterprise db_enterprise = getEnterprise(id);

             if (update_Enterprise.getName() != null && !update_Enterprise.getName().equals("")) {
                 db_enterprise.setName(update_Enterprise.getName());
             }
             if (update_Enterprise.getPhone() != null && !update_Enterprise.getPhone().equals("")){
                 db_enterprise.setPhone(update_Enterprise.getPhone());
             }
             if (update_Enterprise.getAddress() != null && !update_Enterprise.getAddress().equals("")){
                 db_enterprise.setAddress(update_Enterprise.getAddress());
             }

             return db_enterprise;

         } catch (Exception e) {
             throw new Exception("Enterprise not found");
         }
     }

    //DELETE ENTERPRISE BY ID
    public String deleteEnterprise(long id) throws Exception {
        try {
            Enterprise enterprise = getEnterprise(id);

            this.enterprises.remove(enterprise);

            return "Successfully deleted";
        } catch (Exception e) {
            throw new Exception("Enterprise not found to delete");
        }

    }
}