package com.proyecto_ciclo3.proyecto_ciclo3.controlador;

import com.proyecto_ciclo3.proyecto_ciclo3.modelos.Empleado;
import com.proyecto_ciclo3.proyecto_ciclo3.modelos.Empresa;
import com.proyecto_ciclo3.proyecto_ciclo3.modelos.MovimientoDinero;
import com.proyecto_ciclo3.proyecto_ciclo3.service.EmpleadoService;
import com.proyecto_ciclo3.proyecto_ciclo3.service.EmpresaService;
import com.proyecto_ciclo3.proyecto_ciclo3.service.MovimientoDineroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class Control {

    @Autowired
    EmpresaService empresaService;

    @Autowired
    EmpleadoService empleadoService;

    @Autowired
    MovimientoDineroService movimientoDineroService;


    //Empresas
    @GetMapping({"/Empresas", "/VerEmpresas"})

    public String viewEmpresas(Model model, @ModelAttribute("mensaje") String mensaje) {
        List<Empresa> listaEmpresas = empresaService.getAllEmpresas();
        model.addAttribute("emplist", listaEmpresas);
        model.addAttribute("mensaje", mensaje);
        return "verEmpresas";

    }

    @GetMapping("/AgregarEmpresa")
    public String nuevaEmpresa(Model model, @ModelAttribute("mensaje") String mensaje) {

        Empresa emp = new Empresa();
        model.addAttribute("emp", emp);
        model.addAttribute("mensaje", mensaje);
        return "agregarEmpresa";

    }

    // guardar empresa
    @PostMapping("/GuardarEmpresa")
    public String guardarEmpresa(Empresa emp, RedirectAttributes redirectAttributes) {
        if (empresaService.saveOrUpdateEmpresa(emp)) {

            redirectAttributes.addFlashAttribute("mensaje", "guargado,ok");

            return "redirect:/VerEmpresas";
        }
        redirectAttributes.addFlashAttribute("mensaje", "saveError");
        return "redirect:/AgregarEmpresa";
    }

    //editar empresa
    @GetMapping("/EditarEmpresa/{id}") // faltaba colocarle {id}
    public String editarEmpresa(Model model, @PathVariable Long id, @ModelAttribute("mensaje") String mensaje) {
        Empresa emp = empresaService.getEmpresaById(id);
        model.addAttribute("emp", emp);
        model.addAttribute("mensaje", mensaje);

        return "editarEmpresa";
    }


    @PostMapping("/ActualizarEmpresa")
    public String updateEmpresa(@ModelAttribute("emp") Empresa emp, RedirectAttributes redirectAttributes) {
        if (empresaService.saveOrUpdateEmpresa(emp)) {

            redirectAttributes.addFlashAttribute("mensaje", "update,ok");

            return "redirect:/VerEmpresas";
        }
        redirectAttributes.addFlashAttribute("mensaje", "updateError");

        return "redirect:/EditarEmpresa/" + emp.getId();
    }

    // delete eliminar

    @GetMapping("/EliminarEmpresa/{id}")
    public String eliminarEmpresa(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        if (empresaService.deleteEmpresa(id)) {
            redirectAttributes.addFlashAttribute("mensaje", "deleteOK");
            return "redirect:/VerEmpresas";
        }
        redirectAttributes.addFlashAttribute("mensaje", "deleteError");
        return "redirect:/VerEmpresas";
    }


    // EMPLEADO

    @GetMapping("/VerEmpleados")
    public String viewEmpleado(Model model, @ModelAttribute("mensaje") String mensaje) {
        List<Empleado> listaEmpleados = empleadoService.getAllEmpleado();
        model.addAttribute("emplist", listaEmpleados);
        model.addAttribute("mensaje", mensaje);
        return "verEmpleados";
    }


    @GetMapping("/AgregarEmpleado")
    public String nuevaEmpleado(Model model, @ModelAttribute("mensaje") String mensaje) {

        Empresa empl = new Empresa();
        model.addAttribute("empl", empl);
        model.addAttribute("mensaje", mensaje);
        List<Empresa> listaEmpresas = empresaService.getAllEmpresas();
        model.addAttribute("emprelist", listaEmpresas);
        return "agregarEmpleado";
    }

    // guardar empleado
    @PostMapping("/GuardarEmpleado")
    public String guardarEmpleado(Empleado empl, RedirectAttributes redirectAttributes) { 
        if (empleadoService.saveOrUpdateEmpleado(empl)) {

            redirectAttributes.addFlashAttribute("mensaje", "guargado,ok");



            return "redirect:/VerEmpleados";
        }
        redirectAttributes.addFlashAttribute("mensaje", "saveError");
        return "redirect:/AgregarEmpleado";
    }

    //editar empleado
    @GetMapping("/EditarEmpleado/{id}")
    public String editarEmpleado(Model model, @PathVariable Long id, @ModelAttribute("mensaje") String mensaje) {
        Empleado empl = empleadoService.getEmpleadoById(id).get();
        model.addAttribute("empl", empl);
        model.addAttribute("mensaje", mensaje);
        List<Empresa> listaEmpresas = empresaService.getAllEmpresas();
        model.addAttribute("emprelist", listaEmpresas);
        return "editarEmpleado";
    }

    // actualizar empleado
    @PostMapping("/ActualizarEmpleado")
    public String updateEmpleado(@ModelAttribute("empl") Empleado empl, RedirectAttributes redirectAttributes) {
        if (empleadoService.saveOrUpdateEmpleado(empl)) {

            redirectAttributes.addFlashAttribute("mensaje", "update,ok");

            return "redirect:/VerEmpleados";
        }
        redirectAttributes.addFlashAttribute("mensaje", "updateError");

        return "redirect:/EditarEmpleado/" + empl.getId();
    }

    // delete eliminar
    @GetMapping("/EliminarEmpleado/{id}")
    public String eliminarEmpleado(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        if (empleadoService.deleteEmpleado(id)) {
            redirectAttributes.addFlashAttribute("mensaje", "deleteOK");
            return "redirect:/VerEmpleados";
        }
        redirectAttributes.addFlashAttribute("mensaje", "deleteError");
        return "redirect:/VerEmpleados";
    }

    @GetMapping("/Empresa/{id}/Empleados") // filtrar los empleados ´r empresa
    public String verEmpleadosPorEmpresa(@PathVariable("id") Long id, Model model) {
        List<Empleado> listaEmpleados = empleadoService.obtenerPorEmpresa(id);
        model.addAttribute("emplelist", listaEmpleados);
        return "verEmpleados";
        //Llamamos al html con el emplelist de los empleados filtrados
    }




    //movimientos
    @GetMapping("/VerMovimientos")
    public String viewMovimientos(Model model, @ModelAttribute("mensaje") String mensaje) {
        List<MovimientoDinero> listaMovimientos = movimientoDineroService.getAllMovimientos();
        model.addAttribute("movlist", listaMovimientos);
        model.addAttribute("mensaje", mensaje);

        Long sumaMonto = movimientoDineroService.obtenerSumaMontos();
        model.addAttribute("SumaMontos", sumaMonto);
        return "verMovimientos";
    }


    @GetMapping("/AgregarMovimiento")
    public String nuevaMovimiento(Model model, @ModelAttribute("mensaje") String mensaje) {
        MovimientoDinero movimiento = new MovimientoDinero();
        model.addAttribute("mov", movimiento);
        model.addAttribute("mensaje", mensaje);
        List<Empleado> listaEmpleados = empleadoService.getAllEmpleado();
        model.addAttribute("emplelist", listaEmpleados);
        return "agregarMovimiento";
    }

    // guardar empleado
    @PostMapping("/GuardarMovimiento")
    public String guardarMovimiento(MovimientoDinero mov, RedirectAttributes redirectAttributes) {
        if (movimientoDineroService.saveOrUpdateMovimiento(mov)) {

            redirectAttributes.addFlashAttribute("mensaje", "guargado,ok");

            return "redirect:/VerMovimientos";
        }
        redirectAttributes.addFlashAttribute("mensaje", "saveError");
        return "redirect:/AgregarMovimiento";
    }

    //editar empleado
    @GetMapping("/EditarMovimiento/{id}") // faltaba colocarle {id}
    public String editarMovimiento(Model model, @PathVariable Long id, @ModelAttribute("mensaje") String mensaje) {
        MovimientoDinero mov = movimientoDineroService.getMovimientoById(id);
        model.addAttribute("mov", mov);
        model.addAttribute("mensaje", mensaje);
        List<Empleado> listaEmpleados = empleadoService.getAllEmpleado(); // se requiere por la relación q tienen
        model.addAttribute("emplelist", listaEmpleados);
        return "editarMovimiento";
    }

    // actualizar empleado
    @PostMapping("/ActualizarMovimiento")
    public String updateMovimiento(@ModelAttribute("mov") MovimientoDinero mov, RedirectAttributes redirectAttributes) {
        if (movimientoDineroService.saveOrUpdateMovimiento(mov)) {

            redirectAttributes.addFlashAttribute("mensaje", "update,ok");

            return "redirect:/VerMovimientos";
        }
        redirectAttributes.addFlashAttribute("mensaje", "updateError");

        return "redirect:/EditarMovimiento/" + mov.getId();
    }

    // delete eliminar
    @GetMapping("/EliminarMovimiento/{id}")
    public String eliminarMovimiento(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        if (movimientoDineroService.deleteMovimiento(id)) {
            redirectAttributes.addFlashAttribute("mensaje", "deleteOK");
            return "redirect:/VerMovimientos";
        }
        redirectAttributes.addFlashAttribute("mensaje", "deleteError");
        return "redirect:/VerMovimientos";
    }


    //filtro d movimientos por empleados
    @GetMapping("/Empleado/{id}/Movimientos")
    public String movimientosPorEmpleado(@PathVariable("id") Long id, Model model){
        List<MovimientoDinero> movlist = movimientoDineroService.obtenerPorEmpleado(id);
        model.addAttribute("movlist", movlist);

        Long sumaMonto = movimientoDineroService.MontosPorEmpleado(id);
        model.addAttribute("SumaMontos", sumaMonto);

        return "verMovimientos";
    }


    //Filtro d movimientos por empresa
    @GetMapping("/Empresa/{id}/Movimientos")
    public String movimientosPorEmpresa(@PathVariable("id")Long id, Model model){
        List<MovimientoDinero> movlist = movimientoDineroService.obtenerPorEmpresa(id);
        model.addAttribute("movlist", movlist);

        Long sumaMonto = movimientoDineroService.MontosPorEmpresa(id);
        model.addAttribute("SumaMontos", sumaMonto);

        return "verMovimientos";
    }



}
