package com.alkosto.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.alkosto.utils.TerminateProcess.terminateProcess;

public class ProcessID {
    public static String getChromePID() {
        try {
            // Ejecuta el comando para obtener el PID de la última instancia de Chrome
            Process process = Runtime.getRuntime().exec("tasklist /FI \"IMAGENAME eq chrome.exe\"");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("chrome.exe")) {
                    String[] parts = line.split("\\s+");
                    return parts[1];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void terminateLastChromeSubprocess() {
        String line;
        String highestPid = null;

        try {
            // Ejecuta el comando para listar los procesos de Chrome
            Process process = Runtime.getRuntime().exec("tasklist /FI \"IMAGENAME eq chrome.exe\" /FO CSV /NH");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            // Encuentra el PID más alto
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                String pid = details[1].replaceAll("\"", "").trim();

                if (highestPid == null || Integer.parseInt(pid) > Integer.parseInt(highestPid)) {
                    highestPid = pid;
                }
            }

            if (highestPid != null) {
                // Termina el proceso con el PID más alto
                terminateProcess(highestPid);
            } else {
                System.out.println("No se encontraron procesos de Chrome.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
