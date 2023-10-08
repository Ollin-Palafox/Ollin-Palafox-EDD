package tarea8.process;
import tarea8.Orden.Metrica;
public class MergeSort {
        public static void mergeSort(int[] arr, Metrica metrica) {
            mergeSort(arr, 0, arr.length - 1, metrica);
        }

        private static void mergeSort(int[] arr, int inicio, int fin, Metrica metrica) {
            if (inicio < fin) {
                int medio = (inicio + fin) / 2;
                mergeSort(arr, inicio, medio, metrica);
                mergeSort(arr, medio + 1, fin, metrica);
                merge(arr, inicio, medio, fin, metrica);
            }
        }

    private static void merge(int[] arr, int inicio, int medio, int fin, Metrica metrica) {
        int n1 = medio - inicio + 1;
        int n2 = fin - medio;

        int[] izquierda = new int[n1];
        int[] derecha = new int[n2];

        for (int i = 0; i < n1; i++) {
            izquierda[i] = arr[inicio + i];
        }
        for (int i = 0; i < n2; i++) {
            derecha[i] = arr[medio + 1 + i];
        }

        int i = 0, j = 0;
        int k = inicio;

        while (i < n1 && j < n2) {
            if (izquierda[i] <= derecha[j]) {
                arr[k] = izquierda[i];
                i++;
            } else {
                arr[k] = derecha[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = izquierda[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = derecha[j];
            j++;
            k++;
        }
    }
}
