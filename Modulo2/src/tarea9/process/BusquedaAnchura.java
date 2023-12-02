package tarea9.process;

import utils.Grafo;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BusquedaAnchura {

    public static void BuscarenAnchura(Grafo grafo, Grafo.Vertice inicio) {
        Queue<Grafo.Vertice> cola = new LinkedList<>();
        cola.add(inicio);

        HashSet<Grafo.Vertice> visitados = new HashSet<>();
        visitados.add(inicio);

        while (!cola.isEmpty()) {
            Grafo.Vertice actual = cola.poll();
            System.out.print(actual.name() + " ");

            for (Grafo.Arista arista : grafo.obtenerAdyacencias(actual)) {
                Grafo.Vertice vecino = arista.v2();
                if (!visitados.contains(vecino)) {
                    visitados.add(vecino);
                    cola.add(vecino);
                }
            }
        }
    }
}