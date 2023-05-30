package com.tpfinal.bootstrap;

import com.tpfinal.bootstrap.constantes.DescripcionesPosiciones;
import com.tpfinal.domain.Posicion;

import java.util.HashMap;
import java.util.Map;

public class BootstrapData {
    public static Map<String, Posicion> posiciones = new HashMap<>();

    public static void initPosiciones() {
        posiciones = new HashMap();

        cargarPosiciones(posiciones);
    }
    public static void cargarPosiciones(Map<String,Posicion> posiciones) {
        posiciones.put("Arquero",new Posicion(DescripcionesPosiciones.ARQUERO));
        posiciones.put("Defensor",new Posicion(DescripcionesPosiciones.DEFENSOR));
        posiciones.put("Medio Campista",new Posicion(DescripcionesPosiciones.MEDIOCAMPISTA));
        posiciones.put("Delantero",new Posicion(DescripcionesPosiciones.DELEANTERO));
    }
}
