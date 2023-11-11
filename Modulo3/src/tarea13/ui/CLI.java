package tarea13.ui;

import tarea13.process.Mediana;

import java.util.Scanner;

public class CLI {

    public static void Visual() {
        System.out.println("¿Qué tan grande deseas que sea tu arreglo?");
        Scanner scanner = new Scanner(System.in);
        int tamano = scanner.nextInt();
        int[] numeros = new int[tamano];

        for (int i = 0; i < tamano; i++) {
            System.out.println("Inserta el dígito " + (i + 1));
            numeros[i] = scanner.nextInt();
        }

        scanner.close();

        for (int num : numeros) {
            System.out.print(num + " | ");
        }

        double mediana = Mediana.calcularMediana(numeros);
        System.out.println("\nLa mediana del arreglo es: " + mediana);
    }
}
