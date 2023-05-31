package com.tpfinal.services.gui;

import com.tpfinal.domain.Equipo;
import com.tpfinal.services.entrada.console.impl.InputService;
import com.tpfinal.services.equipos.ServicioEquipo;
import com.tpfinal.services.equipos.impl.ServicioEquipoImpl;
import com.tpfinal.services.gui.menuprincipal.MenuIntegrante;
import com.tpfinal.services.gui.menuprincipal.MenuPrincipal;
import com.tpfinal.services.gui.menuprincipal.MenuEquipos;
import com.tpfinal.services.integrante.ServicioIntegrante;
import com.tpfinal.services.integrante.impl.ServicioIntegranteImpl;

import java.util.ArrayList;
import java.util.List;


public class Menu {

    private static final MenuPrincipal mPrincipal = new MenuPrincipal();
    private static final MenuEquipos mEquipo = new MenuEquipos();
    private static final MenuIntegrante mIntegrante = new MenuIntegrante();


    public static final ServicioEquipo servicioEquipo = new ServicioEquipoImpl();
    public static final ServicioIntegrante servicioIntegrante = new ServicioIntegranteImpl();

    public static List<Equipo> equipos;

    public static void menuPrincipal(){
        equipos = new ArrayList<Equipo>();


        Boolean seguir =true;

        InputService.createScanner();

        while (seguir){
            mPrincipal.limpiarPantalla();
            mPrincipal.menuPrincipal();


            String opcion = InputService.scanner.nextLine();

            switch (opcion){
                case "0":
                    seguir=false;
                    break;
                case"1":
                    menuEquipos();
                    break;
            }

        }


    }
    private static void menuEquipos(){



        Boolean seguirEquipos =true;
        while (seguirEquipos){

            mEquipo.limpiarPantalla();
            mEquipo.menuEquipos();
            String opcionEquipos = InputService.scanner.nextLine();

            switch (opcionEquipos){
                case "0":
                    seguirEquipos=false;
                    break;
                case "1":
                    equipos.add(servicioEquipo.crearEquipo());
                    break;
                case "4":
                    servicioEquipo.listadoEquipos(equipos);
                    break;
            }
        }

    }



}
