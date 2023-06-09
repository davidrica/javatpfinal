package com.tpfinal.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Equipo {
    private UUID id;
    private String nombre;
    private LocalDate fechaCreacion;
    private List<Jugador> listaIntegrantes = new ArrayList<>();
    private Entrenador entrenador = new Entrenador();

    public UUID getid(){
        return this.id;
    }
    public void setId(UUID id){
        this.id=id;
    }
    public String getNombre(){
        return this.nombre;
    }
    public void setNombre (String nombre){
        this.nombre=nombre;
    }

    public LocalDate getFechaCreacion(){
        return this.fechaCreacion;
    }
    public void  setFechaCreacion(LocalDate fechaCreacion){
       this.fechaCreacion=fechaCreacion;
    }

    public void addIntegrante(Jugador jugador){
        this.listaIntegrantes.add(jugador);
    }
    public List<Jugador> getListaIntegrantes(){
        return listaIntegrantes;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    @Override
    public String toString(){
        return "Equipo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fechaCreacion='" + fechaCreacion + '\'' +
                '}';
    }
}
