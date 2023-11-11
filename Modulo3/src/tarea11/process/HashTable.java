package tarea11.process;

import java.util.Hashtable;

public class HashTable<K, V> {
    private final Hashtable<K, V> elementos = new Hashtable<>();

    // Agregar elementos a la tabla
    public void add(K clave, V valor) {
        elementos.put(clave, valor);
    }

    // Obtener el tamaño de la tabla
    public int size() {
        return elementos.size();
    }

    // Verificar si la tabla está vacía
    public boolean isEmpty() {
        return elementos.isEmpty();
    }

    // Obtener un elemento por clave
    public V getByKey(K clave) {
        return elementos.get(clave);
    }

    public void Tamano() {
        if (elementos.isEmpty()){
            System.out.println("La tabla esta vacia.");
        }
        else {
            System.out.println("Tamaño de la tabla: " + size());
        }
    }

    // Eliminar un elemento
    public void eliminarElemento(K clave) {
        elementos.remove(clave);
    }

    // Para imprimir todos los elementos en la tabla (opcional)
    public void imprimirElementos() {
        if (isEmpty()) {
            System.out.println("La tabla está vacía.");
        } else {
            for (K clave : elementos.keySet()) {
                System.out.println("Clave: " + clave + ", Valor: " + elementos.get(clave));
            }
        }
    }
}
