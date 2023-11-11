package tarea13.process;

import java.util.Arrays;

public class Mediana {

    public static double calcularMediana(int[] numeros) {
        Arrays.sort(numeros);

        int longitud = numeros.length;

        if (longitud % 2 == 0) {
            int medio1 = numeros[longitud / 2 - 1];
            int medio2 = numeros[longitud / 2];
            return (double) (medio1 + medio2) / 2;
        } else {
            return numeros[longitud / 2];
        }
    }
}
