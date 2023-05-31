package com.tpfinal.services.gui;

import com.tpfinal.domain.Equipo;
import com.tpfinal.domain.Integrante;
import com.tpfinal.services.entrada.console.impl.InputService;
import com.tpfinal.services.equipos.ServicioEquipo;
import com.tpfinal.services.equipos.impl.ServicioEquipoImpl;
import com.tpfinal.services.gui.menuprincipal.menuIntegrante;
import com.tpfinal.services.gui.menuprincipal.menuPrincipal;
import com.tpfinal.services.gui.menuprincipal.menuEquipos;
import com.tpfinal.services.integrante.ServicioIntegrante;
import com.tpfinal.services.integrante.impl.ServicioIntegranteImpl;

import java.util.ArrayList;
import java.util.List;


public class menu {

    private static final menuPrincipal mPrincipal = new menuPrincipal();
    private static final menuEquipos mEquipo = new menuEquipos();
    private static final menuIntegrante mIntegrante = new menuIntegrante();


    public static final ServicioEquipo servicioEquipo = new ServicioEquipoImpl();
    public static final ServicioIntegrante servicioIntegrante = new ServicioIntegranteImpl();

    public static List<Equipo> equipos;
    public static List<Integrante> integrantes;
    public static void menuPrincipal(){
        equipos = new ArrayList<Equipo>();
        integrantes = new ArrayList<Integrante>();

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

            boolean Seguir =true;


            do {

                System.out.println("Desea Agregar integrantes S/N: ");


                String agregarIntegrante = InputService.scanner.nextLine();
                switch (agregarIntegrante) {
                    case "S":
                    case "s":
                        mIntegrante.limpiarPantalla();

                        System.out.println("Bienvenido a la app : Fut5App");
                        System.out.print("Crear Integrante para el equipo: ");
                        System.out.println(equipo.getNombre());
                        System.out.println("");
                        Integrante integrante = servicioIntegrante.crearIntegrante();
                        if (integrante != null){
                            integrante.setEquipo(equipo);
                            integrantes.add(integrante);

                        }else{

                        }
                        break;
                    default:
                        Seguir=false;
                }


            }while (Seguir);




        }else{
            System.out.println("Error en carga");
            System.out.println("Presione una tecla para continuar...");
            String opcionEquipos = InputService.scanner.nextLine();

        }

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

    //seccion equipos

}
