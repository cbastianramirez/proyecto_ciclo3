package com.proyecto_ciclo3.proyecto_ciclo3.modelos;

public class ObjetoRespuesta {
    private String mensaje;
    private Object objeto;


    // constructor vacío

    public ObjetoRespuesta() {
    }


    // constructor lleno
    public ObjetoRespuesta(String mensaje, Object objeto) {
        this.mensaje = mensaje;
        this.objeto = objeto;
    }


    // getters & setters
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Object getObjeto() {
        return objeto;
    }

    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }
}



