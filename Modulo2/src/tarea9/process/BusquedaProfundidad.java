package tarea9.process;

import utils.Grafo;

import java.util.HashSet;
import java.util.Stack;

public class BusquedaProfundidad {

    public static void BuscarenProfundidad(Grafo grafo, Grafo.Vertice inicio) {
        Stack<Grafo.Vertice> pila = new Stack<>();
        pila.push(inicio);

        HashSet<Grafo.Vertice> visitados = new HashSet<>();
        visitados.add(inicio);

        while (!pila.isEmpty()) {
            Grafo.Vertice actual = pila.pop();
            System.out.print(actual.name() + " ");

            for (Grafo.Arista arista : grafo.obtenerAdyacencias(actual)) {
                Grafo.Vertice vecino = arista.v2();
                if (!visitados.contains(vecino)) {
                    visitados.add(vecino);
                    pila.push(vecino);
                }
            }
        }
    }
}