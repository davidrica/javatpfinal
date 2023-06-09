package com.tpfinal.services.entrada.file.impl;


import com.tpfinal.bootstrap.BootstrapData;
import com.tpfinal.domain.Entrenador;
import com.tpfinal.domain.Equipo;
import com.tpfinal.domain.Jugador;
import com.tpfinal.domain.Posicion;
import com.tpfinal.services.entrada.console.impl.InputService;
import com.tpfinal.services.entrada.file.ServicioImportarArchivo;
import org.apache.commons.io.FileUtils;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ServicioImportarArchivoImpl implements ServicioImportarArchivo {
    private static final String path ="final/src/main/java/com/tpfinal/resources/";
    @Override
    public List<Equipo> cargarEquipos(String nombreArchivo){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        List<Equipo> equipos = new ArrayList<>();
        List<String> lineas = null;
        try {
            lineas = FileUtils.readLines(new File(nombreArchivo), StandardCharsets.UTF_8);
            for (String linea: lineas) {

                String[] partes = linea.split(";");

                String nombre = partes[0];
                LocalDate fecha = LocalDate.parse(partes[1],formatter);


                Equipo equiponuevo = new Equipo();

                equiponuevo.setId(UUID.randomUUID());
                equiponuevo.setNombre(nombre);
                equiponuevo.setFechaCreacion( fecha);

                equipos.add(equiponuevo);
            }
            System.out.println("=     Finalizado.");
            System.out.println("=     Se importaron : " + lineas.size() + " equipos.");

        } catch (IOException e) {
            System.out.println(e.getMessage());

        }
        return  equipos;
    }

    @Override
    public List<Jugador> cargarJugadores(String nombreArchivo) {
        List<Jugador> jugadores = new ArrayList<>();
        List<String> lineas = null;
        try {
            lineas = FileUtils.readLines(new File(nombreArchivo), StandardCharsets.UTF_8);
            for (String linea: lineas) {

                String[] partes = linea.split(";");
                String nombre = partes[0];
                String apellido = partes[1];

                String cequipo = partes[2];
                int dni = Integer.parseInt(partes[3]);
                int altura = Integer.parseInt(partes[4]);
                Posicion posicion =BootstrapData.posiciones.get(partes[5]);
                int cantGol = Integer.parseInt(partes[6]);
                int cantPartidos = Integer.parseInt(partes[7]);
                boolean capitan = Boolean.parseBoolean(partes[8]);
                int numeroCamiseta = Integer.parseInt(partes[9]);


                Equipo equipo = BootstrapData.equipos.stream().filter(
                        equipo1 -> equipo1.getNombre().contains(cequipo)
                ).findFirst().get();

                Jugador jugador =new Jugador(nombre,apellido,equipo,dni,altura,posicion, cantGol,cantPartidos, capitan, numeroCamiseta);
                equipo.addIntegrante(jugador);



            }
            System.out.println("=     Finalizado.");
            System.out.println("=     Se importaron : " + lineas.size() + " jugadores.");

        } catch (IOException e) {
            System.out.println(e.getMessage());

        }

        return jugadores;
    }

    @Override
    public List<Entrenador> cargarEntrenadores(String nombreArchivo) {
        List<Entrenador> entrenadores = new ArrayList<>();

        List<String> lineas = null;
        try {
            lineas = FileUtils.readLines(new File(nombreArchivo), StandardCharsets.UTF_8);
            for (String linea: lineas) {

                String[] partes = linea.split(";");
                String nombre = partes[0];
                String apellido = partes[1];
                String cequipo = partes[2];
                int edad = Integer.parseInt(partes[3]);



                Equipo equipo = BootstrapData.equipos.stream().filter(
                        equipo1 -> equipo1.getNombre().contains(cequipo)
                ).findFirst().get();

                Entrenador entrenador =new Entrenador(nombre,apellido,equipo,edad);
                equipo.setEntrenador(entrenador);
                entrenadores.add(entrenador);

            }
            System.out.println("=     Finalizado.");
            System.out.println("=     Se importaron : " + lineas.size() + " Entrenadores.");

        } catch (IOException e) {
            System.out.println(e.getMessage());

        }

        return entrenadores;
    }

    @Override
    public List<Equipo> loadEquiposByFile() {

        List<Equipo> equipos = new ArrayList<>();


        String nombreArchivo= InputService.entradaCadena("=    NOMBRE DEL ARCHIVO DE EQUIPOS equipos.txt: ");
        nombreArchivo =path + nombreArchivo;

        equipos = cargarEquipos(nombreArchivo);



        return equipos;

    }

    @Override
    public List<Jugador> loadJugadoresByFile() {

        List<Jugador> jugadores = new ArrayList<>();

        String nombreArchivo= InputService.entradaCadena("=    NOMBRE DEL ARCHIVO DE JUGADORES jugadores.txt: ");
        nombreArchivo = path+ nombreArchivo;

        jugadores = cargarJugadores(nombreArchivo);

        return jugadores;
    }

    @Override
    public List<Entrenador> loadEntrenadoresByFile() {

        List<Entrenador> entrenadores = new ArrayList<>();

        String nombreArchivo= InputService.entradaCadena("=    NOMBRE DEL ARCHIVO DE ENTRENADORES entrenadores.txt: ");
        nombreArchivo = path + nombreArchivo;

        entrenadores= cargarEntrenadores(nombreArchivo);


        return entrenadores;
    }
}
