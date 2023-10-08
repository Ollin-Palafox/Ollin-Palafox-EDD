package tarea8.process;

import tarea8.Orden.Metrica;

public class HeapSort {
    public static void heapSort(int[] arr, Metrica metrica) {
        int n = arr.length;

        // Construye un max heap (montículo máximo)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extrae elementos del max heap uno por uno
        for (int i = n - 1; i > 0; i--) {
            // Intercambia el elemento raíz (el más grande) con el último elemento del heap
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Llama a heapify en el heap reducido
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int mayor = i;
        int izquierda = 2 * i + 1;
        int derecha = 2 * i + 2;

        // Si el hijo izquierdo es más grande que el nodo raíz
        if (izquierda < n && arr[izquierda] > arr[mayor]) {
            mayor = izquierda;
        }

        // Si el hijo derecho es más grande que el nodo raíz
        if (derecha < n && arr[derecha] > arr[mayor]) {
            mayor = derecha;
        }

        // Si el mayor no es el nodo raíz
        if (mayor != i) {
            int temp = arr[i];
            arr[i] = arr[mayor];
            arr[mayor] = temp;

            // Recursivamente hace heapify en el subárbol afectado
            heapify(arr, n, mayor);
        }
    }
}
