package com.tpfinal.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Equipo {
    private UUID id;
    private String nombre;
    private LocalDate fechaCreacion;
    private List<Integrante> listaIntegrantes = new ArrayList<>();

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

    public void addIntegrante(Integrante integrante){
        this.listaIntegrantes.add(integrante);
    }
    public List<Integrante> getListaIntegrantes(){
        return listaIntegrantes;
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
