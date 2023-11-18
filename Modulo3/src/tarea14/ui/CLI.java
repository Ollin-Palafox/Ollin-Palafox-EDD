package tarea14.ui;

import tarea14.process.Arboles;
public class CLI {
    public static void Visual() {

        Arboles arbol = new Arboles();

        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(70);
        arbol.insertar(20);
        arbol.insertar(40);
        arbol.insertar(60);
        arbol.insertar(80);

        System.out.println("Árbol en orden: ");
        arbol.imprimirEnOrden();
    }
}
