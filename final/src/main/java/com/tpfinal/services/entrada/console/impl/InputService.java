package com.tpfinal.services.entrada.console.impl;

import com.tpfinal.bootstrap.BootstrapData;
import com.tpfinal.domain.Integrante;
import com.tpfinal.domain.Posicion;
import com.tpfinal.services.entrada.console.InputServiceInterface;
import com.tpfinal.services.util.ServicioValidar;
import com.tpfinal.services.util.impl.ServicioValidarImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class InputService  {
    private static final ServicioValidar validar = new ServicioValidarImpl();
    public static Scanner scanner;
    public static String entradaCadena(String prompt){

        String entrada = "";
        boolean seguir =false;
        do {
            System.out.print(prompt);
            entrada = scanner.nextLine();
            seguir=validar.validarCadena(entrada);

        }
        while (seguir);

        return  entrada;
    }

    public static LocalDate entradaFecha(String prompt){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate retorno = LocalDate.parse("2023-01-01");
        String entrada ="";

        boolean seguir =false;
        do {
            System.out.print(prompt);
            entrada =InputService.getScanner().nextLine();
            seguir=validar.validarFecha(entrada);

            if (seguir){
                retorno =LocalDate.parse(entrada,formatter);
                seguir=false;
            }else{
                seguir=true;
                if (entrada.contentEquals("N")){
                    seguir=false;
                }
            }
        }
        while (seguir);

        return  retorno;
    }

    public static int entradaInt(String prompt){
        int retorno =0;
 //       String entrada = "";
 //       boolean seguir =false;
 //       do {
            System.out.print(prompt);
            retorno =scanner.nextInt();
            scanner.nextLine();
//            entrada = scanner.nextLine();
//            seguir=validar.validarInt(entrada);

//        }
//        while (seguir);

        return  retorno;
    }
    public static boolean entradaBoolean(String prompt){


        System.out.print(prompt);
        boolean entrada =   (scanner.nextLine() == "S") ? true : false;

        return  entrada;
    }

    public static Posicion entradaPosicion(String prompt){

        Posicion retorno = new Posicion();
        String entrada ="";

        boolean seguir =false;
        do {
            System.out.print(prompt);
            entrada =InputService.getScanner().nextLine();
            seguir=validar.validarPosicion(entrada);

            if (seguir){
                retorno = BootstrapData.posiciones.get(entrada);
                seguir=false;
            }else{
                seguir=true;
                if (entrada.contentEquals("N")){
                    seguir=false;
                }
            }
        }
        while (seguir);

        return  retorno;
    }
    public static void createScanner(){
        if(scanner == null){
            scanner = new Scanner(System.in);
        }
    }

    public static Scanner getScanner(){
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }

    public static void closeScanner(){
        if(scanner != null){
            scanner.close();
        }
    }
}
