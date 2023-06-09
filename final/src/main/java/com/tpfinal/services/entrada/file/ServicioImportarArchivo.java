package com.tpfinal.services.entrada.file;

import com.tpfinal.domain.Entrenador;
import com.tpfinal.domain.Equipo;
import com.tpfinal.domain.Jugador;

import java.util.List;

public interface ServicioImportarArchivo {
    //cargar los equipos
    List<Equipo> loadEquiposByFile();
    List<Jugador> loadJugadoresByFile();
    List<Entrenador> loadEntrenadoresByFile();

}
