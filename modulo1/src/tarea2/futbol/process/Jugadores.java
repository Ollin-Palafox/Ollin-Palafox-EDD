package tarea2.futbol.process;

import tarea2.utils.ListaEnlazada;

import java.util.Optional;
public class Jugadores {
    private String nombre;
    private int numeroCamiseta;
    private boolean esCapitan;

    public Jugadores(String nombre, int numeroCamiseta, boolean esCapitan) {
        this.nombre = nombre;
        this.numeroCamiseta = numeroCamiseta;
        this.esCapitan = esCapitan;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumeroCamiseta() {
        return numeroCamiseta;
    }

    public boolean esCapitan() {
        return esCapitan;
    }

    public boolean esIgual(String otroNombre) {
        return nombre.equalsIgnoreCase(otroNombre);
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Camiseta: " + numeroCamiseta + (esCapitan ? " (Capitán)" : "");
    }

    public static Optional<Jugadores> buscarYRemoverJugador(ListaEnlazada<Jugadores> jugadores, String nombre) {
        for (int i = 0; i < jugadores.size(); i++) {
            Jugadores jugador = jugadores.get(i).orElse(null);
            if (jugador != null && jugador.getNombre().equalsIgnoreCase(nombre)) {
                jugadores.remove(jugador);
                return Optional.of(jugador);
            }
        }
        return Optional.empty();
    }
}
