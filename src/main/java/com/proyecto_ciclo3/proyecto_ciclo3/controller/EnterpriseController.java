package com.proyecto_ciclo3.proyecto_ciclo3.controller;

import com.proyecto_ciclo3.proyecto_ciclo3.model.Enterprise;
import com.proyecto_ciclo3.proyecto_ciclo3.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;

    //LIST ALL ENTERPRISES IN DB
    @GetMapping("/web_enterprises")
    public String web_enterprises(Model model) {
        model.addAttribute("enterprises", enterpriseService.getEnterprises());
        return "enterprises";
    }

    //DELETE ENTERPRISE FROM LIST
    @DeleteMapping("/enterprise/delete/{id}")
    public String deleteEnterprise(@PathVariable Long id, Model model){
        enterpriseService.deleteEnterpriseById(id);
        return "redirect:/web_enterprises";
    }

    //UPDATE SELECTED ENTERPRISE FROM LIST
    @PutMapping("/enterprise/update")
    public String putEnterprise(@ModelAttribute("enterpriseUpdate") Enterprise enterprise){
        try {
            enterpriseService.updateEnterpriseById(enterprise, enterprise.getEnterpriseId());
            return "redirect:/web_enterprises";
        } catch (Exception e) {
            return  "redirect:/error";
        }
    }

    //CREATE ENTERPRISE
    @PostMapping("/enterprise/create")
    public String createEnterprise(@ModelAttribute("enterpriseCreate") Enterprise enterprise){
        try {
            String message = enterpriseService.createEnterprise(enterprise);
            return "redirect:/web_enterprises";
        } catch (Exception e){
            e.printStackTrace();
            new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return "redirect:/error";
    }

}
