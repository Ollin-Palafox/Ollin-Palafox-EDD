package tarea2.autobuses.process;

import tarea2.utils.ListaEnlazada;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Pasajeros {
    private String nombre;
    private int edad;
    private static ListaEnlazada<Pasajeros> listaPasajeros = new ListaEnlazada<>();

    public Pasajeros(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Edad: " + edad;
    }

    public static void agregarPasajero(Pasajeros pasajero) {
        listaPasajeros.add(pasajero);
        int indice = listaPasajeros.size() - 1;
        System.out.println("Pasajero agregado en el índice: " + indice);
    }

    public static void eliminarPasajero(int indice) {
        if (indice >= 0 && indice < listaPasajeros.size()) {
            Pasajeros pasajeroEliminado = listaPasajeros.get(indice).orElse(null);
            if (pasajeroEliminado != null) {
                listaPasajeros.remove(pasajeroEliminado);
                System.out.println("Pasajero eliminado: " + pasajeroEliminado);
            }
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public static void visualizarPasajero(int indice) {
        if (indice >= 0 && indice < listaPasajeros.size()) {
            Pasajeros pasajeroVisualizar = listaPasajeros.get(indice).orElse(null);
            if (pasajeroVisualizar != null) {
                System.out.println("Datos del pasajero: " + pasajeroVisualizar);
            }
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public static void cargarPasajerosDesdeArchivo() {
        try {
            File file = new File("C:\\Users\\ollin\\OneDrive\\Documentos\\pasajeros.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String nombre = parts[0];
                    int edad = Integer.parseInt(parts[1]);
                    Pasajeros pasajero = new Pasajeros(nombre, edad);
                    Pasajeros.agregarPasajero(pasajero);
                }
            }
            scanner.close();
            System.out.println("Pasajeros cargados desde el archivo.");
        } catch (IOException e) {
            System.out.println("Error al cargar los pasajeros: " + e.getMessage());
        }
    }
}