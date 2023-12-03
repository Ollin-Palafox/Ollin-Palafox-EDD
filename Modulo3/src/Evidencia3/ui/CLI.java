package Evidencia3.ui;

import Evidencia3.process.ArbolBinario;

import java.util.Scanner;

public class CLI {
    private static ArbolBinario arbolBinario;
    private static Scanner scanner = new Scanner(System.in);

    public static void iniciarJuego() {
        arbolBinario = new ArbolBinario(); // Inicializa el árbol antes de iniciar el juego

        System.out.println("Bienvenido al juego de adivinanzas de animales!");
        String jugarDeNuevo;

        do {
            System.out.println("Piensa en un animal y presiona Enter para comenzar a adivinar.");
            scanner.nextLine();

            arbolBinario.adivinarAnimal();

            System.out.println("¿Quieres jugar de nuevo? (si/no)");
            jugarDeNuevo = scanner.nextLine().toLowerCase();

        } while ("si".equals(jugarDeNuevo));

        System.out.println("Gracias por jugar. Hasta luego!");
    }
}

