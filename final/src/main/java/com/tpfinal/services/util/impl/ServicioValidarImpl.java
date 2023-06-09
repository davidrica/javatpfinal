package com.tpfinal.services.util.impl;

import com.tpfinal.bootstrap.BootstrapData;
import com.tpfinal.domain.Posicion;
import com.tpfinal.services.entrada.console.impl.InputService;
import com.tpfinal.services.util.ServicioValidar;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

///implementar KISS
///implementar KISS
///implementar KISS
///implementar KISS

public class ServicioValidarImpl implements ServicioValidar {

    @Override
    public Boolean validarCadena(String dato) {
        Boolean seguir = false;
        if (dato.length() <= 0){
            System.out.print("=    Ingreso incorrecto: ");
            System.out.println(dato);
            seguir=true;
        }
        return seguir;
    }

    @Override
    public Boolean validarFecha(String dato) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        Boolean seguir = true;
        try {
            if (dato.length() <= 0){
                System.out.print("=    Ingreso incorrecto: ");
                System.out.println(dato);
                return false;
            }
            LocalDate.parse(dato,formatter);

        }catch(DateTimeParseException e){
            System.out.print("=   Ingreso incorrecto: ");
            System.out.println(dato);
            return false;
        }



        return seguir;
    }

    @Override
    public Boolean validarInt(String dato) {
        Boolean seguir = false;
        if (dato.length() <= 0){
            System.out.print("=    Ingreso incorrecto: ");
            System.out.println(dato);
            seguir=true;
        }
        return seguir;
    }

    @Override
    public Boolean validarPosicion(String dato) {

        Boolean seguir = true;
        try {
            if (dato.length() <= 0){
                System.out.print("=    Ingreso incorrecto: ");
                System.out.println(dato);
                return false;
            }
           //buscar posicion
            if (BootstrapData.posiciones.get(dato) ==null){
                System.out.print("=    Ingreso incorrecto: ");
                System.out.println(dato);
                return false;
            };

        }catch(DateTimeParseException e){
            System.out.print("=   Ingreso incorrecto: ");
            System.out.println(dato);
            return false;
        }



        return seguir;
    }


}
