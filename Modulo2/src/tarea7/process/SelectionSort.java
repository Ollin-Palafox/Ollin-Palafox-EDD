package tarea7.process;

import tarea7.Orden.Metrica;

public class SelectionSort {

    public static void selectionSort(int[] array, Metrica metricales) {

        for (int i = 0; i < array.length - 1; i++) {
            int min = i;

            for (int j = i + 1; j < array.length; j++) {
                metricales.incrementComparacion();

                if (array[min] > array[j]) {
                    min = j;
                }
            }

            int tem = array[i];
            array[i] = array[min];
            array[min] = tem;
            metricales.incrementMovimientos();
        }

    }

}