package tarea7.process;

import tarea7.Orden.Metrica;

public class BubbleSort {

    public static void bubbleSort(int[] array, Metrica metricales) {

        int n = array.length;
        boolean intercambiado;

        do {
            intercambiado = false;

            for (int i = 1; i < n; i++) {
                metricales.incrementComparacion();

                if (array[i - 1] > array[i]) {

                    int tem = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = tem;

                    metricales.incrementMovimientos();

                    intercambiado = true;
                }
            }
            n--;
        } while (intercambiado);

    }

}