package tarea7.process;

import tarea7.Orden.Metrica;

public class ShellSort {

    public static void shellSort(int[] array, Metrica metricales) {


        int n = array.length;
        int intervalo = 1;

        while (intervalo < n / 3) {
            intervalo = intervalo * 3 + 1;
        }

        while (intervalo > 0) {

            for (int i = intervalo; i < n; i++) {
                int temp = array[i];
                int j = i;

                while (j >= intervalo && array[j - intervalo] > temp) {
                    array[j] = array[j - intervalo];
                    j -= intervalo;
                    metricales.incrementComparacion();
                }

                array[j] = temp;
                metricales.incrementMovimientos();
            }

            intervalo = (intervalo - 1) / 3;
        }
    }

}