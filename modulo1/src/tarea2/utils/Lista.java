package tarea2.utils;

import tarea2.autobuses.process.Pasajeros;

import java.util.Optional;

/**
 * Interfaz base para la implementación de listas enlazadas
 * */
public interface Lista<E> {
    void add(E e);

    void remove(Optional<Pasajeros> e);

    void remove(E e);

    Optional<E> get(int index);

    void update(E oldValue, E newValue);

    int size();

    boolean contains(E t);

    void clear();

    boolean isEmpty();

    int indexOf(E e);

}