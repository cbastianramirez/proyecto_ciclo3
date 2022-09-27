package com.proyecto_ciclo3.proyecto_ciclo3.service;

import com.proyecto_ciclo3.proyecto_ciclo3.Repository.EmployeeRepository;
import com.proyecto_ciclo3.proyecto_ciclo3.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repository;

    public List<Employee> getEmployees() {
        return repository.findAllByOrderByEmployeeIdAsc();

    }

    public Employee getEmployeesEmail(String email) {
        return repository.findAllByEmail(email);

    }

    public Employee getEmployeeById(Long id){
        return repository.findByEmployeeId(id);
    }

    public String createEmployee(Employee employee) throws Exception {
        repository.save(employee);
        return "Employee succesfully created.";
    }

    public Employee updateEmployeeById(Employee update_Employee, long id) throws Exception {
        Employee employee_db = getEmployeeById(id);

        if(update_Employee.getName() != null && !update_Employee.getName().equals("")){
            employee_db.setName(update_Employee.getName());
        }

        if(update_Employee.getEmail() != null && !update_Employee.getEmail().equals("")){
            employee_db.setEmail(update_Employee.getEmail());
        }

        return repository.save(employee_db);
    }

    public String deleteEmployeeById(Long id){
        repository.deleteById(id);
        return "Employee succesfully deleted";
    }

    public List<Employee> getEmployeesByEnterprise(Long enterpriseId){
        return repository.findByEnterpriseEnterpriseId(enterpriseId);
    }
}
