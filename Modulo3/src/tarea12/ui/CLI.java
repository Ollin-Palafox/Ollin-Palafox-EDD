package tarea12.ui;

import tarea12.process.BusquedaBinaria;
import tarea12.process.Factorial;
import tarea12.process.Fibonacci;

import java.util.Scanner;

public class CLI {
    public static void Visual() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== Menú Principal ===");
            System.out.println("1. Fibonacci");
            System.out.println("2. Búsqueda Binaria");
            System.out.println("3. Factorial");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    while (true) {
                        System.out.println("=== Menú Fibonacci ===");
                        System.out.println("1. Calcular término (Recursivo)");
                        System.out.println("2. Calcular término (Iterativo)");
                        System.out.println("3. Volver al Menú Principal");
                        System.out.print("Seleccione una opción: ");

                        int fibOpcion = scanner.nextInt();

                        switch (fibOpcion) {
                            case 1:
                                System.out.print("Ingrese el valor de n: ");
                                int n = scanner.nextInt();
                                System.out.println("Resultado (Recursivo): " + Fibonacci.fnRecursivo(n));
                                break;
                            case 2:
                                System.out.print("Ingrese el valor de n: ");
                                n = scanner.nextInt();
                                System.out.println("Resultado (Iterativo): " + Fibonacci.fnIterativo(n));
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Opción no válida. Por favor, seleccione nuevamente.");
                        }

                        if (fibOpcion == 3) {
                            break;
                        }
                    }
                    break;

                case 2:
                    while (true) {
                        System.out.println("=== Menú Búsqueda Binaria ===");
                        System.out.println("1. Buscar elemento (Recursivo)");
                        System.out.println("2. Buscar elemento (Iterativo)");
                        System.out.println("3. Volver al Menú Principal");
                        System.out.print("Seleccione una opción: ");

                        int binariaOpcion = scanner.nextInt();

                        switch (binariaOpcion) {
                            case 1:
                                int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
                                System.out.print("Ingrese el elemento a buscar: ");
                                int elemento = scanner.nextInt();
                                System.out.println("Resultado (Recursivo): " + BusquedaBinaria.BinariaRecursiva(arr, elemento, 0, arr.length - 1));
                                break;
                            case 2:
                                arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
                                System.out.print("Ingrese el elemento a buscar: ");
                                elemento = scanner.nextInt();
                                System.out.println("Resultado (Iterativo): " + BusquedaBinaria.BinariaIterativa(arr, elemento));
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Opción no válida. Por favor, seleccione nuevamente.");
                        }

                        if (binariaOpcion == 3) {
                            break;
                        }
                    }
                    break;

                case 3:
                    while (true) {
                        System.out.println("=== Menú Factorial ===");
                        System.out.println("1. Calcular factorial (Recursivo)");
                        System.out.println("2. Calcular factorial (Iterativo)");
                        System.out.println("3. Volver al Menú Principal");
                        System.out.print("Seleccione una opción: ");

                        int factOpcion = scanner.nextInt();

                        switch (factOpcion) {
                            case 1:
                                System.out.print("Ingrese el valor de n: ");
                                int n = scanner.nextInt();
                                System.out.println("Resultado (Recursivo): " + Factorial.fcRecursivo(n));
                                break;
                            case 2:
                                System.out.print("Ingrese el valor de n: ");
                                n = scanner.nextInt();
                                System.out.println("Resultado (Iterativo): " + Factorial.fcIterativo(n));
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Opción no válida. Por favor, seleccione nuevamente.");
                        }

                        if (factOpcion == 3) {
                            break;
                        }
                    }
                    break;

                case 4:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, seleccione nuevamente.");
            }
        }
    }
}
