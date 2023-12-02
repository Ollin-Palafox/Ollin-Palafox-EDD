package tarea8.process;
import tarea8.Orden.Metrica;
import utils.sorter.ArrayUtils;

public class Sorting {
    public static void realizarSorting(int[] arrayAleatorio) {

        // Agrega Merge Sort aquí
        Metrica MetricaMergeSort = new Metrica();
        int[] arrayMergeSort = arrayAleatorio.clone();
        MergeSort.mergeSort(arrayMergeSort, MetricaMergeSort);
        System.out.println("\nComparaciones del Merge Sort: " + MetricaMergeSort.getComparacion());
        System.out.println("Movimientos totales del Merge Sort: " + MetricaMergeSort.getMovimientos());

        // Agrega Quick Sort aquí
        Metrica MetricaQuickSort = new Metrica();
        int[] arrayQuickSort = arrayAleatorio.clone();
        QuickSort.quickSort(arrayQuickSort, MetricaQuickSort);
        System.out.println("\nComparaciones del Quick Sort: " + MetricaQuickSort.getComparacion());
        System.out.println("Movimientos totales del Quick Sort: " + MetricaQuickSort.getMovimientos());

        Metrica MetricaHeapSort = new Metrica();
        int[] arrayHeapSort = arrayAleatorio.clone();
        HeapSort.heapSort(arrayHeapSort, MetricaHeapSort);
        System.out.println("\nComparaciones del Heap Sort: " + MetricaHeapSort.getComparacion());
        System.out.println("Movimientos totales del Heap Sort: " + MetricaHeapSort.getMovimientos());

        System.out.println("\nArray acomodado");
        ArrayUtils.imprimirArray(arrayQuickSort);
    }
}
