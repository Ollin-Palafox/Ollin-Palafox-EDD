package tarea2.utils;

import tarea2.autobuses.process.Pasajeros;

import java.util.Optional;
public class ListaEnlazada<E> implements Lista<E> {
    private Optional<Node<E>> cabeza;
    private int tamaño;

    @Override
    public void add(E e) {
        Node<E> nuevoNodo = new Node<>(e);
        nuevoNodo.next = cabeza;
        cabeza = Optional.of(nuevoNodo);
        tamaño++;
    }

    @Override
    public void remove(Optional<Pasajeros> e) {

    }

    @Override
    public void remove(E e) {
        Optional<Node<E>> actual = cabeza;
        Optional<Node<E>> previo = Optional.empty();

        while (actual.isPresent() && !actual.get().data.equals(e)) {
            previo = actual;
            actual = actual.get().next;
        }

        if (actual.isPresent()) {
            if (previo.isPresent()) {
                previo.get().next = actual.get().next;
            } else {
                cabeza = actual.get().next;
            }
            tamaño--;
        }
    }

    @Override
    public Optional<E> get(int index) {
        if (index < 0 || index >= tamaño) {
            return Optional.empty();
        }

        Optional<Node<E>> actual = cabeza;
        for (int i = 0; i < index; i++) {
            actual = actual.get().next;
        }
        return Optional.of(actual.get().data);
    }

    @Override
    public void update(E oldValue, E newValue) {
        Optional<Node<E>> actual = cabeza;
        while (actual.isPresent()) {
            if (actual.get().data.equals(oldValue)) {
                actual.get().data = newValue;
                break;
            }
            actual = actual.get().next;
        }
    }

    @Override
    public int size() {
        return tamaño;
    }

    @Override
    public boolean contains(E t) {
        Optional<Node<E>> actual = cabeza;
        while (actual.isPresent()) {
            if (actual.get().data.equals(t)) {
                return true;
            }
            actual = actual.get().next;
        }
        return false;
    }

    @Override
    public void clear() {
        cabeza = Optional.empty();
        tamaño = 0;
    }

    @Override
    public boolean isEmpty() {
        return tamaño == 0;
    }

    @Override
    public int indexOf(E e) {
        Optional<Node<E>> actual = cabeza;
        int index = 0;
        while (actual.isPresent()) {
            if (actual.get().data.equals(e)) {
                return index;
            }
            actual = actual.get().next;
            index++;
        }
        return -1;
    }
}
