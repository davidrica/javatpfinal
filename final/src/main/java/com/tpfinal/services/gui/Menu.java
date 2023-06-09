package com.tpfinal.services.gui;

import com.tpfinal.bootstrap.BootstrapData;
import com.tpfinal.domain.Equipo;
import com.tpfinal.services.entrada.console.impl.InputService;
import com.tpfinal.services.entrada.file.ServicioImportarArchivo;
import com.tpfinal.services.entrada.file.impl.ServicioImportarArchivoImpl;
import com.tpfinal.services.equipos.ServicioEquipo;
import com.tpfinal.services.equipos.impl.ServicioEquipoImpl;
import com.tpfinal.services.gui.menuprincipal.MenuIE;
import com.tpfinal.services.gui.menuprincipal.MenuIntegrante;
import com.tpfinal.services.gui.menuprincipal.MenuPrincipal;
import com.tpfinal.services.gui.menuprincipal.MenuEquipos;
import com.tpfinal.services.integrante.ServicioIntegrante;
import com.tpfinal.services.integrante.impl.ServicioIntegranteImpl;
import com.tpfinal.services.salida.file.ServicioExportarArchivo;
import com.tpfinal.services.salida.file.impl.ServicioExportarArchivoImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Menu {





    public static final ServicioEquipo servicioEquipo = new ServicioEquipoImpl();
    public static final ServicioIntegrante servicioIntegrante = new ServicioIntegranteImpl();
    public static final ServicioImportarArchivo servicioImportar = new ServicioImportarArchivoImpl();
    public static final ServicioExportarArchivo servicioExportar = new ServicioExportarArchivoImpl();

    public static void menuPrincipal() throws IOException {



        Boolean seguir =true;

        InputService.createScanner();

        while (seguir){

            BootstrapData.mPrincipal.menuPrincipal();


            String opcion = InputService.scanner.nextLine();

            switch (opcion){
                case "0":
                    seguir = false;
                    break;
                case"1":
                    menuEquipos();
                    break;
                case"2":
                    menuIntegrante();
                    break;
                case"5":
                    menuIE();
            }

        }


    }



    private static void menuEquipos(){



        Boolean seguirEquipos =true;
        while (seguirEquipos){


            BootstrapData.mEquipo.menuEquipos();
            String opcionEquipos = InputService.scanner.nextLine();

            switch (opcionEquipos){
                case "0":
                    seguirEquipos = false;
                    break;
                case "1":

                    BootstrapData.equipos.add(servicioEquipo.crearEquipo());
                    break;
                case "2":
                    BootstrapData.equipos.remove(
                            servicioEquipo.eliminarEquipo (BootstrapData.equipos)
                    );

                    break;
                case "3":

                    servicioEquipo.consultaEquipo(
                            servicioEquipo.buscarEquipos (BootstrapData.equipos)
                    );

                    break;
                case "4":
                    servicioEquipo.listadoEquipos(
                            servicioEquipo.buscarEquipos (BootstrapData.equipos)
                    );

                    break;
                case "5":
                    servicioEquipo.listadoEquipos(BootstrapData.equipos);
                    break;
            }
        }

    }

    private static void menuIntegrante(){
        Boolean seguir =true;
        while (seguir){


            BootstrapData.mIntegrante.menuIntegrante();
            String opcionEquipos = InputService.scanner.nextLine();

            switch (opcionEquipos){
                case "0":
                    seguir = false;
                    break;
                case "1":
                    servicioIntegrante.listadoJugadores(
                            servicioIntegrante.buscarJugadores()
                    );

                    break;
                case "2":
                    //buscar entrenador;
                    break;

            }
        }
    }
    private static void menuIE() throws IOException {

        Boolean seguir =true;
        while (seguir){


            BootstrapData.mIE.menuIE();
            String opcion = InputService.scanner.nextLine();

            switch (opcion){
                case "0":
                    seguir = false;
                    break;
                case "1":
                    //importar
                    BootstrapData.equipos= servicioImportar.loadEquiposByFile();
                    break;
                case "2":
                    servicioImportar.loadJugadoresByFile();

                    break;
                case "3":
                    servicioImportar.loadEntrenadoresByFile();

                    break;
                case "4":
                    servicioExportar.exportarEquipo();
                    break;
                case "5":
                    servicioExportar.exportarJugadores();
                    break;
                case "6":
                    servicioExportar.exportarEntrenadores();
                    break;
            }
        }
    }
}
