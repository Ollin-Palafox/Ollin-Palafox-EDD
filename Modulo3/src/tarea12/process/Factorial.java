package tarea12.process;

public class Factorial {
    // Método recursivo para calcular el factorial de un número
    public static long fcRecursivo(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * fcRecursivo(n - 1);
        }
    }

    // Método iterativo para calcular el factorial de un número
    public static long fcIterativo(int n) {
        long resultado = 1;

        for (int i = 1; i <= n; i++) {
            resultado *= i;
        }

        return resultado;
    }
}
