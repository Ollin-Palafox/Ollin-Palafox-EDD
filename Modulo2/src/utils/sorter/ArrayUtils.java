package utils.sorter;

import java.util.Random;

public class ArrayUtils {
    public static int[] generarArrayAleatorio(int longitud, int min, int max) {
        int[] arrayAleatorio = new int[longitud];
        Random random = new Random();

        for (int i = 0; i < longitud; i++) {
            arrayAleatorio[i] = random.nextInt(max - min + 1) + min;
        }

        return arrayAleatorio;
    }

    public static void imprimirArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);

            if (i < array.length - 1) {
                System.out.print(", ");
            }

            if ((i + 1) % 15 == 0) {
                System.out.println();
            }
        }

    }
}