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

        //GET ALL EMPLOYESS
        public ArrayList<Employee> getAllEmployees(){
            return employees;
        }

        //GET EMPLOYEE BY ID
        public Employee getEmployee(long id) throws Exception {
            for (Employee find_employee: employees) {
                if (find_employee.getId() == id){
                    return find_employee;
                }
            }
            throw new Exception("Employee not found");
        }

        //CREATE NEW EMPLOYEE
        public String setEmployee(Employee employee) throws Exception {
            try {
                getEmployee(employee.getId());
            } catch (Exception e){
                employees.add(employee);
                return"Employee was succesfully created";
            }
            throw new Exception("Employee already exists");
    }

        //UPDATE EMPLOYEE
        public Employee updateEmployee(Employee update_Employee, long id) throws Exception {
        try {

            Employee db_employee = getEmployee(id);

            if (update_Employee.getName() != null && !update_Employee.getName().equals("")) {
                db_employee.setName(update_Employee.getName());
            }
            if (update_Employee.getEmail() != null && !update_Employee.getEmail().equals("")){
                db_employee.setEmail(update_Employee.getEmail());
            }
            if (update_Employee.getRole() != null){
                db_employee.setRole(update_Employee.getRole());
            }
            if (update_Employee.getEnterprise() != null){
                db_employee.setEnterprise(update_Employee.getEnterprise());
            }

            return db_employee;

        } catch (Exception e) {
            throw new Exception("Employee not found");
        }
    }

        //DELETE EMPLOYEE BY ID
        public String deleteEmployee(long id) throws Exception {
        try {
            Employee employee = getEmployee(id);

            this.employees.remove(employee);

            return "Successfully deleted";
        } catch (Exception e) {
            throw new Exception("Employee not found to delete");
        }

    }

}
