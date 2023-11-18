package tarea14.process;

import utils.Nodo;
public class Arboles {

    Nodo raiz;

    public Arboles() {

        this.raiz = null;

    }

    public void insertar(int valor) {

        raiz = insertarRec(raiz, valor);

    }

    private Nodo insertarRec(Nodo raiz, int valor) {

        if (raiz == null) {

            raiz = new Nodo(valor);
            return raiz;

        }

        if (valor < raiz.valor) {

            raiz.izquierdo = insertarRec(raiz.izquierdo, valor);

        } else if (valor > raiz.valor) {

            raiz.derecho = insertarRec(raiz.derecho, valor);

        }
        return raiz;
    }

    public void imprimirEnOrden() {

        imprimirEnOrdenRec(raiz);

    }
    private void imprimirEnOrdenRec(Nodo raiz) {

        if (raiz != null) {

            imprimirEnOrdenRec(raiz.izquierdo);
            System.out.println(raiz.valor + " ");
            imprimirEnOrdenRec(raiz.derecho);

        }
    }
}

