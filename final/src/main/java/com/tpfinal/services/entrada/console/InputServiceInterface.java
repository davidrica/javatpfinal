package com.tpfinal.services.entrada.console;

import java.util.Scanner;

public interface InputServiceInterface {
    void createScanner();
    Scanner getScanner();
    void closeScanner();

}
