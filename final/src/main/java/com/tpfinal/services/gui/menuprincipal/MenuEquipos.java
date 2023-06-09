package com.tpfinal.services.gui.menuprincipal;

import com.tpfinal.services.gui.Gui;
import com.tpfinal.services.gui.GuiEquipos;

public class MenuEquipos implements GuiEquipos {

    private void limpiarPantalla() {
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("========================================================================================");
        System.out.println("");
    }
    @Override
    public void menuEquipos() {
        limpiarPantalla();
        System.out.println("=============Bienvenido a la app : Fut5App");
        System.out.println("=");
        System.out.println("=            Menu de Equipos");
        System.out.println("=");
        System.out.println("=     0 - Volver");
        System.out.println("=     1 - Crear Equipo");
        System.out.println("=     2 - Borrar Equipo");
        System.out.println("=     3 - Buscar Equipo y ver Capitan-Entrenador");
        System.out.println("=     4 - Buscar Equipo y ver jugadores");
        System.out.println("=     5 - Ver Todos los equipos");
        System.out.println("");
        System.out.println("");
        System.out.print("Opcion:  ");
    }

    @Override
    public void menuCrearEquipos() {
        limpiarPantalla();
        System.out.println("=============Bienvenido a la app : Fut5App");
        System.out.println("=");
        System.out.println("=            Menu de Equipos");
        System.out.println("=            -  Crear Nuevo Equipo ");
    }

    @Override
    public void menuBuscarEquipos() {
        limpiarPantalla();
        System.out.println("=============Bienvenido a la app : Fut5App");
        System.out.println("=");
        System.out.println("=            Menu de Equipos");
        System.out.println("=            -  Buscar equipos ");
    }

    @Override
    public void menuEliminarEquipo() {
        limpiarPantalla();
        System.out.println("=============Bienvenido a la app : Fut5App");
        System.out.println("=");
        System.out.println("=            Menu de Equipos");
        System.out.println("=            -  Buscar equipos a eliminar");
    }


}
