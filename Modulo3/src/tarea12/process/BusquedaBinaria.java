package tarea12.process;

public class BusquedaBinaria {
    // Método recursivo para realizar búsqueda binaria en un arreglo ordenado
    public static int BinariaRecursiva(int[] arr, int elemento, int inicio, int fin) {
        if (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;

            if (arr[medio] == elemento) {
                return medio;
            } else if (arr[medio] < elemento) {
                return BinariaRecursiva(arr, elemento, medio + 1, fin);
            } else {
                return BinariaRecursiva(arr, elemento, inicio, medio - 1);
            }
        }

        return -1; // Elemento no encontrado
    }

    // Método iterativo para realizar búsqueda binaria en un arreglo ordenado
    public static int BinariaIterativa(int[] arr, int elemento) {
        int inicio = 0;
        int fin = arr.length - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;

            if (arr[medio] == elemento) {
                return medio;
            } else if (arr[medio] < elemento) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }

        return -1; // Elemento no encontrado
    }
}
