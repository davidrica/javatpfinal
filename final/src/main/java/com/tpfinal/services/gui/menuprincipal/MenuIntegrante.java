package com.tpfinal.services.gui.menuprincipal;

import com.tpfinal.services.gui.Gui;
import com.tpfinal.services.gui.GuiIntegrantes;

public class MenuIntegrante implements GuiIntegrantes {

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
    public void menuIntegrante() {
        limpiarPantalla();
        System.out.println("=============Bienvenido a la app : Fut5App");
        System.out.println("=");
        System.out.println("=            Menu Integrante");
        System.out.println("=");
        System.out.println("=     0 - Volver");
        System.out.println("=     1 - Buscar Jugador");
        System.out.println("=     2 - Buscar Entrenador");
        System.out.println("");
        System.out.print("Opcion:  ");
    }

    @Override
    public void menuCrearIntegrante() {
        limpiarPantalla();
        System.out.println("=============Bienvenido a la app : Fut5App");
        System.out.println("=");
        System.out.println("=            Menu de Integrantes");
        System.out.println("=            -  Crear Nuevo Integrante ");

    }
    private void menuBuscar(){
        limpiarPantalla();
        System.out.println("=============Bienvenido a la app : Fut5App");
        System.out.println("=");
        System.out.println("=            Menu de Integrantes");
    }
    @Override
    public void menuBuscarJugador() {
        menuBuscar();
        System.out.println("=            -  Buscar Jugador ");
    }

    @Override
    public void menuBuscarEntrenador() {
        menuBuscar();
        System.out.println("=            -  Buscar Entrenador ");
    }
}
