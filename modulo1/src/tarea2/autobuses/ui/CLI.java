package tarea2.autobuses.ui;

import tarea2.autobuses.process.Pasajeros;
import java.util.Scanner;
public class CLI {
    public static void Menu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nOpciones:");
            System.out.println("1. Agregar pasajero");
            System.out.println("2. Eliminar pasajero");
            System.out.println("3. Visualizar datos de pasajero");
            System.out.println("4. Cargar pasajeros desde archivo");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa el nombre del pasajero: ");
                    scanner.nextLine(); // Consume la nueva línea pendiente
                    String nombre = scanner.nextLine();
                    System.out.print("Ingresa la edad del pasajero: ");
                    int edad = scanner.nextInt();
                    Pasajeros nuevoPasajero = new Pasajeros(nombre, edad);
                    Pasajeros.agregarPasajero(nuevoPasajero);
                    break;

                case 2:
                    System.out.print("Ingresa el índice del pasajero a eliminar: ");
                    int indiceEliminar = scanner.nextInt();
                    Pasajeros.eliminarPasajero(indiceEliminar);
                    break;

                case 3:
                    System.out.print("Ingresa el índice del pasajero a visualizar: ");
                    int indiceVisualizar = scanner.nextInt();
                    Pasajeros.visualizarPasajero(indiceVisualizar);
                    break;

                case 4:
                    Pasajeros.cargarPasajerosDesdeArchivo();
                    break;

                case 5:
                    System.out.println("¡Hasta luego!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}
