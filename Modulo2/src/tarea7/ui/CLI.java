package tarea7.ui;

import utils.sorter.ArrayUtils;
import tarea7.process.BubbleSort;
import tarea7.process.InsertionSort;
import tarea7.process.SelectionSort;
import tarea7.process.ShellSort;
import tarea7.Orden.Metrica;


public class CLI {

    public static void Visual() {
        int[] arrayAleatorio = ArrayUtils.generarArrayAleatorio(200, 1, 500);

        System.out.println("Array original: ");
        ArrayUtils.imprimirArray(arrayAleatorio);

        Metrica MetricaBubbleSort = new Metrica();
        int[] arrayBubbleSort = arrayAleatorio.clone();
        BubbleSort.bubbleSort(arrayBubbleSort, MetricaBubbleSort);
        System.out.println("\nComparaciones del Bubble Sort: " + MetricaBubbleSort.getComparacion());
        System.out.println("Movimientos totales del Bubble Sort: " + MetricaBubbleSort.getMovimientos());

        Metrica MetricaSelectionSort = new Metrica();
        int[] arraySelectionSort = arrayAleatorio.clone();
        SelectionSort.selectionSort(arraySelectionSort, MetricaSelectionSort);
        System.out.println("\nComparaciones del Selection Sort: " + MetricaSelectionSort.getComparacion());
        System.out.println("Movimientos totales del Selection Sort: " + MetricaSelectionSort.getMovimientos());

        Metrica MetricaInsertionSort = new Metrica();
        int[] arrayInsertionSort = arrayAleatorio.clone();
        InsertionSort.insertionSort(arrayInsertionSort, MetricaInsertionSort);
        System.out.println("\nComparaciones del Insertion Sort: " + MetricaInsertionSort.getComparacion());
        System.out.println("Movimientos totales del Insertion Sort: " + MetricaInsertionSort.getMovimientos());

        Metrica MetricaShellSort = new Metrica();
        int[] arrayShellSort = arrayAleatorio.clone();
        ShellSort.shellSort(arrayShellSort, MetricaShellSort);
        System.out.println("\nComparaciones del Shell Sort: " + MetricaShellSort.getComparacion());
        System.out.println("Movimientos totales del Shell Sort: " + MetricaShellSort.getMovimientos());

        System.out.println("\nArray acomodado");
        ArrayUtils.imprimirArray(arrayBubbleSort);
    }
}
