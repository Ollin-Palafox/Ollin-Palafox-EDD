package tarea7.Orden;

public class Metrica {

    private int comparacion;
    private int movimientos;

    public Metrica() {
        comparacion = 0;
        movimientos = 0;
    }

    public void incrementComparacion() {
        comparacion++;
    }

    public void incrementMovimientos() {
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
