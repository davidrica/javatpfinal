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

    }

    @Override
    public void menuCrearIntegrante() {
        limpiarPantalla();
        System.out.println("=============Bienvenido a la app : Fut5App");
        System.out.println("=");
        System.out.println("=            Menu de Integrantes");
        System.out.println("=            -  Crear Nuevo Integrante ");

    }
}
