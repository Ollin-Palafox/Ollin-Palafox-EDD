package tarea15.ui;

import tarea15.process.ArbolDosTres;

import java.util.Scanner;

public class CLI {
    public static void Visual() {
        ArbolDosTres<Integer, String> arbol = new ArbolDosTres<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== Menú ====");
            System.out.println("1. Insertar elemento");
            System.out.println("2. Buscar elemento");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la clave (entero): ");
                    int clave = scanner.nextInt();
                    System.out.print("Ingrese el valor (cadena): ");
                    String valor = scanner.next();
                    arbol.insertar(clave, valor);
                    System.out.println("Elemento insertado con éxito.");
                    break;

                case 2:
                    System.out.print("Ingrese la clave a buscar: ");
                    int claveBusqueda = scanner.nextInt();
                    String resultado = arbol.buscar(claveBusqueda);
                    if (resultado != null) {
                        System.out.println("Resultado de la búsqueda: " + resultado);
                    } else {
                        System.out.println("La clave no fue encontrada.");
                    }
                    break;

                case 3:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    System.exit(0);

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
