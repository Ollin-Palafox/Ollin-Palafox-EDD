package Reinas.process;

import Reinas.ui.CLI;
public class Operaciones {
    private static final int N = 8;
    private static final int[] reinas = new int[N];
    private static int soluciones = 0;

    public static void EncontrarSoluciones(int fila) {
        if (fila == N) {
            soluciones++;
            System.out.println("Solución " + soluciones + ":");
            CLI.ImprimirSolucion(reinas);
            return;
        }

        for (int columna = 0; columna < N; columna++) {
            if (valido(fila, columna)) {
                reinas[fila] = columna;
                EncontrarSoluciones(fila + 1);
            }
        }
    }

    static boolean valido(int fila, int columna) {
        for (int i = 0; i < fila; i++) {
            if (reinas[i] == columna || reinas[i] - i == columna - fila || reinas[i] + i == columna + fila) {
                return false;
            }
        }
        return true;
    }

}
