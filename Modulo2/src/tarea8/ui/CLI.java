package tarea8.ui;
import tarea8.process.BusquedaBinaria;
import tarea8.process.BusquedaSecuencial;
import utils.sorter.ArrayUtils;
import java.util.Scanner;
import static tarea8.process.Sorting.realizarSorting;


public class CLI {

    public static void Visual() {
        int elementoBuscado;
        Scanner scanner = new Scanner(System.in);

        int[] arrayAleatorio = ArrayUtils.generarArrayAleatorio(200, 1, 500);

        System.out.println("\nArray original: ");
        ArrayUtils.imprimirArray(arrayAleatorio);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Realizar el Sorting");
            System.out.println("2. Búsqueda Secuencial");
            System.out.println("3. Búsqueda Binaria");
            System.out.println("4. Salir");

            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    realizarSorting(arrayAleatorio);
                    break;
                case 2:
                    System.out.print("Ingrese el elemento que desea buscar (Búsqueda Secuencial): ");
                    elementoBuscado = scanner.nextInt();
                    BusquedaSecuencial.buscarElementoSecuencial(elementoBuscado, arrayAleatorio);
                    break;
                case 3:
                    System.out.print("Ingrese el elemento que desea buscar (Búsqueda Binaria): ");
                    elementoBuscado = scanner.nextInt();
                    BusquedaBinaria.buscarElementoBinario(elementoBuscado, arrayAleatorio);
                    break;
                case 4:
                    System.out.println("¡Adiós!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }
}
