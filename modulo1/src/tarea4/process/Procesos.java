package tarea4.process;

import java.util.Random;
import java.util.Scanner;

import tarea4.Server.Servidores;

public class Procesos {
    private String nombre;
    private int tamano;
    private Servidores server1;
    private Servidores server2;

    public Procesos(String nombre, int tamano, Servidores server1, Servidores server2) {
        this.nombre = nombre;
        this.tamano = tamano;
        this.server1 = server1;
        this.server2 = server2;
    }

    public void asignarServidor() {
        // Determinar qué servidor tiene menos procesos encolados y asignar el proceso
        if (server1.getSize() < server2.getSize()) {
            server1.enqueue(this);
            System.out.println("Proceso " + this + " encolado en " + server1.getName());
        } else {
            server2.enqueue(this);
            System.out.println("Proceso " + this + " encolado en " + server2.getName());
        }
    }


    public static Procesos[] crearProcesosAleatorios(int cantidad, Servidores server1, Servidores server2) {
        Procesos[] procesos = new Procesos[cantidad];
        Random random = new Random();

        for (int i = 0; i < cantidad; i++) {
            int tamanoProceso = random.nextInt(100) + 1; // Tamaño aleatorio entre 1 y 100 MB
            procesos[i] = new Procesos("Proceso " + (i + 1), tamanoProceso, server1, server2);
        }

        return procesos;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public static void simularAsignacion(Servidores server1, Servidores server2) {
        Scanner scanner = new Scanner(System.in);

        int totalProcesos;
        do {
            System.out.print("Ingrese el número total de procesos a simular (mayor a 0): ");
            totalProcesos = scanner.nextInt();
        } while (totalProcesos <= 0);

        Procesos[] procesos = Procesos.crearProcesosAleatorios(totalProcesos, server1, server2);

        // Asignar procesos a los servidores
        for (Procesos proceso : procesos) {
            proceso.asignarServidor();
        }

        while (!server1.isEmpty() || !server2.isEmpty()) {
            // Verificar cuál de los servidores tiene un proceso para procesar
            if (!server1.isEmpty()) {
                Procesos procesoServer1 = server1.dequeue();
                System.out.println("Proceso " + procesoServer1 + " en " + server1.getName() + " está siendo procesado...");
                // Aquí puedes agregar la lógica de procesamiento específica para server1
                System.out.println("Proceso " + procesoServer1 + " en " + server1.getName() + " ha sido completado.");
            }

            if (!server2.isEmpty()) {
                Procesos procesoServer2 = server2.dequeue();
                System.out.println("Proceso " + procesoServer2 + " en " + server2.getName() + " está siendo procesado...");
                // Aquí puedes agregar la lógica de procesamiento específica para server2
                System.out.println("Proceso " + procesoServer2 + " en " + server2.getName() + " ha sido completado.");
            }
        }

        System.out.println("Todos los procesos han sido completados.");
        scanner.close();
    }

}
