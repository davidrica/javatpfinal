package com.tpfinal.bootstrap;

import com.tpfinal.bootstrap.constantes.DescripcionesPosiciones;
import com.tpfinal.domain.Equipo;
import com.tpfinal.domain.Posicion;
import com.tpfinal.services.gui.menuprincipal.MenuEquipos;
import com.tpfinal.services.gui.menuprincipal.MenuIE;
import com.tpfinal.services.gui.menuprincipal.MenuIntegrante;
import com.tpfinal.services.gui.menuprincipal.MenuPrincipal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BootstrapData {
    public static Map<String, Posicion> posiciones = new HashMap<>();
    public static List<Equipo> equipos;

    public static final MenuPrincipal mPrincipal = new MenuPrincipal();
    public static final MenuEquipos mEquipo = new MenuEquipos();
    public static final MenuIntegrante mIntegrante = new MenuIntegrante();
    public static final MenuIE mIE = new MenuIE();
    public static void initData() {
        //datos vacios
        posiciones = new HashMap();

        equipos = new ArrayList<Equipo>();

        cargarPosiciones(posiciones);
    }
    public static void cargarPosiciones(Map<String,Posicion> posiciones) {
        posiciones.put("Arquero",new Posicion(DescripcionesPosiciones.ARQUERO));
        posiciones.put("Defensor",new Posicion(DescripcionesPosiciones.DEFENSOR));
        posiciones.put("Medio Campista",new Posicion(DescripcionesPosiciones.MEDIOCAMPISTA));
        posiciones.put("Delantero",new Posicion(DescripcionesPosiciones.DELEANTERO));
    }
}
