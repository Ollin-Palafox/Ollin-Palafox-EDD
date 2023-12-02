package tarea8.process;
import utils.sorter.ArrayUtils;
public class BusquedaBinaria {
    public static int busquedaBinaria(int[] arr, int elemento) {
        int inicio = 0;
        int fin = arr.length - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;

            if (arr[medio] == elemento) {
                return medio; // Elemento encontrado, devuelve su índice
            }

            if (arr[medio] < elemento) {
                inicio = medio + 1; // Busca en la mitad derecha del subarreglo
            } else {
                fin = medio - 1; // Busca en la mitad izquierda del subarreglo
            }
        }

        return -1; // Elemento no encontrado en el arreglo
    }
    public static void buscarElementoBinario(int elementoBuscado, int[] arrayAleatorio) {
        int indiceEncontrado = BusquedaBinaria.busquedaBinaria(arrayAleatorio, elementoBuscado);

        if (indiceEncontrado != -1) {
            System.out.println("\nElemento " + elementoBuscado + " encontrado en el índice " + indiceEncontrado);
        } else {
            System.out.println("\nElemento " + elementoBuscado + " no encontrado en el arreglo.");
        }
    }


}

