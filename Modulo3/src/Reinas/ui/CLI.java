package Reinas.ui;

import Reinas.process.Operaciones;

public class CLI {
    public static void Visual() {
        Operaciones.EncontrarSoluciones(0);
    }

    public static void ImprimirSolucion(int[] queens) {
        for (int queen : queens) {
            for (int j = 0; j < queens.length; j++) {
                if (queen == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}