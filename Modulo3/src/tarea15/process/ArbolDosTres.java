package tarea15.process;

import utils.Nodo32;

public class ArbolDosTres<K extends Comparable<K>, V> {
    private Nodo32<K, V> raiz;

    public void insertar(K clave, V valor) {
        if (raiz == null) {
            raiz = new Nodo32<>();
            raiz.agregarElemento(clave, valor);
        } else {
            insertarEnNodo(raiz, clave, valor);
        }
    }

    private void insertarEnNodo(Nodo32<K, V> nodo, K clave, V valor) {
        if (nodo.estaLleno()) {
            // Dividir el nodo si está lleno
            dividirNodo(nodo);
            // Seleccionar el hijo correcto después de la división
            int i = (clave.compareTo(nodo.claves[0]) < 0) ? 0 : 1;
            insertarEnNodo(nodo.hijos[i], clave, valor);
        } else {
            // Insertar en un nodo no lleno
            nodo.agregarElemento(clave, valor);
        }
    }

    private void dividirNodo(Nodo32<K, V> nodo) {
        if (nodo.estaLleno()) {
            // Crear un nuevo nodo temporal para contener los elementos del nodo actual
            Nodo32<K, V> nuevoNodo = new Nodo32<>();

            // Mover el tercer elemento a la raíz temporal
            nuevoNodo.agregarElemento(nodo.claves[2], nodo.valores[2]);

            // Crear un nuevo nodo derecho con el segundo elemento del nodo actual
            Nodo32<K, V> nuevoDerecho = new Nodo32<>();
            nuevoDerecho.agregarElemento(nodo.claves[1], nodo.valores[1]);
            nuevoDerecho.hijos[0] = nodo.hijos[1];
            nuevoDerecho.hijos[1] = nodo.hijos[2];

            // Actualizar el nodo actual con el primer elemento y el nuevo hijo izquierdo
            nodo.claves[1] = nodo.claves[0];
            nodo.valores[1] = nodo.valores[0];
            nodo.hijos[1] = nodo.hijos[0];

            // Actualizar el nodo actual con el nuevo hijo izquierdo y el nuevo derecho
            nodo.hijos[0] = nuevoNodo;
            nodo.hijos[2] = nuevoDerecho;

            // Limpiar el tercer elemento en el nodo actual
            nodo.claves[0] = null;
            nodo.valores[0] = null;

            // Limpiar el tercer hijo en el nodo actual
            nodo.hijos[2] = null;

            // Redefinir la cantidad de elementos en el nodo actual
            nodo.cantidadElementos = 1;
        }
    }

    public V buscar(K clave) {
        return buscarEnNodo(raiz, clave);
    }

    private V buscarEnNodo(Nodo32<K, V> nodo, K clave) {
        if (nodo == null) {
            return null; // La clave no se encontró en el árbol
        }

        // Comprobar si la clave está en el nodo actual
        for (int i = 0; i < nodo.cantidadElementos; i++) {
            int comparacion = clave.compareTo(nodo.claves[i]);
            if (comparacion == 0) {
                // La clave se encontró, devolver el valor asociado
                return nodo.valores[i];
            } else if (comparacion < 0) {
                // La clave podría estar en el hijo izquierdo
                return buscarEnNodo(nodo.hijos[i], clave);
            }
        }

        // La clave podría estar en el último hijo
        return buscarEnNodo(nodo.hijos[nodo.cantidadElementos], clave);
    }
}