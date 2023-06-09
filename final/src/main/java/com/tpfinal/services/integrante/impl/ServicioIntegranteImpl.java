package com.tpfinal.services.integrante.impl;

import com.tpfinal.bootstrap.BootstrapData;
import com.tpfinal.domain.*;
import com.tpfinal.services.entrada.console.impl.InputService;
import com.tpfinal.services.integrante.ServicioIntegrante;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

    @Override
    public List<Jugador> buscarJugadores() {
        List<Jugador>  retorno=new ArrayList<Jugador>();
        List<Jugador>  jugadores=BootstrapData.ObtenerJugadores();

        BootstrapData.mIntegrante.menuBuscarJugador();

        String s= InputService.entradaCadena("=    INGRESE EL NOMBRE DEL JUGADOR A BUSCAR: ");

        if (jugadores != null) {
            System.out.println("=     BUSCANDO....");
            retorno = jugadores.stream().filter(jugador ->
                    jugador.getNombre().contains(s)).collect(Collectors.toList()) ;
        }else{
            System.out.println("=     Sin Datos");
        }

        return retorno;
    }

    @Override
    public void listadoJugadores(List<Jugador> jugadores) {
        //encabezado
        System.out.println("Nombre Apellido      | Posicion | Capitan | Equipo ");

        if (jugadores != null) {
            for (Jugador jugador : jugadores) {
                System.out.printf("%-20S | %-8S | %-7S | %-20S \n",
                        jugador.getNombre()+" " +jugador.getApellido(),
                        jugador.getPosicion().getPosicion(),
                        jugador.isCapitan() ? "Si":"No",
                        jugador.getEquipo().getNombre()
                        );


            }
        }else{
            System.out.println("=     Sin Datos");
        }
        System.out.println("=");
        System.out.println("=     Presione ENTER para continuar...");
        String opcionEquipos = InputService.scanner.nextLine();
    }


}
