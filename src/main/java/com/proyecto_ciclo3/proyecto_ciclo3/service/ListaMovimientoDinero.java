package com.proyecto_ciclo3.proyecto_ciclo3.service;

import com.proyecto_ciclo3.proyecto_ciclo3.modelos.MovimientoDinero;
import com.proyecto_ciclo3.proyecto_ciclo3.repo.MovimientoDineroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ListaMovimientoDinero implements MovimientoDineroInterface{

    @Autowired
    private MovimientoDineroRepository movimientoDineroRepository;

    //Todas los movimientos
    @Override
    public List<MovimientoDinero> getAllMovimientos(){

        return movimientoDineroRepository.findAll();
    }

    //Movimientos por id
    @Override
    public MovimientoDinero getMovimiento(long id) throws Exception {
        Optional<MovimientoDinero> bdMovimiento = movimientoDineroRepository.findById(id);
        if (bdMovimiento.isPresent()){
            return bdMovimiento.get();
        }
        throw new Exception("Movimiento de dinero no encontrado");
    }

    //Creación de movimientos
    @Override
    public String setMovimiento(MovimientoDinero movimientoPost){
        movimientoDineroRepository.save(movimientoPost);
        return "Movimiento dinero creado";
    }

    // patch actualización de forma específica
    @Override
    public MovimientoDinero updateMovimiento(MovimientoDinero updateMovimientos,long id) throws Exception {
            MovimientoDinero bdMovimiento = getMovimiento(id);

            if(updateMovimientos.getMonto() == 0 ){
                bdMovimiento.setMonto(updateMovimientos.getMonto());
            }
            if(updateMovimientos.getMonto() == updateMovimientos.getMonto()){
                bdMovimiento.setMonto(updateMovimientos.getMonto());
            }
            if(updateMovimientos.getUsuario() != null && !updateMovimientos.getUsuario().equals("")){
                bdMovimiento.setUsuario(updateMovimientos.getUsuario());
            }
            if(updateMovimientos.getConcepto() != null && !updateMovimientos.getConcepto().equals("")) {
                bdMovimiento.setConcepto(updateMovimientos.getConcepto());
            }
            if(updateMovimientos.getEmpresa() != null && !updateMovimientos.getEmpresa().equals("")) {
                bdMovimiento.setEmpresa(updateMovimientos.getEmpresa());
            }

            return movimientoDineroRepository.save(bdMovimiento);
    }

    // put
    @Transactional
    @Override
    public MovimientoDinero updateAllMovimientos(MovimientoDinero updateAllMovimiento, long id) throws Exception{
        movimientoDineroRepository.update(updateAllMovimiento.getConcepto(),
                updateAllMovimiento.getMonto(),id);
        return getMovimiento(id);
    }

    //Delete | eliminación por id
    public String deleteMovimientoDinero(long id){
        movimientoDineroRepository.deleteById(id);
        return "Movimiento Dinero eliminado con éxito";
    }
}
