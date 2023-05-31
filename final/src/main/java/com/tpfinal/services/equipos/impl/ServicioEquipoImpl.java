package com.tpfinal.services.equipos.impl;

import com.tpfinal.domain.Equipo;
import com.tpfinal.domain.Integrante;
import com.tpfinal.services.entrada.console.impl.InputService;
import com.tpfinal.services.equipos.ServicioEquipo;
import com.tpfinal.services.gui.menuprincipal.MenuIntegrante;
import com.tpfinal.services.integrante.ServicioIntegrante;
import com.tpfinal.services.integrante.impl.ServicioIntegranteImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

public class ServicioEquipoImpl implements ServicioEquipo {
    private static final MenuIntegrante mIntegrante = new MenuIntegrante();
    public static final ServicioIntegrante servicioIntegrante = new ServicioIntegranteImpl();
    @Override
    public Equipo crearEquipo() {
        Equipo equiponuevo = new Equipo();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");


        equiponuevo.setId(UUID.randomUUID());
        System.out.println("INGRESE EL NOMBRE DEL EQUIPO: ");
        equiponuevo.setNombre(InputService.scanner.nextLine());

        //System.out.println("INGRESE LA FECHA DE CREACION DD/MM/AAAA: ");
        //equiponuevo.setFechaCreacion(LocalDate.parse(InputService.getScanner().nextLine(),formatter));



        if (equiponuevo!=null) {
            //validar equipo

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
                        System.out.println(equiponuevo.getNombre());
                        System.out.println("");
                        Integrante integrante = servicioIntegrante.crearIntegrante();
                        if (integrante != null){
                            integrante.setEquipo(equiponuevo);
                            equiponuevo.addIntegrante(integrante);

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
            System.out.println("Sin Datos");
        }
        System.out.println("");
        System.out.println("Presione una tecla para continuar...");
        String opcionEquipos = InputService.scanner.nextLine();
    }


}
