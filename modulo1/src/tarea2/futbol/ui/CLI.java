package tarea2.futbol.ui;

import tarea2.futbol.process.Jugadores;
import tarea2.utils.ListaEnlazada;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class CLI {
    private static String nombreCapitan1 = "";
    private static String nombreCapitan2 = "";
    public static void Partido() {
        ListaEnlazada<Jugadores> jugadoresDisponibles = new ListaEnlazada<>();
        ListaEnlazada<Jugadores> equipo1 = new ListaEnlazada<>();
        ListaEnlazada<Jugadores> equipo2 = new ListaEnlazada<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Deseas ingresar los nombres manualmente (M) o cargar desde archivo (A)?");
        String opcion = scanner.nextLine();

        if (opcion.equalsIgnoreCase("M")) {
            // Pedir nombres de capitanes
            nombreCapitan1 = pedirNombreCapitan(1, scanner);
            nombreCapitan2 = pedirNombreCapitan(2, scanner);

            // Crear capitanes y agregarlos a los equipos
            Jugadores capitan1 = new Jugadores(nombreCapitan1, 1, true);
            Jugadores capitan2 = new Jugadores(nombreCapitan2, 2, true);
            equipo1.add(capitan1);
            equipo2.add(capitan2);

            // Pedir nombres de jugadores y almacenar en lista de jugadores disponibles
            for (int i = 1; i <= 8; i++) {
                String nombreJugador = pedirNombreJugador(i, scanner);
                jugadoresDisponibles.add(new Jugadores(nombreJugador, i, false));
            }
        } else if (opcion.equalsIgnoreCase("A")) {
            cargarNombresDesdeArchivo(jugadoresDisponibles);
        } else {
            System.out.println("Opción no válida. Saliendo del programa.");
            return;
        }

        // Seleccionar jugadores por capitanes
        seleccionarJugadores(jugadoresDisponibles, equipo1, nombreCapitan1, scanner);
        seleccionarJugadores(jugadoresDisponibles, equipo2, nombreCapitan2, scanner);

        // Imprimir equipos
        System.out.println("\nEquipo 1:");
        imprimirEquipo(equipo1, nombreCapitan1);

        System.out.println("\nEquipo 2:");
        imprimirEquipo(equipo2, nombreCapitan2);
    }

    public static String pedirNombreCapitan(int equipoNumero, Scanner scanner) {
        System.out.print("Nombre del capitán del equipo " + equipoNumero + ": ");
        return scanner.nextLine();
    }

    public static String pedirNombreJugador(int jugadorNumero, Scanner scanner) {
        System.out.print("Nombre del jugador " + jugadorNumero + ": ");
        return scanner.nextLine();
    }

    public static void seleccionarJugadores(ListaEnlazada<Jugadores> jugadoresDisponibles, ListaEnlazada<Jugadores> equipo, String nombreCapitan, Scanner scanner) {
        System.out.println("\nCapitán " + nombreCapitan + ", selecciona tus jugadores:");
        for (int i = 0; i < 4; i++) {
            String nombreJugador = pedirNombreJugador(i + 1, scanner);
            Jugadores jugadorSeleccionado = Jugadores.buscarYRemoverJugador(jugadoresDisponibles, nombreJugador).orElse(null);
            if (jugadorSeleccionado == null) {
                System.out.println("Error: Jugador no encontrado o ya seleccionado.");
                i--;
            } else {
                equipo.add(jugadorSeleccionado);
            }
        }
    }
    public static void cargarNombresDesdeArchivo(ListaEnlazada<Jugadores> jugadoresDisponibles) {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ollin\\OneDrive\\Documentos\\nombres.txt"))) {
            String line;
            boolean capitan1Loaded = false;
            boolean capitan2Loaded = false;

            while ((line = br.readLine()) != null) {
                if (!capitan1Loaded) {
                    nombreCapitan1 = line;
                    capitan1Loaded = true;
                } else if (!capitan2Loaded) {
                    nombreCapitan2 = line;
                    capitan2Loaded = true;
                } else {
                    jugadoresDisponibles.add(new Jugadores(line, jugadoresDisponibles.size() + 1, false));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public static void imprimirEquipo(ListaEnlazada<Jugadores> equipo, String nombreCapitan) {
        System.out.println("Capitán: " + nombreCapitan);

        for (int i = 0; i < equipo.size(); i++) {
            Jugadores jugador = equipo.get(i).orElse(null);
            if (jugador != null) {
                System.out.println(jugador.toString());
            }
        }
    }

}
