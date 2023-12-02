package tarea9.ui;

import utils.Elementos;
import utils.Grafo;
import tarea9.process.BusquedaAnchura;
import tarea9.process.BusquedaProfundidad;

import java.util.Scanner;

public class CLI {

    public static void Visual() {
        Grafo grafo = Elementos.crearGrafoPredefinido();

        System.out.println("Bienvenido a la aplicación de búsqueda en grafo.");
        System.out.println("Vertices predefinidos:");
        Elementos.mostrarVertices(grafo);
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Búsqueda en Anchura");
            System.out.println("2. Búsqueda en Profundidad");
            System.out.println("3. Salir");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el vértice de inicio:");
                    String inicioNombre = scanner.next();
                    Grafo.Vertice inicio = new Grafo.Vertice(inicioNombre);

                    System.out.println("Búsqueda en Anchura desde " + inicio.name() + ":");
                    BusquedaAnchura.BuscarenAnchura(grafo, inicio);
                    System.out.println();
                    break;

                case 2:
                    System.out.println("Ingrese el vértice de inicio:");
                    String inicioProfundidad = scanner.next();
                    Grafo.Vertice inicioProf = new Grafo.Vertice(inicioProfundidad);

                    System.out.println("Búsqueda en Profundidad desde " + inicioProf.name() + ":");
                    BusquedaProfundidad.BuscarenProfundidad(grafo, inicioProf);
                    System.out.println();
                    break;

                case 3:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }
    }
}
