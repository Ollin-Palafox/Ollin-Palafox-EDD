package utils;

public class Nodo32<K extends Comparable<K>, V> {
    private static final int MAX_ELEMENTOS = 2; // Cantidad máxima de elementos en el nodo

    public int cantidadElementos;
    public K[] claves;
    public V[] valores;
    public Nodo32<K, V>[] hijos;

    public Nodo32() {
        this.cantidadElementos = 0;
        this.claves = (K[]) new Comparable[MAX_ELEMENTOS];
        this.valores = (V[]) new Object[MAX_ELEMENTOS];
        this.hijos = new Nodo32[MAX_ELEMENTOS + 1];
    }

    public boolean estaLleno() {
        return cantidadElementos == MAX_ELEMENTOS;
    }

    public void agregarElemento(K clave, V valor) {
        if (estaLleno()) {
            throw new IllegalStateException("El nodo está lleno");
        }

        // Encontrar la posición correcta para agregar la clave y el valor
        int posicion = encontrarPosicion(clave);

        // Mover los elementos mayores a la derecha para hacer espacio
        for (int i = cantidadElementos - 1; i >= posicion; i--) {
            claves[i + 1] = claves[i];
            valores[i + 1] = valores[i];
        }

        // Insertar la nueva clave y valor
        claves[posicion] = clave;
        valores[posicion] = valor;

        // Incrementar la cantidad de elementos
        cantidadElementos++;
    }

    private int encontrarPosicion(K clave) {
        int posicion = 0;
        while (posicion < cantidadElementos && clave.compareTo(claves[posicion]) > 0) {
            posicion++;
        }
        return posicion;
    }

}
