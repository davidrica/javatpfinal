package com.tpfinal.domain;

public class Posicion {
    private String posicion;

    public Posicion(){
    }
    public Posicion(String posicion){
        this.posicion=posicion;
    }
    public String getPosicion(){
        return this.posicion;
    }
    public void setPosicion(String posicion){
        this.posicion=posicion;
    }
}
