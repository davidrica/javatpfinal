package com.tpfinal;

import com.tpfinal.bootstrap.BootstrapData;
import com.tpfinal.services.equipos.ServicioEquipo;
import com.tpfinal.services.equipos.impl.ServicioEquipoImpl;
import com.tpfinal.services.gui.menu;

public class App{



    public static void main( String[] args )  {

        BootstrapData.initPosiciones();

        menu.menuPrincipal();


    }

}
