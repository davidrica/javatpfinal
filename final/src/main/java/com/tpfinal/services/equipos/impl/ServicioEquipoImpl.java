package com.tpfinal.services.equipos.impl;

import com.tpfinal.bootstrap.BootstrapData;
import com.tpfinal.domain.Equipo;
import com.tpfinal.domain.Integrante;
import com.tpfinal.services.entrada.console.impl.InputService;
import com.tpfinal.services.equipos.ServicioEquipo;
import com.tpfinal.services.gui.menuprincipal.MenuIntegrante;
import com.tpfinal.services.integrante.ServicioIntegrante;
import com.tpfinal.services.integrante.impl.ServicioIntegranteImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ServicioEquipoImpl implements ServicioEquipo {
    private static final MenuIntegrante mIntegrante = new MenuIntegrante();
    public static final ServicioIntegrante servicioIntegrante = new ServicioIntegranteImpl();
    @Override
    public Equipo crearEquipo() {

        BootstrapData.mEquipo.menuCrearEquipos();

        Equipo equiponuevo = new Equipo();



        equiponuevo.setId(UUID.randomUUID());


        equiponuevo.setNombre(InputService.entradaCadena("=    INGRESE EL NOMBRE DEL EQUIPO: "));

        equiponuevo.setFechaCreacion( InputService.entradaFecha("=    INGRESE LA FECHA DE CREACION DD/MM/AAAA: "));




        if (equiponuevo!=null) {
            //validar equipo

            System.out.println("=    Equipo agregado correctamente...");

            boolean Seguir =true;


            do {

                System.out.print("=    Desea Agregar integrantes? S/N: ");


                String agregarIntegrante = InputService.scanner.nextLine();
                switch (agregarIntegrante) {
                    case "S":
                    case "s":


                        Integrante integrante = servicioIntegrante.crearIntegrante(equiponuevo);

                        break;
                    default:
                        Seguir=false;
                }


            }while (Seguir);




        }else{
            System.out.println("=     Error en carga");
            System.out.println("=     Presione ENTER para continuar...");
            String opcionEquipos = InputService.scanner.nextLine();

        }
        return equiponuevo;
    }

    @Override
    public void listadoEquipos(List<Equipo> equipos) {

        if (equipos != null) {
            for (Equipo equipo : equipos) {
                System.out.println(equipo.toString());
                for (Integrante integrante: equipo.getListaIntegrantes()) {
                    System.out.println(integrante.toString());

                }
            }
        }else{
            System.out.println("=     Sin Datos");
        }
        System.out.println("=");
        System.out.println("=     Presione ENTER para continuar...");
        String opcionEquipos = InputService.scanner.nextLine();
    }


    public List<Equipo> buscarEquipos(List<Equipo> equipos){
        BootstrapData.mEquipo.menuBuscarEquipos();

        String s= InputService.entradaCadena("=    INGRESE EL EQUIPO A BUSCAR: ");
        List<Equipo>  retorno=new ArrayList<Equipo> ();;
        if (equipos != null) {
            retorno = equipos.stream().filter(equipo -> equipo.getNombre().contains(s)  ).collect(Collectors.toList()); ;
        }else{
            System.out.println("=     Sin Datos");
        }
        //listadoEquipos(retorno);
        return  retorno;
    }
}
