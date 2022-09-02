package com.proyecto_ciclo3.proyecto_ciclo3.service;

import com.proyecto_ciclo3.proyecto_ciclo3.model.Employee;
import com.proyecto_ciclo3.proyecto_ciclo3.model.Enterprise;
import com.proyecto_ciclo3.proyecto_ciclo3.model.Enum_RoleName;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmployeeList {

        private ArrayList<Employee> employees;

        public EmployeeList(){

            this.employees = new ArrayList<>();

            Enterprise enterprise1 = new Enterprise(1234567, "Makro", "3005005050", "Calle 4 # 45-34");
            Enterprise enterprise2 = new Enterprise(8585953, "Flamingo", "55555555", "Carrera 8 # 4-54");

            Employee employee1 = new Employee(123456, "Pepe Perez", "email@email.com", Enum_RoleName.ADMIN, enterprise1);
            Employee employee2 = new Employee(785845, "Margarot Ramirez", "email@microsoft.com", Enum_RoleName.OPERARIO, enterprise2);

            this.employees.add(employee1);
            this.employees.add(employee2);

        }

        public Employee getEmployees(long id) throws Exception {
            for (Employee employees: this.employees) {
                if (employees.getId() == id){
                    return employees;
                }
            }
            throw new Exception("Employee not found");
        }

}
