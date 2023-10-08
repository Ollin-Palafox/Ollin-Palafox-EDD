package tarea7.process;

import tarea7.Orden.Metrica;

public class InsertionSort {

    public static void insertionSort(int[] array, Metrica metricales) {

        for (int i = 1; i < array.length; i++) {
            int tem = array[i];

            int j = i - 1;

            while (j >= 0 && array[j] > tem) {
                metricales.incrementComparacion();

                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = tem;
            metricales.incrementMovimientos();
        }

    }

}