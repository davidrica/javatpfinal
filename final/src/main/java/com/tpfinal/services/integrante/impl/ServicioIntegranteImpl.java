package com.tpfinal.services.integrante.impl;

import com.tpfinal.bootstrap.BootstrapData;
import com.tpfinal.domain.Equipo;
import com.tpfinal.domain.Integrante;
import com.tpfinal.services.entrada.console.impl.InputService;
import com.tpfinal.services.integrante.ServicioIntegrante;

import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class ServicioIntegranteImpl implements ServicioIntegrante {
    @Override
    public Integrante crearIntegrante(Equipo equiponuevo) {

        BootstrapData.mIntegrante.menuCrearIntegrante();

        System.out.print("=            -  Crear Integrante para el equipo: ");
        System.out.println(equiponuevo.getNombre());
        System.out.println("=");

        Integrante integrante = new Integrante();



        integrante.setNombre(InputService.entradaCadena("=    INGRESE EL NOMBRE: "));

        integrante.setApellido(InputService.entradaCadena("=    INGRESE EL APELLIDO: "));



        if (integrante != null){
            integrante.setEquipo(equiponuevo);
            equiponuevo.addIntegrante(integrante);

        }else{

        }


        return integrante;


    }
}
