package com.tpfinal.services.equipos;

import com.tpfinal.domain.Equipo;

import java.util.List;

public interface ServicioEquipo {
    Equipo crearEquipo();

    void listadoEquipos(List<Equipo> equipos);

    List<Equipo> buscarEquipos(List<Equipo> equipos);
}
