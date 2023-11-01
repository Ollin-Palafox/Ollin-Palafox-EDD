package tarea8.Orden;

public class Metrica {

    private static int comparacion;
    private static int movimientos;

    public Metrica() {
        comparacion = 0;
        movimientos = 0;
    }

    public static void incrementComparacion() {
        comparacion++;
    }

    public static void incrementMovimientos() {
        movimientos++;
    }

    public int getComparacion() {
        return comparacion;
    }

    public int getMovimientos() {
        return movimientos;
    }

    public void reinicio() {
        comparacion = 0;
        movimientos = 0;
    }
}
