package com.tpfinal.services.salida.file.impl;

import com.tpfinal.bootstrap.BootstrapData;
import com.tpfinal.domain.Equipo;
import com.tpfinal.domain.Jugador;
import com.tpfinal.services.entrada.console.impl.InputService;
import com.tpfinal.services.salida.file.ServicioExportarArchivo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ServicioExportarArchivoImpl implements ServicioExportarArchivo {
    private static final String path ="final/src/main/java/com/tpfinal/resources/";
    @Override
    public void exportarEquipo() throws IOException {
        String rutaDeDestino= InputService.entradaCadena("=    NOMBRE DEL ARCHIVO DE Equipos: ");
        rutaDeDestino = path+ rutaDeDestino;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaDeDestino))){

            for (Equipo equipo: BootstrapData.equipos) {

                String linea = equipo.getNombre() + ";" +
                        equipo.getFechaCreacion() ;

                writer.write(linea); //Escribimos en archivo
                writer.newLine(); //Salto de linea
            }
            System.out.println("=     Finalizado.");
            System.out.println("=     Se Exportaron : " + BootstrapData.equipos.size() + " Equipos.");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void exportarJugadores() throws IOException {
        String rutaDeDestino= InputService.entradaCadena("=    NOMBRE DEL ARCHIVO DE Jugadores: ");
        rutaDeDestino = path+ rutaDeDestino;
        List<Jugador> jugadores=BootstrapData.ObtenerJugadores();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaDeDestino))){

            for (Jugador jugador: jugadores) {
                //jugador1;apellido1;EQUIPO 1;121212;12;Arquero;0;0;TRUE;1
                String linea = jugador.getNombre() + ";" +
                        jugador.getApellido() + ";" +
                        jugador.getEquipo().getNombre() + ";" +
                        jugador.getDni()+ ";" +
                        jugador.getAltura()+ ";" +
                        jugador.getPosicion().getPosicion()+ ";" +
                        jugador.getCantGol()+ ";" +
                        jugador.getCantPartidos()+ ";" +
                        jugador.isCapitan()+ ";" +
                        jugador.getNumeroCamiseta();


                writer.write(linea); //Escribimos en archivo
                writer.newLine(); //Salto de linea
            }
            System.out.println("=     Finalizado.");
            System.out.println("=     Se Exportaron : " + jugadores.size() + " jugadores.");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void exportarEntrenadores() throws IOException {
        String rutaDeDestino= InputService.entradaCadena("=    NOMBRE DEL ARCHIVO DE entrenadores: ");
        rutaDeDestino = path+ rutaDeDestino;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaDeDestino))){

            for (Equipo equipo: BootstrapData.equipos) {
                //entrenador1;apellido1;EQUIPO 1;52
                if (equipo.getEntrenador() != null){
                    String linea = equipo.getEntrenador().getNombre() + ";" +
                            equipo.getEntrenador().getApellido() +";" +
                            equipo.getEntrenador().getEdad();

                    writer.write(linea); //Escribimos en archivo
                    writer.newLine(); //Salto de linea
                }

            }
            System.out.println("=     Finalizado.");
            System.out.println("=     Se Exportaron : " + BootstrapData.equipos.size() + " entrenadores.");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
