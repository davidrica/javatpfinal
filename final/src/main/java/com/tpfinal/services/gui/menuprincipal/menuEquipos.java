package com.tpfinal.services.gui.menuprincipal;

import com.tpfinal.services.gui.Gui;

public class menuEquipos implements Gui {

    @Override
    public void limpiarPantalla() {
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }

    @Override
    public void menuPrincipal() {

    }

    @Override
    public void menuEquipos() {
        System.out.println("Bienvenido a la app : Fut5App");
        System.out.println("Menu de Equipos");
        System.out.println("");
        System.out.println("0 - Volver");
        System.out.println("1 - Crear Equipo");
        System.out.println("2 - Borrar Equipo");
        System.out.println("3 - Buscar Equipo");
        System.out.println("4 - Ver Todos los equipos");
        System.out.println("");
        System.out.println("");
        System.out.print("Opcion:  ");
    }

    @Override
    public void menuIntegrante() {

    }


}
