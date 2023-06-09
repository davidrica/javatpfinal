package com.tpfinal.services.entrada.file;

import com.tpfinal.domain.Entrenador;
import com.tpfinal.domain.Equipo;
import com.tpfinal.domain.Jugador;

import java.util.List;

public interface ServicioImportarArchivo {
    //cargar los equipos

    List<Equipo> cargarEquipos(String nombreArchivo);
    List<Jugador> cargarJugadores(String nombreArchivo);
    List<Entrenador> cargarEntrenadores(String nombreArchivo);
    List<Equipo> loadEquiposByFile();
    List<Jugador> loadJugadoresByFile();
    List<Entrenador> loadEntrenadoresByFile();


}
