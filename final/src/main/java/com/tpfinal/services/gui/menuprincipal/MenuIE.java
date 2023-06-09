package com.tpfinal.services.gui.menuprincipal;

import com.tpfinal.services.gui.GuiIE;

public class MenuIE implements GuiIE {
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
    public void menuIE() {
        limpiarPantalla();
        System.out.println("=============Bienvenido a la app : Fut5App");
        System.out.println("=");
        System.out.println("=            Menu Importar - Exportar ");
        System.out.println("=");
        System.out.println("=     0 - Volver");
        System.out.println("=     1 - Importar Equipos -");
        System.out.println("=     2 - Importar Jugadores -");
        System.out.println("=     3 - Importar Entrenadores -");
        System.out.println("=     4 - Exportar Equipos");
        System.out.println("=     5 - Exportar Jugadores");
        System.out.println("=     6 - Exportar Entrenadores");
        System.out.println("");
        System.out.println("");
        System.out.print("Opcion:  ");
    }
}
