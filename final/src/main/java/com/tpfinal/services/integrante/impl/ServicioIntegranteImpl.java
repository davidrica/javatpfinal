package com.tpfinal.services.integrante.impl;

import com.tpfinal.domain.Equipo;
import com.tpfinal.domain.Integrante;
import com.tpfinal.services.entrada.console.impl.InputService;
import com.tpfinal.services.integrante.ServicioIntegrante;

import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class ServicioIntegranteImpl implements ServicioIntegrante {
    @Override
    public Integrante crearIntegrante() {
        Integrante integrante = new Integrante();
        System.out.println("INGRESE EL NOMBRE: ");
        integrante.setNombre(InputService.scanner.nextLine());

        System.out.println("INGRESE EL APELLIDO: ");
        integrante.setApellido(InputService.scanner.nextLine());

        return integrante;


    }
}
