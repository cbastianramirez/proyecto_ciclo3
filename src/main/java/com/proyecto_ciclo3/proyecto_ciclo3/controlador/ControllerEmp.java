package com.proyecto_ciclo3.proyecto_ciclo3.controlador;

import com.proyecto_ciclo3.proyecto_ciclo3.modelos.Empleado;
import com.proyecto_ciclo3.proyecto_ciclo3.modelos.Empresa;
import com.proyecto_ciclo3.proyecto_ciclo3.modelos.Enum_RoleName;
import com.proyecto_ciclo3.proyecto_ciclo3.modelos.MovimientoDinero;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.lang.String;


@RestController
public class ControllerEmp {

    // Es posible leer y modificar el nombre de la empresa
    @GetMapping("/sprint2nombre")
    public String sprint2nombre(){
        Empresa empresa = new Empresa("Dafiti","830567409","312132123","calle 3 casa 3-27", -3400 ,2015/11/29,2022/12/27);
        empresa.setNombre("Soluciones empresariales SAS");
        return empresa.getNombre();
    }

    // Es posible leer y modificar la dirección de la empresa
    @GetMapping("/sprint2direccion")
    public String sprint2direccion(){
        Empresa empresa = new Empresa("Dafiti","830567409","312132123","calle 3 casa 3-27", 3.400,2015/11/29,2022/12/27);
        empresa.setDireccion("Av el dorado calle 26 diagonal Avenida 68");
        return empresa.getDireccion();
    }

    //leer y modificar el teléfono de la empresa
    @GetMapping("/sprint2telefono")
    public String sprint2telefono(){
        Empresa empresa = new Empresa("Dafiti","830567409","312132123","calle 3 casa 3-27", 3400,2015/11/29,2022/12/27);
        empresa.setTelefono("3112755992");
        return empresa.getTelefono();
    }

    //posible leer y modificar el NIT de la empresa
    @GetMapping("/sprint2documento")
    public String sprint2documento(){
        Empresa empresa = new Empresa("Dafiti","830567409","312132123","calle 3 casa 3-27", 3.400,2015/11/29,2022/12/27);
        empresa.setNIT("8304321674");
        return empresa.getNIT();
    }

    //leer y modificar el nombre de un empleado
    @GetMapping("/sprint2empNombre")
    public String sprint2empNombre(){
        Empleado empleado = new Empleado("Karen Alfaro","ksalfarom@gmail.com","est", Enum_RoleName.Operario, "Sol sas", -4500, 2022/01/11, 2010/11/15);
        empleado.setNombre("8304321674");
        return empleado.getNombre();
    }

    //leer y modificar el correo de un empleado
    @GetMapping("/sprint2empCorreo")
    public String sprint2empCorreo(){
        Empleado empleado = new Empleado("Karen Alfaro","ksalfarom@gmail.com","est", Enum_RoleName.Operario, "Sol sas", -4500, 2022/01/11, 2010/11/15);
        empleado.setCorreo("sol@gmail.com");
        return empleado.getCorreo();
    }

    //leer y modificar el correo de un empleado
    @GetMapping("/sprint2empCorreo")
    public String sprint2empCorreo(){
        Empleado empleado = new Empleado("Karen Alfaro","ksalfarom@gmail.com","est", Enum_RoleName.Operario, "Sol sas", -4500, 2022/01/11, 2010/11/15);
        empleado.setCorreo("sol@gmail.com");
        return empleado.getCorreo();
    }

    // leer y modificar la empresa a la que el empleado pertenece
    @GetMapping("/sprint2empEmpresa")
    public String sprint2empEmpresa(){
        Empleado empleado = new Empleado("Karen Alfaro","ksalfarom@gmail.com","est", Enum_RoleName.Operario, "Sol sas", -4500, 2022/01/11, 2010/11/15);
        empleado.setEmpresa("Empresa");
        return empleado.getEmpresa();
    }

    // leer y modificar el rol del empleado (administrador, operativo)
    @GetMapping("/sprint2empEnum_role")
    public String sprint2empRole(){
        Empleado empleado = new Empleado("Karen Alfaro","ksalfarom@gmail.com","est", Enum_RoleName.Operario, "Sol sas", -4500, 2022/01/11, 2010/11/15);
        empleado.setEnum_roleName(Enum_RoleName.Admin);
        return empleado.getEnum_roleName();
    }

    // leer y modificar el rol del empleado (administrador, operativo)
    @GetMapping("/sprint2cashMonto")
    public String sprint2cashMonto(){
        MovimientoDinero movimientoDinero = new movimientoDinero("bueno",4000600,"Contorles online", 2009/12/10, 2022/10/31);
        movimientoDinero.setMonto(-80000);
        return movimientoDinero.getMonto();
    }

    // leer y modificar el rol del empleado (administrador, operativo)
    @GetMapping("/sprint2cashConcepto")
    public String sprint2cashConcepto(){
        MovimientoDinero movimientoDinero = new movimientoDinero("bueno",4000600,"Contorles online", 2009/12/10, 2022/10/31);
        movimientoDinero.setConcepto("Mlo");
        return movimientoDinero.getConcepto();
    }

    // posible definir qué usuario fue encargado de registrar el movimiento
    @GetMapping("/sprint2cashUsuario")
    public String sprint2cashUsuario(){
        MovimientoDinero movimientoDinero = new movimientoDinero("bueno",4000600,"Contorles online", 2009/12/10, 2022/10/31);
        movimientoDinero.setUsuario("Ana");
        return movimientoDinero.getUsuario();
    }











}
