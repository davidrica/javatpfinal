package com.tpfinal.domain;

import com.tpfinal.services.entrada.console.impl.InputService;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    public List<Jugador> getListaIntegrantesOrden(String orden){
        Comparator<Jugador> comparator = Comparator.comparing(jugador -> jugador.getNombre());
        switch (orden) {
            case "C":
                comparator = Comparator.comparing(jugador -> jugador.getNumeroCamiseta());
                break;
            case "P":
                comparator = Comparator.comparing(jugador -> jugador.getPosicion().getPosicion());
                break;

        }

        // comparator = comparator.thenComparing(Comparator.comparing(person -> person.age));

        // Sort the stream:
        Stream<Jugador> jugadorStream = listaIntegrantes.stream().sorted(comparator);

        // Make sure that the output is as expected:
        List<Jugador> sortedJugador = jugadorStream.collect(Collectors.toList());

        return sortedJugador;
    }
    public List<Jugador> getListaIntegrantes(){
        return getListaIntegrantesOrden("N");
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
