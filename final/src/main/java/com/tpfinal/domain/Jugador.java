package com.tpfinal.domain;

public class Jugador extends Integrante{
    private long dni;
    private int altura;
    private Posicion posicion;
    private int cantGol;
    private int cantPartidos;
    private boolean capitan;
    private int numeroCamiseta;

    @Override
    public String toString() {
        return "Jugador{" +
                "Apellido=" + getApellido()+
                ", Nombre=" + getNombre() +
                ", dni=" + dni +
                ", altura=" + altura +
                ", posicion=" + posicion +
                ", cantGol=" + cantGol +
                ", cantPartidos=" + cantPartidos +
                ", capitan=" + capitan +
                ", numeroCamiseta=" + numeroCamiseta +
                '}';
    }

    public Jugador(){
    }
    public Jugador (Integrante integrante){
        super(integrante.getNombre(),integrante.getApellido(),integrante.getEquipo());
    }
    public Jugador(long dni,int altura,Posicion posicion, int cantGol,int cantPartidos, boolean capitan, int numeroCamiseta){
        this.dni=dni;
        this.altura=altura;
        this.posicion=posicion;
        this.cantGol=cantGol;
        this.cantPartidos=cantPartidos;
        this.capitan=capitan;
        this.numeroCamiseta=numeroCamiseta;
    }
    public Jugador(String nombre,String apellido,Equipo equipo,long dni,int altura,Posicion posicion, int cantGol,int cantPartidos, boolean capitan, int numeroCamiseta){
        super.setNombre(nombre);
        super.setApellido(apellido);
        super.setEquipo(equipo);
        this.dni=dni;
        this.altura=altura;
        this.posicion=posicion;
        this.cantGol=cantGol;
        this.cantPartidos=cantPartidos;
        this.capitan=capitan;
        this.numeroCamiseta=numeroCamiseta;
    }
    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public int getCantGol() {
        return cantGol;
    }

    public void setCantGol(int cantGol) {
        this.cantGol = cantGol;
    }

    public int getCantPartidos() {
        return cantPartidos;
    }

    public void setCantPartidos(int cantPartidos) {
        this.cantPartidos = cantPartidos;
    }

    public boolean isCapitan() {
        return capitan;
    }

    public void setCapitan(boolean capitan) {
        this.capitan = capitan;
    }

    public int getNumeroCamiseta() {
        return numeroCamiseta;
    }

    public void setNumeroCamiseta(int numeroCamiseta) {
        this.numeroCamiseta = numeroCamiseta;
    }
}
