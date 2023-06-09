package com.tpfinal.domain;

public class Entrenador extends Integrante{
    private  int edad;
    public Entrenador(){

    }
    public Entrenador(Integrante integrante){
        super(integrante.getNombre(),integrante.getApellido(),integrante.getEquipo());
    }

    @Override
    public String toString() {
        return "Entrenador{" +
                "Apellido=" + getApellido()+
                ", Nombre=" + getNombre() +
                ", edad=" + edad +
                '}';
    }

    public Entrenador(String nombre, String apellido, Equipo equipo, int edad){
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setEquipo(equipo);
        this.edad=edad;
    }
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


}
