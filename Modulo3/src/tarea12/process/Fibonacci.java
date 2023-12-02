package tarea12.process;

public class Fibonacci {
    // Método recursivo para calcular el n-ésimo término de Fibonacci
    public static int fnRecursivo(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fnRecursivo(n - 1) + fnRecursivo(n - 2);
        }
    }

    // Método iterativo para calcular el n-ésimo término de Fibonacci
    public static int fnIterativo(int n) {
        if (n <= 1) {
            return n;
        }

        int fib = 1;
        int prevFib = 1;

        for (int i = 2; i < n; i++) {
            int temp = fib;
            fib += prevFib;
            prevFib = temp;
        }

        return fib;
    }
}
