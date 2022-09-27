package com.proyecto_ciclo3.proyecto_ciclo3.controller;


import com.proyecto_ciclo3.proyecto_ciclo3.model.Employee;
import com.proyecto_ciclo3.proyecto_ciclo3.service.EmployeeService;
import com.proyecto_ciclo3.proyecto_ciclo3.service.EnterpriseService;
import com.proyecto_ciclo3.proyecto_ciclo3.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EnterpriseService enterpriseService;
    @Autowired
    private TransactionService transactionService;

    //LISTS ALL EMPLOYEES IN DB
    @GetMapping("/web_employees")
    public String web_employees(Model model) {
        model.addAttribute("employees", employeeService.getEmployees());
        model.addAttribute("enterprises", enterpriseService.getEnterprises());
        model.addAttribute("transactions", transactionService.getTransactions());
        return "employees";
    }

    //DELETE EMPLOYEE FROM LIST
    @DeleteMapping("/employee/delete/{id}")
    public String deleteEmployee(@PathVariable Long id, Model model){
        employeeService.deleteEmployeeById(id);
        return "redirect:/web_employees";
    }

    //UPDATE SELECTED EMPLOYEE FROM LIST
    @PutMapping("/employee/update")
    public String putEmployee(@ModelAttribute("employeeUpdate") Employee employee){
        try {
            employeeService.updateEmployeeById(employee, employee.getEmployeeId());
            return "redirect:/web_employees";
        } catch (Exception e) {
            return  "redirect:/error";
        }
    }
    //CREATE EMPLOYEE
    @PostMapping("/employee/create")
    public String createEmpoyee(@ModelAttribute("employeeCreate") Employee employee){
        try {
            String message = employeeService.createEmployee(employee);
            return "redirect:/web_employees";
        } catch (Exception e){
            e.printStackTrace();
            new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return "redirect:/error";
    }


}