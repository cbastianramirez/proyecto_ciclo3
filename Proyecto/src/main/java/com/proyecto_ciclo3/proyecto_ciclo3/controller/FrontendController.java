package com.proyecto_ciclo3.proyecto_ciclo3.controller;


import com.proyecto_ciclo3.proyecto_ciclo3.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontendController {


    @GetMapping("/")
    public String getIndex() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String getLogin(Model model){
        model.addAttribute("formUser", new Employee());
        return "login";

    }
}
