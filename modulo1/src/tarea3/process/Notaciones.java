package tarea3.process;
import utils.Stack;

/**
 * Clase que proporciona métodos para trabajar con notaciones infijas y postfijas, así como para evaluar expresiones postfijas.
 */
public class Notaciones {

    /**
     * Convierte una expresión infija en notación postfija.
     *
     * @param infix La expresión infija a convertir.
     * @return La expresión postfija resultante.
     */
    public static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> operatorStack = new Stack<>();

        for (char c : infix.toCharArray()) {
            if (Character.isDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                operatorStack.push(c);
            } else if (c == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    postfix.append(" ").append(operatorStack.pop());
                }
                operatorStack.pop(); // Eliminar el paréntesis izquierdo
            } else if (isOperator(c)) {
                while (!operatorStack.isEmpty() && getPrecedence(c) <= getPrecedence(operatorStack.peek())) {
                    postfix.append(" ").append(operatorStack.pop());
                }
                operatorStack.push(c);
                postfix.append(" ");
            }
        }

        while (!operatorStack.isEmpty()) {
            postfix.append(" ").append(operatorStack.pop());
        }

        return postfix.toString().trim();
    }
    /**
     * Verifica si un carácter es un operador válido (+, -, *, /).
     *
     * @param c El carácter a verificar.
     * @return true si es un operador válido, false en caso contrario.
     */

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    /**
     * Obtiene la precedencia de un operador.
     *
     * @param operator El operador (+, -, *, /) del cual se quiere conocer la precedencia.
     * @return La precedencia del operador (1 para + y -, 2 para * y /, 0 para otros).
     */
    private static int getPrecedence(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        }
        return 0;
    }

    /**
     * Evalúa una expresión postfija y devuelve el resultado.
     *
     * @param postfix La expresión postfija a evaluar.
     * @return El resultado de la evaluación.
     * @throws ArithmeticException Si ocurre una división por cero durante la evaluación.
     */
    public static int evaluatePostfix(String postfix) {
        Stack<Integer> operandStack = new Stack<>();

        for (String token : postfix.split(" ")) {
            if (Character.isDigit(token.charAt(0))) {
                operandStack.push(Integer.parseInt(token));
            } else if (isOperator(token.charAt(0))) {
                int operand2 = operandStack.pop();
                int operand1 = operandStack.pop();
                int result = performOperation(operand1, operand2, token.charAt(0));
                operandStack.push(result);
            }
        }

        return operandStack.pop();
    }

    /**
     * Realiza una operación aritmética dada dos operandos y un operador.
     *
     * @param operand1 El primer operando.
     * @param operand2 El segundo operando.
     * @param operator El operador (+, -, *, /).
     * @return El resultado de la operación.
     * @throws ArithmeticException Si ocurre una división por cero durante la división.
     * @throws IllegalArgumentException Si se proporciona un operador no válido.
     */
    private static int performOperation(int operand1, int operand2, char operator) {
        return switch (operator) {
            case '+' -> operand1 + operand2;
            case '-' -> operand1 - operand2;
            case '*' -> operand1 * operand2;
            case '/' -> {
                if (operand2 == 0) {
                    throw new ArithmeticException("División por cero");
                }
                yield operand1 / operand2;
            }
            default -> throw new IllegalArgumentException("Operador no válido: " + operator);
        };
    }

    /**
     * Maneja una expresión infija, realizando la conversión a postfija y la evaluación.
     *
     * @param infixExpression La expresión infija a manejar.
     */
    public static void handleExpression(String infixExpression) {
        String postfixExpression = infixToPostfix(infixExpression);
        System.out.println("Expresión postfija: " + postfixExpression);

        try {
            int result = evaluatePostfix(postfixExpression);
            System.out.println("Resultado de la evaluación: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
