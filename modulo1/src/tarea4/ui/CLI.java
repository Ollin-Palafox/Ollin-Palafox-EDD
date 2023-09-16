package tarea4.ui;

import tarea4.Server.Servidores;

import java.util.Scanner;

import tarea4.process.Procesos;

public class CLI {
    public static void main() {
        Servidores server1 = new Servidores("Server 1", 1000); // 1 GHz
        Servidores server2 = new Servidores("Server 2", 2000); // 2 GHz

        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("Menú:");
            System.out.println("1. Simular asignación de procesos");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    Procesos.simularAsignacion(server1, server2);
                    break;
                case 2:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        } while (opcion != 2);

        scanner.close();
    }
}