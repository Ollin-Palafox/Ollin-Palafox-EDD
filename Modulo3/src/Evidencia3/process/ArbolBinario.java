package Evidencia3.process;

import utils.NodoEvi3;

import java.util.Scanner;

public class ArbolBinario {
    private NodoEvi3 nodoRaiz;
    private Scanner scanner;

    public ArbolBinario() {
        this.scanner = new Scanner(System.in);
        construirArbol();
    }

    private void construirArbol() {
        NodoEvi3 nodoRaiz = new NodoEvi3("Vive en el agua? (Responde sí o no)");
        NodoEvi3 nodoBallena = new NodoEvi3("Ballena");
        NodoEvi3 nodoNoViveAgua = new NodoEvi3("Tiene rayas? (Responde sí o no)");
        NodoEvi3 nodoTigre = new NodoEvi3("Tigre");
        NodoEvi3 nodoNoViveAguaRayas = new NodoEvi3("Tiene cuello largo? (Responde sí o no)");
        NodoEvi3 nodoJirafa = new NodoEvi3("Jirafa");
        NodoEvi3 nodoNoViveAguaRayasCuellolargo = new NodoEvi3("Puede volar? (Responde sí o no)");
        NodoEvi3 nodoPato = new NodoEvi3("Pato");
        NodoEvi3 nodoNoViveAguaRayasCuellolargoVuela = new NodoEvi3("Tiene patas largas? (Responde sí o no)");
        NodoEvi3 nodoCanguro = new NodoEvi3("Canguro");
        NodoEvi3 nodoNoViveAguaRayasCuellolargoVuelaPatasLargas = new NodoEvi3("Es carnívoro? (Responde sí o no)");
        NodoEvi3 nodoVaca = new NodoEvi3("Leon");

// Establecer relaciones entre los nodos
        nodoRaiz.establecerHijoSi(nodoBallena);
        nodoRaiz.establecerHijoNo(nodoNoViveAgua);

        nodoNoViveAgua.establecerHijoSi(nodoTigre);
        nodoNoViveAgua.establecerHijoNo(nodoNoViveAguaRayas);

        nodoNoViveAguaRayas.establecerHijoSi(nodoJirafa);
        nodoNoViveAguaRayas.establecerHijoNo(nodoNoViveAguaRayasCuellolargo);

        nodoNoViveAguaRayasCuellolargo.establecerHijoSi(nodoPato);
        nodoNoViveAguaRayasCuellolargo.establecerHijoNo(nodoNoViveAguaRayasCuellolargoVuela);

        nodoNoViveAguaRayasCuellolargoVuela.establecerHijoSi(nodoCanguro);
        nodoNoViveAguaRayasCuellolargoVuela.establecerHijoNo(nodoNoViveAguaRayasCuellolargoVuelaPatasLargas);

        nodoNoViveAguaRayasCuellolargoVuelaPatasLargas.establecerHijoSi(nodoVaca);
        nodoNoViveAguaRayasCuellolargoVuelaPatasLargas.establecerHijoNo(new NodoEvi3("No se pudo adivinar el animal. (presiona Enter para continuar)"));


        this.nodoRaiz = nodoRaiz;
    }

    public void adivinarAnimal() {
        NodoEvi3 nodoActual = nodoRaiz;

        while (nodoActual != null) {
            System.out.println(nodoActual.obtenerPregunta());
            String respuesta = scanner.nextLine().toLowerCase();

            if ("si".equals(respuesta)) {
                if (nodoActual.obtenerHijoSi() == null || nodoActual.obtenerHijoSi().esHoja()) {
                    if (nodoActual.obtenerHijoSi() != null) {
                        System.out.println("Tu animal es: " + nodoActual.obtenerHijoSi().obtenerPregunta());
                    } else {
                        System.out.println("No se pudo adivinar el animal.");
                    }
                    break;
                }
                nodoActual = nodoActual.obtenerHijoSi();
            } else {
                nodoActual = nodoActual.obtenerHijoNo();
            }
        }

        jugarDeNuevo();
    }

    private void jugarDeNuevo() {
        String jugarDeNuevo;
        do {
            System.out.println("¿Quieres jugar de nuevo? (si/no)");
            jugarDeNuevo = scanner.nextLine().toLowerCase();
            if ("si".equals(jugarDeNuevo)) {
                construirArbol();
                adivinarAnimal();
            } else {
                System.out.println("Gracias por jugar. Hasta luego!");
                System.exit(0);
            }
        } while (true);
    }
}