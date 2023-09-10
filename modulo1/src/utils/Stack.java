package utils;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;

public class Stack<E> {
    private LinkedList<E> list = new LinkedList<>();

    // Método para agregar un elemento a la pila (push)
    public void push(E item) {
        list.addLast(item);
    }

    // Método para retirar y devolver el elemento superior de la pila (pop)
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.removeLast();
    }

    // Método para obtener el elemento superior de la pila sin retirarlo (peek)
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.getLast();
    }

    // Método para invertir el orden de los elementos en la pila (inverse)
    public void inverse() {
        LinkedList<E> reversed = new LinkedList<>();
        while (!isEmpty()) {
            reversed.addLast(pop());
        }
        list = reversed;
    }

    // Método para alternar los elementos de esta pila con los de otra pila (alternate)
    public void alternate(Stack<E> stack2) {
        if (stack2 == null) {
            throw new IllegalArgumentException("La segunda pila no puede ser nula.");
        }

        Queue<E> queue1 = new LinkedList<>();
        Queue<E> queue2 = new LinkedList<>();

        // Llenar las colas con elementos de ambas pilas
        while (!isEmpty() || !stack2.isEmpty()) {
            if (!isEmpty()) {
                queue1.add(pop());
            }
            if (!stack2.isEmpty()) {
                queue2.add(stack2.pop());
            }
        }

        // Alternar elementos de las colas en la pila original
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            if (!queue1.isEmpty()) {
                push(queue1.poll());
            }
            if (!queue2.isEmpty()) {
                push(queue2.poll());
            }
        }
    }

    // Método para verificar si la pila está vacía
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // Método para obtener el tamaño de la pila
    public int size() {
        return list.size();
    }
}
