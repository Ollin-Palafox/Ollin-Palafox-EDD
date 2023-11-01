package tarea8.process;

import tarea8.Orden.Metrica;

public class QuickSort {
    public static void quickSort(int[] arr, Metrica metrica) {
        if (arr == null || arr.length == 0) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int indicePivote = particion(arr, izquierda, derecha);

            // Llamadas recursivas para ordenar las dos sub-arrays
            quickSort(arr, izquierda, indicePivote - 1);
            quickSort(arr, indicePivote + 1, derecha);
        }
    }

    private static int particion(int[] arr, int izquierda, int derecha) {
        int pivote = arr[derecha]; // Elegimos el último elemento como pivote
        int i = izquierda - 1; // Índice del elemento más pequeño

        for (int j = izquierda; j < derecha; j++) {
            // Si el elemento actual es menor o igual al pivote
            if (arr[j] <= pivote) {
                i++;

                // Intercambiamos arr[i] y arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                Metrica.incrementComparacion(); // Comparación
                Metrica.incrementMovimientos();
            }
        }

        // Intercambiamos arr[i+1] y arr[derecha] (el pivote)
        int temp = arr[i + 1];
        arr[i + 1] = arr[derecha];
        arr[derecha] = temp;

        return i + 1;
    }
}
