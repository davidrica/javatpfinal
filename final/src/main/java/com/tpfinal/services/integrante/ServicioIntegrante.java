package com.tpfinal.services.integrante;

import com.tpfinal.domain.Entrenador;
import com.tpfinal.domain.Equipo;
import com.tpfinal.domain.Integrante;
import com.tpfinal.domain.Jugador;

public interface ServicioIntegrante {
    Jugador crearJugador(Equipo equipo);
    Entrenador crearEntrenador(Equipo equipo);
}
