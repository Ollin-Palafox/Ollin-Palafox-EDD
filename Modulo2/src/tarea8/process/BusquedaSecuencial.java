package tarea8.process;

import utils.sorter.ArrayUtils;

public class BusquedaSecuencial {
    public static int busquedaSecuencial(int[] arr, int elemento) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == elemento) {
                return i; // Elemento encontrado, devuelve su índice
            }
        }
        return -1; // Elemento no encontrado en el arreglo
    }

    public static void buscarElementoSecuencial(int elementoBuscado, int[] arrayAleatorio) {
        int indiceEncontrado = BusquedaBinaria.busquedaBinaria(arrayAleatorio, elementoBuscado);

        if (indiceEncontrado != -1) {
            System.out.println("\nElemento " + elementoBuscado + " encontrado en el índice " + indiceEncontrado);
        } else {
            System.out.println("\nElemento " + elementoBuscado + " no encontrado en el arreglo.");
        }
    }
}
