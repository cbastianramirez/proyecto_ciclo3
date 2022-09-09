/*
package com.proyecto_ciclo3.proyecto_ciclo3.controlador;

import com.proyecto_ciclo3.proyecto_ciclo3.modelos.Empleado;
import com.proyecto_ciclo3.proyecto_ciclo3.modelos.Empresa;
import com.proyecto_ciclo3.proyecto_ciclo3.modelos.Enum_RoleName;
import com.proyecto_ciclo3.proyecto_ciclo3.modelos.MovimientoDinero;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class ControllerEmp {

    // Es posible leer y modificar el nombre de la empresa
    @GetMapping("/sprint2nombre")
    public String sprint2nombre(){
        Empresa empresa = new Empresa("Dafiti","830049737432","32138834843","calle 26 av el dorado", new LocalDateTime(), new LocalDateTime());
        empresa.setNombre("Soluciones empresariales SAS");
        return empresa.getNombre();
        //return empresa.toString()  para q pueda verse el array con cambios
    }

    // Es posible leer y modificar la dirección de la empresa
    @GetMapping("/sprint2direccion")
    public String sprint2direccion(){
        Empresa empresa = new Empresa("Dafiti","830049737432","32138834843","calle 26 av el dorado");
        empresa.setDireccion("Av el dorado calle 26 diagonal Avenida 68");
        return empresa.getDireccion();
    }

    //leer y modificar el teléfono de la empresa
    @GetMapping("/sprint2telefono")
    public String sprint2telefono(){
        Empresa empresa = new Empresa("Dafiti","830049737432","32138834843","calle 26 av el dorado");
        empresa.setTelefono("3112755992");
        return empresa.getTelefono();
    }

    //posible leer y modificar el NIT de la empresa
    @GetMapping("/sprint2documento")
    public String sprint2documento(){
        Empresa empresa = new Empresa("Dafiti","830049737432","32138834843","calle 26 av el dorado");
        empresa.setNIT("8304321674");
        return empresa.getNIT();
    }

    //leer y modificar el nombre de un empleado
    @GetMapping("/sprint2empNombre")
    public String sprint2empNombre(){
        Empleado empleado = new Empleado("Karen","ksalf@gmail.com",Enum_RoleName.Admin,"Sol");
        empleado.setNombre("Andrea");
        return empleado.getNombre();
    }

    //leer y modificar el correo de un empleado
    @GetMapping("/sprint2empCorreo")
    public String sprint2empCorreo(){
        Empleado empleado = new Empleado("Karen","ksalf@gmail.com",Enum_RoleName.Admin,"Sol");
        empleado.setCorreo("sol@gmail.com");
        return empleado.getCorreo();
    }

    // leer y modificar la empresa a la que el empleado pertenece
    @GetMapping("/sprint2empEmpresa")
    public String sprint2empEmpresa(){
        Empleado empleado = new Empleado("Karen","ksalf@gmail.com",Enum_RoleName.Admin,"Sol");
        empleado.setEmpresa("Empresa");
        return empleado.getEmpresa();
    }

    // leer y modificar el rol del empleado (administrador, operativo)
    @GetMapping("/sprint2empEnum_role")
    public Enum_RoleName sprint2empRole(){
        Empleado empleado = new Empleado("Karen","ksalf@gmail.com",Enum_RoleName.Admin,"Sol");
        empleado.setEnum_roleName(Enum_RoleName.Operario);
        return empleado.getEnum_roleName();
    }

    // leer y modificar Monto empleado (administrador, operativo)
    @GetMapping("/sprint2cashMonto")
    public float sprint2cashMonto(){
        MovimientoDinero movimientoDinero = new MovimientoDinero("bueno",80000055,"Cluente","Sol");
        movimientoDinero.setMonto(-90000);
        return movimientoDinero.getMonto();
    }

    // leer y modificar el concepto del empleado (administrador, operativo)
    @GetMapping("/sprint2cashConcepto")
    public String sprint2cashConcepto(){
        MovimientoDinero movimientoDinero = new MovimientoDinero("bueno",80000055,"Cluente","Sol");
        movimientoDinero.setConcepto("Mlo");
        return movimientoDinero.getConcepto();
    }

    // posible definir qué usuario fue encargado de registrar el movimiento
    @GetMapping("/sprint2cashUsuario")
    public String sprint2cashUsuario(){
        MovimientoDinero movimientoDinero = new MovimientoDinero("bueno",80000055,"Cluente","Sol");
        movimientoDinero.setUsuario("Ana");
        return movimientoDinero.getUsuario();
    }












}
*/