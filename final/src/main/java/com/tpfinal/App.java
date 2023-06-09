package com.tpfinal;

import com.tpfinal.bootstrap.BootstrapData;
import com.tpfinal.services.gui.Menu;

import java.io.IOException;

public class App{



    public static void main( String[] args ) throws IOException {

        BootstrapData.initData();

        Menu.menuPrincipal();


    }

}
