package com.tpfinal.services.integrante;

import com.tpfinal.domain.Entrenador;
import com.tpfinal.domain.Equipo;
import com.tpfinal.domain.Integrante;
import com.tpfinal.domain.Jugador;

import java.util.List;

public interface ServicioIntegrante {
    Jugador crearJugador(Equipo equipo);
    Entrenador crearEntrenador(Equipo equipo);

    List<Jugador> buscarJugadores();
    void listadoJugadores(List<Jugador> jugadores);


}
