package com.tpfinal.services.integrante.impl;

import com.tpfinal.bootstrap.BootstrapData;
import com.tpfinal.domain.*;
import com.tpfinal.services.entrada.console.impl.InputService;
import com.tpfinal.services.integrante.ServicioIntegrante;

import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class ServicioIntegranteImpl implements ServicioIntegrante {
    private Integrante cargarNombreApellido(Equipo equiponuevo){

        System.out.println(equiponuevo.getNombre());
        System.out.println("=");

        Integrante integrante  = new Integrante();
        integrante.setNombre(InputService.entradaCadena("=    INGRESE EL NOMBRE: "));

        integrante.setApellido(InputService.entradaCadena("=    INGRESE EL APELLIDO: "));

        integrante.setEquipo(equiponuevo);

        return integrante;
    }
    @Override
    public Jugador crearJugador(Equipo equiponuevo) {
        System.out.print("=            -  Crear Jugador para el equipo: ");
        BootstrapData.mIntegrante.menuCrearIntegrante();


        Jugador jugador =  new Jugador(cargarNombreApellido(equiponuevo))  ;
        jugador.setDni(InputService.entradaInt("=    INGRESE EL DNI: "));
        jugador.setAltura(InputService.entradaInt("=    INGRESE LA ALTURA: "));
        jugador.setPosicion(InputService.entradaPosicion("=    INGRESE LA POSICION: "));
        jugador.setCantGol(InputService.entradaInt("=    INGRESE LA CANTIDAD DE GOLES: "));
        jugador.setCantPartidos(InputService.entradaInt("=    INGRESE LA CANTIDAD DE PARTIDOS: "));
        jugador.setCapitan(InputService.entradaBoolean("=    ES CAPITAN S/N: "));
        jugador.setNumeroCamiseta(InputService.entradaInt("=    INGRESE EL NUMERO CAMISETA: "));

        equiponuevo.addIntegrante(jugador);

        return jugador;


    }

    @Override
    public Entrenador crearEntrenador(Equipo equiponuevo) {
        System.out.print("=            -  Crear Entrenador para el equipo: ");
        BootstrapData.mIntegrante.menuCrearIntegrante();
        Entrenador entrenador = new Entrenador(cargarNombreApellido(equiponuevo));

        entrenador.setEdad(InputService.entradaInt("=    INGRESE LA EDAD: "));
        return entrenador;
    }
}
