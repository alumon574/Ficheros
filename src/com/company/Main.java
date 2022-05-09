package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        File currentFile = File.listRoots()[0];
        int userIndex = 0;
        while (userIndex != -1) {
            imprimeFicheros(currentFile);
            System.out.println("Introduce un directorio al que te quieras mover (-1 Para terminar):");
            userIndex = scanner.nextInt();

            if (userIndex == -1)
                break;

            if (userIndex > currentFile.listFiles().length)
                continue;

            if (userIndex == 0 && File.listRoots()[0] == currentFile)
                continue;

            currentFile = accederPadre(userIndex, currentFile) ? currentFile.getParentFile() : currentFile.listFiles()[userIndex - 1];
        }
    }

    private static boolean accederPadre(int userIndex, File file) {
        return userIndex == 0 && file.getParent() != null;
    }

    private static void imprimeFicheros(File file) {
        System.out.println("Lista de ficheros y directorios del directorio " + file + ":");
        System.out.println("---------------------------------------------------");
        System.out.println("0-Directorio padre");

        if (file.listFiles() == null)
            return;

        for (int i = 0; i < file.listFiles().length; i++) {
            System.out.println((i + 1 + "-" + file.listFiles()[i]));
        }
    }
}
