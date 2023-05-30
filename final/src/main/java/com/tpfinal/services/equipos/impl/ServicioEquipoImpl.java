package com.tpfinal.services.equipos.impl;

import com.tpfinal.domain.Equipo;
import com.tpfinal.services.entrada.console.impl.InputService;
import com.tpfinal.services.equipos.ServicioEquipo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class ServicioEquipoImpl implements ServicioEquipo {

    @Override
    public Equipo crearEquipo() {

        Equipo equiponuevo = new Equipo();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");


        equiponuevo.setId(UUID.randomUUID());
        System.out.println("INGRESE EL NOMBRE DEL EQUIPO: ");
        equiponuevo.setNombre(InputService.scanner.nextLine());

        //System.out.println("INGRESE LA FECHA DE CREACION DD/MM/AAAA: ");
        //equiponuevo.setFechaCreacion(LocalDate.parse(InputService.getScanner().nextLine(),formatter));
        return equiponuevo;
    }
}
