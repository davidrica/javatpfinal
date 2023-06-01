package com.tpfinal.services.util.impl;

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
        Boolean seguir = false;
        try {
            if (dato.length() <= 0){
                System.out.print("=    Ingreso incorrecto: ");
                System.out.println(dato);
                return true;
            }
            LocalDate.parse(dato,formatter);

        }catch(DateTimeParseException e){
            System.out.print("=    Ingreso incorrecto: ");
            System.out.println(dato);

        }



        return seguir;
    }


}
