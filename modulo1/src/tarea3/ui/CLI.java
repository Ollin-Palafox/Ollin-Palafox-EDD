package tarea3.ui;

import tarea3.process.Notaciones;
import java.util.Scanner;

/**
 * Una aplicación de línea de comandos (CLI) para interactuar con la clase Notaciones.
 * Permite al usuario ingresar expresiones en notación infija y realiza la conversión a notación postfija
 * y la evaluación de la expresión.
 */
public class CLI {
    /**
     * Método principal que inicia la aplicación CLI.
     *
     */
    public static void Inicio() {
        Scanner scanner = new Scanner(System.in);
        CLI calculator = new CLI();

        while (true) {
            System.out.println("Calculadora en notación infija a postfija y evaluación");
            System.out.println("Operadores permitidos: +, -, *, /, (, )");
            System.out.println("1. Ingrese una expresión en notación infija");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (option) {
                case 1:
                    System.out.print("Ingrese una expresión en notación infija: ");
                    String infixExpression = scanner.nextLine();
                    Notaciones.handleExpression(infixExpression);
                    break;
                case 2:
                    System.out.println("Saliendo de la calculadora.");
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
