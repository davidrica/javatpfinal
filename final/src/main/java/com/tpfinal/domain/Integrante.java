package com.tpfinal.domain;

public class Integrante {

    private String nombre;
    private String apellido;
    private Equipo equipo;

    public Integrante(String nombre,String apellido,Equipo equipo){
        this.nombre=nombre;
        this.apellido=apellido;
        this.equipo=equipo;
    }
}
