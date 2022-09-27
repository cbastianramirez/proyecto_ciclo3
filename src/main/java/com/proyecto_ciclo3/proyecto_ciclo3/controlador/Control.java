package com.proyecto_ciclo3.proyecto_ciclo3.controlador;

import com.proyecto_ciclo3.proyecto_ciclo3.modelos.Empleado;
import com.proyecto_ciclo3.proyecto_ciclo3.modelos.Empresa;
import com.proyecto_ciclo3.proyecto_ciclo3.modelos.Enum_RoleName;
import com.proyecto_ciclo3.proyecto_ciclo3.modelos.MovimientoDinero;
import com.proyecto_ciclo3.proyecto_ciclo3.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class Control {

    @Autowired
    private EmpleadoInterface empleadoService;

    //@Autowired //EmpleadoService empleadoService;

    @Autowired
    private EmpresaInterface empresaService;

    @Autowired
    private MovimientoDineroService movimientoDineroService;

    @Autowired MovimientoDineroInterface movimientoDineroInterface;


    @GetMapping("/")
    public String getIndex(){
        return "index";
    }


    @GetMapping("/login")
    public String getLogin(Model model){
        model.addAttribute("formUsuario",new Empleado());
        System.out.println(model.getAttribute("formUsuario"));
        return "login";
    }


    @GetMapping("/welcomes")
    public  String getWelcome(Model model){
        model.addAttribute("empleados",empleadoService.getAllEmpleados());
        //model.addAttribute("empresas",empleadoInterface.getAllEmpresas());
        model.addAttribute("movimientos",movimientoDineroService.getAllMovimientos());
        System.out.println(model.getAttribute("empleados"));
        return "welcome";
    }

    // EMPLEADOS
    @GetMapping("/addEmpleado")
    public String getAddEmpleado(Model model){
        model.addAttribute("empleado", new Empleado());
        model.addAttribute("Enum_RoleName", Enum_RoleName.values());
        System.out.println(model.getAttribute("Enum_RoleName"));
        return "add-empleado";
    }

    @GetMapping("/updateEmpleado")
    public String getUpdateEmpleado(Model model){
        System.out.println(model.getAttribute("empleadoUpdate"));
        return "update-empleado";
    }

    @GetMapping("/empleado/front/{id}")
    public String getEmpleado(@PathVariable Long id, Model model) {
        try {
            System.out.println(id);
            System.out.println(empleadoService.getEmpleado(id));
            model.addAttribute("empleadoUpdate",empleadoService.getEmpleado(id));
            model.addAttribute("Enum_RoleName",Enum_RoleName.values());
            return "update-empleado";
        } catch (Exception e) {
            return " redirect:/error";
        }
    }

    @PostMapping("/empleado/front")
    public String postEmpleado(
            @ModelAttribute("empleado") Empleado empleado_parametro){
        try {
            System.out.println(empleado_parametro);
            String mensaje = empleadoService.setEmpleado(empleado_parametro);
            return "redirect:/welcome";
        }catch (Exception e){
        }
        return "redirect:/error";
    }

    @DeleteMapping("/empleado/front/{id}")
    public String deleteEmpleado(@PathVariable Long id, Model model) {
        try {
            empleadoService.deleteEmpleado(id);
            return "redirect:/welcome";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }


    @PutMapping("empleado/front/update")
    public String putEmpleado(@ModelAttribute("empleadoUpdate") Empleado empleado){
        try {
            System.out.println(empleado);
            empleadoService.updateEmpleado(empleado,empleado.getId());
            return "redirect:/welcome";
        } catch (Exception e) {
            return "redirect:/error";

        }
    }



    ////////////////EMPRESAS
    @GetMapping("/addEmpresa")
    public String getAddEmpresa(Model model){
        model.addAttribute("empresa", new Empresa());

        return "add-empresa";
    }

    @GetMapping("/updateEmpresa") // muestra la actualización dada, dos getmapping estan juntos este y el de getUsuaruario
    public String getUpdateEmpresa(Model model){ //
        System.out.println(model.getAttribute("empresaUpdate"));
        return "update-empresa";
    }

    @GetMapping("/empresa/front/{id}")
    public String getEmpresa(@PathVariable Long id, Model model) {
        try {
            System.out.println(id);
            System.out.println(empresaService.getEmpresa(id));
            model.addAttribute("empresaUpdate",empresaService.getEmpresa(id));
            return "update-empresa";
        } catch (Exception e) {
            return " redirect:/error";
        }
    }

    @PostMapping("/empresa/front")
    public String postEmpresa(
            @ModelAttribute("empresa") Empresa empresa_parametro){ // con este Modelattribute cambia la forma de responder (return) y en el public va a cambiar a STring 2. se va welcome
        try {
            System.out.println(empresa_parametro);
            String mensaje = empresaService.setEmpresa(empresa_parametro);
            return "redirect:/welcome";
        }catch (Exception e){
        }
        return "redirect:/error";
    }

    @DeleteMapping("/empresa/front/{id}")
    public String deleteEmpresa(@PathVariable Long id, Model model) {
        try {
            empresaService.deleteEmpresa(id); //3.
            return "redirect:/welcome";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }


    @PutMapping("empresa/front/update")
    public String putEmpresa(@ModelAttribute("empresaUpdate") Empresa empresa){
        try {
            System.out.println(empresa);
            empresaService.updateEmpresa(empresa,empresa.getId());
            return "redirect:/welcome";
        } catch (Exception e) {
            return "redirect:/error";

        }
    }





    /////////////// Movimientos
    @GetMapping("/addMovimiento")
    public String getAddMovimiento(Model model){
        model.addAttribute("movimiento", new MovimientoDinero());
        return "add-movimiento";
    }

    @GetMapping("/updateMovimiento") // muestra la actualización dada, dos getmapping estan juntos este y el de getUsuaruario
    public String getUpdateMovimiento(Model model){ //
        System.out.println(model.getAttribute("movimientoUpdate"));
        return "update-movimiento";
    }

    @GetMapping("/movimiento/front/{id}")
    public String getMovimiento(@PathVariable Long id, Model model) {
        try {
            System.out.println(id);
            model.addAttribute("movimientoUpdate",movimientoDineroInterface.getMovimiento(id));
            return "update-movimiento";
        } catch (Exception e) {
            return " redirect:/error";
        }
    }

    @PostMapping("/movimiento/front")
    public String postMovimiento(
            @ModelAttribute("movimiento") MovimientoDinero movimiento_parametro){
        try {
            System.out.println(movimientoDineroService);
            String mensaje = movimientoDineroInterface.setMovimiento(movimiento_parametro);
            return "redirect:/welcome";
        }catch (Exception e){
        }
        return "redirect:/error";
    }

    @DeleteMapping("/movimiento/front/{id}")
    public String deleteMovimiento(@PathVariable Long id, Model model) {
        try {
            movimientoDineroService.deleteMovimientoDinero(id); //3.
            return "redirect:/welcome";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }

    @PutMapping("movimiento/front/update")
    public String putMovimiento(@ModelAttribute("movimientoUpdate") MovimientoDinero movimientoDinero){
        try {
            System.out.println(movimientoDinero);
            movimientoDineroInterface.updateMovimiento(movimientoDinero,movimientoDinero.getId());
            return "redirect:/welcome";
        } catch (Exception e) {
            return "redirect:/error";

        }
    }



    //filtro d movimientos por empleados
    @GetMapping("/Empleado/{id}/Movimientos")
    public String movimientosEmpleado(@PathVariable("id") Long id, Model model) throws Exception {
        List<MovimientoDinero> movempl = (List<MovimientoDinero>) movimientoDineroInterface.getMovimiento(id);
        model.addAttribute("movempl",movempl);

        Long totalMonto = movimientoDineroService.MontosEmpleado(id);
        model.addAttribute("TotalMontos", totalMonto);

        return "movimientos";
    }


    //Filtro d movimientos por empresa
    @GetMapping("/Empresa/{id}/Movimientos")
    public String movimientosEmpresa(@PathVariable("id")Long id, Model model){
        List<MovimientoDinero> movempr = movimientoDineroService.movimientoEmpleado(id);
        model.addAttribute("movempr", movempr);

        Long totalMonto = movimientoDineroService.MontosEmpresa(id);
        model.addAttribute("TotalMontos", totalMonto);

        return "movimientos";
    }

}
