package com.alkosto.utils;

import java.io.IOException;

public class TerminateProcess {
    public static void terminateProcess(String pid) {
        try {
            // Ejecuta el comando para terminar el proceso
            Process process = Runtime.getRuntime().exec("taskkill /F /PID " + pid);
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("Proceso terminado exitosamente.");
            } else {
                System.out.println("No se pudo terminar el proceso.");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}