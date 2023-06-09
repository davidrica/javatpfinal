package com.tpfinal.services.equipos.impl;

import com.tpfinal.bootstrap.BootstrapData;
import com.tpfinal.domain.Entrenador;
import com.tpfinal.domain.Equipo;
import com.tpfinal.domain.Integrante;
import com.tpfinal.domain.Jugador;
import com.tpfinal.services.entrada.console.impl.InputService;
import com.tpfinal.services.equipos.ServicioEquipo;
import com.tpfinal.services.gui.menuprincipal.MenuIntegrante;
import com.tpfinal.services.integrante.ServicioIntegrante;
import com.tpfinal.services.integrante.impl.ServicioIntegranteImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class ServicioEquipoImpl implements ServicioEquipo {
    private static final MenuIntegrante mIntegrante = new MenuIntegrante();
    public static final ServicioIntegrante servicioIntegrante = new ServicioIntegranteImpl();

    public Jugador obtenerCapitan(Equipo equipo){
        Jugador retorno = new Jugador();
        retorno.setNombre("Sin");
        retorno.setApellido("Capitan");

        Optional<Jugador> jugador=equipo.getListaIntegrantes().stream().filter(
                jugador1 -> jugador1.isCapitan()  ).findFirst();
        if (jugador.isPresent()){
            retorno=jugador.get();
        }
        return  retorno;
    }
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

                System.out.print("=    Desea Agregar los Jugadores? S/N: ");


                String agregarIntegrante = InputService.scanner.nextLine();
                switch (agregarIntegrante) {
                    case "S":
                    case "s":
                        Jugador jugador = servicioIntegrante.crearJugador(equiponuevo);

                        break;
                    default:
                        Seguir=false;
                }


            }while (Seguir);


            Entrenador entrenador = servicioIntegrante.crearEntrenador(equiponuevo);

            equiponuevo.setEntrenador(entrenador);


        }else{
            System.out.println("=     Error en carga");
            System.out.println("=     Presione ENTER para continuar...");
            String opcionEquipos = InputService.scanner.nextLine();

        }
        return equiponuevo;
    }
    private void listadoEquipoIndice(List<Equipo> equipos){
        System.out.println("Opcion     | Nombre Equipo        ");
        if (equipos != null) {
            for (Equipo equipo : equipos) {
                System.out.printf("%-10S | %-20S \n",
                        equipos.indexOf(equipo) ,
                        equipo.getNombre()
                );


            }
        }else{
            System.out.println("=     Sin Datos");
        }

    }
    @Override
    public void listadoEquipos(List<Equipo> equipos) {
        String opcionEquipos =InputService.entradaCadena("=    Orden Nombre 'N', Orden Camiseta 'C' : ");


        System.out.println("Nombre Equipo        | Entrenador            | Jugadores            | Capitan | N C | ");
        if (equipos != null) {
            for (Equipo equipo : equipos) {
                System.out.printf("%-20S | %-20S \n",
                        equipo.getNombre() ,
                        equipo.getEntrenador().getNombre()+" "+equipo.getEntrenador().getApellido()
                );
                List<Jugador> jugadores =equipo.getListaIntegrantesOrden(opcionEquipos);

                for (Jugador jugador: jugadores) {
                    System.out.printf("                                            %20S | %-7S | %3S \n",
                            jugador.getNombre()+" "+jugador.getApellido(),
                            jugador.isCapitan()? "Si":"No",
                            jugador.getNumeroCamiseta()
                    );

                }

                            }
        }else{
            System.out.println("=     Sin Datos");
        }
        System.out.println("=");
        System.out.println("=     Presione ENTER para continuar...");
        opcionEquipos = InputService.scanner.nextLine();
    }

    @Override
    public void consultaEquipo(List<Equipo> equipos) {

        System.out.println("Nombre Equipo        | Entrenador            | Capitan             ");
        if (equipos != null) {
            for (Equipo equipo : equipos) {
                Jugador jugador = obtenerCapitan(equipo);
                System.out.printf("%-20S | %-20S | %-20S \n",
                        equipo.getNombre(),
                        equipo.getEntrenador().getNombre() + " " + equipo.getEntrenador().getApellido(),
                        jugador.getNombre() + " " + jugador.getApellido()
                );
            }


        }else{
            System.out.println("=     Sin Datos");
        }
        System.out.println("=");
        System.out.println("=     Presione ENTER para continuar...");
        String opcionEquipos = InputService.scanner.nextLine();

    }

    @Override
    public Equipo eliminarEquipo(List<Equipo> equipos) {
        BootstrapData.mEquipo.menuEliminarEquipo();
        Equipo equipoEliminar = new Equipo();

        String s= InputService.entradaCadena("=    INGRESE EL EQUIPO A ELIMINAR: ");

        List<Equipo>  retorno=new ArrayList<Equipo> ();;
        if (equipos != null) {
            retorno = equipos.stream().filter(equipo -> equipo.getNombre().contains(s)  ).collect(Collectors.toList());
            if(retorno.size()>0){
                System.out.println("====================================");
                listadoEquipoIndice(retorno);
                System.out.println("====================================");
                System.out.println("=");
                int opcionEquipos = InputService.entradaInt("=    INGRESE opcion a eliminar: ");
                if (opcionEquipos<retorno.size()){
                    equipoEliminar = retorno.get(opcionEquipos);

                }else{
                    System.out.println("=     Opcion Incorrecta");
                }
            }else{
                System.out.println("=     No Se encontraro equipos");
            }




        }else{
            System.out.println("=     Sin Datos");
        }


        return equipoEliminar;
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
