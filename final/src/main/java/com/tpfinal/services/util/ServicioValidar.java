package com.tpfinal.services.util;

import java.time.LocalDate;

public interface ServicioValidar {
    Boolean validarCadena(String dato);
    Boolean validarFecha(String dato);
    Boolean validarInt(String dato);
    Boolean validarPosicion(String dato);
}
