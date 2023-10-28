package tarea11.ui;

import tarea11.process.HashTable;

import java.util.Scanner;

public class CLI {
    public static void Menu() {
        HashTable<String, Integer> Tabla = new HashTable<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar elemento");
            System.out.println("2. Imprimir tamaño de la tabla");
            System.out.println("3. Eliminar elemento");
            System.out.println("4. Verificar la existencia de un elemento");
            System.out.println("5. Imprimir la tabla");
            System.out.println("0. Salir");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la clave: ");
                    String clave = scanner.next();
                    System.out.print("Ingrese el valor: ");
                    int valor = scanner.nextInt();
                    Tabla.add(clave, valor);
                    break;
                case 2:
                    Tabla.Tamano();
                    break;
                case 3:
                    System.out.print("Ingrese la clave a eliminar: ");
                    String claveAEliminar = scanner.next();
                    Tabla.eliminarElemento(claveAEliminar);
                    break;
                case 4:
                    System.out.print("Ingrese la clave a verificar: ");
                    String claveAVerificar = scanner.next();
                    if (Tabla.getByKey(claveAVerificar) == null) {
                        System.out.println("Clave no encontrada");
                    }
                    else {
                    Integer valorVerificado = Tabla.getByKey(claveAVerificar);
                    System.out.println("Valor asociado a la clave: " + valorVerificado);
                    }
                    break;
                case 5:
                    Tabla.imprimirElementos();
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        }
    }
}
