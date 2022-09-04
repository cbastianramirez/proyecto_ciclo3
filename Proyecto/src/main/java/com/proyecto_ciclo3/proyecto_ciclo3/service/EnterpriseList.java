package com.proyecto_ciclo3.proyecto_ciclo3.service;

import com.proyecto_ciclo3.proyecto_ciclo3.model.Employee;
import com.proyecto_ciclo3.proyecto_ciclo3.model.Enterprise;
import com.proyecto_ciclo3.proyecto_ciclo3.model.Enum_RoleName;
import net.bytebuddy.asm.Advice;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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

    public ArrayList<Enterprise> getAllEnterprises(){
        return this.enterprises;
    }

    public Enterprise getEnterprise(long id) throws Exception {
        for (Enterprise enterprises: this.enterprises) {
            if (enterprises.getId() == id){
                return enterprises;
            }
        }
        throw new Exception("Enterprise not found");
    }

}
