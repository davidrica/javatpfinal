package com.tpfinal.services.entrada.console.impl;

import com.tpfinal.services.entrada.console.InputServiceInterface;

import java.util.Scanner;

public class InputService  {
    public static Scanner scanner;

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
