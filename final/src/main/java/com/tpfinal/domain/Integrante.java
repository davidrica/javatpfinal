package com.tpfinal.domain;

public class Integrante {

    private String nombre;
    private String apellido;
    private Equipo equipo;

    public Integrante() {

    }

    public Integrante(String nombre,String apellido,Equipo equipo){
        this.nombre=nombre;
        this.apellido=apellido;
        this.equipo=equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        return "Integrante{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", equipo=" + equipo +
                '}';
    }
}
