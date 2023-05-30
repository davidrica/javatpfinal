package com.tpfinal.services.gui;

import com.tpfinal.domain.Equipo;
import com.tpfinal.services.entrada.console.impl.InputService;
import com.tpfinal.services.equipos.ServicioEquipo;
import com.tpfinal.services.equipos.impl.ServicioEquipoImpl;
import com.tpfinal.services.gui.menuprincipal.menuPrincipal;
import com.tpfinal.services.gui.menuprincipal.menuEquipos;
import java.util.ArrayList;
import java.util.List;


public class menu {

    private static final menuPrincipal mPrincipal = new menuPrincipal();
    private static final menuEquipos mEquipo = new menuEquipos();

    public static final ServicioEquipo servicioEquipo = new ServicioEquipoImpl();

    public static List<Equipo> equipos;
    public static void menuPrincipal(){
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

        equipos = new ArrayList<Equipo>();

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
                    crearEquipos();
                    break;
                case "4":
                    ListadoEquipos();
                    break;
            }
        }

    }

    public static void  crearEquipos(){
        Equipo  equipo= servicioEquipo.crearEquipo();
        if (equipo!=null) {
            //validar equipo
            equipos.add(equipo);
            System.out.println("Equipo agregado...");

        }else{
            System.out.println("Error en carga");
        }
        System.out.println("Presione una tecla para continuar...");
        String opcionEquipos = InputService.scanner.nextLine();
    }
    public static void ListadoEquipos(){

        if (equipos != null) {
            for (Equipo equipo : equipos) {
                System.out.println(equipo.toString());
            }
        }else{
            System.out.println("Sin Datos");
        }
        System.out.println("");
        System.out.println("Presione una tecla para continuar...");
        String opcionEquipos = InputService.scanner.nextLine();
    }
}
