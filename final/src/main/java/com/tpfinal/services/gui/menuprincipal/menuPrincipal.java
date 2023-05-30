package com.tpfinal.services.gui.menuprincipal;

import com.tpfinal.services.gui.Gui;

public class menuPrincipal implements Gui {
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
        System.out.println("Bienvenido a la app : Fut5App");
        System.out.println("");
        System.out.println("");
        System.out.println("0 - Terminar App");
        System.out.println("1 - Equipos");
        System.out.println("2 - Jugadores");
        System.out.println("3 - Entrenador");
        System.out.println("4 - Informes");
        System.out.println("");
        System.out.println("");
        System.out.print("Opcion:  ");
    }

    @Override
    public void menuEquipos() {
       // menuEquipos.menuEquipos();
    }
}

