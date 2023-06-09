package com.tpfinal.services.salida.file;

import com.tpfinal.domain.Equipo;

import java.io.IOException;
import java.util.List;

public interface ServicioExportarArchivo {
    void exportarEquipo() throws IOException;
    void exportarJugadores() throws IOException;
    void exportarEntrenadores() throws IOException;
}
