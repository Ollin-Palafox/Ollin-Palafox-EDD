package tarea4.Server;

import tarea4.process.Procesos;
import java.util.LinkedList;
import java.util.Queue;
import java.util.EmptyStackException;

public class Servidores {
    private String nombre;
    private int velocidad; // Velocidad en MHz
    private Queue<Procesos> colaProcesos = new LinkedList<>();

    public Servidores(String nombre, int velocidad) {
        this.nombre = nombre;
        this.velocidad = velocidad;
    }

    public String getName() {
        return nombre;
    }

    public int getSpeed() {
        return velocidad;
    }

    public void enqueue(Procesos proceso) {
        colaProcesos.add(proceso);
    }

    public Procesos dequeue() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return colaProcesos.poll();
    }

    public boolean isEmpty() {
        return colaProcesos.isEmpty();
    }

    public int getSize() {
        return colaProcesos.size();
    }
}
