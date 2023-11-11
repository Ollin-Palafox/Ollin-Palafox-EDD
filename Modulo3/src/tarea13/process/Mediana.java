package tarea13.process;

public class Mediana {

    public static double calcularMediana(int[] numeros) {
        quickSort(numeros, 0, numeros.length - 1);

        int longitud = numeros.length;

        if (longitud % 2 == 0) {
            int medio1 = numeros[longitud / 2 - 1];
            int medio2 = numeros[longitud / 2];
            return (double) (medio1 + medio2) / 2;
        } else {
            return numeros[longitud / 2];
        }
    }

    private static void quickSort(int[] arr, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int indiceParticion = particion(arr, izquierda, derecha);

            quickSort(arr, izquierda, indiceParticion - 1);
            quickSort(arr, indiceParticion + 1, derecha);
        }
    }

    private static int particion(int[] arr, int izquierda, int derecha) {
        int pivote = arr[derecha];
        int i = izquierda - 1;

        for (int j = izquierda; j < derecha; j++) {
            if (arr[j] <= pivote) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[derecha];
        arr[derecha] = temp;

        return i + 1;
    }
}

